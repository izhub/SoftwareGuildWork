/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrary;

import com.swcguild.consoleio.ConsoleIO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class DVDLibrary {

    ConsoleIO con = new ConsoleIO();

    HashMap<Integer, DVD> dvd = new HashMap<>();
    private static final String DVD_File = ("DVD.txt");
    private static final String DELIMITER = "::";

    public void loadDVD() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(DVD_File)));

        String currentLine;
        String[] currentTokens;
        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            DVD currentDVD = new DVD();
            currentDVD.setCounter(Integer.parseInt(currentTokens[0]));
            currentDVD.setTitle(currentTokens[1]);
            currentDVD.setDirector(currentTokens[2]);
            currentDVD.setRating(currentTokens[3]);
            currentDVD.setReleaseDate(currentTokens[4]);
            currentDVD.setStudio(currentTokens[5]);
            currentDVD.setUserRating(currentTokens[6]);
            currentDVD.setUserNotes(currentTokens[7]);

            dvd.put(currentDVD.getCounter(), currentDVD);
        }
        sc.close();
    }

    public void writeDVD() throws IOException {

        PrintWriter out = new PrintWriter(new FileWriter(DVD_File));

        Collection<DVD> addressCollection = dvd.values();

        for (DVD currentAddress : addressCollection) {
            out.println(currentAddress.getCounter() + DELIMITER
                    + currentAddress.getTitle() + DELIMITER
                    + currentAddress.getRating() + DELIMITER
                    + currentAddress.getReleaseDate() + DELIMITER
                    + currentAddress.getDirector() + DELIMITER
                    + currentAddress.getStudio() + DELIMITER
                    + currentAddress.getUserRating() + DELIMITER
                    + currentAddress.getUserRating());
            out.flush();
        }
        out.close();
    }

    private Integer nextKey() {
        int maxVal = 0;
        for (Integer n : dvd.keySet()) {
            if (n > maxVal) {
                maxVal = n;
            }
        }
        return maxVal++;
    }
//    int counter = 1;

    public void addDVD(DVD newdvd) {
        newdvd.setCounter(nextKey());
        dvd.put(nextKey(), newdvd);
        //    counter++;
        //System.out.println(counter);
    }

    public void removeDVD(int key) {
        dvd.remove(key);
    }

    public void editDVD(DVD dvdEdit) {
        dvd.putIfAbsent(nextKey(), dvdEdit);
    }

    // first hasmap in case there's more than one movie title
    public HashMap<Integer, DVD> searchByTitle(String title) {
        HashMap<Integer, DVD> results = new HashMap<>();
        Set<Integer> searchkeys = dvd.keySet();

        for (int key : searchkeys) {
            DVD currentdvd = dvd.get(key);
            if (currentdvd.getTitle().equals(title)) {
                results.put(key, dvd.get(key));
            }
        }
        return results;
    }

    public DVD[] listDVD() {
        DVD[] dvdList = new DVD[dvd.size()];
        Set<Integer> keys = dvd.keySet();
        int i = 0;
        for (int key : keys) {
            dvdList[i++] = dvd.get(key);
        }
        return dvdList;
    }
}
