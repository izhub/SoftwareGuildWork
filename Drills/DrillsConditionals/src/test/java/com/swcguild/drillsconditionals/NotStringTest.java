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
public class NotStringTest {
    
    public NotStringTest() {
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
    public void notStringTestCandy(){
        
        NotString not = new NotString();
        
        String results = not.notString("candy");
        assertEquals("not candy", results);
    }
    @Test
    public void notStringTestX(){
        
        NotString not = new NotString();
        
       String results = not.notString("x");
       assertEquals("not x", results);
    }
    @Test 
    public void notStringTestNotBad(){
        
        NotString not = new NotString();
        
        String results = not.notString("not bad");
        assertEquals("not bad", results);
    }
}
