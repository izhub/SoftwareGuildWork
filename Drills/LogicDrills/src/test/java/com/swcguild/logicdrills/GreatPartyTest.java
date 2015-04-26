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
    
    /* greatParty(30, false) → false
     greatParty(50, false) → true
     greatParty(70, true) → true
     */
    
    @Test
    public void greatPartyTest30False(){
        GreatParty myParty = new GreatParty();
        
        boolean results = myParty.Greatparty(30, false);
        assertFalse(results);
    }
    @Test
    public void greatPartyTest50False(){
        GreatParty myParty = new GreatParty();
        
        boolean results = myParty.Greatparty(50, false);
        assertTrue(results);
    }
    @Test
    public void greatPartyTest70True(){
        GreatParty myParty = new GreatParty();
        
        boolean results = myParty.Greatparty(70, true);
        assertTrue(results);
    }
}
