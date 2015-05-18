/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrarywithstreams.DAO;

import com.swcguild.dvdlibrarywithstreams.DTO.DVD;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface DVDDAO {

    public void loadDVD() throws FileNotFoundException;
    public void writeDVD() throws IOException;

    public void addDVD(DVD dvd);
    public void removeDVD(int id);
    public void editDVD(int id, DVD currentDVD);
    public DVD displayDVD(String name);
    public DVD findDVDById(int id);
    public int countDVD();
    
    public List<DVD> searchDVDByTitle(String title);
    public List<DVD> listAllDVD();
    public List<DVD> searchDVDByYears(int year);
    public List<DVD> searchDVDByRating(String rating);

    public Map<String, List<DVD>> searchDVDByDirectorThanRating(String director);

    public List<DVD> searchDVDByStudio(String studio);
    public List<DVD> listNewestDVD();
    public List<DVD> listOldestDVD();

    public double getAvgMovieAge();
    public double getAvgNotes();

}
