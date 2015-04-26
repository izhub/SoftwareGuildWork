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
public class PlayOutsideTest {
    
    public PlayOutsideTest() {
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
    public void playOutsideTest70Flase(){
        PlayOutside play = new PlayOutside();
        
        boolean results = play.PlayOutside(70, false);
        assertTrue(results);
    }
    @Test
    public void playOutSideTest95False(){
        PlayOutside play = new PlayOutside();
        
        boolean results = play.PlayOutside(95, false);
        assertFalse(results);
    }
    @Test
    public void pllayOutSideTest95True() {
        PlayOutside play = new PlayOutside();
        
        boolean results = play.PlayOutside(95, true);
        assertTrue(results);
    }
}
