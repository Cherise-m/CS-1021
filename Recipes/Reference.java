/*
 * Course: CS 1021
 * Term: Winter
 * Assignment Name: Lab 3
 * Name: Cherise Malisa
 * Created: 16/12/2020
 */

package malisac;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * parent class for book and article
 */
public abstract class Reference {

    private static int INSTANCE_COUNT = 0;
    protected String author;
    protected final String myUniqueID;
    protected int publicationYear;
    protected String title;

    /**
     * constructor to update the unique id
     */
    public Reference() {
        myUniqueID = "Ref" + INSTANCE_COUNT;
        INSTANCE_COUNT++;
    }

    /**
     * empty method
     *
     * @param out from manger class
     * @param in  from manager class
     */
    public abstract void promptToInitialize(PrintStream out, Scanner in);

    /**
     * method for updated reference information
     *
     * @param out from manger
     * @param in  from the manager class
     */
    public void promptForUpdate(PrintStream out, Scanner in) {

        out.println("Enter the updated author of the reference");
        author = in.nextLine();
        out.println("Enter the updated title of the reference");
        title = in.nextLine();
        out.println("Enter the updated copyright year for the reference.");
        publicationYear = Integer.parseInt(in.nextLine());

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
}
