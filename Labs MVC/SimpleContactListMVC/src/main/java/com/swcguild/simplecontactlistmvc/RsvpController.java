/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.simplecontactlistmvc;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class RsvpController {
    
    @RequestMapping(value="displayRsvpForm", method=RequestMethod.GET)
    public String displayRsvpForm(HttpServletRequest req, Model model){
        return "displayRsvpForm";
    }
    
    @RequestMapping(value="submitRsvpForm", method=RequestMethod.POST)
    public String submitRsvpForm(HttpServletRequest req, Model model){
        
        String guestAnswer = req.getParameter("answer");
        
        String responseMessage = "";
        if(guestAnswer.equalsIgnoreCase("no")){
            responseMessage = "Bummer - Bill doesn't want you anyway!";
        } else {
            responseMessage = "Bill Can't wait to see you!";
        }
        
        model.addAttribute("responseMessage", responseMessage);
        
        
        return "rsvpResult";
    }
}
