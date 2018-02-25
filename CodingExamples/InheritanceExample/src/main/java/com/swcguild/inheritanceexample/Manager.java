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
public class Manager extends Employee{
   public void doWork(){
       
//       super.doWork(); // why did we super class this? 
       System.out.println(name + "Manger: Managing for people here.");
    }
    public void createObjective(){
        
        super.createObjective(); // why did we super class this? 
        System.out.println("Manager: Manage to best of my ability");
    }
    public void hire(){
        
        System.out.println("Welcome on board");
    }
    public void fire(){
        System.out.println("you are fired!!");
    }
    public void givePerformanceReviews(){
            System.out.println("well done. work harder next year");
    }
    public Manager(){
        
        super ("Steve"); // why did we super class this? 
        System.out.println("Manager created");
    }
    public Manager(String name) {
         super(name);
         System.out.println("Manager with name created here." + name);
    }
}
