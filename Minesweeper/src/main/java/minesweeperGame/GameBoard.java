/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeperGame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author joel
 */
public class GameBoard extends JPanel {
    private final int images = 13;
    private final int cellSize = 15;
    
    private final int cellCover = 10;
    private final int cellFlagged = 10;
    private final int emptyCell = 0;
    private final int mineCell = 9;
    private final int mineInHiding = mineCell + cellCover;
    private final int flaggedMine = mineInHiding + cellFlagged;
    
    private final int drawMine = 9;
    private final int drawCover = 10;
    private final int drawFlag = 11;
    private final int drawFalse = 12;
    
    private final int mines = 40;
    private final int rows = 16;
    private final int cols = 16;
    
    private final int width = cols * cellSize + 1;
    private final int height = rows * cellSize + 1;
    
    private int[] field;
    private boolean gameGoing;
    private int flagsLeft;
    private  Image[] img;
    private int allCells;
    private final JLabel statusbar;
    
    public GameBoard (JLabel statusbar) {
        this.statusbar = statusbar;
        initBoard();
    }
    
    private void initBoard() {
        setPreferredSize(new Dimension(width, height));
        img = new Image[images];
        
        for (int i = 0; i< images; i++) {
            var path = "src/pics/"+i+".png";
            img[i] = (new ImageIcon(path)).getImage();
        }
        
        addMouseListener(new MinesAdapter());
        newGame();
    }
    
    private void newGame() {
        var random = new Random();
        gameGoing = true;
        flagsLeft = mines;
        
        allCells = rows*cols;
        field = new int[allCells];
        
        for (int i = 0; i < allCells; i++) {
            field[i] = cellCover;
        }
        
        statusbar.setText("Flags Left: "+Integer.toString(flagsLeft));
        
        int i = 0;
        while (i < mines) {
            int position = (int) (allCells * random.nextDouble());
            
            if((position < allCells) && (field[position] != mineInHiding)) {
                int col = position % cols;
                field[position] = mineInHiding;
                i++; 
                
                if(col > 0) {
                    if(position - 1 - cols >= 0) {
                        cellNumbering(position - 1 - cols);
                    }
                    if (position - 1 >= 0) {
                        cellNumbering(position-1);
                    }
                    if (position + cols - 1 < allCells) {
                        cellNumbering(position + cols - 1);
                    }
                }
                if(position - cols >= 0) {
                    cellNumbering(position - cols);
                }
                if(position + cols < allCells) {
                    cellNumbering(position + cols);
                }
                if(col < (cols - 1)) {
                    if(position - cols -1 >= 0) {
                        cellNumbering(position - cols - 1);
                    }
                    if(position + cols + 1 < allCells) {
                        cellNumbering(position + cols + 1);
                    }
                    if(position + 1 < allCells) {
                        cellNumbering(position + 1);
                    }
                }
            }
        }
        
        
    }
    
    public void cellNumbering(int c) {   
        int cell = c;
        if (field[cell] != mineInHiding) {
        field[cell] += 1;
            }
            
            
    }
    
    private void findEmptyCells(int j) {
        int col = j % cols;
        
        if(col > 0) {
            if(j - cols - 1 >= 0) {
                coverCells(j - cols - 1);
            }
            if(j-1 >= 0) {
                coverCells(j-1);
            }
            if(j + cols -1 < allCells) {
                coverCells(j+cols-1);
            }
        }
        
        if(j-cols >= 0) {
            coverCells(j-cols);
        }
        if(j+cols < allCells) {
            coverCells(j+cols);
        }
        
        if(col < (cols-1)) {
            if(j-cols-1 >= 0) {
                coverCells(j-cols-1);
            }
            if(j+cols+1 < allCells) {
                coverCells(j+cols+1);
            }
            if(j+1 < allCells) {
                coverCells(j+1);
            }
        }
    }
    
    private void coverCells(int c) {
        int cell = c;
        if(field[cell] > mineCell) {
            field[cell] -= cellCover;
            if (field[cell] == emptyCell) {
                findEmptyCells(cell);
            }
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        int uncover = 0;
        
        for(int i = 0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                int cell = field[(i*cols) + j];
                
                if(gameGoing && cell == mineCell) {
                    gameGoing = false;
                }
                
                if(!gameGoing) {
                    if(cell == mineInHiding) {
                        cell = drawMine;
                    } else if (cell == flaggedMine) {
                        cell = drawFlag;
                    } else if (cell > mineInHiding) {
                        cell = drawFalse;
                    } else if (cell > mineCell) {
                        cell = drawCover;
                    }
                } else {
                    if(cell>mineInHiding) {
                        cell = drawFlag;
                    } else if (cell > mineCell) {
                        cell = drawCover;
                        uncover++;
                    }
                }
                
                g.drawImage(img[cell], (j*cellSize), (i*cellSize), this);
            }
        }
        if(uncover==0 && gameGoing) {
            gameGoing =false;
            statusbar.setText("You win!");
        } else if (!gameGoing) {
            statusbar.setText("You lost :'(");
        }
    }
    
    public void setStatus(int i) {
        if(i == 0) {
            statusbar.setText("We're all out of flags");
        }
        statusbar.setText("Flags left: "+i);
    }
    
    private class MinesAdapter extends MouseAdapter {
        
        @Override
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            
            int mCol = x / cellSize;
            int mRow = y / cellSize;
            
            boolean needRepaint = false;
            
            if(!gameGoing) {
                newGame();
                repaint();
            }
            
            if((x < cols * cellSize) && (y < rows * cellSize)) {
                if(e.getButton() == MouseEvent.BUTTON3) {
                    if (field[(mRow * cols)+mCol] > mineCell) {
                        needRepaint = true;
                        if (field[mRow*cols + mCol] <= mineInHiding) {
                            if(flagsLeft > 0) {
                                field[(mRow*cols)+mCol] += cellFlagged;
                                flagsLeft --;
                                setStatus(flagsLeft);
                            } else {
                                statusbar.setText("No flags left");
                            }
                        } else {
                            field[(mRow * cols)+mCol] -= cellFlagged;
                            flagsLeft++;
                            setStatus(flagsLeft);
                        }
                    }
                } else {
                    if (field[(mRow*cols)+mCol] > mineInHiding) {
                        return;
                    }
                    if((field[(mRow*cols)+mCol] > mineCell) && (field[(mRow*cols)+mCol] < flaggedMine)) {
                        field[(mRow*cols)+mCol] -= cellCover;
                        needRepaint = true;
                        if (field[(mRow*cols)+mCol] == mineCell) {
                            gameGoing = false;
                        }
                        if(field[(mRow*cols)+mCol] == emptyCell) {
                            findEmptyCells((mRow*cols)+mCol);
                        }
                    }
                }
                if(needRepaint) {
                    repaint();
                }
            }
            
        }
    }
}
