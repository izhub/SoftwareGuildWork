/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.olympian;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class SkiJumperTest {
    
    public SkiJumperTest() {
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
    public void SkiJumperTest(){
//        SkiJumper jumper = new SkiJumper();
//        assertEquals(jumper.competeInEvent(), "Ski Jump");

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SkiJumper jumper = ctx.getBean("superSkiJumper", SkiJumper.class);
        assertEquals(jumper.competeInEvent(), "Ski Jump");
    }
}
