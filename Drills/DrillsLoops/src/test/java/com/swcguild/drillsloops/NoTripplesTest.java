package com.swcguild.drillsloops;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class NoTripplesTest {
    
    public NoTripplesTest() {
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
    public void noTripplesTest1True(){
        
        NoTripples trip = new NoTripples();
        
        int num[] = {1,1,2,2,1};
        
        boolean results = trip.NoTriples(num);
        assertTrue(results);
    }
    @Test
    public void noTripplesTest1False(){
        
        NoTripples trip = new NoTripples();
        
        int num[] = {1,1,2,2,2,1};
        
        boolean results = trip.NoTriples(num);
        assertFalse(results);
    }
    @Test 
    public void noTripplesTest2False(){
        
        NoTripples trip = new NoTripples();
        
        int nump[] = {1,1,1,2,2,2,1};
        
        boolean result = trip.NoTriples(nump);
        assertFalse(result);
    }
}
