/*
 * Course: CS 1021
 * Term: Winter
 * Assignment Name: Lab 3
 * Name:Cherise Malisa
 * Created:
 */

package malisac;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * test for reference holder
 */

public class ReferenceHolderTestDriver {
    public static void main(String[] args) {

        PrintStream out = new PrintStream(System.out);
        Scanner in = new Scanner(System.in);

        ReferenceHolder ref = new ReferenceHolder();
        Book b1 = new Book();
        Article a1 = new Article();


        ref.addReference(a1);

        System.out.println(ref);

        ref.removeReference("0");


    }
}
