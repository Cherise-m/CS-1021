/*
 * Course: CS 1021
 * Term: Winter
 * Assignment Name:
 * Name: Cherise Malisa
 * Created:10/02/2020
 */

package malisac;

import edu.msoe.cs1021.ImageUtil;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

/**
 * controls for the filter kernel
 */
public class Lab9Controller2 extends Lab10Controller {

    @FXML
    TextField field1;
    @FXML
    TextField field2;
    @FXML
    TextField field3;
    @FXML
    TextField field4;
    @FXML
    TextField field5;
    @FXML
    TextField field6;
    @FXML
    TextField field7;
    @FXML
    TextField field8;
    @FXML
    TextField field9;

    Double[] values;
    double sum = 0.0;
    Lab10Controller c1;

    private void userValues() {
        double num1 = Double.parseDouble(field1.getText());
        double num2 = Double.parseDouble(field2.getText());
        double num3 = Double.parseDouble(field3.getText());
        double num4 = Double.parseDouble(field4.getText());
        double num5 = Double.parseDouble(field5.getText());
        double num6 = Double.parseDouble(field6.getText());
        double num7 = Double.parseDouble(field7.getText());
        double num8 = Double.parseDouble(field8.getText());
        double num9 = Double.parseDouble(field9.getText());

        values = new Double[]{num1, num2, num3, num4, num5, num6, num7, num8, num9};
        for (Double v : values) {
            sum += v;
        }

    }

    /**
     * blurs the image according to applied filters
     */
    @FXML
    public void blur() {

        field1.setText("0");
        field2.setText("1");
        field3.setText("0");
        field4.setText("1");
        field5.setText("5");
        field6.setText("1");
        field7.setText("0");
        field8.setText("1");
        field9.setText("0");
    }

    /**
     * sharpens the image according to applied filters
     */
    @FXML
    public void sharpen() {

        field1.setText("0");
        field2.setText("-1");
        field3.setText("0");
        field4.setText("-1");
        field5.setText("5");
        field6.setText("-1");
        field7.setText("0");
        field8.setText("-1");
        field9.setText("0");

    }

    /**
     * applies the blur or sharpen methods to the image
     * if values are valid
     */
    @FXML
    public void apply() {
        while (c1.file != null) {
            Image originalImage = c1.getImage();

            try {
                userValues();
            } catch (NumberFormatException e) {
                System.out.println("filters in kernel are empty");
            }

            double[] kernel = new double[9];

            if (!(sum <= 0)) {
                for (int x = 0; x < 9; x++) {
                    kernel[x] = values[x] / sum;
                }
                Image blurredImage = ImageUtil.convolve(originalImage, kernel);
                c1.setImage(blurredImage);
            }
        }
        System.out.println(" no picture loaded");
    }

    public void setC1(Lab10Controller c1) {
        this.c1 = c1;
    }
}
