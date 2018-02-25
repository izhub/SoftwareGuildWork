/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.inheritanceexample.application;

import com.swcguild.inheritanceexample.Employee;
import com.swcguild.inheritanceexample.Manager;
import com.swcguild.inheritanceexample.SummerIntern;
import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args){
        
//        Employee employee = new Employee();
        System.out.println("===================");
        Manager manager = new Manager();
        System.out.println("===================");
        SummerIntern intern = new SummerIntern();
        
            
        manager. setName("Jefferson");
        
//        employee.doWork();
        System.out.println("===================");
        manager.doWork();
        System.out.println("===================");
        intern.doWork();
        
        manager.createObjective();
//        manager.name = "Bad name";
        
        Employee undercoverBoss = new Manager("Elysha Spector");
        
        undercoverBoss.doWork();
        ((Manager)undercoverBoss).hire();
        
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Manager());
        employees.add(new SummerIntern());
//        employees.add(new Employee ("John Smith"));
//        employees.add(new Employee("Will"));
        
        System.out.println("=================");
        
        for (Employee e : employees){
            System.out.println("");
            
            e.doWork();
            System.out.println("------------");
        }
    }
}
