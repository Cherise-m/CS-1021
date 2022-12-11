/*
 * Course: CS 1021
 * Term: Winter
 * Assignment Name: lab 3
 * Name: Cherise Malisa
 * Created:
 */

package malisac;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * class that displays options and changes the variables
 */
public class ReferencesManager {

    static PrintStream out = new PrintStream(System.out);
    static Scanner in = new Scanner(System.in);

    /**
     * string instance variable types
     */
    public static String choice, idRef;

    public static void main(String[] args) {

        ReferenceHolder ref = new ReferenceHolder();

        do {
            menu();

            if (choice.equals("1")) {
                Book b1 = new Book();
                b1.promptToInitialize(System.out, in);
                ref.addReference(b1);

            } else if (choice.equals("2")) {


                Article a1 = new Article();
                a1.promptToInitialize(System.out, in);
                ref.addReference(a1);

            } else if (choice.equals("3")) {
                out.print("Enter the ID of the reference you want to update");
                idRef = in.nextLine();

                if (ref.updateReference(idRef, out, in)) {
                    System.out.println("reference has been updated");
                } else {
                    System.out.println("reference doesn't exist");
                }

            } else if (choice.equals("4")) {
                System.out.println(ref.toString());

            } else if (choice.equals("5")) {
                System.out.println("enter the ID of the reference you want to remove");
                idRef = in.nextLine();

                if (ref.removeReference(idRef)) {
                    System.out.println("reference has been removed");
                } else {
                    System.out.println("reference doesn't exist");
                }

            }

        } while (!(choice.equals("0")));
        System.out.println("Goodbye");

    }

    /**
     * menu of options for user to choose from
     */
    public static void menu() {
        out.println("Enter 0 to exit the program");
        out.println("Enter 1 to enter a new book into the reference set.");
        out.println("Enter 2 to enter a new article into the reference set.");
        out.println("Enter 3 to update a reference.");
        out.println("Enter 4 to printout the entries in Bibtex format.");
        out.println("Enter 5 to remove a reference.");
        choice = in.nextLine();
    }


}
