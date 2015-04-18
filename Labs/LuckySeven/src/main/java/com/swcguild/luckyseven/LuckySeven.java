/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.luckyseven;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 * 
 In this lab you will write a program that plays Lucky Sevens. The rules of the game are as
follow:
1. Each round the program rolls a virtual pair of dice for the user
2. If the sum of the 2 dice is equal to 7, the play wins $4; else the play loses $1
Your job is to write a program that plays this game, which will also demonstrate the futility of
playing Lucky Sevens.
Your program must have the following features:
1. This program will be a Java Console Application called LuckySevens
2. The program first asks the user how many dollars they have to bet.
3. The program then rolls the dice repeatedly until all the money is gone.
    a. HINT: use a loop construct to keep playing until the money is gone.
4. The program keeps track of how many rolls were taken before the money ran out.
5. The program keeps track of the maximum amount of money held by the player.
6. The program keeps track of how many rolls were taken at the point when the user held the
most money.
    a. HINT for 4, 5, and 6 declare some variables

* Sample Game Output:
How many dollars do you have? 100
You are broke after 543 rolls.
You should have quit after 47 rolls when you had $113
*/ 
public class LuckySeven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        
        int roll = 1;
        int money = 0;
        int maxMoney = 0;
        int maxRoll = 0;
         
        System.out.println("How much money do you have? ");
        money = sc. nextInt();
        
        do {
            int dice1 = 1 +r.nextInt(6); // 1 + becuase index starts at 0 
            int dice2 = 1 + r.nextInt(6);
            roll++;     
               
        if (dice1 + dice2 == 7) {
            money = money + 4;
        } else {
            money -= 1;
        }
        if (money > maxMoney){
            maxMoney = money;
            maxRoll = roll;
        }
        
        } while (money > 0);
       
        System.out.println("You are broke after " + roll);
        System.out.println("You should have quit after " + maxRoll + " when you had " + maxMoney);
    }
}
