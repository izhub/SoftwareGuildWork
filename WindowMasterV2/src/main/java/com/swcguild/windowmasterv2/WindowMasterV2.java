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
        
        double height, width, costOfWindow, costOfTrim, unitCostWindow, 
                unitCostTrim, areaOfWindow, perimeterOfTrim, totalCost;
        
        String strWindow, strTrim,strUnitWindow, strUnitTrim;
        
        Scanner sc = new Scanner (System.in);
        
        System.out.println("Enter window height: ");
        height = Double.parseDouble(sc.nextLine());
        
        System.out.println("Enter width: ");
        width = Double.parseDouble(sc.nextLine());
        
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
    }}
    
    
}
