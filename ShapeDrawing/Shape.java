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
 * abstract class shape
 */
public abstract class Shape {
    private Color color;
    protected final double x;
    protected final double y;

    /**
     * shape constructor
     *
     * @param x     from face maker
     * @param y     from face maker
     * @param color from face maker
     * @throws IllegalArgumentException if the parameters passed in are incorrect format or empty
     */
    public Shape(double x, double y, Color color) throws IllegalArgumentException {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**
     * draw abstract method
     *
     * @param plotter from face maker
     */
    public abstract void draw(WinPlotterFX plotter);

    /**
     * setPenColor abstract method
     *
     * @param plotter from face maker
     */
    public void setPenColor(WinPlotterFX plotter) {

        plotter.setPenColor(color.getRed(), color.getGreen(), color.getBlue());
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
