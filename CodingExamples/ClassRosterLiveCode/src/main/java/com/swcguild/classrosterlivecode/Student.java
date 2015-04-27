/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.classrosterlivecode;

/**
 *
 * @author apprentice
 */
public class Student {
    //this is just a bucket to carry data
    // will have 4 private fields and getters and setters
       
    private String fName;
    private String lName;
    private String studentId;      
    // right click "get code" getters and setters
    
// can also set to private final studentId per 'warning' msg because of constructor
    private String cohort;
    
    //make id read only field : delete setter below ; 
    
    // constructor ...
    
    // means set this id to what user passes in
    public Student(String id) {         
        this.studentId = id;
    }

    // getters and setters....
    
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getstudentId() {
        return studentId;
    }

    

    public String getCohort() {
        return cohort;
    }

    public void setCohort(String cohort) {
        this.cohort = cohort;
    }
    
}
