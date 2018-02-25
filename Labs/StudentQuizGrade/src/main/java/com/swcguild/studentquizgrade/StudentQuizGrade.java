/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.studentquizgrade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author apprentice
 */

/*
 REQUIREMENTS
 In this lab you will write a program that stores quiz scores for each student in a class and
 calculates the average quiz score for each student on request. The user should be able to do
 the following:

 ● View a list of students in the system
 ● Add a student to the system
 ● Remove a student from the system
 ● View a list of quiz scores for a given student
 ● View the average quiz score for a given student

 It is left up to you to design and implement a reasonable UI menu system. Design the UI
 and program flow chart before coding - you must review your both with the instructor before
 proceeding.

 Your program must have the following features:

 1. This program will be a Java Console Application called StudentQuizGrades

 2. The program must use the ConsoleIO class created previously for all console input and
 output.

 3. The program must store student quiz data in a HashMap that has the student name as
 the key and an ArrayList of Integers as the values (will this affect your ability to calculate
 average scores?)
 */
public class StudentQuizGrade {

    public static void main(String[] args) {
        StudentIO con = new StudentIO();

        int userChoice = 0;
        String studentName = "";

        ArrayList<Integer> tScores = new ArrayList<>();

        tScores.add(100);
        tScores.add(95);
        tScores.add(90);
        tScores.add(85);

        HashMap<String, ArrayList> scores = new HashMap<>();

        scores.put("Peter Parker", new ArrayList<Integer>());
        scores.put("Mary Jane", new ArrayList<Integer>());

        scores.get("Peter Parker").add(100);
        scores.get("Peter Parker").add(95);
        scores.get("Peter Parker").add(90);
        scores.get("Peter Parker").add(85);

        scores.get("Mary Jane").add(100);
        scores.get("Mary Jane").add(95);
        scores.get("Mary Jane").add(90);
        scores.get("Mary Jane").add(85);

    //    System.out.println(scores.size());  //shows list ofrecords (two) (peter and mary)
        //display list of students        
        Set<String> students = scores.keySet();
    //    for (String student : students) {
        //        System.out.println(student);
        //    }

        //display menu
        userChoice = con.getInt(" Choose one of the following options:"
                + "\n(1) View a list of students in the system "
                + "\n(2) Add a student to the system "
                + "\n(3) Remove a student from the system"
                + "\n(4) View a list of quiz scores for a given student "
                + "\n(5) View the average quiz score for a given student"
                + "\n(6) Exit");

        if (userChoice == 1) {
            for (String student : students) {
                System.out.println(student);
            }
        } else if (userChoice == 2) {
            studentName = con.getString("Enter student name: ").toLowerCase();
            
            ArrayList<Integer> student = new ArrayList<>();
            scores.put(studentName.toLowerCase(), new ArrayList<>());
            con.String("Student added..");
            students = scores.keySet(); //updates list
        
        } else if (userChoice == 3) {
            scores.remove(studentName.toLowerCase());
            con.String("Student removed..");
            students = scores.keySet(); //updates list
        
        }else if (userChoice == 4){
            ArrayList scoreList = scores.get(studentName.toLowerCase());
            for (int i = 0; i < scoreList.size(); i++){
                con.String(" " + (int)scoreList.get(i));
                //System.out.println(scoreList.get(i));
            }
        }else if (userChoice == 5){
            ArrayList scoreList = scores.get(studentName.toLowerCase());
            int sum = 0;
            
            for (int i = 0; i < scoreList.size(); i++){
                sum += (int)scoreList.get(i);
            }
            con.String("Average for " + studentName + " is " + ((double)sum/scoreList.size()));
        } else if (userChoice == 6){
            con.String("Exiting..");            
        }
    }

}
