/*
 * Course: CS 1021
 * Term: Winter
 * Assignment Name:
 * Name: Cherise Malisa
 * Created:
 */

package malisac;



import javafx.fxml.FXML;


import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;



/**
 * Controller for the image fxml
 */
public class Lab8Controller {


    @FXML
    ImageView view = new ImageView();

    File file;
    Image image, upDated;
    ImageIO io = new ImageIO();


    /**
     * to load images from files
     *
     */
    @FXML
    public void open() {

        FileChooser fileChooser = new FileChooser();
        file = new File("images");
        fileChooser.setInitialDirectory(file);
        file = fileChooser.showOpenDialog(null);



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
            view.setImage(image);
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
        try {
            image = io.read(file.toPath());

        } catch (IllegalArgumentException g) {
            System.out.println("File passed in is incorrect");
        } catch (FileNotFoundException g) {
            System.out.println("File not found");
        } catch (IOException g) {
            System.out.println("something went wrong");
        }

    }

    /**
     * to save image in new form
     *
     */
    @FXML
    public void save() {
        FileChooser fileChooser = new FileChooser();
        file = new File("images");
        fileChooser.setInitialDirectory(file);
        file = fileChooser.showSaveDialog(null);
        try {
            io.write(upDated, file.toPath());
        } catch (IllegalArgumentException a) {
            System.out.println("wrong parameters passed in");
        } catch (IOException a) {
            System.out.println("something went wrong");
        }

    }

    /**
     * to change image from colour to black and white(grayscale)
     */
    @FXML
    public void grayscale() {

        int height, width;
        Color color;
        height = (int) image.getHeight();
        width = (int) image.getWidth();
        WritableImage newImage = new WritableImage(width, height);
        PixelWriter writer = newImage.getPixelWriter();

        PixelReader reader = image.getPixelReader();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                color = reader.getColor(x, y);
                writer.setColor(x, y, color.grayscale());
            }
        }

        view.setImage(newImage);
        upDated = newImage;
    }

    /**
     *
     * change the colour of the image from normal to negative tone
     */
    @FXML
    public void negative() {
        int height, width;
        Color color;
        double nB = 0.0, nG = 0.0, nR = 0.0;
        height = (int) image.getHeight();
        width = (int) image.getWidth();
        WritableImage newImage = new WritableImage(width, height);
        PixelWriter writer = newImage.getPixelWriter();

        PixelReader reader = image.getPixelReader();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                color = reader.getColor(x, y);


                if (color != null) {
                    nB = 1 - color.getBlue();
                    nR = 1 - color.getRed();
                    nG = 1 - color.getGreen();
                }
                Color negative = Color.color(nR, nG, nB);
                writer.setColor(x, y, negative);
            }
        }

        view.setImage(newImage);
        upDated = newImage;
    }


}
