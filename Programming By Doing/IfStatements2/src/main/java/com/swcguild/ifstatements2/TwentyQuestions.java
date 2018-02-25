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
        
        System.out.println("TWO QUESTOINS!");
        System.out.println("Think of an object, and I'll try to guess it.");
        System.out.println();
        System.out.println("Question 1) Is it animal, vegetable, or mineral? ");
        q1 = sc.nextLine();
        System.out.println("Is it bigger than a breadbox? (yes or no)");
        q2 = sc.nextLine();
        
        if ("animal".equalsIgnoreCase(q1) ) {
            if ("yes".equalsIgnoreCase(q2) || "y".equals(q2)) {
                System.out.println("My Guess is that you are thinking of a horse. \n I would ask you if I'm right, but I don't actually care");
            } else { System.out.println("My Guess is that you are thinking of a bird. \n I would ask you if I'm right, but I don't actually care");
            
            }
        } else if ("vegetable".equalsIgnoreCase(q1) ) {
            if ("yes".equalsIgnoreCase(q2) || "y".equals(q2)) {
                System.out.println("My Guess is that you are thinking of a carrot. \n I would ask you if I'm right, but I don't actually care");
            } else { System.out.println("My Guess is that you are thinking of a watermelon. \n I would ask you if I'm right, but I don't actually care");
            
            }
        }else if ("Mineral".equalsIgnoreCase(q1)){
              if ( "yes".equalsIgnoreCase(q2) || q2 == "y") {
                System.out.println("My Guess is that you are thinking of a paper clip. \n I would ask you if I'm right, but I don't actually care");
            } else { System.out.println("My Guess is that you are thinking of a truck. \n I would ask you if I'm right, but I don't actually care");
            
            }
        } else;
    }

}
