/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.drillsarrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class Makes2Test {
    
    public Makes2Test() {
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
    public void makes2Test1(){
        int num[] = {4,5};
        int num2[] = {1,2,3};
        int test[] = {4,5};
        Make2 nums = new Make2();
        
        Assert.assertArrayEquals(test,nums.make2(num, num2));
        
//        assert.assertArrayEquals(test, nums.make2(num, num2));
    }
    @Test
    public void makes2Test2(){
        int num[] = {4};
        int num2[] = {1,2,3};
        int test[] = {4,1};
        Make2 nums = new Make2();
        
         Assert.assertArrayEquals(test,nums.make2(num, num2));
         
//        assert.assertArrayEquals(test,nums.make2(num, num2));
        
    }
    @Test
    public void makes2Test3(){
        int num[] = {};
        int num2[] = {1,2};
        int test[] = {1,2};
        Make2 nums = new Make2();
        
         Assert.assertArrayEquals(test,nums.make2(num, num2));
//        assert.assertArrayEquals(test,nums.make2(num, num2));
        
    }
}
