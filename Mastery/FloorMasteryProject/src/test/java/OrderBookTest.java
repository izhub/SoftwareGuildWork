/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.consoleio.ConsoleIO;
import com.swcguild.floormasteryproject.DAO.OrderBook;
import com.swcguild.floormasteryproject.DTO.Order;
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

    OrderBook orderBook;

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
        orderBook = new OrderBook();
        orderBook.loadProduct();
        orderBook.loadTaxes();
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
    public void addOrderTest() {
        Order order = new Order();
        order.setCustomerName("TestFirst");
        order.setArea(32);
        order.setProduct(orderBook.getProductMap().get("1"));
        order.setTaxes(orderBook.getTaxesMap().get("OH"));
        orderBook.addOrder(order);
        assertEquals(order, orderBook.getOrderMap().get("1"));

    }

}
