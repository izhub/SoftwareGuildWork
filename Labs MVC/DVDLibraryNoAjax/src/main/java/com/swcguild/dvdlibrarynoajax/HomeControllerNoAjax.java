/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrarynoajax;

import com.swcguild.dvdlibrarynoajax.dao.DVDDao;
import com.swcguild.dvdlibrarynoajax.model.DVD;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class HomeControllerNoAjax {
    
    //reference to our DAO interface
    private  DVDDao dao;
    
    //user annotation driven constructor injection to inject DAO implementation
    // into controller
    
    @Inject
    public HomeControllerNoAjax(DVDDao dao){
        this.dao=dao;
    }
    //this endpoint returns name of view: displayDVDDaoNoAjax.jsp
    @RequestMapping(value="/displayDVDDaoNoAjax", method=RequestMethod.GET)
    public String displayDVDDaoNoAjax(Model model){
        
        //get list of all contacts
        List<DVD> dList = dao.getAllDvds();
        //put list on Model  so spring MVC can pass it to view
        model.addAttribute("dvdList", dList);
        //return logical view name
        return "displayDVDDaoNoAjax";
        
    }
    
    //this endpoint returns name of view that display new dvd Form (newDvdFormNoAjax.jsp)
    //takes no parameters because doesn't need to look at incoming reqeust or 
    // put anything on the model
    @RequestMapping(value="displayNewDvdFormNoAjax", method=RequestMethod.GET)
    public String displayNewDvdFormNoAjax(Model model){
        
        //add this to tag the field to dto for validation check on add form
        model.addAttribute("dvd", new DVD());
        
        return "displayNewDvdFormNoAjax";
    } // now go make newDvdFormNoAjax.jsp form
    
    //this endpoint gets submitted form from HttpServletRequest,
    //creates new dvd object, sets fields on new dvd object, add dvd to DAO and
    // redirects to displayDVDDaoNoAjax controller endpoint
    @RequestMapping(value="/addnew", method=RequestMethod.POST)
    public String addNewDvdNoAjax(@Valid @ModelAttribute("dvd") DVD dvd, BindingResult result, 
            HttpServletRequest req){
        
         if(result.hasErrors()){
            return "displayNewDvdFormNoAjax";
        }
         
        //get all the form data from request
//        String title=req.getParameter("title");
//        String releaseDate = req.getParameter("releaseDate");
//        String mpaaRating = req.getParameter("mpaaRating");
//        String director = req.getParameter("director");
//        String studio = req.getParameter("studio");
//        String note = req.getParameter("note");
//        
//        create new DVD and set all fields
//        DVD dvd = new DVD();
//        dvd.setTitle(title);
//        dvd.setDirector(director);
//        dvd.setMpaaRating(mpaaRating);
//        dvd.setStudio(studio);
//        dvd.setReleaseDate(releaseDate);
//        dvd.setNote(note);
                
        dao.addDvd(dvd);
        
        //redirect to displayDVDDaoNoAjax controller end point - 
        //must redirect here so Spring MVC routes us to controller
        //endpoint and not directly to JSP
        return "redirect:displayDVDDaoNoAjax";
    }
    
    
    //This method gets id of dvd to be deleted from HttpServletrequest and
    // then asks DAO to delte dvd. when done, it redirects to displayDVDDaoNoAjax
    // controller endpoint
    @RequestMapping(value="/deleteDvdNoAjax", method=RequestMethod.GET)
    public String deleteDvdnoAjax(HttpServletRequest req){
        
        //get id of dvd to be deleted from Http
        int dvdId = Integer.parseInt(req.getParameter("dvdId"));
        
        //ask DAO to delete dvd
        dao.removeDvd(dvdId);
        
        //redirect to displayDVDDaoNoAjax controller endpoint
        //must redirect so Spring MVC routes to controller endpoint
        return "redirect:displayDVDDaoNoAjax";
    }
    
    //Now create endpoint that will cause Edit Contact Form to be displayed.  
    //follow the same pattern - first display the form, second process the form, 
    // and third, redirect back to the displayContactListNoAjax endpoint.  
    
    //This method gets id of dvd to be editted from Http and edits it
    
    public String displayEditDvdFormNoAjax(HttpServletRequest req, Model model){
        
        //get id to be edited
        int dvdId = Integer.parseInt(req.getParameter("dvdId"));
        
        //get dvd from dao
        DVD dvd = dao.getDvdById(dvdId);
        
        //put in model
        model.addAttribute("dvd", dvd);
        
        return "editDvdFormNoAjax";
    } // create ^ jsp file now
    
    
    //Finally, create endpoint to process Edit Dvd Form submimssion
    
    //First we need an edit GET method to HttpServlet and put it in the model
    // and then create 2nd edit POST method to update that form
    
      @RequestMapping(value="/editDvdFormNoAjax", method=RequestMethod.GET)
    public String editContactNoAjax(HttpServletRequest req, Model model){
        int dvdId = Integer.parseInt((req.getParameter("dvdId")));
        
        DVD dvd = dao.getDvdById(dvdId);
        
        model.addAttribute("dvd", dvd);
        
        return "editDvdFormNoAjax";
    }
    
    //This method uses @ModelAttribute annotation to tell Spring to convert 
    //submitted form data into Dvd object. Then hands Dvd to DAO for update, 
    //redirects to displayDVDDaoNoAjax controller enpoint
    @RequestMapping(value="/editDvdNoAjax", method=RequestMethod.POST)
    public String editDvdNoAjax(@Valid @ModelAttribute("dvd") DVD dvd, 
            BindingResult result){
        
        if(result.hasErrors()){
            return "editDvdFormNoAjax";
        }
        dao.updateDvd(dvd);
        return "redirect:displayDVDDaoNoAjax";
    }
}
