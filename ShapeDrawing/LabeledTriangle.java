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
 * class for labeled triangle
 */
public class LabeledTriangle extends Triangle {

    private final String name;

    /**
     * constructor for labeled triangle
     *
     * @param x      from shape
     * @param y      from shape
     * @param base   from face maker
     * @param height from face maker
     * @param color  from shape
     * @param name   from face maker
     * @throws IllegalArgumentException if the parameters passed in are incorrect format or empty
     */
    public LabeledTriangle(double x, double y, double base,
                           double height, Color color, String name)
            throws IllegalArgumentException {
        super(x, y, base, height, color);
        this.name = name;
    }

    @Override
    public void draw(WinPlotterFX plotter) {
        setPenColor(plotter);
        plotter.moveTo(x, y);
        plotter.drawTo(x + base, y);
        plotter.drawTo(x + height / 2, y + height);
        plotter.drawTo(x, y);
        plotter.printAt(x, y, name);
    }
}
