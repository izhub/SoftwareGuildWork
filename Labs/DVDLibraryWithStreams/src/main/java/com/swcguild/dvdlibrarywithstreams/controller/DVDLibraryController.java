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
import java.util.List;

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
        con.String("13. Average Age of Moviese");
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

            // can code more to check if DVD is already in library .... someday....
        } while (addMoreDVD);
        
        dao.addDVD(mydvd);
        
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
        boolean removeMore;
        
        do {
            removeMore = false;
            
        } while (removeMore);
        con.String("EDIT DVD...");
    }// NOT  done
    

    private void countDVD() {
        dao.countDVD();
    }//done

    private void listAllDVD() {
        if (dao.listAllDVD().size() > 0) {
            
        
        dao.listAllDVD().stream()
                .forEach(d -> {
                    con.String("\nID:" + d.getId());
                con.String("\nTitle: " + d.getTitle());
                con.String("\nRlease Date: " + d.getReleaseDate());
                con.String("\nDirector: " + d.getDirector());
                con.String("\nMPAA Rating: " + d.getRating());
                con.String("\nStudio: " + d.getStudio());
        
                });
        } else {
            con.String("Not found...");
        }
    }//done

    private void searchDVDByTitle() {
        String title = con.getString("Enter DVD title to search: ");
        
        List<DVD> findDVD = dao.searchDVDByTitle(title);
        
        if (dao.searchDVDByTitle(title).size() > 0) {
            
            for (DVD dvds : findDVD ) {
                con.String("\nID:" + dvds.getId());
                con.String("\nTitle: " + dvds.getTitle());
                con.String("\nRlease Date: " + dvds.getReleaseDate());
                con.String("\nDirector: " + dvds.getDirector());
                con.String("\nMPAA Rating: " + dvds.getRating());
                con.String("\nStudio: " + dvds.getStudio());
                
                if (dvds.getNotes().size() > 0) {
                    con.String("\nNotes: ");
                    for (String notes : dvds.getNotes()) {
                        con.String("\t" + notes);
                    }
                }
                con.String("");
                
            }
        } else {
            con.String("Not found...");
        }
        
    }//done

    private void searchDVDByYears() {
        int year = con.getInt("Enter years to see DVDs released in that period: ");
        
        dao.searchDVDByYears(year);

//        List<DVD> temp = dao.searchDVDByYears(Integer.parseInt(year));
//        temp.stream()
//                .forEach(d -> {
//                    con.String(d.getTitle());
//                    con.String(d.getRating());
//                    con.String(d.getReleaseDate());
//                    con.String(d.getDirector());
//                    con.String(d.getStudio());
//                    con.String(d.getNotes().stream()  //not sure on this one
//                            .forEach(n -> n.toString()));
//
//                });
    }//done

    private void searchDVDByRating() {
        String rating = con.getString("Enter MPAA rating to search for DVDs by rating");
        dao.searchDVDByRating(rating);
    }//done

    private void searchDVDByDirectorThanRating() {
        String dir = con.getString("Enter director's name: ");
        dao.searchDVDByDirectorThanRating(dir);
    }//done

    private void searchDVDByStudio() {
        String studio = con.getString("Enter studio name: ");
        dao.searchDVDByStudio(studio);
    }//done

    private void avgMovieAge() {
        dao.getAvgMovieAge();
    }//done

    private void avgNotes() {
        dao.getAvgNotes();
    }//done

    private void listNewestDVD() {
        dao.listNewestDVD();
    }//done

    private void listOldestDVD() {
        dao.listOldestDVD();
    }//done

}
