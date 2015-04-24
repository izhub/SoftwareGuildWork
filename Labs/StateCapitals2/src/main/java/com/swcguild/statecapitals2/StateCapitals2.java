/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.statecapitals2;

import java.util.HashMap;

/**
 *
 * @author apprentice
 */

/*REQUIREMENTS

In this lab you will write a simple program that holds all of the states and their corresponding
capitals in a HashMap. This lab is similar to Lab 01 except you will create an object to hold
information about the capital of each state. This object (rather than the city name String) will be
the value for each state/capital pair.

Your program must have the following features:

1. This program will be a Java Console Application called StateCaptials2
*/
public class StateCapitals2 {
    public static void main(String[] args) {
        
/*  2. A class called Capital with the following properties:
    a. Name
    b. Population
    c. Square mileage
*/
 
        
/*
        3. A HashMap that holds the names of all the states and their corresponding Capital
            objects (State name is the key, Capital object is the value)
*/
        
        HashMap<String, Capital> states = new HashMap<>();
        
        Capital newCapital = new Capital();
        newCapital.name = "Austin";
        newCapital.population = 10000000;
        newCapital.sqMi = 1500000;
        
        Capital newCapital1 = new Capital();
        newCapital.name = "Columbus";
        newCapital.population = 10500000;
        newCapital.sqMi = 2500;
        
        Capital newCapital2 = new Capital();
        newCapital.name = "Olympia";
        newCapital.population = 100000;
        newCapital.sqMi = 500;
        
        Capital newCapital3 = new Capital();
        newCapital.name = "Salem";
        newCapital.population = 150000;
        newCapital.sqMi = 150;
        
        Capital newCapital4 = new Capital();
        newCapital.name = "Boise";
        newCapital.population = 12000;
        newCapital.sqMi = 250;
        
        states.put("Texas", newCapital);
        states.put("Ohio", newCapital1);
        states.put("Washington", newCapital2);
        states.put("Oregon", newCapital3);
        states.put("Idaho", newCapital4);
        
/*  4. Prints the Name, Population, and Square mileage for each capital along with its
    corresponding state name to the screen (hint - use the key set to get each capital object
    out of the map one by one and then print each field of the Capital object to the screen)
*/
        
        for (String currentStates : states.keySet()) {
           
        System.out.println(currentStates + "|" + states. + " " + newCapital.name + 
                "|" + newCapital.population + "|" + newCapital.sqMi);
        }
/*
    5. Prints the states with capitals that have a population over a given value (this value is
    typed in by the user of the program) to the screen (hint - you will have to add code to ask
    the user for a minimum population. Once you have this value, go through each state/
    capital pair as you did for #4 above but only print the information for capitals that have a
    population above the limit)
*/
    }
}





