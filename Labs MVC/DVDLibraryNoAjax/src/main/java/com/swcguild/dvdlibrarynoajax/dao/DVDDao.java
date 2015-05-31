/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrarynoajax.dao;

import com.swcguild.dvdlibrarynoajax.model.DVD;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface DVDDao {
    
    public DVD addDvd(DVD dvd);
    
    public void removeDvd(int dvdId);
    
    public void updateDvd(DVD dvd);
    
    public List<DVD> getAllDvds();
    
    public DVD getDvdById(int dvdId);
    
    public List<DVD> searchDvds (Map<SearchTerm, String> criteria);
    
    //Map has SearchTerm as keys, guarantees that callers will only be able 
    // to specify valid search criteria
}
