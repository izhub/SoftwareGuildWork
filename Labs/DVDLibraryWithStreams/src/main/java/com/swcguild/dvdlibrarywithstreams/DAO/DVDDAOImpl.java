/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrarywithstreams.DAO;

import com.swcguild.consoleio.ConsoleIO;
import com.swcguild.dvdlibrarywithstreams.DTO.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class DVDDAOImpl implements DVDDAO {

    ConsoleIO con = new ConsoleIO();
    Map<Integer, DVD> dvdMap = new HashMap<>();

    public static int counter = 0;

    private static final String DVD_FILE = "dvds.txt";
    private static final String DELIMITER = "::";

    @Override
    public void loadDVD() throws FileNotFoundException {

        Scanner file = new Scanner(new BufferedReader(new FileReader(DVD_FILE)));

        String line;
        String[] lineTokens;

        while (file.hasNext()) {
            line = file.nextLine();
            lineTokens = line.split(DELIMITER);

            DVD newDVD = new DVD();
            newDVD.setId(Integer.parseInt(lineTokens[0]));
            newDVD.setTitle(lineTokens[1]);
            newDVD.setReleaseDate(lineTokens[2]);
            newDVD.setRating(lineTokens[3]);
            newDVD.setDirector(lineTokens[4]);
            newDVD.setStudio(lineTokens[5]);

            List<String> notes = new ArrayList<>();
            if (lineTokens.length > 6) {
                String notesToken[] = lineTokens[6].split("\\|");

                for (int i = 0; i < notesToken.length; i++) {
                    notes.add(notesToken[i]);
                }
            }
            newDVD.setNotes(notes);
            dvdMap.put(newDVD.getId(), newDVD);
            
            if (Integer.parseInt(lineTokens[0]) > counter){
                counter = Integer.parseInt(lineTokens[0]);
            }
        }
        file.close();
    }

    @Override
    public void writeDVD() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(DVD_FILE));

        dvdMap.values().stream()
                .forEach(dv -> {
                    out.print(dv.getId() + DELIMITER
                            + dv.getTitle() + DELIMITER
                            + dv.getDirector() + DELIMITER
                            + dv.getRating() + DELIMITER
                            + dv.getReleaseDate() + DELIMITER
                            + dv.getStudio()); 
                    if (dv.getNotes().size() > 0) {
                        out.print(DELIMITER);
                        dv.getNotes().stream()
                        .forEach(n -> out.print(n + "|"));
                    }
                    out.println("");

                });

// Enhance for loop method:
//        Collection<DVD> dvds = dvdMap.values();
//
//        for (DVD dvd : dvds) {
//            out.println(dvd.getId() + DELIMITER
//                    + dvd.getTitle() + DELIMITER
//                    + dvd.getDirector() + DELIMITER
//                    + dvd.getRating() + DELIMITER
//                    + dvd.getStudio() + DELIMITER
//                    + dvd.getReleaseDate() + DELIMITER
//                    + dvd.getNotes());
//        }
        out.flush();
        out.close();
    }

    @Override
    public void addDVD(DVD newdvd) {
        newdvd.setId(++counter);
        dvdMap.put(newdvd.getId(), newdvd);
    }

    @Override
    public void removeDVD(int id) {
            dvdMap.remove(id);
    }

    @Override
    public void editDVD(int id, DVD currentDVD) {
        if (dvdMap.containsKey(id)) {
            dvdMap.put(id, currentDVD);
        }
    }

    @Override
    public int countDVD() {
        return dvdMap.size();
    }

    @Override
    public DVD findDVDById(int id) {
        List<DVD> results = dvdMap.values().stream()
                .filter(d -> d.getId() == id)
                .collect(Collectors.toList());
        return results.get(0);
    }

    @Override
    public DVD displayDVD(String name){
        
        List<DVD> result = dvdMap.values()
                .stream()
                .filter(d -> d.getTitle().equalsIgnoreCase(name))
                .collect(Collectors.toList());

        if (result.size() > 0) {
            return result.get(0);
        } else {
            return new DVD();
        }
    }
    
    @Override
    public List<DVD> listAllDVD() {
        return dvdMap.values().stream()
                .collect(Collectors.toList());
    }

    @Override
    public List<DVD> searchDVDByTitle(String title) {
        return dvdMap.values().stream()
                .filter(dt -> dt.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());

    }

    @Override
    public List<DVD> searchDVDByRating(String rating) {
       return dvdMap.values().stream()
                .filter(dr -> dr.getRating().equalsIgnoreCase(rating))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<DVD>> searchDVDByDirectorThanRating(String director) {
        return dvdMap.values().stream()
                .filter(dd -> dd.getDirector().contains(director))
                .collect((Collectors.groupingBy(DVD::getRating)));
    }

    @Override
    public List<DVD> searchDVDByStudio(String studio) {
        return dvdMap.values().stream()
                .filter(ds -> ds.getStudio().equalsIgnoreCase(studio))
                .collect(Collectors.toList());
    }

    @Override
    public List<DVD> searchDVDByYears(int year) {
        return dvdMap.values().stream()
                .filter(dy -> dy.getDVDAge() <= year)
                .collect(Collectors.toList());
    }   

    @Override
    public double getAvgMovieAge() {
        return dvdMap.values().stream()
                .mapToLong(DVD::getDVDAge) //why map to long and not double?
                .average()
                .getAsDouble();
        
    }

    @Override
    public double getAvgNotes() {
        return dvdMap.values().stream()
                .mapToDouble(dn -> dn.getNotes().size())
                .average()
                .getAsDouble();
    }

    @Override
    public List<DVD> listNewestDVD() {
        return dvdMap.values().stream()
                .filter(nd -> nd.getDVDAge() <= 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<DVD> listOldestDVD() {
        Long getMaxAge = dvdMap.values().stream()
                .mapToLong(DVD::getDVDAge)
                .max().getAsLong();

        return dvdMap.values().stream()
                .filter(od -> od.getDVDAge() == getMaxAge)
                .collect(Collectors.toList());
    }

}
