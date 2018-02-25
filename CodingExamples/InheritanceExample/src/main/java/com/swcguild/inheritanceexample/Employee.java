/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.inheritanceexample;

/**
 *
 * @author apprentice
 */

//need annoations, lagging screen and went too fast to follow along

public abstract class Employee {
    
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    public abstract void doWork(); 
//    {
//        System.out.println("Employee: I'm working here!");
//        
//    }
    public void createObjective(){
        System.out.println("Employee drinks all the shakes");
    }
    
    public Employee() {
        System.out.println("Employee created.");
    }
    public Employee (String name) {
        
        this.name = name;
        System.out.println("overloaded employee constructor" + this.name);
    }
}
