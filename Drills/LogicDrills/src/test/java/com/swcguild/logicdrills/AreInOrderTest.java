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
public class AreInOrderTest {
    AreInOrder order;
    public AreInOrderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        order = new AreInOrder();
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
    public void TestAreInOrder(){
        
        boolean result = order.AreInOrder(1, 2, 4, false);
        assertTrue(result);
    }
    @Test
    public void TestAreInOrder1(){
        
        boolean result = order.AreInOrder(1, 2, 1, false);
        assertFalse(result);
    }
    @Test
    public void TestAreInOrder2(){
        
        boolean result = order.AreInOrder(1, 1, 2, true);
        assertTrue(result);
    }
}

//AreInOrder(1, 2, 4, false) → true
//AreInOrder(1, 2, 1, false) → false
//AreInOrder(1, 1, 2, true) → true