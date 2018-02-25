/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryv3;

import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import com.swcguild.dvdlibrary.dto.Dvd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class DVDLibraryInMemImplZahidIqbal implements DvdLibraryDao {

    Map<Integer, Dvd> dvds = new HashMap<>();
    public static int counter = 0;

    @Override
    public void add(Dvd dvd) {
        dvd.setId(counter++);
        dvds.put(dvd.getId(), dvd);
    }

    @Override
    public void remove(int id) {
        dvds.remove(id);
    }

    @Override
    public Dvd getById(int id) {
        return dvds.get(id);
    } 

    @Override
    public List<Dvd> listAll() {
        return dvds.values().stream()
                .collect(Collectors.toList());
    }

    @Override
    public List<Dvd> getByTitle(String title) {
        return dvds.values().stream()
                .filter(t -> t.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    @Override
    public List<Dvd> getByRating(String rating) {
        return dvds.values().stream()
                .filter(r -> r.getMpaaRating().equalsIgnoreCase(rating))
                .collect(Collectors.toList());
    }

    @Override
    public List<Dvd> getByStudio(String studio) {
        return dvds.values().stream()
                .filter(s -> s.getStudio().equalsIgnoreCase(studio))
                .collect(Collectors.toList());
    }

}
