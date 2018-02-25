/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.drillsloops;

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
public class Patterns51Test {
    
    public Patterns51Test() {
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
    public void patterns51Test1271True(){
        int num [] = {2,7,1};
        Patterns51 pat = new Patterns51();
        
        boolean results = pat.Pattern51(num);
        
        assertTrue(results);
    }
    @Test
    public void patterns51Test1281False(){
        
        int num[] = {1,2,8};
        
        Patterns51 pat = new Patterns51();
        
        boolean results = pat.Pattern51(num);
        
        assertFalse(results);
    }
    @Test
    public void patterns51Test271True(){
    
    Patterns51 pat = new Patterns51();
    
    int num[] = {2,7,1};
    
    boolean results = pat.Pattern51(num);
    assertTrue(results);
}
}
