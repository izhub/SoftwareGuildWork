/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.drillsconditionals;

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
public class SumDoubleTest {
    
    public SumDoubleTest() {
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
    public void SumDoubleTest123(){
        
        SumDouble sum = new SumDouble();
        
        int results = sum.SumDouble(1, 2);
        assertEquals(3, results);
    }
    @Test
    public void SumDoubleTest325(){
        
        SumDouble sum = new SumDouble();
        
        int results = sum.SumDouble(3, 2);
        assertEquals(5, results);
    }
    @Test
    public void SumDoubleTest228(){
        
        SumDouble sum = new SumDouble();
        
        int results = sum.SumDouble(2, 2);
        assertEquals(8, results);
    }
}
