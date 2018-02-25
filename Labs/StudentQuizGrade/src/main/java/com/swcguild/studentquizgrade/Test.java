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
public class Test {

    public static void main(String[] args) {
        StudentIO con = new StudentIO();

        HashMap<String, ArrayList<Integer>> scores = new HashMap<>();

        String student1 = "Peter Parker";
        String student2 = "Marry Jane";
        String student3 = "Harry Osborn";

        ArrayList<Integer> peterScores = new ArrayList<>();
        peterScores.add(99);
        peterScores.add(93);
        peterScores.add(90);

        ArrayList<Integer> maryScores = new ArrayList<>();
        maryScores.add(93);
        maryScores.add(48);

        ArrayList<Integer> harryScores = new ArrayList<>();
        harryScores.add(87);
        harryScores.add(48);
        harryScores.add(77);

        scores.put(student1, peterScores);
        scores.put(student2, maryScores);
        scores.put(student3, maryScores);

        ArrayList<Integer> peterParkerScores = scores.get("Peter Parker");

        Set<String> students = scores.keySet();

//        for(Integer currentQuizScore : peterParkerScores){
//            
//            System.out.println(currentQuizScore);
//        }
        con.String("choose from the selection below: \n");
        con.String("1. View a list of students in the system");
        con.String("2. Add a student to the system");
        con.String("3. Remove a student from the system");
        con.String("4. View a list of quiz scores for a given student");
        con.String("5. View the average quiz score for a given student");
        con.String("6. Exit");
        String userChoice = "";
        con.getString(userChoice);
        switch (userChoice) {
            case "1":
                for (String currentStudents : students) {
                    System.out.println(currentStudents);
                }
                break;
            case "2":
                String newName = con.getString("Enter name to add to system: ").toLowerCase();
                //       ArrayList<String> student = new ArrayList<>();
                scores.put(newName, null);
                con.String("Name addedd...");
                break;
        }

    }
}
