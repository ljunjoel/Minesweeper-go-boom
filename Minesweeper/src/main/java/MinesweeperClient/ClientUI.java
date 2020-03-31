/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinesweeperClient;

import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author joel
 */
public class ClientUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane menu = new BorderPane();
        Button playButton = new Button("Play!");
        Button hofButton = new Button("Hall of Fame");

        menu.getChildren().add(playButton);
        menu.getChildren().add(hofButton);

        Scene scene = new Scene(menu);

        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(ClientUI.class);
    }
}
