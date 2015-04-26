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
public class AlarmClockTest {

    public AlarmClockTest() {
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
    public void alarmClockTest1False() {
        AlarmClock ring = new AlarmClock();

        String results = ring.AlarmClock(1, false);
        assertEquals("7:00", results);
    }

    @Test
    public void alarmClockTest5False() {
        AlarmClock ring = new AlarmClock();

        String results = ring.AlarmClock(5, false);
        assertEquals("7:00", results);
    }
    @Test
    public void alarmClockTest0False(){
        AlarmClock ring = new AlarmClock();
        
        String results = ring.AlarmClock(0, false);
        assertEquals("10:00", results);
    }

}
