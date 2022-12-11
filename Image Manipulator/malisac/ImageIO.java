/*
 * Course: CS 1021
 * Term: Winter
 * Assignment Name: lab 9
 * Name: Cherise Malisa
 * Created:10/02/2020
 */

package malisac;


import edu.msoe.cs1021.ImageUtil;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * class where reading and saving of files in new forms takes place
 */
public class ImageIO {

    Scanner in;
    Image image;

    /**
     * constructor for image IO
     */
    public ImageIO() {

    }

    /**
     * method to convert file info to image
     *
     * @param path passed in from file chosen
     * @return Image from read in file
     * @throws IllegalArgumentException when incorrect file path is passed in
     * @throws IOException              something went wrong
     */
    public Image read(Path path) throws IllegalArgumentException, IOException {
        String imagePath, extension = "";
        imagePath = path.toFile().getName();
        int index = imagePath.lastIndexOf('.');
        if (index > 0) {
            extension = imagePath.substring(index + 1);
        }
        if ((extension.equals("msoe") || extension.equals("png") ||
                extension.equals("jpg") || extension.equals("bmsoe"))) {
            if (extension.equals("msoe")) {
                readMSOE(path);
            } else if (extension.equals("bmsoe")) {
                readBMSOE(path);
            } else {
                image = ImageUtil.readImage(path);
            }
        } else {
            System.out.println("file type not supported");
        }
        return image;
    }

    /**
     * writes image in new form to a chosen file
     *
     * @param image image created or modified by user
     * @param path  path of image originally loaded in
     * @throws IllegalArgumentException error
     * @throws IOException              error
     */
    public void write(Image image, Path path) throws IllegalArgumentException, IOException {
        String imagePath, extension = "";
        imagePath = path.toFile().getName();
        int index = imagePath.lastIndexOf('.');
        if (index > 0) {
            extension = imagePath.substring(index + 1);
        }
        if (extension.equals("msoe") || extension.equals("jpg") ||
                extension.equals("png") || extension.equals("bmsoe")) {
            if (extension.equals("msoe")) {
                writeMSOE(image, path);
            } else if (extension.equals("bmsoe")) {
                writeBMSOE(image, path);
            } else {
                ImageUtil.writeImage(path, image);
            }
        } else {
            System.out.println("file extension not supported");
        }
    }

    private void readMSOE(Path path) throws IOException,
            ArrayIndexOutOfBoundsException,
            IllegalArgumentException {

        String name, dimension;
        int width, height;
        in = new Scanner(path);
        List<String> pixels = new ArrayList<>();
        Color color;
        name = in.nextLine();
        if (name.equals("MSOE")) {
            dimension = in.nextLine();
            String[] dimensions = dimension.split(" ");
            width = Integer.parseInt(dimensions[0]);
            height = Integer.parseInt(dimensions[1]);
            WritableImage msoeImage = new WritableImage(width, height);

            while (in.hasNextLine()) {
                pixels.add(in.nextLine());
            }
            for (int y = 0; y < height; y++) {
                String[] pixel = pixels.get(y).split("  ");
                for (int x = 0; x < width; x++) {
                    PixelWriter writer = msoeImage.getPixelWriter();
                    color = Color.web(pixel[x]);
                    writer.setColor(x, y, color);
                }
            }
            image = msoeImage;
        } else {
            System.out.println("first line of file chosen is not = msoe");
        }

    }

    private void writeMSOE(Image image, Path path) throws IOException {

        PrintWriter writer;
        Color color;
        String hexValue;
        writer = new PrintWriter(new File(String.valueOf(path)));
        writer.write("MSOE\r\n");
        String width = Integer.toString((int) image.getWidth());
        String height = Integer.toString((int) image.getHeight());
        writer.write(width + " " + height + "\r\n");

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                PixelReader reader = image.getPixelReader();
                color = reader.getColor(x, y);
                hexValue = colorHex(color);
                writer.write(hexValue + "  ");

            }
            writer.write("\r\n");
        }
        writer.close();
    }

    /**
     * https://stackoverflow.com/questions/17925318/how-to-get-hex-web-string-from-javafx-colorpicker-color
     * was used to achieve purpose of the method
     *
     * @param color of the pixel being written
     * @return color as a hex-string value
     */
    public String colorHex(Color color) {

        int red = (int) (color.getRed() * 255);
        String redString = Integer.toHexString(red);

        int green = (int) (color.getGreen() * 255);
        String greenString = Integer.toHexString(green);

        int blue = (int) (color.getBlue() * 255);
        String blueString = Integer.toHexString(blue);

        return "#" + redString.toUpperCase()
                + greenString.toUpperCase()
                + blueString.toUpperCase();

    }

    private void readBMSOE(Path path) throws IOException,
            ArrayIndexOutOfBoundsException,
            IllegalArgumentException {
        String name;
        int width;
        int height;
        FileInputStream stream = new FileInputStream(String.valueOf(path));

        DataInputStream inputStream = new DataInputStream(stream);

        ArrayList<Character> format = new ArrayList<>();
        format.add((char) inputStream.readByte());
        format.add((char) inputStream.readByte());
        format.add((char) inputStream.readByte());
        format.add((char) inputStream.readByte());
        format.add((char) inputStream.readByte());

        name = Character.toString(format.get(0)) + format.get(1) + format.get(2) +
                format.get(3) + format.get(4);

        if (name.equals("BMSOE")) {
            width = inputStream.readInt();
            height = inputStream.readInt();
            WritableImage bmsoe = new WritableImage(width, height);

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    PixelWriter writer = bmsoe.getPixelWriter();
                    Color color = intToColor(inputStream.readInt());
                    writer.setColor(x, y, color);
                }
            }
            inputStream.close();
            stream.close();
            image = bmsoe;
        } else {
            System.out.println("first line of file chosen is not = BMSOE");
        }
    }

    private static Color intToColor(int color) {
        double red = ((color >> 16) & 0x000000FF) / 255.0;
        double green = ((color >> 8) & 0x000000FF) / 255.0;
        double blue = (color & 0x000000FF) / 255.0;
        double alpha = ((color >> 24) & 0x000000FF) / 255.0;
        return new Color(red, green, blue, alpha);
    }

    private void writeBMSOE(Image image, Path path) throws IOException {

        Color color;
        FileOutputStream stream = new FileOutputStream(new File(String.valueOf(path)));
        DataOutputStream outputStream = new DataOutputStream(stream);

        /*outputStream.writeByte(Integer.parseInt("B"));
        outputStream.writeByte(Integer.parseInt("M"));
        outputStream.writeByte(Integer.parseInt("O"));
        outputStream.writeByte(Integer.parseInt("S"));
        outputStream.writeByte(Integer.parseInt("E"));*/
        outputStream.writeBytes("BMSOE");

        int width = (int) image.getWidth();
        int height = (int) image.getHeight();
        outputStream.writeInt(width);
        outputStream.writeInt(height);

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                PixelReader reader = image.getPixelReader();
                color = reader.getColor(x, y);
                int intValue = colorToInt(color);
                outputStream.writeInt(intValue);

            }

        }
        outputStream.close();
        stream.close();

    }

    private static int colorToInt(Color color) {
        int red = ((int) (color.getRed() * 255)) & 0x000000FF;
        int green = ((int) (color.getGreen() * 255)) & 0x000000FF;
        int blue = ((int) (color.getBlue() * 255)) & 0x000000FF;
        int alpha = ((int) (color.getOpacity() * 255)) & 0x000000FF;
        return (alpha << 24) + (red << 16) + (green << 8) + blue;
    }
}



