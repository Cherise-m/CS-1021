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
 * class to draw a labeled rectangle
 */
public class LabeledRectangle extends Rectangle {

    private final String name;

    /**
     * labeled rectangle
     *
     * @param x      from shape
     * @param y      from shape
     * @param width  from shape
     * @param height from shape
     * @param color  from shape
     * @param name   triangle labels
     */
    public LabeledRectangle(double x, double y, double width,
                            double height, Color color, String name) {
        super(x, y, width, height, color);
        this.name = name;
    }

    @Override
    public void draw(WinPlotterFX plotter) {

        setPenColor(plotter);
        plotter.drawPoint(x, y);
        plotter.drawTo(x + width, y);
        plotter.drawTo(x + width, y + width);
        plotter.drawTo(x, y + width);
        plotter.drawTo(x, y);
        super.draw(plotter);
        plotter.printAt(x, y, name);

    }
}
