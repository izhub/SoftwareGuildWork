/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.consoleio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ConsoleIO {

    private Scanner sc = new Scanner(System.in);

    int intA = 0;
    float floatB = 0;
    double doubleC = 0;
    boolean badInput;
    LocalDate localDate;

    public void String(String msg) {
        System.out.println(msg);
    }
    
    public LocalDate getLocaldeDate(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-DD");
        String input = "";
        boolean exit;

        do {
            try {
            exit = true;
            System.out.println("date");
            input = sc.nextLine();
            localDate = LocalDate.parse(input, dtf);
            return localDate;
        } catch (Exception e){
            exit = false;
            System.out.println("Bad input: must be YYYY-MM-DD");
        }
    } while (!exit);
        return null;
    }


    public int getInt(String prompt) {

        do {
            try {
                System.out.println(prompt);
                intA = sc.nextInt();
                badInput = false;
            } catch (InputMismatchException ime) {
                badInput = true;
                sc.nextLine();
            }
        } while (badInput);
        return intA;
    }

    public int intMinMax(String prompt, int min, int max) {

        do {
            try {
                System.out.println(prompt);
                intA = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException ime) {
                badInput = true;
                sc.nextLine();
            }

            if (intA < min) {
                System.out.println("Value needs to be " + min + " or higher");

            } else if (intA > max) {
                System.out.println("Value needs to be " + max + "or lower than ");
            }
        } while (intA < min || intA > max);
        return intA;

    }

    public String getString(String prompt) {
        System.out.println(prompt);
        prompt = sc.nextLine();
        return prompt;

    }

    public float getFloat(String prompt) {

        do {
            try {
                System.out.println(prompt);
                this.floatB = sc.nextFloat();
                badInput = false;
            } catch (InputMismatchException ime) {
                badInput = true;
                sc.nextLine();
            }
        } while (badInput);

        return this.floatB;
    }

    public float getFloatMinMax(String prompt, float min, float max) {

        do {
            System.out.println(prompt);
            floatB = sc.nextInt();
            sc.nextLine();

            if (floatB < min) {
                System.out.println("Value needs to be " + min + " or higher");

            } else if (floatB > max) {
                System.out.println("Value needs to be " + max + "or lower than ");
            }
        } while (floatB < min || floatB > max);
        return floatB;
    }

    public double getDouble(String prompt) {
        do {
            try {
                System.out.println(prompt);
                doubleC = sc.nextDouble();
                badInput = false;
            } catch (InputMismatchException ime) {
                badInput = true;
                sc.nextLine();
            }
        } while (badInput);
        return doubleC;
    }

    public double getDoubleMinMax(String prompt, double min, double max) {

        do {
            try {
                System.out.println(prompt);
                doubleC = sc.nextDouble();
                sc.nextLine();
            } catch (InputMismatchException ime) {
                badInput = true;
                sc.nextLine();
            }
            if (doubleC < min) {
                System.out.println("Value needs to be " + min + " or higher");

            } else if (doubleC > max) {
                System.out.println("Value needs to be " + max + "or lower than ");
            }
        } while (doubleC < min || doubleC > max);
        return doubleC;
    }



}

/*
 Requirements:
 Design IntA class (no main method) that has methods to ask for and retrieve keyboard input
 from the user and to print information out to the console. You must have methods that
 do the following:

 1. Display IntA prompt to the user and read in an integer. The prompt value should be passed
 in as IntA parameter and the value that is read in should be the return value of the method.

 2. Display IntA prompt to the user and read in an integer between max val and min val. The
 prompt value, min, and max should be passed in as parameter. The value read in from
 the console should be the return value of the method. This method must keep asking
 the user for input until the value is in range.

 3. Display IntA prompt to the user and read in IntA String. The prompt value should be passed in
 as IntA parameter and the value that is read in should be the return value of the method.

 4. Display IntA prompt to the user and read in IntA float. The prompt value should be passed in
 as IntA parameter and the value that is read in should be the return value of the method.

 5. Display IntA prompt to the user and read in IntA float between max val and min val. The
 prompt value, min, and max should be passed in as parameter. The value read in from
 the console should be the return value of the method. This method must keep asking
 the user for input until the value is in range.

 6. Display IntA prompt to the user and read in IntA double.

 7. Display IntA prompt to the user and read in IntA double between max val and min val. The
 prompt value, min, and max should be passed in as parameter. The value read in from
 the console should be the return value of the method. This method must keep asking
 the user for input until the value is in range.

 8. Print IntA given String to the console. The prompt value should be passed in as IntA
 parameter.

 After completing this class, refactor your Simple Calculator program to use this object for all of
 its console input and output.

 Before coding you must create IntA flowchart and class diagram (in Dia) for your program.
 */
