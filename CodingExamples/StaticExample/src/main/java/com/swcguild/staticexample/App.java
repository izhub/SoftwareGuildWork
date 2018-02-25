/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.staticexample;

/**
 *
 * @author apprentice   
 */
public class App {
    public static void main(String[] args) {
        
        AdderNonStaticMethod myAdder = new AdderStaticeMethod(); 
        
    // instantiates the adder method; (); is calling the JVM to make it a constructor
    // hands a reference of AdderNonStaticMethod to myAdder from the heap; 
    // hands the reference in the stack frame
        
        int sum = myAdder.add(3,2);     // invoke add method on myAdder object reference
        
        int sum2 = AdderStaticLibrary.add(15,23);
        
        AdderStaticLibrary myLib = new AdderStaticLibrary();
        
    //    int sum3 = myLib.add(5,4);      //warning: say there's a better way, doing more work
        
    }
}
