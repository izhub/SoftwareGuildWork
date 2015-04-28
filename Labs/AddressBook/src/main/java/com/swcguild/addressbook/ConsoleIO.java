
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ConsoleIO {
   private Scanner sc = new Scanner (System.in);
    
    String prompt = "";
    int a = 0;
    float b = 0;
    double c = 0;
    
    public void print(String msg){
        System.out.println(msg);
    }

public int getInt(String prompt) {
        System.out.println(prompt);
        a = sc.nextInt();
        return a;
    }
    public int intMaxMin(String prompt, int max, int min){
        
        do {
            System.out.println(prompt + min  + prompt + max);
            a = sc.nextInt();
        } while ( a >= min &  a<= max);
        return a;       
               
    }
    public String getString( String prompt) {
        System.out.println(prompt);
        prompt = sc.next();
        return prompt;
        
    }
    public float getFloat(String prompt){
        System.out.println(prompt);
        b = sc.nextFloat();
        return b;
    }
    public float getFloatMinMax( String prompt, float min, float max){
        
        do {
            System.out.println(prompt + min  + prompt + max);
            b = sc.nextInt();
        } while ( b >= min &  b<= max);
        return b; 
    }
    public double getDouble( String prompt){
        System.out.println(prompt);
        c = sc.nextDouble();
        return c;
    }
    public double getDoubleMinMax(String prompt, double min, double max){
        
        do {
            System.out.println(prompt + min  + prompt + max);
            c = sc.nextInt();
        } while ( c >= min &  c<= max);
        return c; 
    }
    public void String(String prompt){
        System.out.println(prompt);
    }

    
}
/*
Requirements:
Design a class (no main method) that has methods to ask for and retrieve keyboard input
from the user and to print information out to the console. You must have methods that
do the following:

1. Display a prompt to the user and read in an integer. The prompt value should be passed
in as a parameter and the value that is read in should be the return value of the method.

2. Display a prompt to the user and read in an integer between max val and min val. The
prompt value, min, and max should be passed in as parameter. The value read in from
the console should be the return value of the method. This method must keep asking
the user for input until the value is in range.

3. Display a prompt to the user and read in a String. The prompt value should be passed in
as a parameter and the value that is read in should be the return value of the method.

4. Display a prompt to the user and read in a float. The prompt value should be passed in
as a parameter and the value that is read in should be the return value of the method.

5. Display a prompt to the user and read in a float between max val and min val. The
prompt value, min, and max should be passed in as parameter. The value read in from
the console should be the return value of the method. This method must keep asking
the user for input until the value is in range.

6. Display a prompt to the user and read in a double.

7. Display a prompt to the user and read in a double between max val and min val. The
prompt value, min, and max should be passed in as parameter. The value read in from
the console should be the return value of the method. This method must keep asking
the user for input until the value is in range.

8. Print a given String to the console. The prompt value should be passed in as a
parameter.

After completing this class, refactor your Simple Calculator program to use this object for all of
its console input and output.

Before coding you must create a flowchart and class diagram (in Dia) for your program.
*/