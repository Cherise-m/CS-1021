/*
 * Course: CS 1021
 * Term: Winter
 * Assignment Name: Lab 4
 * Name: Cherise Malisa
 * Created:6/01/2021
 */

package malisac;

import edu.msoe.winplotterfx.WinPlotterFX;
import javafx.scene.paint.Color;

/**
 * class for triangle
 */
public class Triangle extends Shape {

    protected final double base;
    protected final double height;

    /**
     * constructor for labeled triangle
     *
     * @param x      from shape
     * @param y      from shape
     * @param base   from face maker
     * @param height from face maker
     * @param color  from shape
     */
    public Triangle(double x, double y, double base, double height, Color color) {
        super(x, y, color);
        this.base = base;
        this.height = height;

    }

    @Override
    public void draw(WinPlotterFX plotter) {

        setPenColor(plotter);
        plotter.drawPoint(x, y);
        plotter.drawTo(x + base, y);
        plotter.drawTo(x + height / 2, y + height);
        plotter.drawTo(x, y);

    }
}
