/*
 * Course: CS 1021
 * Term: Winter
 * Assignment Name: Lab3
 * Name:Cherise Malisa
 * Created:
 */

package malisac;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * class that handles the references
 */
public class ReferenceHolder {

    private final List<Reference> references = new ArrayList<>();

    /**
     * constructor for reference
     */
    public ReferenceHolder() {

    }

    /**
     * to add a book to reference arraylist
     *
     * @param book from class book
     */
    public void addReference(Book book) {
        references.add(book);
    }

    /**
     * to add an article to reference arraylist
     *
     * @param article from class book
     */
    public void addReference(Article article) {
        references.add(article);
    }

    /**
     * to remove and insure that a a reference has been deleted
     *
     * @param uniqueID from the user
     * @return true if reference was removed
     */
    public boolean removeReference(String uniqueID) {
        for (Reference reference : references) {
            if (uniqueID.equals(reference.getMyUniqueID())) {
                references.remove(uniqueID);
                return true;
            }
        }

        return false;
    }

    /**
     * to update already exsiting reference
     *
     * @param uniqueID from the user
     * @param out      the prompt for information to be updated
     * @param in       values that have been updated by user
     * @return true if referenced was removed
     */
    public boolean updateReference(String uniqueID, PrintStream out, Scanner in) {
        for (Reference reference : references) {
            if (uniqueID.equals(reference.getMyUniqueID())) {
                reference.promptForUpdate(out, in);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String temp = " ";
        for (Reference reference : references) {
            temp += reference.toString();

        }
        return temp;
    }
}
