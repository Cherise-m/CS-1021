/*
 * Course: CS 1021
 * Term: Winter
 * Assignment Name: lab 9
 * Name: Cherise Malisa
 * Created:10/02/2020
 */

package malisac;


import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * Controller for the image fxml
 */
public class Lab9Controller {

    @FXML
    ImageView view = new ImageView();
    @FXML
    Button showFilter;

    File file;
    Image image;
    Image upDated;
    ImageIO io = new ImageIO();
    Lab9 lab;


    /**
     * to load images from files
     */
    @FXML
    public void open() {

        FileChooser fileChooser = new FileChooser();
        file = new File("images");
        try {
            fileChooser.setInitialDirectory(file);
            file = fileChooser.showOpenDialog(null);
        } catch (IllegalArgumentException e) {
            System.out.println("no images file located");
        }

        if (file != null) {

            try {
                image = io.read(file.toPath());

            } catch (IllegalArgumentException e) {
                System.out.println("format of file passed in is incorrect");
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (IOException e) {
                System.out.println("something went wrong");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("error with pixel format of the file chosen");
            }
            view.setImage(image);
            upDated = image;
        } else {
            System.out.println("no image was chosen");
        }

    }

    /**
     * to load originally chosen image by user
     */
    @FXML
    public void reload() {

        view.setImage(image);
        if (file != null) {
            try {
                image = io.read(file.toPath());

            } catch (IllegalArgumentException e) {
                System.out.println("File passed in is incorrect");
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (IOException e) {
                System.out.println("something went wrong");
            }
        } else {
            System.out.println(" no file chosen");
        }

    }

    /**
     * to save image in new form
     */
    @FXML
    public void save() {
        FileChooser fileChooser = new FileChooser();
        file = new File("images");
        fileChooser.setInitialDirectory(file);
        file = fileChooser.showSaveDialog(null);

        if (file != null) {

            try {
                io.write(upDated, file.toPath());
            } catch (IOException e) {
                System.out.println(e.getMessage());
                System.out.println("something wrong with the file you want to save");
            } catch (IllegalArgumentException e) {
                System.out.println("the extension entered is not supported");

            }
        } else {
            System.out.println(" no image loaded");
        }

    }

    /**
     * to change image from colour to black and white(grayscale)
     */
    @FXML
    public void grayscale() {

        if (file != null) {
            upDated = transformImage(image, (y, color) -> color.grayscale());
            view.setImage(upDated);
        } else {
            System.out.println("no Image chosen, can't grayscale");
        }

    }

    /**
     * change the colour of the image from normal to negative tone
     */
    @FXML
    public void negative() {

        if (file != null) {
            upDated = transformImage(image, (y, color) -> {
                double nB, nG, nR;
                nB = 1 - color.getBlue();
                nR = 1 - color.getRed();
                nG = 1 - color.getGreen();

                return Color.color(nR, nG, nB);
            });
            view.setImage(upDated);
        } else {
            System.out.println("no image was loaded, can't negate");
        }

    }

    /**
     * colors the whole image loaded red
     */
    @FXML
    public void red() {

        if (file != null) {
            upDated = transformImage(image, (y, color) -> {
                double nB, nG, nR;
                nB = color.getBlue() * 0;
                nR = color.getRed();
                nG = color.getGreen() * 0;

                return Color.color(nR, nG, nB);
            });
            view.setImage(upDated);
        } else {
            System.out.println("no image chosen, can't make red");
        }

    }

    /**
     * applies red gray effect to the colors of the image
     * switching between gray and red in each row
     */
    @FXML
    public void redGray() {

        if (file != null) {
            upDated = transformImage(image, (y, color) -> {
                if (y % 2 == 0) {

                    double nB, nG, nR;
                    nB = color.getBlue() * 0;
                    nR = color.getRed();
                    nG = color.getGreen() * 0;
                    return Color.color(nR, nG, nB);

                } else {
                    return color.grayscale();

                }
            });
            view.setImage(upDated);
        } else {
            System.out.println("no image chosen, can't apply red-gray");
        }

    }

    private static Image transformImage(Image image, Transformable transform) {
        Color pixelColor, transformedColor;
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();

        PixelReader reader = image.getPixelReader();

        WritableImage newImage = new WritableImage(width, height);
        PixelWriter writer = newImage.getPixelWriter();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixelColor = reader.getColor(x, y);
                transformedColor = transform.apply(y, pixelColor);
                writer.setColor(x, y, transformedColor);
            }

        }

        image = newImage;
        return image;
    }

    /**
     * controls which stage is showing and changes the sow button to hide as needed
     */
    @FXML
    public void showFilter() {

        if (lab.stage2.isShowing()) {
            lab.stage2.hide();
            showFilter.setText("Show Filter");
        } else {
            lab.stage2.show();
            showFilter.setText("Hide Filter");
        }
    }

    public Image getImage() {
        return upDated;
    }

    /**
     * puts kerneled  image into the view
     *
     * @param image from the apply method
     */
    public void setImage(Image image) {
        if (file != null) {
            upDated = image;
            view.setImage(upDated);
        } else {
            System.out.println("no image passed in");
        }
    }


    public void setModel(Lab9 model) {
        lab = model;
    }
}
