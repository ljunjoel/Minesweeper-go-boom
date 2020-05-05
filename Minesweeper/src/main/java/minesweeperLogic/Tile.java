/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeperLogic;

import javafx.scene.control.Button;

/**
 *
 * @author joel
 */
public class Tile extends Button{
    boolean isBomb = false;
    int bombsNear;
    
    public void setBomb() {
        isBomb = true;
    }
    
    public int getNear() {
        return this.bombsNear;
    }
    
}
