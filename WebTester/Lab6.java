/*
 * Course: CS 1021
 * Term: Winter
 * Assignment Name:
 * Name: Cherise Malisa
 * Created:
 */

package malisac;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * main class for displaying
 */
public class Lab6 extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Lab6.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setTitle("Website Tester");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
