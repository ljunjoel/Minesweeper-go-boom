/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinesweeperClient;

import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
//import javafx.scene.effect.Dropshadow;

/**
 *
 * @author joel
 */
public class ClientUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        GridPane menu = new GridPane();
        
        Button playButton = new Button("Play!");
        playButton.setPrefSize(400, 200);
        Button hofButton = new Button("Hall of Fame");
        hofButton.setPrefSize(400, 200);
       // Dropshadow shadow = new Dropshadow();
        
        menu.add(playButton, 200, 0);
        menu.add(hofButton, 200, 300);
        menu.setPrefSize(800, 600);
        menu.setAlignment(Pos.CENTER);

        Scene scene = new Scene(menu);

        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(ClientUI.class);
    }
}
