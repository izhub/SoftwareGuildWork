/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.logicdrills;

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
public class InRangeTest {
    
    public InRangeTest() {
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
    public void inRangeTest5FalseTrue(){
        
        InRange range = new InRange();
        
        boolean results = range.InRange(5, false);
        assertTrue(results);
    }
    @Test
    public void inRangeTest11FalseFalse(){
        
        InRange range = new InRange();
        
        boolean results = range.InRange(11, false);
        assertFalse(results);
    }
    @Test
    public void inRangeTest11TrueTrue(){
        
        InRange range = new InRange();
        
        boolean results = range.InRange(11, true);
        assertTrue(results);
    }
}
