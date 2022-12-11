/*
 * Course: CS 1021
 * Term: Winter
 * Assignment Name: Lab 7
 * Name: Cherise Malisa
 * Created: 27/01/2021
 */

package malisac;

import edu.msoe.winplotterfx.WinPlotterFX;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * deals with creating instances of the shapes and reading
 * the files user choose as well as handling errors
 */
public class ShapeLoaderApp extends Application {

    Scanner in;
    List<Shape> shapes = new ArrayList<>();
    WinPlotterFX plotter = new WinPlotterFX();
    Alert alert = new Alert(Alert.AlertType.ERROR);

    @Override
    public void start(Stage primaryStage) throws Exception {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        in = new Scanner(file);

        String windowSize, color;
        Color windowColor;
        int height, width;

        try {
            plotter.setWindowTitle(in.nextLine());
            windowSize = in.nextLine();
            String[] dimension = windowSize.split(" ");
            width = Integer.parseInt(dimension[0]);
            height = Integer.parseInt(dimension[1]);
            plotter.setWindowSize(width, height);

            color = in.nextLine();
            windowColor = stringToColor(color);
            plotter.setBackgroundColor(windowColor.getRed(),
                    windowColor.getGreen(),
                    windowColor.getBlue());
        } catch (IllegalArgumentException e) {
            alert.setHeaderText("Error");
            alert.setContentText("header info in the file is incorrectly formatted");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

        readShapes();
        drawShapes();
        in.close();
        plotter.showPlotter();
    }

    /**
     * reads lines from the file to create the shapes
     */
    public void readShapes() {

        try {
            while (in.hasNextLine()) {
                shapes.add((Shape) parseShape(in.nextLine()));
            }
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            alert.setHeaderText("Error");
            alert.setContentText("format in file for shapes is incorrect");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

        }


    }

    /**
     * method that draws the shape according to the plotter
     */
    public void drawShapes() {
        for (Shape shape : shapes) {
            shape.draw(plotter);

        }

    }


    public static void main(String[] args) {
        launch(args);
    }

    /**
     * method to create shape instances
     *
     * @param lines from the file with parameters for the shapes
     * @return created shape objects
     * @throws NullPointerException if line doesn't create a shape
     */
    public Object parseShape(String lines) {

        String[] pointString = lines.split(" ");
        if (pointString[0].equals("P:")) {
            return new Point(Integer.parseInt(pointString[1]), Integer.parseInt(pointString[2]),
                    stringToColor(pointString[3]));
        } else if (pointString[0].equals("C:")) {
            return new Circle(Integer.parseInt(pointString[1]), Integer.parseInt(pointString[2]),
                    Integer.parseInt(pointString[4]), stringToColor(pointString[3]));
        } else if (pointString[0].equals("T:")) {
            return new Triangle(Integer.parseInt(pointString[1]), Integer.parseInt(pointString[2]),
                    Integer.parseInt(pointString[4]),
                    Integer.parseInt(pointString[5]), stringToColor(pointString[3]));
        } else if (pointString[0].equals("R:")) {
            return new Rectangle(Integer.parseInt(pointString[1]),
                    Integer.parseInt(pointString[2]),
                    Integer.parseInt(pointString[4]),
                    Integer.parseInt(pointString[5]), stringToColor(pointString[3]));
        } else if (pointString[0].equals("LT:")) {
            return new LabeledTriangle(Integer.parseInt(pointString[1]),
                    Integer.parseInt(pointString[2]),
                    Integer.parseInt(pointString[4]), Integer.parseInt(pointString[5]),
                    stringToColor(pointString[3]), pointString[6]);
        } else if (pointString[0].equals("LR:")) {
            return new LabeledRectangle(Integer.parseInt(pointString[1]),
                    Integer.parseInt(pointString[2]),
                    Integer.parseInt(pointString[4]), Integer.parseInt(pointString[5]),
                    stringToColor(pointString[3]),
                    pointString[6] + pointString[7] + pointString[8] + pointString[9]);
        }
        return null;
    }

    /**
     * takes in colour from file
     *
     * @param color changes the string input to a color
     * @return returns color instance
     * @throws InputMismatchException when incorrectly formatted string are passed in
     */
    public Color stringToColor(String color) {

        try {
            return Color.web(color);
        } catch (IllegalArgumentException e) {

            alert.setHeaderText("Error in file");
            alert.setContentText("String for colour in file is formatted incorrectly");
            alert.showAndWait();
            throw new InputMismatchException(e.getMessage());

        }

    }


}
