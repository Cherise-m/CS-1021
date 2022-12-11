/*
 * Course: CS 1021
 * Term: Winter
 * Assignment Name: lab 9
 * Name: Cherise Malisa
 * Created:10/02/2020
 */

package malisac;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * main class for the image functionality program
 */
public class Lab9 extends Application {

    public Stage stage1;
    public Stage stage2;

    public Lab9Controller c1;
    public Lab9Controller2 c2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage kernelStage = new Stage();

        stage1 = primaryStage;
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("Lab 9.fxml"));
        Parent root1 = loader1.load();
        c1 = loader1.getController();
        c1.setModel(this);

        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(getClass().getResource("Filter Kernel.fxml"));
        Parent root2 = loader2.load();
        c2 = loader2.getController();

        c2.setC1(c1);
        stage2 = kernelStage;

        primaryStage.setTitle("Image Manipulator");
        primaryStage.setScene(new Scene(root1));


        kernelStage.setTitle("Filter Kernel");
        kernelStage.setScene(new Scene(root2));

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
