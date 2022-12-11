/*
 * Course: CS 1021
 * Term: Winter
 * Assignment Name:
 * Name: Cherise Malisa
 * Created:
 */

package malisac;

import edu.msoe.winplotterfx.WinPlotterFX;
import javafx.scene.paint.Color;

/**
 * point class inherits from shape
 */
public class Point extends Shape {


    /**
     * shape constructor
     *
     * @param x     from face maker
     * @param y     from face maker
     * @param color from face maker
     * @throws IllegalArgumentException if the parameters passed in are incorrect format or empty
     */
    public Point(double x, double y, Color color) throws IllegalArgumentException {
        super(x, y, color);
    }

    @Override
    public void draw(WinPlotterFX plotter) {
        setPenColor(plotter);

        plotter.drawPoint(x, y);


    }
}
