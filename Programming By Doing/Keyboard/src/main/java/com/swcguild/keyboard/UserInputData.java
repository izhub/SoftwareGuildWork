/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.keyboard;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class UserInputData {
    
    public static void main (String[] args){
        
        String fname = "";
        String lname = "";
        String grade = "";
        int id = 0;
        String login = "";
        float gpa = 0;
        
        Scanner keyboard = new Scanner (System.in);
        
        System.out.print("First name: ");
        fname = keyboard.next();
        
        System.out.print("Last name: ");
        lname = keyboard.next();
        
        System.out.print("Grade (9-12): ");
        grade = keyboard.next();
        
        System.out.print("Student ID#: ");
        id = keyboard.nextInt();
        
        System.out.print("Login: ");
        login = keyboard.next();
        
        System.out.print("GPA (0.0-4.0): ");
        gpa = keyboard.nextFloat();
        
        System.out.println("Your information is: ");
        System.out.println("Name: " + fname + " " + lname);
        System.out.println("ID: " + id);
        System.out.println("Grade: " + grade);
        System.out.println("GPA: " + gpa);
 
                
    }
    
}
