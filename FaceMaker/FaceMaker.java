/*
 * Course: CS 1021
 * Term: Winter
 * Assignment Name: Lab 4
 * Name: Cherise Malisa
 * Created:6/01/2021
 */

package malisac;

import edu.msoe.winplotterfx.WinPlotterFX;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Scanner;

/**
 * This class draws a face out of a bunch of rectangles.
 *
 * @author taylor
 * @version 20191216
 */
public class FaceMaker extends Application {
    public static final int WINDOW_SIZE = 900;
    public static final int GRID_INCREMENT = WINDOW_SIZE / 10;
    public static final int HEAD_SIZE = 700;
    public static String choice;

    public static Scanner in = new Scanner(System.in);

    /**
     * Launches the JavaFX application
     *
     * @param args ignored
     */
    public static void main(String[] args) {


        choice = options();
        if (choice.equals("6")) {
            random();
        }
        launch(args);
    }

    /**
     * Use the Shape class and its descendants to draw a face.
     *
     * @param stage Default stage given to a JavaFX program. Unused.
     */
    @Override
    public void start(Stage stage) {
        WinPlotterFX plotter = new WinPlotterFX();
        plotter.setWindowTitle("Face Maker");
        plotter.setWindowSize(WINDOW_SIZE, WINDOW_SIZE);
        plotter.setBackgroundColor(Color.BLACK.getRed(), Color.BLACK.getGreen(),
                Color.BLACK.getBlue());
        final boolean showGrid = true;
        plotter.setGrid(showGrid, GRID_INCREMENT, GRID_INCREMENT, Color.GRAY);
        Shape head = createHead(choice);
        Shape leftEye = createLeftEye(choice);
        Shape rightEye = createRightEye(choice);
        Shape nose = createNose(choice);
        Shape mouth = createMouth(choice);

        head.draw(plotter);
        leftEye.draw(plotter);
        rightEye.draw(plotter);
        nose.draw(plotter);
        mouth.draw(plotter);

        plotter.showPlotter();
    }

    /**
     * Creates and returns a shape representing the head
     *
     * @param choice user input
     * @return shape representing the head
     */
    private static Shape createHead(String choice) {
        final int xLeft = (WINDOW_SIZE - HEAD_SIZE) / 2;
        final int yBottom = (WINDOW_SIZE - HEAD_SIZE) / 2;
        final String head = "head";
        if (choice.equals("1")) {
            return new Rectangle(xLeft, yBottom, HEAD_SIZE, HEAD_SIZE, Color.WHITE);
        } else if (choice.equals("2")) {
            return new LabeledRectangle(xLeft, yBottom, HEAD_SIZE, HEAD_SIZE, Color.WHITE, head);
        } else if (choice.equals("3")) {
            return new Triangle(xLeft, yBottom, HEAD_SIZE, HEAD_SIZE, Color.WHITE);
        } else if (choice.equals("4")) {
            return new LabeledTriangle(xLeft, yBottom, HEAD_SIZE, HEAD_SIZE, Color.WHITE, head);
        } else if (choice.equals("5")) {
            return new Circle(xLeft, yBottom, HEAD_SIZE, Color.WHITE);
        }
        return new Rectangle(xLeft, yBottom, HEAD_SIZE, HEAD_SIZE, Color.WHITE);
    }

    /**
     * Creates and returns a shape representing the right eye
     *
     * @param choice user input
     * @return shape representing the right eye
     */
    private static Shape createRightEye(String choice) {
        final double scaleFactor = 0.15;
        final double size = scaleFactor * HEAD_SIZE;
        final double yBottom = WINDOW_SIZE / 2 + size * 3 / 2;
        final double xLeft = WINDOW_SIZE / 2 + size;
        final String rightEye = "right eye";

        if (choice.equals("1")) {
            return new Rectangle(xLeft, yBottom, size, size, Color.WHITE);
        } else if (choice.equals("2")) {
            return new LabeledRectangle(xLeft, yBottom, size, size, Color.WHITE, rightEye);
        } else if (choice.equals("3")) {
            return new Triangle(xLeft, yBottom, size, size, Color.WHITE);
        } else if (choice.equals("4")) {
            return new LabeledTriangle(xLeft, yBottom, size, size, Color.WHITE, rightEye);
        } else if (choice.equals("5")) {
            return new Circle(xLeft, yBottom, size, Color.WHITE);
        }
        return new Rectangle(xLeft, yBottom, size, size, Color.WHITE);

    }

