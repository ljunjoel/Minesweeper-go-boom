/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeperLogic;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author joel
 */
public class Tile extends Button{
    boolean isBomb = false;
    boolean flagged = false;
    int bombsNear;
    boolean open;
    
    public void setBomb() {
        isBomb = true;
    }
    
    public int getNear() {
        return this.bombsNear;
    }
    
    public void handle(MouseEvent event) {
        if (event.isPrimaryButtonDown()) {
            this.open();
        } else if (event.isSecondaryButtonDown()) {
            this.flag();
        }
    }
    
    public void open() {
        if(flagged) {
            flagged = false;
            return;
        }
        
        if(!open) {
            if(isBomb) {
                
            } else {
                open = true;
                String bombs = Integer.toString(this.bombsNear);
                this.setText(bombs);
            }
        }
    }
    
    public void flag() {
        if(!open) {
            flagged = true;
            this.setText("X");
        }
    }
}
