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
public class SkipSumTest {
    
    public SkipSumTest() {
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
    public void skipSumTest347(){
        SkipSum sum = new SkipSum();
        
        int results = sum.SkipSum(3, 4);
        assertEquals(7, results);
    }
    @Test
    public void skipSumTest9420(){
        SkipSum sum = new SkipSum();
        
        int results = sum.SkipSum(9,4);
        assertEquals(20, results);
    }
    @Test
    public void skipSumTest101121(){
        SkipSum sum = new SkipSum();
        
        int results = sum.SkipSum(10, 11);
        assertEquals(21, results);
    }
}
