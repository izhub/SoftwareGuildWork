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
public class Diff21Test {
    
    public Diff21Test() {
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
    public void Diff21Test234(){
        
        Diff21 diff = new Diff21();
        
        int results = diff.Diff21(23);
        assertEquals(4, results);
    }
    @Test
    public void Diff21Test1011(){
        
        Diff21 diff = new Diff21();
        
        int results = diff.Diff21(10);
        assertEquals(11, results);
    }
    @Test
    public void DiffTest210(){
        
        Diff21 diff = new Diff21();
        
        int results = diff.Diff21(21);
        assertEquals(0, results);
    }
}
