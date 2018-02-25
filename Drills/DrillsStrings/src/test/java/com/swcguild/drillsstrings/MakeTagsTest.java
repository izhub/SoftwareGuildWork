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
public class MakeTagsTest {
    
    public MakeTagsTest() {
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
    public void makeTagsTestIYay(){
        
        MakeTags yay = new MakeTags();
        
        String results = yay.MakeTags("i","Yay");
        assertEquals("<i>Yay</i>", results);
       }
    @Test
    public void makeTagsTestIHello(){
        
        MakeTags hello = new MakeTags();
        
        String results = hello.MakeTags("i", "Hello");
        assertEquals("<i>Hello</i>", results);
        
    }
    @Test
    public void makeTagsCiteYay(){
        
        MakeTags cyay = new MakeTags();
        
        String results = cyay.MakeTags("cite", "Yay");
        assertEquals("<cite>Yay</cite>", results);
    }
}
