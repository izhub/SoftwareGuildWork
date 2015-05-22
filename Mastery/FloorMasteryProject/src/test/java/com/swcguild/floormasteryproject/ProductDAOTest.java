/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.floormasteryproject;

import com.swcguild.floormasteryproject.DAO.OrderDAOFileImpl;
import com.swcguild.floormasteryproject.DAO.ProductDAOFileImpl;
import com.swcguild.floormasteryproject.DAO.TaxDAOFileImpl;
import com.swcguild.floormasteryproject.DTO.Product;
import com.swcguild.floormasteryproject.Factory.OrderFactory;
import java.io.FileNotFoundException;
import java.util.HashMap;
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
public class ProductDAOTest {
  
      ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    ProductDAOFileImpl prod = ctx.getBean("productdao", ProductDAOFileImpl.class);
    
    public ProductDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        prod = new ProductDAOFileImpl();
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
        prod.load();
        assertEquals(4,prod.getListProduct().size());
    }
    @Test
    public void testGet() throws FileNotFoundException{
       
        Product product = new Product();
        product.setId("1");
       HashMap<String, Product> prod1 = new HashMap<>();
       prod1.put("1", product);
       prod.setProductMap(prod1);
        assertEquals(product,prod.getProduct("1"));
        
        
    }
}
