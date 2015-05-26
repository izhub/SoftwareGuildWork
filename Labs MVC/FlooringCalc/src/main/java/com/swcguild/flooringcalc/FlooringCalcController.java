/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringcalc;

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
public class FlooringCalcController {
    
    @RequestMapping(value="displayFlooringCalc", method=RequestMethod.GET)
    public String displayFlooringCalc(HttpServletRequest req, Model model){
        return "displayFlooringCalc";
    }
    
    @RequestMapping(value="submitFlooringCalc", method=RequestMethod.POST)
    public String submitFlooringCalc(HttpServletRequest req, Model model){
        
        double width = 0;
        double length = 0;
        double costPerSqrFoot = 0;
                
        String errorMessage = "Invalid. Try again";
        String errorMessage1 = "Invalid. Try again";
        String errorMessage2 = "Invalid. Try again";
        
        try {
            width = Double.parseDouble(req.getParameter("width"));        
        } catch (Exception e) {
            model.addAttribute("errorMessage", errorMessage);
            return "displayFlooringCalc";
        }
        
        try {
            length = Double.parseDouble(req.getParameter("length"));
        } catch (Exception e) {
            model.addAttribute("errorMessage1", errorMessage1);
            return "displayFlooringCalc";
        }
        
         try {
            costPerSqrFoot = Double.parseDouble(req.getParameter("costPerSqrFoot"));
        } catch (Exception e) {
            model.addAttribute("errorMessage2", errorMessage2);
            return "displayFlooringCalc";
        }
         
        
        double area = width * length;
        final double LABOR_COST_PER_HOUR = 86;
        final double SQUARE_FOOT_PER_HOUR = 20;
        double laborCostPer15Min = LABOR_COST_PER_HOUR / 4;
        
        double flooringCost = area * costPerSqrFoot;
        double flooringTime = Math.floor(area/ SQUARE_FOOT_PER_HOUR);
        double flooringMod = ((area / SQUARE_FOOT_PER_HOUR) - flooringTime) * 60;
        double laborCostHour = flooringTime * LABOR_COST_PER_HOUR;
        double laborCost15Min = Math.ceil(flooringMod / 15) * laborCostPer15Min;
        double laborCostTotal = laborCostHour + laborCost15Min;
        
        String result = "Total area: " + area + " sqaure foot<br>";
        result += "Flooring cost: $" + String.format("%.2f", flooringCost) + "<br>";
        result += "Labor Cost: $" + String.format("%.2f", laborCostTotal) + "<br>";
        result += "Total Cost: $" + String.format("%.2f", (flooringCost + laborCostTotal));
        
        model.addAttribute("result", result);
        
        return "flooringCalcResults" ;
    }
    
                 
}
