package com.swcguild.addressbook;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.addressbook.dao.AddressBookDao;
import com.swcguild.addressbook.dao.AddressBookDaoInterface;
import com.swcguild.addressbook.dao.SearchTerm;
import com.swcguild.addressbook.dto.Address;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class AddressBookDaoTests {
    
    private AddressBookDaoInterface dao;
    Address a1;
    Address a2;
    Address a3;
    Address a4;
    
    public AddressBookDaoTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
    
    JdbcTemplate cleaner = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
    cleaner.execute("delete from addresses");
    
    dao = ctx.getBean("addressBookDaoInterface", AddressBookDaoInterface.class);
    
    a1 = new Address();
    a1.setFirstName("John");
    a1.setLastName("Doe");
    a1.setStreet("1 main st");
    a1.setCity("Akron");
    a1.setState("OH");
    a1.setZip("44321");
    
    a2 = new Address();
    a2.setFirstName("Zee");
    a2.setLastName("Rana");
    a2.setStreet("401 Lofts");
    a2.setCity("Akron");
    a2.setZip("44311");
    a2.setState("OH");
    
    a3 = new Address();
    a3.setFirstName("Terry");
    a3.setLastName("Seah");
    a3.setStreet("401 Lofts");
    a3.setCity("Austin");
    a3.setState("Texas");
    a3.setZip("78550");
    
    a4 = new Address();
    a4.setFirstName("Nadia");
    a4.setLastName("Khan");
    a4.setStreet("9419 Lost Pond Dr.");
    a4.setCity("Twinsburg");
    a4.setState("OH");
    a4.setZip("44087");
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
    public void addUpdateTest(){
        dao.addAddress(a1);
        
        a1.setCity("cleveland");
        dao.updateAddress(a1);
        Address fromAd = dao.getAddressById(a1.getId());
        assertEquals(fromAd, a1);
        
    }
    @Test
    public void getAllTest(){
        dao.addAddress(a1);
        dao.addAddress(a2);
        dao.addAddress(a3);
        dao.addAddress(a4);
        
        List<Address> cList = dao.getAllAddress();
        assertEquals(4, cList.size());
    }
    @Test
    public void searchAddress(){
        dao.addAddress(a1);
        dao.addAddress(a2);
        dao.addAddress(a3);
        dao.addAddress(a4);
        
        //create search criteria
        Map<SearchTerm, String> criteria = new HashMap<>();
        
        criteria.put(SearchTerm.ZIP, "44087");
        List<Address> cList = dao.searchAddress(criteria);
        assertEquals(1, cList.size());
        assertEquals(a4, cList.get(0));
        
        criteria.clear();
        
        //new search criteria
        criteria.put(SearchTerm.STATE, "OH");
        cList = dao.searchAddress(criteria);
        assertEquals(3, cList.size());
        
    }
}
