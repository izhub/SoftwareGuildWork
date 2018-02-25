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
public class InsertWordTest {
    
    public InsertWordTest() {
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
    public void insertWordTestYay(){
        
        InsertWord yay = new InsertWord();
        
        String results = yay.InsertWord("<<>>", "Yay");
        assertEquals("<<Yay>>",results);        
    }
    @Test
    public void insertWordTestWoohoo(){
        
        InsertWord woohoo = new InsertWord();
            
        String results = woohoo.InsertWord("<<>>", "WooHoo");
        assertEquals("<<WooHoo>>",results);     
                
    }
    @Test
    public void insertWord(){
        
        InsertWord word = new InsertWord();
        
        String results = word.InsertWord("[[]]","word");
        assertEquals("[[word]]", results);
    }
}
