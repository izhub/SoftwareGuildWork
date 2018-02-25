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
public class Mode35Test {
    Mod35 mod;
    public Mode35Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        mod = new Mod35();
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
    public void TestMod35(){
        boolean results = mod.Mod35(3);
        assertTrue(results);
    }
    @Test
    public void TestMod3510(){
        
        boolean results = mod.Mod35(10);
        assertTrue(results);
    }
    @Test 
    public void TestMod35115(){
        
        boolean results = mod.Mod35(15);
        assertFalse(results);
    }
}
//Mod35(3) → true
//Mod35(10) → true
//Mod35(15) → false