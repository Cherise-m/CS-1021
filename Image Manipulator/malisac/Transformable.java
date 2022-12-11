/*
 * Course: CS 1021
 * Term: Winter
 * Assignment Name: Lab
 * Name: Cherise Malisa
 /* Created:10/02/2020
 */
package malisac;

import javafx.scene.paint.Color;

/**
 * image transformation interface
 */
public interface Transformable {

    /**
     * performs transformations to pixels of image
     * @param y y-coordinate of the pixel
     * @param color color of the image at the y-coordinate
     * @return returns the new color after transformation has taken place
     */
    Color apply(int y, Color color);

}
