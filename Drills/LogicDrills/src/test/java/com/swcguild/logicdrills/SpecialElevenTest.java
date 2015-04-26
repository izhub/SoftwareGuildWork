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
public class SpecialElevenTest {
    
    public SpecialElevenTest() {
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
    public void specialElevenTest22True(){
        
        SpecialEleven special = new SpecialEleven();
        
        boolean results = special.SpecialEleven(22);
        assertTrue(results);
    }
    @Test 
    public void specialElevenTest23True(){
        
        SpecialEleven special = new SpecialEleven();
        
        boolean results = special.SpecialEleven(23);
        assertTrue(results);
    }
    @Test
    public void specialElevenTest24False(){
        
        SpecialEleven special = new SpecialEleven();
        
        boolean results = special.SpecialEleven(24);
        assertFalse(results);
    }
}
