/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.junitexample;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class GreatPartyTest {
    
    public GreatPartyTest() {
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
    
    // 3 step test: set (setup scenario), act(excute scenario), assert(verify)
    
    @Test
    public void greatPartyTest30False() {
        // can set all tests into methods like shown in notes or separate as shown below
        
        GreatParty myParty = new GreatParty();
        
        boolean result = myParty.greatParty(30, false);
        assertFalse(result);
        
    }
    @Test
    public void greatPartyTest50False() {
        //instantiate great partyy
        GreatParty myParty = new GreatParty();
        
        // get results
        boolean result = myParty.greatParty(50, false);
        assertTrue(result);
    }
    @Test
    
    public void greatPartytest70True () {
        GreatParty myParty = new GreatParty();
        boolean result = myParty.greatParty(70, true);
        assertTrue(result);
    }
}
