/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructures.stack;

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
public class StackTest {

    public StackTest() {
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
    public void canStackTest() {

        Stack s = new ArrayStack(5);

        s.push("A");
        s.push("B");
        s.push("C");
        s.push("D");
        s.push("E");

        Integer in = 1;
        Integer in2 = 2;
        Integer in3 = 3;


        assertEquals(s.pop(), "E");
        assertEquals(s.pop(), "D");
        assertEquals(s.pop(), "C");
        assertEquals(s.pop(), "B");
        assertEquals(s.pop(), "A");
        
    }
}

