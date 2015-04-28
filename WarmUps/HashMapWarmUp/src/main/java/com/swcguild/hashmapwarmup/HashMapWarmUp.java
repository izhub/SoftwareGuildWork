/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.hashmapwarmup;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author apprentice
 */
/*
Using HashMaps warmup

Pair up to write code that does the following (this can all be in a main method):
Create a HashMap that will be used to keep track of how many points each player 
on a team scores in a particular game.  Keys should be of type String and values
of type Integer.

Add the following stats to the map:
Smith - 23 points
Jones - 12 points
Jordan - 45 points
Pippen - 32 points
Kerr - 15 points
Print each players name and associated point total
Calculate the average points per game for the team and print it to the screen
*/
public class HashMapWarmUp {
    
    public static void main(String[] args) {
        
        HashMap<String, Integer> playerPoints = new HashMap<>(); //instantiates in a heap
    
    playerPoints.put("Smith", 23);
    playerPoints.put("Jones", 12);
    playerPoints.put("Jordan", 45);
    playerPoints.put("Pippen", 32);
    playerPoints.put("kerr", 15);
    
    Set<String> players = playerPoints.keySet();
    
    for (String currentPlayer :players ) {
        System.out.println("Plane name: " + currentPlayer);
        Integer currentPoints = playerPoints.get(currentPlayer);
        System.out.println("player Points: " + currentPoints);
    }
    }
    
}
