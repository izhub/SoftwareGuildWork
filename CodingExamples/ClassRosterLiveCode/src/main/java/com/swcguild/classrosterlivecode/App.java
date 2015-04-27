/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.classrosterlivecode;

import java.io.IOException;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) {
        
    //adding students to the roster is all you need to think about here
     try {   
        ClassRoster roster = new ClassRoster();
        
        Student currentStudent = new Student ("001");
        currentStudent.setfName("Joe");
        currentStudent.setlName("Smoe");
        currentStudent.setCohort("Java-April2015");
        
        roster.addStudent(currentStudent.getstudentId(), currentStudent);
        
        roster.writeRoster();
        
        ClassRoster readRoster = new ClassRoster();
        
        Student studentFromFile = readRoster.getStudent("001");
        
        if (studentFromFile == null) {
            System.out.println("Roster empty as expected");
        } else {
            System.out.println("Unexpect student present");
            return;
        } 
        
        readRoster.loadRoster ();
        studentFromFile = readRoster.getStudent("001");
         System.out.println(studentFromFile.getfName() + " " + studentFromFile.getlName());
         
    } catch(IOException ex) {
         System.out.println("ERROR: IOException occured. Message = " + ex.getMessage());
        
    }
    }
}
