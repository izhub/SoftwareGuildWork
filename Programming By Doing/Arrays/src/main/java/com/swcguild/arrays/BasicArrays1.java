/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.arrays;

/**
 *
 * @author apprentice
 */
public class BasicArrays1 {
    public static void main(String[] args) {
        
        int[] arrayOne = {-133,-133,-133,-133,-133,
            -133,-133,-133,-133,-133
        };
        int slotNumber = arrayOne[0];
        
        for (int i = 0; i < arrayOne.length; i++)
        {
            System.out.println("Slot " + i + " contains a " + slotNumber);
        }
    }
}
