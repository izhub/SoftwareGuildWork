/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.warmupiteration;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author apprentice
 */
public class IteratorWarmUP {

    public static void main(String[] args) {

        ArrayList<String> teams = new ArrayList<>();

        teams.add("Vikings");
        teams.add("Packers");
        teams.add("Lions");
        teams.add("Bears");
        teams.add("Browns");
        teams.add("Bengals");
        teams.add("Steelers");
        teams.add("Ravens");

        for (int i = 0; i < teams.size(); i++) {
            System.out.println(teams.get(i));
        }
        System.out.println();
        for (String currentTeams : teams) {
            System.out.println(currentTeams);
        }
        System.out.println();
        int i = 0;
        while (i < teams.size()) {
            System.out.println(teams.get(i));
            i++;
        }
        System.out.println();
        
        Iterator<String> itr = teams.iterator();
          while(itr.hasNext()){
              System.out.println(itr.next());
          }    
    }
}
