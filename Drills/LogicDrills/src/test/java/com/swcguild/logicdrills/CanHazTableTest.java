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
public class CanHazTableTest {
    
    public CanHazTableTest() {
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
public void canHazTableTest5102(){
    CanHazTable myTable = new CanHazTable();
    
    int results = myTable.CanHazTable(5,10);
    assertEquals(2, results);
}
@Test
public void canHazTableTest520(){
    CanHazTable myTable = new CanHazTable();
    
    int results = myTable.CanHazTable(5, 2);
    assertEquals(0, results);
}
@Test
public void canHazTableTest551(){
    CanHazTable myTable = new CanHazTable();
    
    int results = myTable.CanHazTable(5, 5);
    assertEquals(1, results);
}
      
}
