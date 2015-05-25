/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.tipcalculator;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class TipCalculatorController {

    @RequestMapping(value="displayTippingCalc", method=RequestMethod.GET)
    public String displayTippingCalc(HttpServletRequest req, Model model) {
        return "displayTippingCalc";
    }
    
    @RequestMapping(value="submitTippingCalc", method=RequestMethod.POST)
    public String submitTippingCalc(HttpServletRequest req, Model model){
        
        String userValue = req.getParameter("value");
        String userTip = req.getParameter("tip");
         
        String errorMessage = "Invalid, try again.";
        String errorMessage1 = "Invalid, try again.";
        
        
        double value = 0;
        double tip = 0;
        double tipPer = 0;
        double total=0;
        
        try {
            value = Integer.parseInt(req.getParameter("value"));         
        } catch (Exception e){
            model.addAttribute("errorMessage", errorMessage);
            return "displayTippingCalc";
        }
        
         try {
            tipPer = Integer.parseInt(req.getParameter("tip"));
            
        } catch (Exception e){
            model.addAttribute("errorMessage1", errorMessage1);
            return "displayTippingCalc";
        }
                
        tip = value * (tipPer/100);
        total = value + tip;
        
        model.addAttribute("errorMessage", errorMessage);
        model.addAttribute("errorMessage1", errorMessage1);
        model.addAttribute("value", value);
        model.addAttribute("tipPer", tipPer);
        model.addAttribute("tip", tip);
        model.addAttribute("total", total);
        
        
        
        return "tipCalcResults";
    }
}
