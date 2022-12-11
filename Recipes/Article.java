/*
 * Course: CS 1021
 * Term: Winter
 * Assignment Name: Lab 3
 * Name: Cherise Malisa
 * Created:16/12/2020
 */

package malisac;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * class that handles article references
 */
public class Article extends Reference {

    private int endingPage;
    private int startingPage;
    private String journal;

    @Override
    public void promptToInitialize(PrintStream out, Scanner in) {
        out.println("Enter the author of the reference");
        author = in.nextLine();
        out.println("Enter the title of the reference");
        title = in.nextLine();
        out.println("Enter the copyright year of the reference");
        publicationYear = Integer.parseInt(in.nextLine());
        out.println("Enter the title of the journal");
        journal = in.nextLine();
        out.println("Enter the first page number of the article");
        startingPage = Integer.parseInt(in.nextLine());
        out.println("Enter the last page number of the article");
        endingPage = Integer.parseInt(in.nextLine());

    }

    @Override
    public void promptForUpdate(PrintStream out, Scanner in) {

        super.promptForUpdate(out, in);
        out.println("Enter the updated title of the journal");
        journal = in.nextLine();
        out.println("Enter the updated first page number of the article");
        startingPage = Integer.parseInt(in.nextLine());
        out.println("Enter the updated last page number of the article");
        endingPage = Integer.parseInt(in.nextLine());
    }

    public int getEndingPage() {
        if (setEndingPage(endingPage)) {
            return endingPage;
        }
        return 0;
    }

    public int getStartingPage() {
        return startingPage;
    }

    public String getJournal() {
        return journal;
    }


    private boolean setEndingPage(int endingPage) {
        if (endingPage < getStartingPage()) {
            this.endingPage = endingPage;
            return false;
        }
        return true;
    }

    private boolean setStartingPage(int startingPage) {
        if (startingPage < 0 || startingPage > endingPage) {
            this.startingPage = startingPage;
            return false;
        }
        return true;
    }


    public String getAuthor() {
        return author;
    }


    public String getMyUniqueID() {
        return myUniqueID;
    }


    public String getTitle() {
        return title;
    }


    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public String toString() {

        return "@ARTICLE { " + getMyUniqueID() + ",\n" +
                "author = \"" + getAuthor() + "\",\n" +
                "title = \"" + getTitle() + "\",\n" +
                "journal = \"" + getJournal() + "\",\n" +
                "pages = \"" + getStartingPage() + "- " + getEndingPage() + "\",\n" +
                "year = \"" + getPublicationYear() + "\"" +
                "\n}";
    }

}
