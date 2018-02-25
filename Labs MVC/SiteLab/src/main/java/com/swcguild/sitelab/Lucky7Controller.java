/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.sitelab;

import java.util.Random;
import javax.servlet.RequestDispatcher;
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
@RequestMapping("Lucky7")
public class Lucky7Controller {
    
    @RequestMapping(value="displayLucky7", method=RequestMethod.GET)
    public String displayLucky7(HttpServletRequest req, Model model){
        return "Lucky7/displayLucky7";
    }
    
    @RequestMapping(value="submitLucky7", method=RequestMethod.POST)
    public String submitLucky7(HttpServletRequest req, Model model){
        
        String guestAnswer = req.getParameter("answer");
        String responseMessage = "";
        String errorMessage = "Enter a real number to play.";
        
         int money = 0;

        try {
            money = Integer.parseInt(req.getParameter("answer"));

        } catch (Exception e) {
            model.addAttribute("errorMessage", errorMessage);
        return "Lucky7/displayLucky7";
        }

        Random r = new Random();
        
        int roll = 1;
       
        int maxMoney = 0;
        int maxRoll = 0;
         
          
        do {
            int dice1 = 1 +r.nextInt(6); 
            int dice2 = 1 + r.nextInt(6);
            roll++;     
               
        if (dice1 + dice2 == 7) {
            money = money + 4;
        } else {
            money -= 1;
        }
        if (money > maxMoney){
            maxMoney = money;
            maxRoll = roll;
        }
        
        } while (money > 0);

        responseMessage = ("You are broke after " + roll + " You should have quit after " + maxRoll
                + " when you had " + maxMoney);
        
        model.addAttribute("responseMessage", responseMessage);
        
        return "Lucky7/lucky7Results";
    }
}
