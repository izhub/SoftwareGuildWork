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
public class MischevioushChildrenTest {
    
    public MischevioushChildrenTest() {
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
    public void AreWeInTroubleTestTrueTrueTrue(){
        
        MischeviousChildren trouble = new MischeviousChildren();
        
        boolean results = trouble.AreWeInTrouble(true, true);
        assertTrue(results);
    }
    @Test
    public void AreWeInTroubleTestFalseFalseTrue(){
        
        MischeviousChildren trouble = new MischeviousChildren();
        
        boolean results = trouble.AreWeInTrouble(false, false);
        assertTrue(results);
    }
    @Test
    public void AreWeInTroubleTestTrueFalseFalse(){
        
        MischeviousChildren trouble = new MischeviousChildren();
        
        boolean results = trouble.AreWeInTrouble(true, false);
        assertFalse(results);
    }
}
