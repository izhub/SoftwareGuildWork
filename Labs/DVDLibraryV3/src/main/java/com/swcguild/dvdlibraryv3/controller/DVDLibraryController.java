/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryv3.controller;

import com.swcguild.consoleio.ConsoleIO;
import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import com.swcguild.dvdlibrary.dto.Dvd;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class DVDLibraryController {

    ConsoleIO con = new ConsoleIO();

    private final DvdLibraryDao dao;

    public DVDLibraryController(DvdLibraryDao dao) {
        this.dao = dao;
    }

    public void run() {

        int userChoice = 0;

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
                    listAllDVD();
                    break;
                case 5:
                    searchDVDByTitle();
                    break;
                case 6:
                    searchDVDByRating();
                    break;
                case 7:
                    searchDVDByStudio();
                    break;
                case 8:
                    break;
                default:
                    con.String("Invalid choice");

            }
        } while (userChoice != 8);

    }
    // methods...

    private void printMenu() {
        con.String("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        con.String("                DVD Library Menu ");
        con.String("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        con.String("1. Add DVD");
        con.String("2. Delete DVD");
        con.String("3. Edit DVD");
        con.String("4. List All DVDs");
        con.String("5. Search DVD By Title");
        con.String("6. Search DVD By Rating");
        con.String("7. Search DVD By Studio");
        con.String("8. Exit");
        con.String("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    private void addDVD() {
        boolean addMoreDVD;
        con.String("");
        Dvd mydvd = new Dvd();
        do {
            addMoreDVD = false;

            String title = con.getString("Enter Title: ").toUpperCase();
            mydvd.setTitle(title);
            String dir = con.getString("Enter director: ").toUpperCase();
            mydvd.setDirector(dir);
            
            LocalDate date = con.getLocaldeDate("Enter Release date year (YYYY-MM-DD))");
            mydvd.setReleaseDate(date);
            
            String rating = con.getString("Enter MPAA Rating: ");
            mydvd.setMpaaRating(rating);
            String studio = con.getString("Enter productin studio: ");
            mydvd.setStudio(studio);
            String notes = con.getString("Enter notes for dvd: ");
            mydvd.setNote(notes);

            dao.add(mydvd);

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
            dao.remove(remove);
            con.String("Done!");

        } while (deleteMore);

    }//done

    private void editDVD() {

        //       searchDVDByTitle();
        //search for DVD:
        String title = con.getString("Enter Title to search:");

        List<Dvd> dvdTitle = dao.getByTitle(title);
        con.String("\nDVDs BY TITLE:");

        if (dvdTitle.size() > 0) {

            for (Dvd results : dvdTitle) {
                con.String("\tID:" + results.getId());
                con.String("\tTitle: " + results.getTitle());
                con.String("\tRelease Date: " + results.getReleaseDate());
                con.String("\tDirector: " + results.getDirector());
                con.String("\tMPAA Rating: " + results.getMpaaRating());
                con.String("\tStudio: " + results.getStudio());
                con.String("\tNotes: " + results.getNote());

                // ask for DVD ID to edit    
                int editNum = con.getInt("Enter ID to edit DVD: ");
                if (editNum > dvdTitle.size()) {
                    con.String("Invalid");
                    return;
                }

                Dvd editThis = dao.getById(editNum);

                // check if it matches
                if (dao.getByTitle(title).contains(editThis)
                        && editThis.getId() == editNum) {

                    // edit information
                    con.String("Enter new information or enter to keep");
                    con.String((""));

                    String newTitle = con.getString("Enter new Title: "
                            + editThis.getTitle());
                    editThis.setTitle(newTitle);

                    String newReleaseDate = con.getString("Enter new Release date: "
                            + editThis.getReleaseDate());
                    editThis.setReleaseDate(LocalDate.parse(newReleaseDate, DateTimeFormatter.ISO_DATE));

                    String newDirector = con.getString("Enter new Director name: "
                            + editThis.getDirector());
                    editThis.setDirector(newDirector);

                    String newRating = con.getString("Enter new MPAA Rating: "
                            + editThis.getMpaaRating());
                    editThis.setMpaaRating(newRating);

                    String newStudio = con.getString("Enter new Studio : "
                            + editThis.getStudio());
                    editThis.setStudio(newStudio);

                } else {
                    con.String("Invalid input");
                }
            }
        } else {
            con.String("NOT FOUND");
        }

        con.String("\n");
    }// done

    private void listAllDVD() {

        List<Dvd> listAll = dao.listAll();

        if (listAll.size() > 0) {

            for (Dvd results : listAll) {
                con.String("\tTitle: " + results.getTitle());
                con.String("\tRelease Date: " + results.getReleaseDate());
                con.String("\tDirector: " + results.getDirector());
                con.String("\tMPAA Rating: " + results.getMpaaRating());
                con.String("\tStudio: " + results.getStudio());
                con.String("\tNotes: " + results.getNote());
            }

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

            List<Dvd> dvdTitle = dao.getByTitle(title);
            con.String("\nDVDs BY TITLE:");

            if (dvdTitle.size() > 0) {

                for (Dvd results : dvdTitle) {
                    con.String("\tID:" + results.getId());
                    con.String("\tTitle: " + results.getTitle());
                    con.String("\tRelease Date: " + results.getReleaseDate());
                    con.String("\tDirector: " + results.getDirector());
                    con.String("\tMPAA Rating: " + results.getMpaaRating());
                    con.String("\tStudio: " + results.getStudio());
                    con.String("\tNotes: " + results.getNote());

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

    private void searchDVDByRating() {

        boolean byRating;

        do {
            byRating = false;

            String rating = con.getString("Enter MPAA rating to search for DVDs by rating");

            List<Dvd> rate = dao.getByRating(rating);
            con.String(("\nDVDs BY RATING: "));

            if (rate.size() > 0) {

                for (Dvd results : rate) {
                    con.String("\tID:" + results.getId());
                    con.String("\tTitle: " + results.getTitle());
                    con.String("\tRelease Date: " + results.getReleaseDate());
                    con.String("\tDirector: " + results.getDirector());
                    con.String("\tMPAA Rating: " + results.getMpaaRating());
                    con.String("\tStudio: " + results.getStudio());
                    con.String("\tNotes: " + results.getNote());
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

    private void searchDVDByStudio() {
        boolean searchAnotherStudio;
        do {
            searchAnotherStudio = false;

            String studio = con.getString("Enter studio name: ");

            List<Dvd> byStudio = dao.getByStudio(studio);
            con.String("\nDVDs BY STUDIO: ");

            if (byStudio.size() > 0) {

                for (Dvd results : byStudio) {
                    con.String("\tID:" + results.getId());
                    con.String("\tTitle: " + results.getTitle());
                    con.String("\tRelease Date: " + results.getReleaseDate());
                    con.String("\tDirector: " + results.getDirector());
                    con.String("\tMPAA Rating: " + results.getMpaaRating());
                    con.String("\tStudio: " + results.getStudio());
                    con.String("\tNotes: " + results.getNote());

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

}
