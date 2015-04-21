/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.ifstatements2;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class TwentyQuestions {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String q1 = "";
        String q2 = "";
        
        System.out.println("Two more questions!");
        System.out.println("Think of something and I'll try to guess");
        
        System.out.println("Question 1) Does it stay inside or outside or both? ");
        q1 = sc.nextLine();
        
        System.out.println("Question 2) Is it a living thing? (yes or no)");
        q2 = sc.nextLine();
        
        if (q1 == "inside" && q2 == "yes") System.out.println("it's a cat!");
        if (q1 == "inside" && q2 == "no") System.out.println("it's a sofa!");
        if (q1 == "outside" && q2 == "yes") System.out.println("it's a elephant!");
        if (q1 == "outside" && q2 == "no") System.out.println("it's a tree!");
        if (q1 == "both" && q2 == "yes") System.out.println("it's a dog!");
        if (q1 == "both" && q2 == "no") System.out.println("it's a cellphone!");
        


    }

}
