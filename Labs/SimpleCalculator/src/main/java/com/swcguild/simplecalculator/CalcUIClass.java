/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.simplecalculator;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class CalcUIClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleCalculator calc = new SimpleCalculator();
        System.out.println("This is a simple numerical calculator.");
        System.out.println("Choose which operation you would like to compute.");
        String calcAgain;
        do {
            System.out.println("(1)Addition, (2)Subtraction, (3)Multiplication, (4)Division");
            int choice = sc.nextInt();
            System.out.print("Select the first integer: ");
            int num1 = sc.nextInt();
            System.out.println("");
            System.out.print("Select the second integer: ");
            int num2 = sc.nextInt();
            int result = 0;

            switch (choice) {
                case (1):
                    result = calc.add(num1, num2);
                    break;
                case (2):
                    result = calc.subtract(num1, num2);
                    break;
                case (3):
                    result = calc.multiplication(num1, num2);
                    break;
                case (4):
                    result = calc.division(num1, num2);
                    break;
                default:
                    break;

            }
            System.out.println("Your result is: " + result);
            System.out.println("Would you like to use the calculator again? 'yes' or 'no'");
            calcAgain = sc.next();

        } while (calcAgain.equalsIgnoreCase("yes"));

    }
}
