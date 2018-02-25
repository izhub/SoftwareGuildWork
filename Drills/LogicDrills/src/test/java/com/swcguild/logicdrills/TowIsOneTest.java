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
public class TowIsOneTest {
    TwoIsOne math;
    public TowIsOneTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        math = new TwoIsOne();
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
    public void TestTwoIsOne(){
        
        boolean result = math.TwoIsOne(1, 2, 3);
        assertTrue(result);
    }
    @Test
    public void TestTwoIsOne1(){
        boolean result = math.TwoIsOne(3, 1, 2);
        assertTrue(result);
    }
    @Test
    public void TestTwoIsOne2(){
        boolean result = math.TwoIsOne(3, 2, 2);
        assertFalse(result);
    }
}

//TwoIsOne(1, 2, 3) → true
//TwoIsOne(3, 1, 2) → true
//TwoIsOne(3, 2, 2) → false