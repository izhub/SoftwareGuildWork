/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.simplecalculator;

/**
 *
 * @author apprentice
 */
public class SimpleCalculator {

    public int add(int a, int b) {

        return a + b;
    }
    
    public int subtract(int a, int b){
        return a-b;
    }
    public int multiplication(int a, int b){
        return a * b;
        
    }public int division(int a, int b){
        return a/b;
    }
}
/*
Objective:
The objective of this lab is to practice designing and implementing programs
that have more than one class.

Requirements:
Design a class (no main method) that performs basic math operations (addition,
subtraction, multiplication, division) on 2 operands.

Create a JUnit test and test all methods in this class
Create another class that presents a simple console calculator UI to the user. This
second class should handle all user input and console output and must use the first
class to perform all of the math operations.
○ The UI should give the user a choice of operations - one of the choices should be
to exit the program
○ Once the user selects an operations, the UI should ask the user for 2 operands
and then display the result of the calculation
○ The UI should then display the menu of choices again
○ When the user chooses to exit the program, the UI should print a thank you
message
Before coding you must create a flowchart and class diagram (in Dia) for your program.
Please show the diagrams to the instructor before coding.
*/