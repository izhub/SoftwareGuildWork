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
public class SayHiTest {
    
    public SayHiTest() {
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
    public void sayHiTestBob(){
        
        SayHi bob = new SayHi();
        
        String results =  bob.SayHi("Bob");
        assertEquals("Hello Bob", results);
    }
    @Test
    public void sayhiTestAlice(){
        
        SayHi alice = new SayHi();
        
        String results = alice.SayHi("Alice");
        assertEquals("Hello Alice", results);
    }
    @Test
    public void sayHiTestX(){
        
        SayHi x = new SayHi();
        
        String results = x.SayHi("X");
        assertEquals("Hello X", results);
    }
}
