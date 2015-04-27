/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.classrosterlivecode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import static sun.net.www.http.HttpClient.New;

/**
 *
 * @author apprentice
 */

// need to have data structure
// be able to ask info from roster
// give me all students or particular students
// be able to add/remove students
// called: CRUD - create, read, update, delete
// DAO (Data Access Object):  handles all low level CRUD activity

public class ClassRoster {
    
    public static final String ROSTER_FILE = "roster.txt"; //see below on WriteRoster
    public static final String DELIMITER = "::";            //see below on WriteRoster
    
    HashMap<String, Student> students = new HashMap<>();
    
    //in memory piece, have several methods 
    
    public Student getStudent(String studentId) {
        //get student from hashmap
        return students.get(studentId);
    }
    // student should already exist before we can add to roster
    // we pass the student and add it in
    public Student addStudent(String studentId, Student student){
        return students.put(studentId, student);
    } 
    public Student removeStudent(String studentId) {
        return students.remove(studentId);
    }
    //put every student we have in a roster 
    public void writeRoster() throws IOException {
        // have to know where to put it and what the delimiter is
        // define constants methods above hashmap
        
        PrintWriter out = new PrintWriter(new FileWriter(ROSTER_FILE));
        // this writes every student to file
        
        //get values of Student object
        Collection<Student> studentCollection = students.values();
        
        //iterate over studentCollection
        for (Student currentStudent : studentCollection) {
            out.println(currentStudent.getstudentId()+ DELIMITER + 
                    currentStudent.getfName() + DELIMITER +
                    currentStudent.getlName() + DELIMITER +
                    currentStudent.getCohort());
            out.flush(); // create record right now
        }
        out.close();      
        
        // Filewriter is in red, need to add IOException and import
            
        }
    
    // load roster, will open read and stick those in map and construct new students
    public void loadRoster() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));
        // point to buffer reader and file reader who takes a roster file
        //will red out, add throw exception
        
        String currentLine; // break into parts and 
        String[] currentTokens; 
        
// go file line line, read line, take tockens, create new students, and put them in maps
        
        while (sc.hasNext()) {
            //get next line in file
        currentLine = sc.next();
        //break line into tokens
        currentTokens = currentLine.split(DELIMITER); // hand in the delimiter
        
        Student currentStudent = new Student(currentTokens[0]);
        currentStudent.setfName(currentTokens[1]);
        currentStudent.setlName(currentTokens[2]);
        currentStudent.setCohort(currentTokens[3]);
        
        students.put(currentStudent.getstudentId(), currentStudent);
    }
        sc.close();
    }
    }
    

