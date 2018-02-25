/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.warmupiteration;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class Iteration2 {
    public static void main(String[] args) {
        
        HashMap<String, String> cities = new HashMap<>();
        
        cities.put("Cleveland", "Browns");
        cities.put("Pittsburg", "Steelers");
        cities.put("Cincinnati", "Bengals");
        cities.put("Minneapolis", "Vikings");
        cities.put("Kansas City", "Chiefs");
        
      Set<String> cityteams = cities.keySet();
           
      for (String currentCityNFL : cityteams){
          System.out.println(currentCityNFL + " " + cities.get(currentCityNFL));
      }
    
    }
}
