/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrarynoajax;

import com.swcguild.dvdlibrarynoajax.dao.DVDDaoInMemImpl;
import com.swcguild.dvdlibrarynoajax.model.DVD;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author apprentice
 */

@Controller
public class HomeController {
    
   
    @RequestMapping(value={"/","/home"},method=RequestMethod.GET)
    public String displayHomePage(){
        return "home";
    }

    private DVDDaoInMemImpl dao;
    
    @Inject
    public HomeController(DVDDaoInMemImpl dao){
        this.dao=dao;
    }
    
    @RequestMapping(value="/dvd/{id}", method=RequestMethod.GET)
    @ResponseBody
    public DVD getDvd(@PathVariable("id") int id){
        return dao.getDvdById(id);
    }
    @RequestMapping(value="/dvd", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public DVD createDvd(@Valid @RequestBody DVD dvd){
         dao.addDvd(dvd);
         return dvd;
    }
    @RequestMapping(value="/dvd/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDvd(@PathVariable("id") int id){
        dao.removeDvd(id);
    }
    
    @RequestMapping(value="/dvd/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putDvd(@PathVariable("id") int id, @RequestBody DVD dvd){
        dvd.setDvdId(id);
        dao.updateDvd(dvd);
    }
    @RequestMapping(value="/dvds", method=RequestMethod.GET)
    @ResponseBody
    public List<DVD> getAllDvds(){
        return dao.getAllDvds();
    }
}
