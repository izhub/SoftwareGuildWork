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
public class MissingCharTest {
    
    public MissingCharTest() {
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
    public void misshingCharTestKitten1(){
        
        MissingChar miss = new MissingChar();
        
        String results = miss.MissingChar("kitten", 1);
        assertEquals("ktten", results);
    }
    @Test
    public void missingCharTestkitten0(){
        
        MissingChar miss = new MissingChar();
        
        String results = miss.MissingChar("kitten", 0);
        assertEquals("itten", results);
    }
    @Test 
    public void missingCharTestKitten4(){
        
        MissingChar miss = new MissingChar();
        
        String results = miss.MissingChar("kitten", 4);
        assertEquals("kittn", results);
    }
}

