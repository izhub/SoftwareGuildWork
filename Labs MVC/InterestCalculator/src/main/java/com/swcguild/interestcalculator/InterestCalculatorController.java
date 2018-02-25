/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.interestcalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServlet;
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
public class InterestCalculatorController {

    @RequestMapping(value = "displayInterestCalc", method = RequestMethod.GET)
    public String displayInterestCalc(HttpServletRequest req, Model model) {
        return "displayInterestCalc";
    }

    @RequestMapping(value = "submitInterestCalc", method = RequestMethod.POST)
    public String submitInterestCalc(HttpServletRequest req, Model model) {

        String userPrincipal = req.getParameter("principal");
        String userInterest = req.getParameter("interest");
        String userPeriod = req.getParameter("period");
        
        String errorMessage = "Invalid. Try again";
        String errorMessage1 = "Invalid. Try again";
        String errorMessage2 = "Invalid. Try again";

        float pBal = 0;
        float aInterest = 0;
        int period = 0;

        float qInt = 0;
        float cBal = 0;
        float iEarned = 0;
        int feq = 0;
        
  // new amount each quarter is equal to: CurrentBalance * (1 + (QuarterlyInterestRate / 100))
     
        try {
            pBal = Integer.parseInt(req.getParameter(userPrincipal));
        } catch (Exception e) {
            model.addAttribute("errorMessage", errorMessage);
            return "displayInterestCalc";
        }
      
        cBal = pBal;

        try {
            aInterest = Integer.parseInt(req.getParameter(userInterest));            
        }catch (Exception e) {
            model.addAttribute("errorMessage1", errorMessage1);
             return "displayInterestCalc";
        }
        
        try {
            period = Integer.parseInt(req.getParameter(userPeriod));            
        }catch (Exception e) {
            model.addAttribute("errorMessage2", errorMessage2);
             return "displayInterestCalc";
        }
        

        if (1 == Integer.parseInt(req.getParameter("int"))) {
            feq = 4;
        } else if (2 == Integer.parseInt(req.getParameter("int"))) {
            feq = 12;
        } else if (3 == Integer.parseInt(req.getParameter("int"))) {
            feq = 365;
        } else {
            feq = 1;
        }
        qInt = (aInterest / feq) / 100;

/*       Map<Integer, List<Integer>> hash = new HashMap<Integer, List<Integer>>();
        
        
        for (int i = 1; i<= period; i++) {
            List<Integer> intervals = new ArrayList<>();
                 
         intervals.add(cBal);

        for (int j = 1; j <= feq; j++) {
                  cBal = cBal
                iEarned = cBal * qInt;
                cBal = cBal + iEarned;
                
            }
        
        intervals.add(iEarned);        
        intervals.add(cBal);
        
//        hash.put(i, intervals);
//        }
        
        
 */
        String results = "";
        
        for (int i = 1; i <= period; i++) {
            results +="<p>For year: " + i+ "<br>";
            

            for (int j = 1; j <= feq; j++) {
                results +="Period: " + j + " | Beginning balance: $" + cBal+" |";
                iEarned = cBal * qInt;
                cBal = cBal + iEarned;
                results += "| Interest earned: $" + String.format("%.2f", iEarned) + " | Ending balance: $" + String.format("%.2f", cBal)+"<br>";            }
        }

  
        
      model.addAttribute("results", results);
        
//        model.addAttribute("hash", hash);
        
        return "interestCalcResults";
        
        
        
    }
    
    
    
}

