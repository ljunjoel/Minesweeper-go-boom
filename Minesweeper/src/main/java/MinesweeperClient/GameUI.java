/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinesweeperClient;

import minesweeperGame.GameBoard;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 *
 * @author joel
 */
public class GameUI extends JFrame {
    private JLabel statusbar;
    
    public GameUI () {
        init();
    }
    
    private void init() {
        statusbar = new JLabel("");
        add(statusbar, BorderLayout.NORTH);
        
        add(new GameBoard(statusbar));
        
        setResizable(false);
        pack();
        
        setTitle("Minesweeper");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main (String[] args) {
        var game = new GameUI();
        game.setVisible(true);
    }
}
