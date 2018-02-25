/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlist.dao;

import com.swcguild.contactlist.dto.Contact;
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
public class ContactListDaoTest {
    
    private ContactListDao dao;
    private Contact c1;
    private Contact c2;
    private Contact c3;
    
    public ContactListDaoTest() {
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
        cleaner.execute("delete from contacts");
        
        dao = ctx.getBean("contactListDao", ContactListDao.class);
        
        c1= new Contact();
        c1.setCompany("Apple");
        c1.setEmail("stevejobs@apple.com");
        c1.setLastName("Jobs");
        c1.setFirstName("Steve");
        c1.setPhone("5129636690");
        
        c2= new Contact();
        c2.setCompany("Microsoft");
        c2.setEmail("billgates@microsoft.com");
        c2.setLastName("Gates");
        c2.setFirstName("Bill");
        c2.setPhone("2169636690");
        
        c3= new Contact();
        c3.setCompany("Oracle");
        c3.setEmail("larry@oracle.com");
        c3.setLastName("Ellison");
        c3.setFirstName("Larry");
        c3.setPhone("3305648965");
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
    public void addGetDeleteContact(){
        
        dao.addContact(c1);
        
        Contact fromDao = dao.getContactById(c1.getContactId());
        assertEquals(fromDao, c1);
        
        dao.removeContact(c1.getContactId());
        assertNull(dao.getContactById(c1.getContactId()));
    }
    
    @Test
    public void addUpdatedTest(){
        
        dao.addContact(c1);
        
        c1.setPhone("9999999999");        
        dao.updateContact(c1);
        
        Contact fromDao = dao.getContactById(c1.getContactId());
        assertEquals(fromDao, c1);
    }
    
    @Test
    public void getAllContacts(){
        
        dao.addContact(c1);
        dao.addContact(c2);
        
        List<Contact> cList = dao.getAllContact();
        assertEquals(2, cList.size());
    }
    @Test
    
    public void searchContactTest(){
        
        dao.addContact(c1);
        dao.addContact(c2);
        c3.setCompany("Microsoft");
        dao.addContact(c3);
        
        Map<SearchTerm, String> criteria = new HashMap<>();
        criteria.put(SearchTerm.LAST_NAME, "gates");
        List<Contact> cList = dao.searchContacts(criteria);
        
        assertEquals(1, cList.size());
        assertEquals(c2, cList.get(0));
        
        criteria.put(SearchTerm.LAST_NAME, "jobs");
        cList = dao.searchContacts(criteria);
        assertEquals(1, cList.size());
        assertEquals(c1, cList.get(0));
        
        criteria.clear();
        
        criteria.put(SearchTerm.COMPANY, "Microsoft");
        cList=dao.searchContacts(criteria);
        assertEquals(2, cList.size());
        
        criteria.put(SearchTerm.LAST_NAME, "Ellison");
        cList=dao.searchContacts(criteria);
        assertEquals(1, cList.size());
        assertEquals(c3, cList.get(0));
        
        
        criteria.put(SearchTerm.COMPANY, "Oracle");
        cList=dao.searchContacts(criteria);
        assertEquals(0, cList.size());
        
    }
    
    
}
