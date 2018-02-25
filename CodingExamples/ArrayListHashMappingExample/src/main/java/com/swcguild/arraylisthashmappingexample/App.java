/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.arraylisthashmappingexample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) {
        ArrayList <String> myList = new ArrayList();
        // got to File tab; pom.xml file; line 9/10; change 1.7 -> 1.8
     
     myList.add("This is string one"); // like an array, is in slot 0 ...etc
     myList.add("This is string two");
     myList.add("This is string three");   
     
     String myString = myList.get(1);
     
    System.out.println(myString);
    
//    myList.remove(1);    
//    myString = myList.get(1);
//    System.out.println(myString);
//        
    
    // iterate through ArrayList using classic for loop
    
    for (int i = 0; i < myList.size(); i++) {
        System.out.println(myList.get(i));
    }
    
    // iterate through ArrayList using enhanced for loop
    
    for  (String currentString : myList)    {
       // meaning: for each String lets call that a currentString, call it from myList
        
        System.out.println(currentString);
        
    }
    
    // iterate through an ArrayList using an Iterator and a while loop
    
    Iterator<String> iter = myList.iterator();
    
    while(iter.hasNext()) {
        String currentString = iter.next();
        System.out.println(currentString);
    }
    
        System.out.println("=================================================");
        
        HashMap<String, String> myMap = new HashMap<>();
        myMap.put("Java", "A great programming language.");  // key, value on heap
        myMap.put("Akron", "where we are.");
        myMap.put("Browns", "A football team from Cleveland.");
        
        String whereAreWe = myMap.get("Akron");
        System.out.println(whereAreWe);
        
        String testString = myMap.get("Columbus"); // what happens if ask for something not there
        System.out.println(testString);           // returns a null
        
        boolean hasKey = myMap.containsKey("Columbus"); // way to check if its there
        System.out.println(hasKey);
        
        // get the key set and list all the keys in the map
        
        Set<String> myKeys = myMap.keySet();
        for (String currentKey : myKeys) {
            System.out.println(currentKey);            
        }
        
        // get all values in a  map and list them
        Collection<String> values = myMap.values(); // returns back values from reference 
        for (String currentValue : values) {
            System.out.println(currentValue);
        }
    }
}
