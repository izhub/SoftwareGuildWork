/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
public class DVDLibraryTest {
    DVD dao;
     DVD d1;
    DVD d2;
    DVD d3;
    
    public DVDLibraryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dao = new DVD();
        
        d1 = new DVD();
        d1.setTitle("American Pie");
        d1.setDirector("Paul Weitz");
        d1.setRating("R");
        d1.setStudio("Univerasl Studio");
        
        d2 = new DVD();
        d2.setTitle("Jumanji");
        d2.setDirector("Joe Jonston");
        d2.setRating("PG");
        d2.setStudio("TriStar");

        
        d3 = new DVD();
        d3.setTitle("The Shawshank Redemption");
        d3.setDirector("Frank Darabont");
        d3.setRating("R");
        d3.setStudio("Columbia Pictures");
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
    public void TestIsEmpty(){
        assertEquals(0,dao.getCounter());
        
        
    }
    
    
}
