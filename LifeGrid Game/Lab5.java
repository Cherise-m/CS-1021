/*
 * Course: CS 1021
 * Term: Winter
 * Assignment Name: Lab 5
 * Name: Cherise Malisa
 * Created: 13/1/2021
 */

package malisac;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Lab5 extends Application {


    VBox container = new VBox();
    HBox smallBox = new HBox(5);

    private Pane gamePane = new Pane();
    private Label l1 = new Label("Alive:");
    private Label l2 = new Label("Dead:");
    private final TextField text1 = new TextField();
    private final TextField text2 = new TextField();
    public Button b1 = new Button("randomize");
    public Button b2 = new Button("iterate");
    public LifeGrid lifeGrid;


    @Override
    public void start(Stage primaryStage) throws Exception {

        FlowPane pane = new FlowPane();
        Scene scene = new Scene(pane, 500, 400);

        primaryStage.setTitle("Game of Life");
        createContents(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
        b1.setOnAction(this::respond);
        b2.setOnAction(this::respond);
        gamePane.setOnMouseClicked(this::update);


    }

    public static void main(String[] args) {
        launch(args);
    }

    private void createContents(FlowPane pane) {

        smallBox.getChildren().addAll(b1, b2, l1, text1, l2, text2);
        lifeGrid = new LifeGrid(gamePane, 500, 350);
        container.getChildren().addAll(gamePane, smallBox);
        container.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(container);
        pane.setAlignment(Pos.BOTTOM_CENTER);


    }

    private void respond(ActionEvent e) {

        if (e.getSource() == b1) {
            lifeGrid.randomize();
            text1.setText(Integer.toString(lifeGrid.getNumAlive()));
            text2.setText(Integer.toString(lifeGrid.getNumDead()));
        }
        if (e.getSource() == b2) {
            lifeGrid.iterate();
            text1.setText(Integer.toString(lifeGrid.getNumAlive()));
            text2.setText(Integer.toString(lifeGrid.getNumDead()));
        }
    }

    private void update(MouseEvent e) {
        text1.setText(Integer.toString(lifeGrid.getNumAlive()));
        text2.setText(Integer.toString(lifeGrid.getNumDead()));
    }


}
