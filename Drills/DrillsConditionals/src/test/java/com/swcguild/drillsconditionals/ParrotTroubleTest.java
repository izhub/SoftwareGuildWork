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
public class ParrotTroubleTest {
    
    public ParrotTroubleTest() {
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
    public void ParrotTroubleTestTrue6True(){
        
         ParrotTrouble trouble = new ParrotTrouble();
        
        boolean result = trouble.parrotTrouble(true,6);
        assertTrue(result);
    }
    @Test
    public void ParrotTroubleTestingTrue7False(){
        
        ParrotTrouble trouble = new ParrotTrouble();
        
        boolean result = trouble.parrotTrouble(true, 7);
        assertFalse(result);
    }
    public void ParrotTroubleTestingFalse6False(){
        
        ParrotTrouble trouble = new ParrotTrouble();
        
        boolean result = trouble.parrotTrouble(false, 6);
        assertFalse(result);
    }
}