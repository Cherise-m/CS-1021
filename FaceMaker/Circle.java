/*
 * Course: CS 1021
 * Term: Winter
 * Assignment Name: Lab 4
 * Name: Cherise Malisa
 * Created: 6/01/2021
 */

package malisac;

import edu.msoe.winplotterfx.WinPlotterFX;
import javafx.scene.paint.Color;

/**
 * class that draws circle face
 */
public class Circle extends Shape {

    private final double RADIUS;

    /**
     * circle constructor class
     *
     * @param x      from shape
     * @param y      from shape
     * @param radius from face maker
     * @param color  from shape
     */
    public Circle(double x, double y, double radius, Color color) {
        super(x, y, color);
        this.RADIUS = radius;
    }

    /**
     * circle constructor class
     *
     * @param x      from shape
     * @param y      from shape
     * @param radius from face maker
     * @param color  from shape
     * @param width  from face maker
     * @param height from face maker
     */
    public Circle(double x, double y, double width, double height, Color color, double radius) {
        super(x, y, color);
        RADIUS = radius;
    }

    @Override
    public void draw(WinPlotterFX plotter) {
        setPenColor(plotter);
        //plotter.drawPoint(x, y);
        for (int degrees = 0; degrees < 361; degrees++) {

            plotter.moveTo((RADIUS / 2) * Math.cos(Math.toRadians(degrees)) + x + (RADIUS / 2),
                    (RADIUS / 2) * Math.sin(Math.toRadians(degrees)) + y + (RADIUS / 2));
            plotter.drawTo((RADIUS / 2) * Math.cos(Math.toRadians(degrees + 1)) + x + (RADIUS / 2),
                    (RADIUS / 2) * Math.sin(Math.toRadians(degrees + 1)) + y + (RADIUS / 2));

        }


    }
}
