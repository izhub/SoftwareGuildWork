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

        //    Scanner sc = new Scanner(System.in);
        SimpleCalculator calc = new SimpleCalculator();
        ConsoleIOClass con = new ConsoleIOClass();

        con.String("This is a simple numerical calculator.");

        con.String("Choose which operation you would like to compute.");
        String calcAgain;
        do {

            int choice = con.getInt("(1)Addition, (2)Subtraction, (3)Multiplication, (4)Division");
            int num1 = con.getInt("Select the first integer: ");
            int num2 = con.getInt("Select the second integer: ");

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
            con.String("Your result is: " + result);
            calcAgain = con.getString("Would you like to use the calculator again? 'yes' or 'no'");

        } while (calcAgain.equalsIgnoreCase("yes"));

    }
}
