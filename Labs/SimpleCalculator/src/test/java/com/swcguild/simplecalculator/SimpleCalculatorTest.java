/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.simplecalculator;

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
public class SimpleCalculatorTest {

    public SimpleCalculatorTest() {
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
    public void simpleCalculatorTestAdd() {
        SimpleCalculator calculator =  new SimpleCalculator();
        
        int result = calculator.add(10, 10);
        assertEquals(20, result);

    }
    @Test
    public void simpleCalculatorTestSubtract() {
        SimpleCalculator calculator = new SimpleCalculator();
        
        int result = calculator.subtract(15,10);
        assertEquals(5, result);

    }
    @Test
    public void simpleCalculatorTestMultiplication() {
        SimpleCalculator calculator = new SimpleCalculator();
        
        int result = calculator.multiplication(5,5);
        assertEquals(25, result);
                

    }
    @Test
    public void simpleCalculatorTestDivision() {
        SimpleCalculator calculator = new SimpleCalculator();
        
        int result = calculator.division(100, 10);
        assertEquals(10, result);

    }
}
