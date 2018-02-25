/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrarywithstreams.controller;

import com.swcguild.consoleio.ConsoleIO;
import com.swcguild.dvdlibrarywithstreams.DAO.DVDDAO;
import com.swcguild.dvdlibrarywithstreams.DAO.DVDDAOImpl;
import com.swcguild.dvdlibrarywithstreams.DTO.DVD;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public class DVDLibraryController {

    ConsoleIO con = new ConsoleIO();
    DVDDAO dao = new DVDDAOImpl();

    public void run() throws FileNotFoundException, IOException {

        int userChoice = 0;

        try {
            dao.loadDVD();
        } catch (FileNotFoundException e) {
            
        }

        do {
            printMenu();
            userChoice = con.getInt("Please select from the options above: \r");
            con.getString("");
            switch (userChoice) {
                case 1:
                    addDVD();
                    break;
                case 2:
                    removeDVD();
                    break;
                case 3:
                    editDVD();
                    break;
                case 4:
                    countDVD();
                    break;
                case 5:
                    listAllDVD();
                    break;
                case 6:
                    searchDVDByTitle();
                    break;
                case 7:
                    searchDVDByYears();
                    break;
                case 8:
                    searchDVDByRating();
                    break;
                case 9:
                    searchDVDByDirectorThanRating();
                    break;
                case 10:
                    searchDVDByStudio();
                    break;
                case 11:
                    listNewestDVD();
                    break;
                case 12:
                    listOldestDVD();
                    break;
                case 13:
                    avgMovieAge();
                    break;
                case 14:
                    avgNotes();
                    break;
                case 15:
                    break;
                default:
                    con.String("Invalid choice");

            }
        } while (userChoice != 15);

        try {
            dao.writeDVD();
        } catch (IOException e) {
        }
    }
    // methods...

    private void printMenu() {
        con.String("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        con.String("                DVD Library Menu ");
        con.String("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        con.String("1. Add DVD");
        con.String("2. Delete DVD");
        con.String("3. Edit DVD");
        con.String("4. Show Total DVDs");
        con.String("5. List All DVDs");
        con.String("6. Search DVD By Title");
        con.String("7. Search DVDs in last N Years");
        con.String("8. Search DVD By Rating");
        con.String("9. Search DVD By Director");
        con.String("10. Search DVD By Studio");
        con.String("11. List Newest DVD");
        con.String("12. List Oldest DVD");
        con.String("13. Average Age of Movies");
        con.String("14. Average Number of Notes");
        con.String("15. Exit");
        con.String("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    private void addDVD() {
        boolean addMoreDVD;
        con.String("");
        DVD mydvd = new DVD();
        do {
            addMoreDVD = false;

            String title = con.getString("Enter Title: ").toUpperCase();
            mydvd.setTitle(title);
            String dir = con.getString("Enter director: ").toUpperCase();
            mydvd.setDirector(dir);
            String date = con.getString("Enter Release date year (YYYY))");
            mydvd.setReleaseDate(date);
            String rating = con.getString("Enter MPAA Rating: ");
            mydvd.setRating(rating);
            String studio = con.getString("Enter productin studio: ");
            mydvd.setStudio(studio);

            List<String> notes = new ArrayList<>();
            boolean addAnotherNote = false;
            String dvdNotes;

            do {
                dvdNotes = con.getString("Enter personal note or enter to continue");

                if (dvdNotes.equals("")) {
                    break;
                }
                notes.add(dvdNotes);

                String addAnother = con.getString("Want to enter more notes? Y/N");

                if (addAnother.equalsIgnoreCase("Y")) {
                    addAnotherNote = true;
                }
            } while (addAnotherNote);

            mydvd.setNotes(notes);

            dao.addDVD(mydvd);

            String add1More = con.getString("Wish to add more DVDs? Y/N");
            if (add1More.equalsIgnoreCase("Y")) {
                addMoreDVD = true;
            }

        } while (addMoreDVD);

    }//done

    private void removeDVD() {
        boolean deleteMore;

        do {
            deleteMore = false;
            searchDVDByTitle();

            int remove = con.getInt("\rEnter ID to remove");
            dao.removeDVD(remove);
            con.String("Done!");

        } while (deleteMore);

    }//done

    private void editDVD() {

            //       searchDVDByTitle();
        //search for DVD:
        String title = con.getString("Enter Title to search:");

        List<DVD> dvdTitle = dao.searchDVDByTitle(title);
        con.String("\nDVDs BY TITLE:");

        if (dvdTitle.size() > 0) {

            for (DVD results : dvdTitle) {
                con.String("\tID:"+ results.getId());
                con.String("\tTitle: " + results.getTitle());
                con.String("\tRelease Date: " + results.getReleaseDate());
                con.String("\tDirector: " + results.getDirector());
                con.String("\tMPAA Rating: " + results.getRating());
                con.String("\tStudio: " + results.getStudio());

                if (results.getNotes().size() > 0) {
                    con.String("Notes:");

                    for (String notes : results.getNotes()) {
                        con.String("\t" + notes + "\n");
                    }
                }
            }

            // ask for DVD ID to edit    
            int editNum = con.getInt("Enter ID to edit DVD: ");
            if (editNum > dvdTitle.size()){
                con.String("Invalid");
                return;
            }
            DVD editThis = dao.findDVDById(editNum);

            // check if it matches
            if (dao.searchDVDByTitle(title).contains(editThis)
                    && editThis.getId() == editNum) {

                // edit information
                con.String("Enter new information or enter to keep");
                con.getString((""));
                
                String newTitle = con.getString("Enter new Title: "
                        + editThis.getTitle());
                editThis.setTitle(newTitle);

                String newReleaseDate = con.getString("Enter new Release date: "
                        + editThis.getReleaseDate());
                editThis.setReleaseDate(newReleaseDate);

                String newDirector = con.getString("Enter new Director name: "
                        + editThis.getDirector());
                editThis.setDirector(newDirector);

                String newRating = con.getString("Enter new MPAA Rating: "
                        + editThis.getRating());
                editThis.setReleaseDate(newRating);

                String newStudio = con.getString("Enter new Studio : "
                        + editThis.getStudio());
                editThis.setStudio(newStudio);

                // create a new list for the notes
                List<String> notes = new ArrayList<>();
                boolean addAnother = false;

                if (editThis.getNotes().size() > 0) {
                    con.String("Notes:");

                    for (String notez : editThis.getNotes()) {
                        String newNotes = con.getString("Enter new Note: "
                                + notez);

                        //check to see if note is not empty and then add
                        if (!newNotes.trim().equals("")) {
                            notes.add(newNotes);
                        } else {
                            notes.add(notez);
                        }

                    }
                }

                //ask to add notes to the dvd
                String dvdNotes;

                do {

                    dvdNotes = con.getString("Enter new notes or Enter to continue");

                    if (dvdNotes.equals("")) {
                        break;
                    }
                    notes.add(dvdNotes);
                    String addMore = con.getString("Enter more notes? Y/N");
                    if (addMore.equalsIgnoreCase("Y")) {
                        addAnother = true;
                    }
                } while (addAnother);

            } else {
                con.String("Invalid input");
            }
        } else {
            con.String("NOT FOUND");
        }

        con.String("\n");
    }// done

    private void countDVD() {
        con.String("Total: " +dao.countDVD());
    }//done

    private void listAllDVD() {

        List<DVD> listAll = dao.listAllDVD();

        if (listAll.size() > 0) {

            for (DVD results : listAll) {
                con.String("\tTitle: " + results.getTitle());
                con.String("\tRelease Date: " + results.getReleaseDate());
                con.String("\tDirector: " + results.getDirector());
                con.String("\tMPAA Rating: " + results.getRating());
                con.String("\tStudio: " + results.getStudio());

                if (results.getNotes().size() > 0) {
                    con.String("Notes:");

                    for (String notes : results.getNotes()) {
                        con.String("\t\t" + notes);
                    }
                }
            }
            /*           dao.listAllDVD().stream()
             .forEach(d -> {
             con.String("ID:" + d.getId());
             con.String("Title: " + d.getTitle());
             con.String("Rlease Date: " + d.getReleaseDate());
             con.String("Director: " + d.getDirector());
             con.String("MPAA Rating: " + d.getRating());
             con.String("Studio: " + d.getStudio());
             });
             // how to use lambba to get notes? 
             */

        } else {
            con.String("Zero entries found...");
        }

        con.String("\n");
    }//done

    private void searchDVDByTitle() {
        boolean byTitle;

        do {
            byTitle = false;

            String title = con.getString("Enter Title to search:");

            List<DVD> dvdTitle = dao.searchDVDByTitle(title);
            con.String("\nDVDs BY TITLE:");

            if (dvdTitle.size() > 0) {

                /*            dao.searchDVDByTitle(title).stream()
                 .forEach(t -> {
                 con.String("\tTitle: " + t.getTitle());
                 con.String("\tRelease Date: " + t.getReleaseDate());
                 con.String("\tDirector: " + t.getDirector());
                 con.String("\tMPAA Rating: " + t.getRating());
                 con.String("\tStudio: " + t.getStudio());
                 });
                 // how to lambda string? 
                 */
                for (DVD results : dvdTitle) {
                    con.String("\tID:"+ results.getId());
                    con.String("\tTitle: " + results.getTitle());
                    con.String("\tRelease Date: " + results.getReleaseDate());
                    con.String("\tDirector: " + results.getDirector());
                    con.String("\tMPAA Rating: " + results.getRating());
                    con.String("\tStudio: " + results.getStudio());

                    if (results.getNotes().size() > 0) {
                        con.String("Notes:");

                        for (String notes : results.getNotes()) {
                            con.String("\t" + notes);
                        }
                    }
                }

            } else {
                con.String("NOT FOUND");
            }

            String searchMore = con.getString("Search more DVDs? Y/N");

            if (searchMore.equalsIgnoreCase("Y")) {
                byTitle = true;
            }

        } while (byTitle);
        con.String("\n");

    }//done

    private void searchDVDByYears() {

        boolean byYears;

        do {
            byYears = false;

            int year = con.getInt("Enter year to see DVD in that man years");

            List<DVD> years = dao.searchDVDByYears(year);

            con.String("\nDVDs BY YEARS");

            if (years.size() > 0) {

                for (DVD results : years) {
                   con.String("\tID:"+ results.getId());
                   con.String("\tTitle: " + results.getTitle());
                    con.String("\tRelease Date: " + results.getReleaseDate());
                    con.String("\tDirector: " + results.getDirector());
                    con.String("\tMPAA Rating: " + results.getRating());
                    con.String("\tStudio: " + results.getStudio());

                    if (results.getNotes().size() > 0) {
                        con.String("Notes:");

                        for (String notes : results.getNotes()) {
                            con.String("\t" + notes);
                        }
                    }
                }

            } else {
                con.String("NOT FOUND");
            }

            String searchMore = con.getString("Search more? Y/N");

            if (searchMore.equalsIgnoreCase("Y")) {
                byYears = true;
            }
        } while (byYears);
        con.String("\n");
    }//done

    private void searchDVDByRating() {

        boolean byRating;

        do {
            byRating = false;

            String rating = con.getString("Enter MPAA rating to search for DVDs by rating");

            List<DVD> rate = dao.searchDVDByRating(rating);
            con.String(("\nDVDs BY RATING: "));

            if (rate.size() > 0) {

                for (DVD results : rate) {
                  con.String("\tID:"+ results.getId());
                  con.String("\tTitle: " + results.getTitle());
                    con.String("\tRelease Date: " + results.getReleaseDate());
                    con.String("\tDirector: " + results.getDirector());
                    con.String("\tMPAA Rating: " + results.getRating());
                    con.String("\tStudio: " + results.getStudio());

                    if (results.getNotes().size() > 0) {
                        con.String("Notes: ");
                        for (String notes : results.getNotes()) {
                            con.String("\t" + notes);
                        }
                    }
                    con.String("");
                }

            } else {
                con.String("NOT FOUND");
            }
            String searchMore = con.getString("Search more? Y/N");

            if (searchMore.equalsIgnoreCase("Y")) {
                byRating = true;
            }

        } while (byRating);
        con.String("\n");
    }//done

    private void searchDVDByDirectorThanRating() {
        boolean searchdir;

        do {

            searchdir = false;

            String director = con.getString("Enter Director name to search: ");

            Map<String, List<DVD>> diry = dao.searchDVDByDirectorThanRating(director);

            Collection<List<DVD>> groupByRating = diry.values();

            for (List<DVD> dvds : groupByRating) {
                for (DVD results : dvds) {
                    con.String("\tID:"+ results.getId());
                    con.String("\tTitle: " + results.getTitle());
                    con.String("\tRelease Date: " + results.getReleaseDate());
                    con.String("\tDirector: " + results.getDirector());
                    con.String("\tMPAA Rating: " + results.getRating());
                    con.String("\tStudio: " + results.getStudio());

                    if (results.getNotes().size() > 0) {
                        con.String("NOTES:");
                        for (String notes : results.getNotes()) {
                            con.String("\t" + notes);
                        }

                    }
                }
                con.String("");

            }

        } while (searchdir);
        con.String("\n");
    }//done

    private void searchDVDByStudio() {
        boolean searchAnotherStudio;
        do {
            searchAnotherStudio = false;

            String studio = con.getString("Enter studio name: ");

            List<DVD> byStudio = dao.searchDVDByStudio(studio);
            con.String("\nDVDs BY STUDIO: ");

            if (byStudio.size() > 0) {

                for (DVD results : byStudio) {
                   con.String("\tID:"+ results.getId());
                   con.String("\tTitle: " + results.getTitle());
                    con.String("\tRelease Date: " + results.getReleaseDate());
                    con.String("\tDirector: " + results.getDirector());
                    con.String("\tMPAA Rating: " + results.getRating());
                    con.String("\tStudio: " + results.getStudio());

                    if (results.getNotes().size() > 0) {
                        con.String("\tNOTES: ");

                        for (String notes : results.getNotes()) {
                            con.String("\t" + notes);
                        }

                    }
                    con.String("");
                }
            } else {
                con.String("\rNo Results Found\r");
            }
            String more = con.getString("Search for more? Y/N");
            if (more.equalsIgnoreCase("Y")) {
                searchAnotherStudio = true;
            }
        } while (searchAnotherStudio);
        con.String("\n");
    }//done

    private void avgMovieAge() {
        con.String("\nAVERAGE AGE: " + dao.getAvgMovieAge());
    }//done

    private void avgNotes() {
        con.String("\nAVERAGE NUMBER OF NOTES: " + dao.getAvgNotes());
    }//done

    private void listNewestDVD() {

        List<DVD> newest = dao.listNewestDVD();
        con.String("\nLIST OF NEWEST DVDS:");

        if (newest.size() > 0) {

            for (DVD results : newest) {
               con.String("\tID:"+ results.getId());
               con.String("\tTitle: " + results.getTitle());
                con.String("\tRelease Date: " + results.getReleaseDate());
                con.String("\tDirector: " + results.getDirector());
                con.String("\tMPAA Rating: " + results.getRating());
                con.String("\tStudio: " + results.getStudio());

                if (results.getNotes().size() > 0) {
                    con.String("\tNOTES: ");
                    for (String note : results.getNotes()) {
                        con.String("\t" + note);
                    }
                }
            }
            con.String("");

        } else {
            con.String("\rNo Results\r");
        }
    }//done

    private void listOldestDVD() {

        List<DVD> oldest = dao.listOldestDVD();
        con.String("\nLIST OF OLDEST DVDS: ");

        if (oldest.size() > 0) {

            for (DVD results : oldest) {
               con.String("\tID:"+ results.getId());
               con.String("\tTitle: " + results.getTitle());
                con.String("\tRelease Date: " + results.getReleaseDate());
                con.String("\tDirector: " + results.getDirector());
                con.String("\tMPAA Rating: " + results.getRating());
                con.String("\tStudio: " + results.getStudio());

                if (results.getNotes().size() > 0) {
                    con.String("\tNOTES: ");
                    for (String notes : results.getNotes()) {
                        con.String("\t" + notes);
                    }
                }
                con.String("");
            }

        } else {
            con.String("\r No Results");
        }
    }//done

}
