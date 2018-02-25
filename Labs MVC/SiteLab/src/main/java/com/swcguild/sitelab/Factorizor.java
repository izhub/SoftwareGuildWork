/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.sitelab;

import java.util.ArrayList;
import java.util.List;
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
@RequestMapping("Factorizor")
public class Factorizor {
    
    @RequestMapping(value="/displayFactorizor", method=RequestMethod.GET)
    public String displayFactorizor(HttpServletRequest req, Model model){
        return "Factorizor/displayFactorizor";
    }
    
    @RequestMapping(value ="submitFactorizor", method=RequestMethod.POST)
    public String submitFactorizor(HttpServletRequest req, Model model){
        String guestAnswer = req.getParameter("answer");
        String errorMessage="Enter real number. " ;
        String responsePrime="";
        String responseSquare="";
               
        
        int num = 0;
        
        try {
            num = Integer.parseInt(req.getParameter("answer"));
        } catch (Exception e) {
            model.addAttribute("errorMessage", errorMessage);
            return "Factorizor/displayFactorizor";
        }
        
        int count = 0;
        int sum = 0;

        List<Integer> responseFactors  = new ArrayList<>(); 
        for (int i = 1; i < num; i++) {

            if (num % i == 0) {
                count++;
                sum += i;
                responseFactors.add(i);
            }                      

        }
                      
        if (sum == num) {
            responseSquare = (num + " is a perfect square.");
        } else {
            responseSquare = (num + " is not a perfect square.");
        }
        
        if (count > 2) {
                responsePrime = (num + " is not a prime number.");
            } else {
                responsePrime = (num + " is a prime number.");
            }
        
        
        model.addAttribute("responsePrime", responsePrime);
        model.addAttribute("count", count);
        model.addAttribute("guestAnswer", guestAnswer);
        model.addAttribute("responseSquare", responseSquare);
        model.addAttribute("responseFactors", responseFactors);
        
        return "Factorizor/factorizorResults";
        
    }
    
    
    
    
    
}
