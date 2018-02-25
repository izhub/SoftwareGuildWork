/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.drillsstrings;

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
public class TweakFrontTest {
    
    public TweakFrontTest() {
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
    public void TweakFrontTest1(){
        
        TweakFront tweak = new TweakFront();
        
        String results = tweak.TweakFront("Hello");
        assertEquals("llo", results);
        
    }
    @Test
    public void TweakFrontTest2(){
        
        TweakFront tweak = new TweakFront();
        
        String results = tweak.TweakFront("away");
        assertEquals("aay", results);
        
    }
    @Test
    public void TweakFrontTest3(){
        
        TweakFront tweak = new TweakFront();
        
        String results = tweak.TweakFront("abed");
        assertEquals("abed", results);
        
    }
}
