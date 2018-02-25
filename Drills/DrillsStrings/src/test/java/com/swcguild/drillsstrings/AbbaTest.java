/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.drillsstrings;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class AbbaTest {
    
    public AbbaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void abbaTestHiBye(){
        
        Abba hi = new Abba();
        
        String results = hi.Abba("Hi", "Bye");
        assertEquals("HiByeByeHi", results);
    }
    @Test
    public void abbaTestYoAlice(){
        
        Abba alice = new Abba();
        
        String results = alice.Abba("Yo", "Alice");
        assertEquals("YoAliceAliceYo", results);
    }
    @Test
    public void abbaTestWhatUp(){
        
        Abba what = new Abba();
        
        String results = what.Abba("What", "Up");
        assertEquals("WhatUpUpWhat", results);
    }
}