    /**
     * Creates and returns a shape representing the left eye
     *
     * @param choice user input
     * @return shape representing the left eye
     */
    private static Shape createLeftEye(String choice) {
        final double scaleFactor = 0.15;
        final double size = scaleFactor * HEAD_SIZE;
        final double yBottom = WINDOW_SIZE / 2 + size * 3 / 2;
        final double xLeft = WINDOW_SIZE / 2 - size * 2;
        final String leftEye = "left eye";

        if (choice.equals("1")) {
            return new Rectangle(xLeft, yBottom, size, size, Color.WHITE);
        } else if (choice.equals("2")) {
            return new LabeledRectangle(xLeft, yBottom, size, size, Color.WHITE, leftEye);
        } else if (choice.equals("3")) {
            return new Triangle(xLeft, yBottom, size, size, Color.WHITE);
        } else if (choice.equals("4")) {
            return new LabeledTriangle(xLeft, yBottom, size, size, Color.WHITE, leftEye);
        } else if (choice.equals("5")) {
            return new Circle(xLeft, yBottom, size, Color.WHITE);
        }
        return new Rectangle(xLeft, yBottom, size, size, Color.WHITE);

    }

    /**
     * Creates and returns a shape representing the nose
     *
     * @param choice user input
     * @return shape representing the nose
     */
    private static Shape createNose(String choice) {
        final double scaleFactor = 0.2;
        final double size = scaleFactor * HEAD_SIZE;
        final String nose = "nose";
        final double xLeft = WINDOW_SIZE / 2 - size / 2;
        final double yBottom = (WINDOW_SIZE) / 2;

        if (choice.equals("1")) {
            return new Rectangle(xLeft, yBottom, size, size, Color.WHITE);
        } else if (choice.equals("2")) {
            return new LabeledRectangle(xLeft, yBottom, size, size, Color.WHITE, nose);
        } else if (choice.equals("3")) {
            return new Triangle(xLeft, yBottom, size, size, Color.WHITE);
        } else if (choice.equals("4")) {
            return new LabeledTriangle(xLeft, yBottom, size, size, Color.WHITE, nose);
        } else if (choice.equals("5")) {
            return new Circle(xLeft, yBottom, size, Color.WHITE);
        }
        return new Rectangle(xLeft, yBottom, size, size, Color.WHITE);

    }

    /**
     * Creates and returns a shape representing the mouth
     *
     * @param choice user input
     * @return shape representing the mouth
     */
    private static Shape createMouth(String choice) {
        final double scaleFactor = 0.3;
        final double size = scaleFactor * HEAD_SIZE;
        final double xLeft = WINDOW_SIZE / 2 - size / 2;
        final double yBottom = (WINDOW_SIZE) / 2 - size * 3 / 2;
        final String mouth = "mouth";

        if (choice.equals("1")) {
            return new Rectangle(xLeft, yBottom, size, size, Color.WHITE);
        } else if (choice.equals("2")) {
            return new LabeledRectangle(xLeft, yBottom, size, size, Color.WHITE, mouth);
        } else if (choice.equals("3")) {
            return new Triangle(xLeft, yBottom, size, size, Color.WHITE);
        } else if (choice.equals("4")) {
            return new LabeledTriangle(xLeft, yBottom, size, size, Color.WHITE, mouth);
        } else if (choice.equals("5")) {
            return new Circle(xLeft, yBottom, size, Color.WHITE);
        }
        return new Rectangle(xLeft, yBottom, size, size, Color.WHITE);

    }

    public static String options() {
        System.out.println("1: -Rectangle (draws face using rectangles as shown above)");
        System.out.println("2:  -Labeled Rectangle (draws face using labeled" +
                "rectangles for each facial component)");
        System.out.println("3: -Triangle (draws face using triangles for" +
                " each facial component)");
        System.out.println("4:-Labeled Triangle (draws face using labeled " +
                "triangles for each facial component");
        System.out.println("5:-Circle (draws face using circles for each facial component");
        System.out.println("6: - Random ( draws face using one of the previous" +
                " shapes for each facial component");


        choice = in.nextLine();
        return choice;
    }

    public static void random() {
        String ran1;
        ran1 = String.valueOf((int) (5 * Math.random() + 1));
        Shape head = createHead(choice);
        Shape leftEye = createLeftEye(ran1);
        Shape rightEye = createRightEye(ran1);
        Shape nose = createNose(choice);
        Shape mouth = createMouth(ran1);

    }

}
