/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.ifstatements;

/**
 *
 * @author apprentice
 */
public class ElseAndIf {
    public static void main(String[] args) {
        
        int people = 30;
        int cars = 40;
        int buses = 15;
        
        if (cars > people){
            System.out.println("We should take the cars");
        } else if (cars < people){
            System.out.println("We should not take the cars");
        } else {
            System.out.println("We cannot decide");
        }
        if (buses > cars){
            System.out.println("There are too many buses");
        } else if (buses < cars){
            System.out.println("Maybe we can take the buses");
        } else {
            System.out.println("We still cannot decide");
        }
        if (people > buses){
            System.out.println("Alright, let's take the buses");
        } else {
            System.out.println("Fine, let's stay home.");
        }
    }
    
}
