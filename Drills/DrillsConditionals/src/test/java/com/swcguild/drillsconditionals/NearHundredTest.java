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
public class NearHundredTest {

    public NearHundredTest() {
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
    public void nearHundredTest103True() {

        NearHundred near = new NearHundred();

        boolean results = near.nearHundred(103);
        assertTrue(results);
    }

    @Test
    public void nearHundredTest90True() {

        NearHundred near = new NearHundred();

        boolean results = near.nearHundred(90);
        assertTrue(results);
    }

    @Test
    public void nearHundredTest89False() {

        NearHundred near = new NearHundred();

        boolean results = near.nearHundred(89);
        assertFalse(results);
    }

}
