/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.unitconverter;

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
public class UnitConvertorController {

    @RequestMapping(value = "displayUnitConvertorController", method = RequestMethod.GET)
    public String displayUnitConvertorController(HttpServletRequest req, Model model) {
        return "displayUnitConvertor";
    }

//    @RequestMapping(value="selectUnitConvertorController", method=RequestMethod.POST)
//    public String selectUnitConvertorContorller(HttpServletRequest req,Model model){
//        return null;
//        
//    }
    @RequestMapping(value = "submitUnitConvertorController", method = RequestMethod.POST)
    public String submitUnitConvertorController(HttpServletRequest req, Model model) {

        double userTemp = Double.parseDouble(req.getParameter("temp"));
        double userLength = Double.parseDouble(req.getParameter("length"));
        double userWeigth = Double.parseDouble(req.getParameter("weight"));

        double cT = 0;
        double cL = 0;
        double cW = 0;

        String lenght;

        double pound;
        double kg;

        double cmToIn = userLength * 0.39;
        double cmToFT = userLength / 30.48;
        double inToCm = userLength / .39;
        double inToFt = userLength / 12;
        double ftToIn = userLength * 12;
        double ftToCmv = userLength * 30.48;
        double kgToLb = userWeigth * 2.2;
        double LbToKg = userWeigth / 2.2;

        String results = "";

//        F to C : ((n - 32) * 5)/9      //        C to F: ((n * 9) / 5) + 32
//1 meter (m) 	39.37 inches (in.)      //1 centimeter (cm) 	0.39 in.
//1 millimeter (mm) 	0.039 in.       //1 yard (yd) 	91.44 centimeters (cm)
//1 foot (ft) 	30.48 cm                //1 inch (in.) 	2.54 cm
//        1 kg = 2.2 lb


            //-----------------------TEMPERATURE CONVERSION ---------------
        if (((Integer.parseInt(req.getParameter("temp1")) == 1)
                && (Integer.parseInt(req.getParameter("temp2")) == 1))
                || ((Integer.parseInt(req.getParameter("temp1")) == 2)
                && (Integer.parseInt(req.getParameter("temp2")) == 2))) {
            cT = userTemp;

        } else if ((Integer.parseInt(req.getParameter("temp1")) == 1)
                && (Integer.parseInt(req.getParameter("temp2")) == 2)) {
            cT = ((userTemp - 32) * 5) / 9;

        } else if ((Integer.parseInt(req.getParameter("temp1")) == 2)
                && (Integer.parseInt(req.getParameter("temp2")) == 1)) {
            cT = ((userTemp * 9) / 5) + 32;
        }

            //------------------ LENGTH CONVERSION ------------------------
        if (((Integer.parseInt(req.getParameter("len1")) == 1)
                && (Integer.parseInt(req.getParameter("len2")) == 1))
                || ((Integer.parseInt(req.getParameter("len1")) == 2)
                && (Integer.parseInt(req.getParameter("len2")) == 2))
                || ((Integer.parseInt(req.getParameter("len1")) == 3)
                && (Integer.parseInt(req.getParameter("len2")) == 3))) {
            
            cL = userTemp;

        } else if ((Integer.parseInt(req.getParameter("len1")) == 1)
                && (Integer.parseInt(req.getParameter("len2")) == 2)) {
            cL = 0;

        }else if ((Integer.parseInt(req.getParameter("len1")) == 1)
                && (Integer.parseInt(req.getParameter("len2")) == 3)) {
            cL = 0;

        } else if ((Integer.parseInt(req.getParameter("temp1")) == 2)
                && (Integer.parseInt(req.getParameter("temp2")) == 1)) {
            cL = 0;
        } else if ((Integer.parseInt(req.getParameter("temp1")) == 2)
                && (Integer.parseInt(req.getParameter("temp2")) == 1)) {
            cL = 0;
        }

              //------------------ Weight CONVERSION ------------------------
        if (((Integer.parseInt(req.getParameter("we1")) == 1)
                && (Integer.parseInt(req.getParameter("we2")) == 1))
                || ((Integer.parseInt(req.getParameter("we1")) == 2)
                && (Integer.parseInt(req.getParameter("we2")) == 2))) {
            cW = userWeigth;

        } else if ((Integer.parseInt(req.getParameter("we1")) == 1)
                && (Integer.parseInt(req.getParameter("we2")) == 2)) {
            cW = userWeigth / 2.2;   //lb  to kg

        } else if ((Integer.parseInt(req.getParameter("we1")) == 2)
                && (Integer.parseInt(req.getParameter("we2")) == 1)) {
            cW = userWeigth * 2.2; //kg to lb
        }

        results += "The temperature conversion is: " + cT
                + "<br>The Length conversion is: " + cL
                + "<br>The weigth conversion is: " + cW;

        model.addAttribute("results", results);

        return "unitConvertorResults";

    }
}
