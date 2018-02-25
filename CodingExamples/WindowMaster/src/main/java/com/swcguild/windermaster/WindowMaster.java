/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.windermaster;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class WindowMaster {
    public static void main (String[] args) {
    
     double height;
     double width;
     
     String stringheight;
     String stringwidth;
     
     double areaOfWindow;
     double perimeterOfWindow;
     double cost;
     
     Scanner sc = new Scanner (System.in);
           
     System.out.println("Please enter height:  ");
     stringheight = sc.nextLine();
     
     System.out.println("Please enter width: ");
     stringwidth = sc.nextLine();
     
     height = Double.parseDouble(stringheight);
     width = Double.parseDouble(stringwidth);
     
     areaOfWindow = height * width;
     perimeterOfWindow = 2* (height + width);
     cost = areaOfWindow + perimeterOfWindow;
     
     System.out.println("Height is: " + stringheight);
     System.out.println("Width is: " + stringwidth);
     System.out.println("Area is: " + areaOfWindow);
     System.out.println("Periemeter is: " + perimeterOfWindow);
     System.out.println("Total cost: " + cost);
     
}
    
}
