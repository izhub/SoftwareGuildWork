/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrary;

import com.swcguild.consoleio.ConsoleIO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public class DVDController {

    ConsoleIO con = new ConsoleIO();
    DVDLibrary dvdCon = new DVDLibrary();

    public void run() throws IOException {
        boolean keepGoing = true;

        try {
            dvdCon.loadDVD();

            while (keepGoing) {
                printMenu();
                String userChoice = con.getString("");

                switch (userChoice) {
                    case "1":
                        addDVD();
                        break;
                    case "2":
                        removeDVD();
                        break;
                    case "3":
                        editDVD();
                        break;
                    case "4":
                        listDVD();
                        break;
                    case "5":
                        searchDVDByTitle();
                        break;
                    case "6":
                        keepGoing = false;
                        break;
                    default:
                        con.String("Not an option");
                        break;
                }
            }
            dvdCon.writeDVD();
        } catch (FileNotFoundException ex) {
            con.String("Error loading DVD");
        } catch (IOException e) {
            con.String("Error Writing to file");
        }
    }

    public void printMenu() {
        con.String("\nMake a selection from the following options: \n");
        con.String("1. Add a DVD to the collectoin");
        con.String("2. Remove a DVD from the collection");
        con.String("3. Edit a DVD ");
        con.String("4. List the DVDs in the collection");
        con.String("5. Search DVD by title");
        con.String("6. Exit");
    }

    public void addDVD() {

        String title = con.getString("Enter title of DVD: ").toUpperCase();
        String releaseDate = con.getString("Enter release date of DVD:");
        String ratingMPAA = con.getString("Enter DVD rating: ").toUpperCase();
        String director = con.getString("Enter name of movie director:");
        String studio = con.getString("Enter name of production studio:");
        String userRating = con.getString("Enter your rating of the DVD:");
        String userNotes = con.getString("Enter any extra notes:");

        DVD currentdvd = new DVD();
        currentdvd.setTitle(title);
        currentdvd.setReleaseDate(releaseDate);;
        currentdvd.setRating(ratingMPAA);
        currentdvd.setDirector(director);
        currentdvd.setStudio(studio);
        currentdvd.setUserRating(userRating);
        currentdvd.setUserNotes(userNotes);

        dvdCon.addDVD(currentdvd);
        String menu = con.getString("DVD added. Press any key to return to menu");

    }

    public void removeDVD() {
        searchDVDByTitle();
        int num = con.getInt("\nEnter movie number to remove: ");
        dvdCon.removeDVD(num);
        con.String("Movie removed.");
        con.getString("");

    }

    public void editDVD() {
        String edit = con.getString("\nEnter Title of DVD to edit: ").toUpperCase();
        boolean run = false;

        for (DVD entry : dvdCon.dvd.values()) {
            if (edit.equalsIgnoreCase(entry.getTitle())) {
                con.getString("DVD #:" + entry.getCounter());
                con.getString(entry.getTitle());
                run = true;
            }
        }
        if (run) {
            DVD currentDVD = new DVD();
            int count = con.getInt("Enter movie # you wish to edit.");
            con.getString("");
            currentDVD = dvdCon.dvd.get(count);
            String title = con.getString("Enter to keep or type new title \r"
                    + currentDVD.getTitle());
            String releaseDate = con.getString("Enter to keep or type new date?\r"
                    + currentDVD.getReleaseDate());
            String rating = con.getString("Enter to keep or type new rating\r"
                    + currentDVD.getRating());
            String director = con.getString("Enter to keep or type new director name\r"
                    + currentDVD.getDirector());
            String studio = con.getString("Enter to keep or type new studio name\r"
                    + currentDVD.getStudio());
            String myRating = con.getString("Enter to keep or type new user rating\r"
                    + currentDVD.getUserRating());
            String notes = con.getString("Enter to keep or type new notes\r3"
                    + currentDVD.getUserNotes());

            if (!title.equals("")) {
                currentDVD.setTitle(title);
            }
            if (!title.equals("")) {
                currentDVD.setReleaseDate(releaseDate);
            }
            if (!title.equals("")) {
                currentDVD.setRating(rating);
            }
            if (!title.equals("")) {
                currentDVD.setDirector(director);
            }
            if (!title.equals("")) {
                currentDVD.setStudio(studio);
            }
            if (!title.equals("")) {
                currentDVD.setUserRating(myRating);
            }
            if (!title.equals("")) {
                currentDVD.setUserNotes(notes);
            }
            currentDVD.setCounter(count);
            
            dvdCon.dvd.put(count, currentDVD);

        }
////        
//         if (!input.equals("")) {
//            order.setCustomerName(input);
//        }
//         HashMap<Integer, DVD> results = dvdCon.searchByTitle(title);
//        String Collection<DVD > collectionResults;
//        if (results.isEmpty()) {
//            con.String("Not found...");
//        } else {
//            collectionResults = results.values();
//            for (DVD result : collectionResults) {
//                con.String("\n#" + result.getCounter()
//                        + "\nTite:" + result.getTitle()
//                        + "\nDirector: " + result.getDirector()
//                        + "\nRating: " + result.getRating()
//                        + "\nRelease Date: " + result.getReleaseDate()
//                        + "\nStudio: " + result.getStudio()
//                        + "\nMy rating: " + result.getUserRating()
//                        + "\nMy Notes:" + result.getUserNotes());
//            }
//            String key = con.getString(("\nEnter movie number to edit:"));
//
//            con.String("1 " + results.get(key).getTitle());
//            con.String("2 " + results.get(key).getDirector());
//            con.String("3 " + results.get(key).getRating());
//            con.String("4 " + results.get(key).getReleaseDate());
//            con.String("5 " + results.get(key).getStudio());
//            con.String("6 " + results.get(key).getUserRating());
//            con.String("7 " + results.get(key).getUserNotes());
//
//            String lineNumber = con.getString("\nEnter line number to edit:");
//            String revisedLine = con.getString("\nEnter new information: ");
//
//            switch (lineNumber) {
//                case "1":
//                    results.get(key).setTitle(revisedLine);
//                    break;
//                case "2":
//                    results.get(key).setDirector(revisedLine);
//                    ;
//                    break;
//                case "3":
//                    results.get(key).setRatinsetRatingLine
//                    );
//                    break;
//                case "4":
//                    results.get(key).setReleaseDate(revisedLine);
//                    break;
//                case "5":
//                    results.get(key).setStudio(revisedLine);
//                    break;
//                case "6":
//                    results.get(key).setUserRating(revisedLine);
//                    break;
//                case "7":
//                    results.get(key).setUserNotes(revisedLine);
//                    break;
//                default:
//                    con.String("Invalid selection");
//                    break;
//            }
//            dvdCon.editDVD(results.get(key));
//        }
    }

    public void listDVD() {

        for (DVD dvd : dvdCon.dvd.values()) {
            con.String(dvd.getCounter() + " Title: " + dvd.getTitle()
                    + "\nRelease date: " + dvd.getReleaseDate()
                    + "\nRating: " + dvd.getRating() + "\nDirector: "
                    + dvd.getDirector() + "\nStudio: " + dvd.getStudio()
                    + "\nMy Rating: " + dvd.getUserRating()
                    + "\nNotes: " + dvd.getUserNotes());
        }

    }

    public void searchDVDByTitle() {
        String title = con.getString("Enter title of DVD to search").toUpperCase();
        HashMap<Integer, DVD> results = dvdCon.searchByTitle(title);

        if (results.isEmpty()) {
            con.String("DVD not found");
        } else {
            Collection<DVD> collResults = results.values();
            for (DVD result : collResults) {
                con.String("\n# " + result.getCounter()
                        + " Title: " + result.getTitle()
                        + "\nRating: " + result.getRating()
                        + "\nRelease date: " + result.getReleaseDate()
                        + "\nDirector: " + result.getDirector()
                        + "\nStudio: " + result.getStudio()
                        + "\nMy Rating: " + result.getUserRating()
                        + "\nNotes: " + result.getUserNotes());
            }
        }

    }

}
