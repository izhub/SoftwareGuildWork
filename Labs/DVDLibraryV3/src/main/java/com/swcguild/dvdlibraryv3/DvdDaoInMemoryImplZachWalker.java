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
public class DvdDaoInMemoryImplZachWalker implements DvdLibraryDao {
    Map<Integer,Dvd> list = new HashMap<>();
    int id =0;
    
    @Override
    public void add(Dvd dvd) {
        id++;
        dvd.setId(id);
        list.put(dvd.getId(),dvd);   
    }
    @Override
    public List<Dvd> listAll() {
       
        return list.values().stream().collect(Collectors.toList());
    }

    @Override
    public List<Dvd> getByTitle(String title) {
       return list.values().stream().filter(s -> s.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
    }

    @Override
    public List<Dvd> getByRating(String rating) {
        return  list.values().stream().filter(s -> s.getMpaaRating().equalsIgnoreCase(rating)).collect(Collectors.toList());
    }

    @Override
    public List<Dvd> getByStudio(String studio) {
        return list.values().stream().filter(s -> s.getStudio().equalsIgnoreCase(studio)).collect(Collectors.toList());
    }

    @Override
    public void remove(int id) {
        list.remove(id);
    }

    @Override
    public Dvd getById(int id) {
        return list.get(id);
    }
    
}
