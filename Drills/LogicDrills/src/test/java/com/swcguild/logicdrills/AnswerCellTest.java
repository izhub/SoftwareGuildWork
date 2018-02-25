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
public class AnswerCellTest {
    AnswerCell cell;
    public AnswerCellTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        cell = new AnswerCell();
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
    public void TestAnswerCell1(){
        
        boolean result = cell.AnswerCell(false, false, false);
        assertTrue(result);
                
    }
    public void TestAnswerCell2(){
        boolean result = cell.AnswerCell(false, false, true);
        assertFalse(result);
    }
    public void TestAnswerCell3(){
        boolean result = cell.AnswerCell(true, false, false);
        assertFalse(result);
    }
}

//AnswerCell(false, false, false) → true
//AnswerCell(false, false, true) → false
//AnswerCell(true, false, false) → false
