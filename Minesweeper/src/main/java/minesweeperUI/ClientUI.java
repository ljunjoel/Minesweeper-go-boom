/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeperUI;

import minesweeperLogic.Tile;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author joel
 */
public class ClientUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        GridPane mainMenu = new GridPane();
        GridPane board = new GridPane();
        GridPane diffMenu = new GridPane();
        
        Button playButton = new Button("Play!");
        playButton.setPrefSize(400, 200);
        
        Button hofButton = new Button("Hall of Fame");
        hofButton.setPrefSize(400, 200);
        
        Button easyButton = new Button("Easy");
        easyButton.setPrefSize(200, 200);
        
        Button mediumButton = new Button("Medium");
        mediumButton.setPrefSize(200, 200);
        
        Button hardButton = new Button("Hard");
        hardButton.setPrefSize(200, 200);
        
        Button insaneButton = new Button ("Insane!");
        insaneButton.setPrefSize(200, 200);
        
        
        mainMenu.add(playButton, 200, 0);
        mainMenu.add(hofButton, 200, 300);
        mainMenu.setPrefSize(800, 600);
        mainMenu.setAlignment(Pos.CENTER);
        
        diffMenu.add(easyButton, 200, 0);
        diffMenu.add(mediumButton, 200, 100);
        diffMenu.add(hardButton, 200, 200);
        diffMenu.add(insaneButton, 200, 300);
        diffMenu.setPrefSize(800,600);
        diffMenu.setAlignment(Pos.CENTER);

        Scene scene = new Scene(mainMenu);
        Scene diffScene = new Scene(diffMenu);
        
        playButton.setOnMouseClicked((event) -> {
            stage.setScene(diffScene);
        });

        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(ClientUI.class);
    }
}
