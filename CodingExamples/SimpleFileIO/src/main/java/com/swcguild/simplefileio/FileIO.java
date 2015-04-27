package com.swcguild.simplefileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author warde
 */
public class FileIO {

    public static void main(String[] args)  {

        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter("OutFile.txt"));
            out.println("This is the first line of my file.");
            out.println("This is the second line of my file.");
            out.println("This is the third line of my file.");
            out.flush();
        } catch (IOException ex) {
            System.out.println("Problem writing to file.");
        } finally {
            if (out != null) {
            out.close();
        }
        }

        Scanner sc = new Scanner(new BufferedReader(new FileReader("OutFile.txt")));

        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            System.out.println(currentLine);
        }
    }

}
