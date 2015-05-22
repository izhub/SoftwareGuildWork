package com.swcguild.floormasteryproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.swcguild.consoleio.ConsoleIO;
import com.swcguild.floormasteryproject.Controller.OrderController;
import com.swcguild.floormasteryproject.DAO.OrderDAOFileImpl;
import com.swcguild.floormasteryproject.DAO.ProductDAOFileImpl;
import com.swcguild.floormasteryproject.DAO.TaxDAOFileImpl;
import com.swcguild.floormasteryproject.DTO.Order;
import com.swcguild.floormasteryproject.DTO.Product;
import com.swcguild.floormasteryproject.DTO.Tax;
import com.swcguild.floormasteryproject.Factory.OrderFactory;
import com.swcguild.floormasteryproject.Interface.OrderDAO;
import com.swcguild.floormasteryproject.Interface.ProductDAO;
import com.swcguild.floormasteryproject.Interface.TaxDAO;
import java.io.FileNotFoundException;
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
public class OrderBookTest {

//    OrderDAOFileImpl orderBook;
//    ProductDAOFileImpl  productDao;
//    TaxDAOFileImpl taxDao;
// 
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    OrderDAOFileImpl orderBook = ctx.getBean("orderdao", OrderDAOFileImpl.class);
    ProductDAOFileImpl productBook = ctx.getBean("productdao", ProductDAOFileImpl.class);
    TaxDAOFileImpl taxBook = ctx.getBean("taxdao", TaxDAOFileImpl.class);
    OrderFactory factory = ctx.getBean("factory", OrderFactory.class);
    
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
        productBook.load();
        taxBook.load();
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

        Tax tax = taxBook.getTax("PA");
        Product product = productBook.getProduct("1");
        orderBook.addDate("2");
        Order order = OrderFactory.buildOrder("2", "3", tax, 5, product, "7");
        orderBook.addOrder(order, "2");
        assertEquals(order, orderBook.getOrderByDates().get("2").get("7"));

    }

    @Test
    public void TestRemove() {

        Tax tax = taxBook.getTax("PA");
        Product product = productBook.getProduct("1");
        orderBook.addDate("2");
        Order order = OrderFactory.buildOrder("2", "3", tax, 5, product, "7");
        orderBook.addOrder(order, "2");
        orderBook.removeOrder("7");

    }

}
