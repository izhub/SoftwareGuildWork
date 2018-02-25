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
/*
Make a program which displays an appropriate name for a person, using a
combination of nested ifs and compound conditions. Ask the user for a gender, 
first name, last name and age.

If the person is female and 20 or over, ask if she is married. If so, display
"Mrs." in front of her name. If not, display "Ms." in front of her name. If the 
female is under 20, display her first and last name.

If the person is male and 20 or over, display "Mr." in front of his name. 
Otherwise, display his first and last name.

Note that asking a person if they are married should only be done if they are 
female and 20 or older, which means you will have a single if and else nested 
inside one of your if statements.
*/
public class GenderGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String fName;
        String lName;
        String gender;
        int age;
        String married;

        System.out.println("What is your gender (M or F): ");
        gender = sc.next();
        System.out.println("First name: ");
        fName = sc.next();
        System.out.println("Last name: ");
        lName = sc.next();
        System.out.println("Age: ");
        age = sc.nextInt();
        
     
        if (gender == "M" && age >= 20){
            System.out.println("Then I shall call you Mr. " + lName);
             
        }else System.out.println("Then I shall call you " + fName + " " + lName);
        
        if (gender == "F" ) {

            if (age >= 20) {
                System.out.println("Are you married, " + fName + " (y or n )");
                married = sc.next();
                if (married == "y") {
                    System.out.println("Then I shall call you Mrs. " + lName);
                } else {
                    System.out.println("Then I shall call you Ms. " + lName);
                }
            } else {
                System.out.println("Then I shall call you " + fName + " " + lName);
            }

        }
        
    }
}
