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
public class Mod20Test {
    
    public Mod20Test() {
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
    public void Mod20Test20False(){
        Mod20 mod = new Mod20();
        
        boolean results = mod.Mod2(20);
        assertFalse(results);
    }
    @Test
    public void Mod20Test21True(){
        Mod20 mod = new Mod20();
        
        boolean results = mod.Mod2(21);
        assertTrue(results);
    }
}
