/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.statecapitals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author apprentice
 */

/*
REQUIREMENTS
In this lab you will write a simple program that holds all of the states and their corresponding
capitals in a HashMap.

Your program must have the following features:

1. This program will be a Java Console Application called StateCaptials

*/
public class StateCapitals {
    public static void main(String[] args) {

//2. Creates a HashMap to hold the names of all the states and their corresponding capital
//      names (State name is the key, capital name is the value)

        HashMap<String, String> states = new HashMap<>();

//3. Loads the HashMap with the each State/Capital pair (this should be hard coded)
       
        states.put("Texas","Austin");
        states.put("Ohio", "Columbus");
        states.put("Washington", "Oympia");
        states.put("Oregon", "Salem");
        states.put("Idaho", "Boise");
        states.put("Montana", "Helena");
        states.put("Nevada", "Carson city");
        states.put("Utah", "Salt Lake City");
        states.put("Colorad", "Denver");
        
// 4. Prints all of the state names to the screen (hint - get the keys from the map and then
//     print each state name one by one)
       
        Set<String> stateKeys = states.keySet();
        for (String state : stateKeys) {
            System.out.println(state);
        }
        
        System.out.println();
// 5. Prints all of the capital names to the screen (hint - get the values from the map and then
//      print each capital name to the screen one by one)
        
        Collection<String> capValues = states.values();
        for (String c : capValues) {
            System.out.println(c);
        }
// 6. Prints each state along with its capital to the screen (hint - use the key set to
//      get each value from the map one by one printing both the key and value as you go)
        
        for(String currentStates : stateKeys)  {
            System.out.println(currentStates +" - " + states.get(currentStates));
        }
    }
}

