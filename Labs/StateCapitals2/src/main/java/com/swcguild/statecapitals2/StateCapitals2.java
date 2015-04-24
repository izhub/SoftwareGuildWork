/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.statecapitals2;

import java.util.HashMap;
import java.util.Scanner;

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
        newCapital.setName("Austin");
        newCapital.setPopulation(10000000);
        newCapital.setSqMi(1500000);

        Capital newCapital1 = new Capital();
        newCapital1.setName("Columbus");
        newCapital1.setPopulation(10500000);
        newCapital1.setSqMi(2500);

        Capital newCapital2 = new Capital();
        newCapital2.setName("Olympia");
        newCapital2.setPopulation(100000);
        newCapital2.setSqMi(500);

        Capital newCapital3 = new Capital();
        newCapital3.setName("Salem");
        newCapital3.setPopulation(150000);
        newCapital3.setSqMi(150);

        Capital newCapital4 = new Capital();
        newCapital4.setName("Boise");
        newCapital4.setPopulation(12000);
        newCapital4.setSqMi(250);

        states.put("Texas", newCapital);
        states.put("Ohio", newCapital1);
        states.put("Washington", newCapital2);
        states.put("Oregon", newCapital3);
        states.put("Idaho", newCapital4);

        /*  4. Prints the Name, Population, and Square mileage for each capital along with its
         corresponding state name to the screen (hint - use the key set to get each capital object
         out of the map one by one and then print each field of the Capital object to the screen)
         */
        //get the keys
        // loop through keys
        // for each key, print out state, capital, pop, sq miles
        for (String currentStates : states.keySet()) {

            // store the new Capital object  (value in the HashMaps) as separate object   
            Capital currentCapital = states.get(currentStates);

            // print  out values using the getters that were created in the encapsulate      
            System.out.println(currentStates + "|" + " " + currentCapital.getName()
                    + "|" + currentCapital.getPopulation() + "|" + currentCapital.getSqMi());
        }
        /*
         5. Prints the states with capitals that have a population over a given value (this value is
         typed in by the user of the program) to the screen (hint - you will have to add code to ask
         the user for a minimum population. Once you have this value, go through each state/
         capital pair as you did for #4 above but only print the information for capitals that have a
         population above the limit)
         */
        //do #4 again
        //only changes...(use same code, w/folloiwing changes...)
        //propmt user for min pop
        // ONLY print output if pop is greater than or equal to min pop

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the lower limit for capital city population:");
        int min = sc.nextInt();
            
        System.out.println("LIST CAPITALS WITH POPULATIONS GREATER THAN " + min +":");
        for (String currentStates : states.keySet()) {

            Capital currentCapital = states.get(currentStates);
            int pop = currentCapital.getPopulation();          
            int area = currentCapital.getSqMi();

            if (pop >= min) {
            System.out.println(currentStates + " | "+ currentCapital.getName() + 
                    "| population: "+ pop + " | Area: " + area);
            }
        }
    }
}
