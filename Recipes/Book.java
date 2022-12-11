/*
 * Course: CS 1021
 * Term: Winter
 * Assignment Name: Lab 03
 * Name: Cherise Malisa
 * Created: 16/12/2020
 */

package malisac;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * class that handles book references
 */
public class Book extends Reference {

    private String publisher;

    @Override
    public void promptToInitialize(PrintStream out, Scanner in) {
        out.println("Enter the author of the reference");
        author = in.nextLine();
        out.println("Enter the title of the reference");
        title = in.nextLine();
        out.println("Enter the copyright year of the reference");
        publicationYear = Integer.parseInt(in.nextLine());
        out.println("Enter the publisher of the book");
        publisher = in.nextLine();

    }

    @Override
    public void promptForUpdate(PrintStream out, Scanner in) {
        super.promptForUpdate(out, in);
        out.println("Enter the updated publisher for the book");
        publisher = in.nextLine();
    }

    public String getPublisher() {
        return publisher;
    }


    public String getAuthor() {

        return author;
    }


    public String getMyUniqueID() {
        return myUniqueID;
    }


    public int getPublicationYear() {
        return publicationYear;
    }


    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "@BOOK { " + getMyUniqueID() + ",\n" +
                "author = \" " + getAuthor() + "\",\n" +
                "title = \" " + getTitle() + "\"," +
                "\npublisher = \" " + getPublisher() + "\",\n" +
                "year = \" " + getPublicationYear() + "\"\n" +
                "}";
    }
}
