/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dogexample;

/**
 *
 * @author apprentice
 */
public class Dog {
    
    private String dogName; // private appears before when checking "encapsulate" when setting getters/setters
    private int age;
    private int weight;

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    public void bark() {
        System.out.println("WOOF");
    }
    public void sit(){
        System.out.println("sitting");
    }
    
}
