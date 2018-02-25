/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.variables;

/**
 *
 * @author apprentice
 */
public class VariablesAndPrinting {
    
    public static void main (String[] args) {
        
        String Name, Eyes, Teeth, Hair;
        int Age, Height, Weight;
        double kilos=0;
        double cm=0;
        
        Name = "Zed A. Shaw";
        Age= 35; // not a lie;
        Height = 74; // in inches
        Weight = 180; // in lbs
        Eyes = "Blue"; 
        Teeth = "White";
        Hair = "Brown";
        
        cm = Height * 2.54;
        kilos = Weight * 0.453592;
        
        System.out.println("Let's talk about " + Name + ".");
        System.out.println("He's " + Height + " inches (or " + cm +") tall.");
        System.out.println("He's " + Weight + " pounds (or " + kilos + ") heavy.");
        System.out.println("Actually, that's not too heavy.");
        System.out.println("He's got "+Eyes+ " eyes and " + Teeth + 
                " teeth and " + Hair + " hair");
        System.out.println("His teeth are usually " + Teeth + " depending on the coffee.");
        
        // This line is tricky; try to get it right. 
        System.out.println("If I add " + Age + ", " + Height + ", and " + Weight +
                " I get " + (Age + Height + Weight) + ".");
    }
    // Shift+H to find/replace all "my" from the front of the variables
}
