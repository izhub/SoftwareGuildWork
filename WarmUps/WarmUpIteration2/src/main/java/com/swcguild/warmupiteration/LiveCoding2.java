/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.warmupiteration;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class LiveCoding2 {
    public static void main(String[] args) {
        HashMap<String, String> footballTeams = new HashMap<>();
        
        footballTeams.put("Cleveland", "Browns");
        footballTeams.put("Pitssburg", "Steelers");
        footballTeams.put("Minneapolis", "Vikings");
        footballTeams.put("Kansas Cityy", "Chiefs");
        
        //enhanced for loop w/o entry set
        
        Set<String> cityNames = footballTeams.keySet();
        
        for (String currentCity : cityNames) {
            
            System.out.println("City: " + currentCity + " |Team: " + footballTeams.get(currentCity));
        }
        System.out.println("+++++++++++++++++++++++++++++++++");
        
        //using  iterator wit keySet
        Iterator<String> iter = cityNames.iterator();
        
        while (iter.hasNext()){
            String currentCity = iter.next();
            System.out.println("City: " + currentCity + " |" + "Team: "+ footballTeams.get(currentCity));
        }
        System.out.println("+++++++++++++++++++++++++++++++++");
        
        // asking usering entry Set
        Set<Entry <String, String>> mapEntries = footballTeams.entrySet();
        
        for (Entry<String, String> currentEntry : mapEntries){
        System.out.println("City: " + currentEntry.getKey() + "|Teams: " + currentEntry.getValue() );
        }
    }
}
