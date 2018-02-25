/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.errorfindingexample;

import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public class FullOfErrors {
    
    ArrayList<String> myList = new ArrayList(); 
    
    public int countMyList() {
        myList.add("String one");
        myList.add("String two");
        
        return myList.size();
    }
    
}
