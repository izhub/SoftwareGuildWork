package com.swcguild.floormasteryProejct;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.consoleio.ConsoleIO;
import com.swcguild.floormasteryproject.DAO.OrderDAOFileImpl;
import com.swcguild.floormasteryproject.DAO.ProductDAOFileImpl;
import com.swcguild.floormasteryproject.DAO.TaxDAOFileImpl;
import com.swcguild.floormasteryproject.DTO.Order;
import com.swcguild.floormasteryproject.DTO.Product;
import com.swcguild.floormasteryproject.DTO.Tax;
import com.swcguild.floormasteryproject.factory.OrderFactory;
import java.io.FileNotFoundException;
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
public class OrderBookTest {

    OrderDAOFileImpl orderBook;
    ProductDAOFileImpl  productDao;
    TaxDAOFileImpl taxDao;
    

    public OrderBookTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws FileNotFoundException {
        orderBook = new OrderDAOFileImpl();
        productDao = new ProductDAOFileImpl();
             taxDao = new  TaxDAOFileImpl();  
        productDao.load();
        taxDao.load();
//        
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
    public void addOrderTest() throws FileNotFoundException {  
        
        
        Order order = new Order();
        Tax tax = taxDao.getTax("PA");
        Product product = productDao.getProduct("1");
        orderBook.addDate("2");
        order = OrderFactory.buildOrder("2", "3", tax, 5, product, "7");
        orderBook.addOrder(order,"2");
        assertEquals(order, orderBook.getOrderByDates().get("2").get("7"));
        
    }
    @Test
    public void TestRemove(){
       
        
        Order order = new Order();
        Tax tax = taxDao.getTax("PA");
        Product product = productDao.getProduct("1");
        orderBook.addDate("2");
        order = OrderFactory.buildOrder("2", "3", tax, 5, product, "7");
        orderBook.addOrder(order,"2");
        orderBook.removeOrder("7");
        
    }

}
