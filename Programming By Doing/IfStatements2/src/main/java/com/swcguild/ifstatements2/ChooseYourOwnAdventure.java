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
public class ChooseYourOwnAdventure {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String q1 = "";
        String q2 = "";
        String q3 = "";
        String q4 = "";
        String q5 = "";

        System.out.println("WELCOME TO MITCHELL'S TINY ADVENTURE!");
        System.out.println("You are in a creepy house!  "
                + "Would you like to go \"upstairs\" or into the \"kitchen\"?");
        q1 = sc.nextLine();

        System.out.println("There is a long countertop with dirty dishes everywhere.  "
                + "Off to one side\n there is, as you'd expect, a refrigerator. "
                + "You may open the \"refrigerator\"\n or look in a \"cabinet\".");
        q2 = sc.nextLine();

        System.out.println("Inside the refrigerator you see food and stuff.  "
                + "It looks pretty nasty.\n Would you like to eat some of the food? (\"yes\" or \"no\")");
        q3 = sc.nextLine();

        System.out.println("Upstairs you see a hallway.  At the end of the hallway is the master\n"
                + "\"bedroom\".  There is also a \"bathroom\" off the hallway.  "
                + "Where would you like\n to go?");
        q4 = sc.nextLine();

        System.out.println("You are in a plush bedroom, with expensive-looking hardwood furniture.  "
                + "The\n bed is unmade.  In the back of the room, the closet door is ajar.  "
                + "Would you\n like to open the door? (\"yes\" or \"no\")");
        q5 = sc.nextLine();

      if (q1.equalsIgnoreCase("kitchen")) {
            if (q2.equalsIgnoreCase("refrigerator") && q3.equalsIgnoreCase("yes")) {
                System.out.println("You die of food poisoning");
            } else if (q2.equalsIgnoreCase("refrigerator") && q3.equalsIgnoreCase("no")) {
                System.out.println("You die of starvation");
            }
        } else {
            System.out.println("I'm tired of this");
        }

        if (q1.equalsIgnoreCase("kitchen")) {
            if (q2.equalsIgnoreCase("cabinet") && q3.equalsIgnoreCase("yes")) {
                System.out.println("cockroaches run everywhere");
            } else if (q2.equalsIgnoreCase("cabinet") && q3.equalsIgnoreCase("no")) {
                System.out.println("you'll never know what was in it now");
            } else {
                System.out.println("That's enough for today");
            }
        }

        if (q1.equalsIgnoreCase("upstairs") && q4.equalsIgnoreCase("bedroom")
                && q3.equalsIgnoreCase("no")) {
            System.out.println("Well, then I guess you'll never know what was in there.");
        } else {
            System.out.println("I'm tired of all this");
        }
    }

}
