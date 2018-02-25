/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.ifstatements;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class SpaceBoxing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        float weight = 0;
        int planet = 0;
        
        System.out.println("Enter your earth weight: ");
        weight = sc.nextFloat();
        
        System.out.println("Followng planets are available to fight on: "
                + "1. Venus  2. Mars   3. Jupiter"
                + "4. Saturn 5. Uranus 6. Neptune");
        
        System.out.println("Which planet do you want to visit: ");
        planet = sc.nextInt();
        
        if (planet == 1){
            System.out.println("Your weight would be " + (.78 * weight) + " on that planet");
        } else if (planet == 2){
            System.out.println("Your weight would be " + (.39 * weight) + " on that planet");
        } else if (planet == 3) {
            System.out.println("Your weight would be " + (2.65 * weight) + " on that planet");
        } else if (planet == 4) {
            System.out.println("Your weight would be " + (1.17 * weight) + " on that planet");
        } else if (planet == 5) {
            System.out.println("Your weight would be " + (1.05 * weight) + " on that planet");
        } else if (planet == 6){
            System.out.println("Your weight would be " + (1.23 * weight) + " on that planet");
        } else return;
    }
}
