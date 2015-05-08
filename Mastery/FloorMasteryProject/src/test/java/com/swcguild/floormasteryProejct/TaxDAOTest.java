/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.floormasteryProejct;

import com.swcguild.floormasteryproject.DAO.TaxDAOFileImpl;
import com.swcguild.floormasteryproject.DTO.Product;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
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
public class TaxDAOTest {
    TaxDAOFileImpl taxT;
    public TaxDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        taxT = new TaxDAOFileImpl();
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
    public void testLoad() throws FileNotFoundException{
        taxT.load();
        assertEquals(4, taxT.getTaxesMap().size());
        
    }
    
    @Test
    public void testGet() throws FileNotFoundException{
        ArrayList<String> states = new ArrayList<>();
       taxT.load();
       states.add("PA");
       states.add("IN");
       states.add("OH");
       states.add("MI");
       
       assertEquals(states,taxT.getListStates());
    }
}
