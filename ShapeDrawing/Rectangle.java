/*
 * Course: CS 1021
 * Term: Winter
 * Assignment Name: Lab 7
 * Name: Cherise Malisa
 * Created: 27/01/2021
 */

package malisac;

import edu.msoe.winplotterfx.WinPlotterFX;
import javafx.scene.paint.Color;

/**
 * draws rectangle face
 */
public class Rectangle extends Shape {

    protected final double height;
    protected final double width;

    /**
     * rectangle constructor
     *
     * @param x      from shape
     * @param y      from shape
     * @param width  from shape
     * @param height from shape
     * @param color  from shape
     * @throws IllegalArgumentException if the parameters passed in are incorrect format or empty
     */
    public Rectangle(double x, double y, double width, double height, Color color)
            throws IllegalArgumentException {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(WinPlotterFX plotter) {

        setPenColor(plotter);
        plotter.moveTo(x, y);
        plotter.drawTo(x + width, y);
        plotter.drawTo(x + width, y + width);
        plotter.drawTo(x, y + width);
        plotter.drawTo(x, y);


    }

}
