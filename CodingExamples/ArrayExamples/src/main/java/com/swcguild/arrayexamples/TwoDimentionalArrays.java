/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.arrayexamples;

/**
 *
 * @author apprentice
 */
public class TwoDimentionalArrays {

    public static void main(String[] args) {

        // usually best to define upfront on the diments
        String[][] cityTeamNames = {
            {"Cleveland", "browns", "Cavs", "Indians"},
            {"columbus", "bluejackets", "Buckeyes"},
            {"Pittsburg", "Steelers", "Pirates", "Penguins"}

        };
        
        for (int i=0; i < cityTeamNames.length; i++)
        {
            for (int j=0; j < cityTeamNames[i].length; j++)
            {
                System.out.println(cityTeamNames[i][j] + " ");
            }
            System.out.println();
        }
    }
}
