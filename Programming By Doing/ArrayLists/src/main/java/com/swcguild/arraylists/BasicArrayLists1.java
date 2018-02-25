/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.arraylists;

import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public class BasicArrayLists1 {
    public static void main(String[] args) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(-113);
        list.add(-113);
        list.add(-133);
        list.add(-113);
        list.add(-113);
        list.add(-113);
        list.add(-113);
        list.add(-113);
        list.add(-113);
        list.add(-113);
        
        for (int i=0; i< list.size(); i++) {
            System.out.println("slot "+ i +" contains a " + list.get(i));
        }
    }
    
}
