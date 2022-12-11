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
     */
    public Shape(double x, double y, Color color) {
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
