package com.swcguild.logicdrills;

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
public class CaughtSpeedingTest {
    
    public CaughtSpeedingTest() {
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
    public void caughtSpeedingTest60False(){
        CaughtSpeeding speeding = new CaughtSpeeding();
        
        int results = speeding.CaughtSpeeding(60, false);
        assertEquals(0, results);
    }
    @Test
    public void caughtSpeedingTest65False(){
        CaughtSpeeding speeding = new CaughtSpeeding();
        
        int results = speeding.CaughtSpeeding(65, false);
        assertEquals(1, results);
    }
    @Test
    public void caughtSpeedingTest65True(){
        CaughtSpeeding speeding = new CaughtSpeeding();
        
        int results = speeding.CaughtSpeeding(65, true);
        assertEquals(0, results);
    }
}
