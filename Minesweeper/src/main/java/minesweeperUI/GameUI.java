/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeperUI;

import java.util.Random;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import minesweeperLogic.Tile;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author joel
 */
public class GameUI extends Application{

    public void start(Stage stage) throws Exception {
        GridPane board = new GridPane();
        Parameters params = getParameters();
       // try {
        int x = Integer.parseInt(params.getNamed().get("x"));
        int y = Integer.parseInt(params.getNamed().get("y"));
        int bombs = Integer.parseInt(params.getNamed().get("bombs"));
       /* } catch (NumberFormatException nfe) {
            Alert nfeAlert = new Alert(AlertType.ERROR);
            nfeAlert.setHeaderText("Input invalid for height and/or width");
            nfeAlert.setContentText("That was not a natural number, now was it?");
            nfeAlert.showAndWait();
        }*/
        for(int i=1; i<=x; i++) {
            for(int j=1; j<=y; j++) {
                board.add(new Tile(), i, j);
            }
        }
        for(int a=0; a<bombs; a++) {
            Random random = new Random();
            int b = random.nextInt(x)+1;
            int c = random.nextInt(y)+1;
            
        }
        
        
    }
    
    public static void main (String [] args) {
        launch(GameUI.class);
    }
    
}
