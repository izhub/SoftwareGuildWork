/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructures.queque;

import com.sun.jmx.remote.internal.ArrayQueue;
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
public class QQTest {
    
    public QQTest() {
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
    public void canEnDeQTest() {
        Queque q = new ArrayQueque(5);
        
        q.enqueque("A");
        q.enqueque("B");
        q.enqueque("C");
        q.enqueque("D");
        q.enqueque("E");
        
        
        Integer in = 1;
        Integer in2 = 2;
        Integer in3 = 3;
        
        Object[] array = new Object[5];
        array[0] = "A";
        array[1] = "B";
        array[2] = "C";
        array[3] = "D";
        array[4] = "E";
        
       assertEquals(q.getArray()[0], array[0]); 
        
       for (int i = 0; i < q.size(); i++) {
           assertTrue(q.getArray()[i].equals(array[i])); 
       
    }
       
       assertTrue(q.dequeque().equals("A"));
       assertTrue(q.dequeque().equals("B"));
    }
}
