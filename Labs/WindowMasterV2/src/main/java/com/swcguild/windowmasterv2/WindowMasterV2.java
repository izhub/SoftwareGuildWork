/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.windowmasterv2;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class WindowMasterV2 {
    public static void main (String[] args){
        
        double height=0;
        double width = 0;
        double costOfWindow = 0; 
        double costOfTrim = 0; 
        double unitCostWindow = 0;                 
        double unitCostTrim = 0;
        double areaOfWindow = 0;
        double perimeterOfTrim = 0;
        double totalCost = 0;
        
        final double MAXHEIGHT = 25.5;
        final double MAXWIDTH = 18.75;
        final double MIN = 1.0;
        
        String strWindow, strTrim,strUnitWindow, strUnitTrim;
        
        Scanner sc = new Scanner (System.in);
        
        do { System.out.println("Enter window height (25.5 - 1.0): ");
        height = Double.parseDouble(sc.nextLine());
        } while (height > MAXHEIGHT || height < MIN);
        
       
        do { System.out.println("Enter width: ");
        width = Double.parseDouble(sc.nextLine());
        } while (width > MAXWIDTH || width < MIN);
       
        System.out.println("Enter unit cost of Window: ");
        unitCostWindow = Double.parseDouble(sc.nextLine());
        
        System.out.println("Enter unit cost of Trim: ");
        unitCostTrim = Double.parseDouble(sc.nextLine());
        
        costOfWindow = costOfWindow(height, width, unitCostWindow);
        costOfTrim = costOfTrim(height, width, unitCostTrim);
        totalCost = costOfWindow + costOfTrim;
        

        System.out.println("Cost of Window is: " + costOfWindow);
        System.out.println("Cost of Trim is: " + costOfTrim);
        System.out.println("Total cost is: " + totalCost);
    }
    public static double costOfWindow(double h, double w, double uc){
        
        return (h * w * uc);
    }
    public static double costOfTrim (double h, double w,double ut) {
        return (2*(h + w) * ut);
    }
}   
