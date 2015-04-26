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
public class Makes10Test {

    public Makes10Test() {
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
    public void makes10Test910True() {

        Makes10 makes = new Makes10();

        boolean result = makes.Makes10(9, 10);
        assertTrue(result);
    }

    @Test
    public void makes10Test99False() {

        Makes10 makes = new Makes10();

        boolean result = makes.Makes10(9, 9);
        assertFalse(result);
    }
    @Test
    public void makes10Test19True(){
        
        Makes10 makes = new Makes10();
        
        boolean result = makes.Makes10(1,9);
        assertTrue(result);
    }
}
