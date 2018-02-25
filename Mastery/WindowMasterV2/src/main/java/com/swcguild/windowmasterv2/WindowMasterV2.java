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
        
        /*(if (height > MAXHEIGHT) {
            System.out.println("Too big");
        } else if (height < MIN) {
            System.out.println("Too small");
        } else ;)
        */
        
        do { System.out.println("Enter width: ");
        width = Double.parseDouble(sc.nextLine());
        } while (width > MAXWIDTH || width < MIN);
        /*
        if (width > MAXWIDTH) {
            System.out.println("Too big");
        } else if (width < MIN) {
            System.out.println("Too small");
        } else ; 
        */
        
        System.out.println("Enter unit cost of Window: ");
        unitCostWindow = Double.parseDouble(sc.nextLine());
        
        System.out.println("Enter unit cost of Trim: ");
        unitCostTrim = Double.parseDouble(sc.nextLine());
        
        areaOfWindow = height * width;
        perimeterOfTrim = 2*(height+width);
        costOfWindow = areaOfWindow * unitCostWindow;
        costOfTrim = perimeterOfTrim * unitCostTrim;
        totalCost = costOfWindow + costOfTrim;
        
        System.out.println("Window area is: " + areaOfWindow);
        System.out.println("Window Perimeter is: " + perimeterOfTrim);  
        System.out.println("Cost of Window is: " + costOfWindow);
        System.out.println("Cost of Trim is: " + costOfTrim);
        System.out.println("Total cost is: " + totalCost);
    }
}   
