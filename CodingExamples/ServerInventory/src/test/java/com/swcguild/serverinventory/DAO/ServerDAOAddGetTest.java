/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.serverinventory.DAO;

import com.swcguild.serverinventory.DTO.Server;
import java.time.LocalDate;
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
public class ServerDAOAddGetTest {
    ServerDAO dao;  //dummy for implementing stuff; 
    Server s1;   // null by default
    Server s2;
    Server s3;
    
    public ServerDAOAddGetTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
//       dao = new ServerDAOInMemImpl();
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        dao = ctx.getBean("dao", ServerDAOInMemImpl.class);
        
        s1 = new Server();
        s1.setName("TEST SERVER");
        s1.setIp("130.45.34");
        s1.setMake("DELL");
        s1.setNumProcessors(16);
        s1.setPurchaseDate(LocalDate.now());
        s1.setRam("246GB DDR");

        //don't re-declare class level variables down here; ex: Server s2 = new Sever();
        //will give no exeception error
        
        s2 = new Server();
        s2.setName("TEST SERVER 2");
        s2.setIp("130.45.40");
        s2.setMake("DELL");
        s2.setNumProcessors(24);
        s2.setPurchaseDate(LocalDate.now());
        s2.setRam("64GB DDR");
        
        s3 = new Server();
        s3.setName("TEST SERVER 3");
        s3.setIp("130.50.40");
        s3.setMake("HP");
        s3.setNumProcessors(24);
        s3.setPurchaseDate(LocalDate.now());
        s3.setRam("64GB DDR");
        
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
    public void getNoneExistentServer(){
        //make sure when I ask for something from an empty DAO I get nothing back
        Server testServer = dao.getServer(7);
        assertNull(testServer);
        
        //make sure when i ask for a non existent server from a non-empty
        // DAO I get nothing back
        dao.addServer(s1);
        testServer = dao.getServer(7);
        assertNull(testServer);
    }
    
    @Test
    public void addGetServerTest(){
        //this test is why we do hashequals insert
        //do this test becuase we do not know the implementation behind it
        dao.addServer(s1);
        Server fromDao = dao.getServer(s1.getId());
        assertEquals(s1, fromDao);
        
        
        // add more servers to test if more than 1 passes
        dao.addServer(s2);
        dao.addServer(s3);
        
        fromDao = dao.getServer(s1.getId());
        assertEquals(s1, fromDao);
        
        fromDao = dao.getServer(s2.getId());
        assertEquals(s2, fromDao);
        
        fromDao = dao.getServer(s3.getId());
        assertEquals(s3, fromDao);
        
//        Server nullServer = null;
//        dao.addServer(nullServer);
//        fromDao = dao.getServer(null); //can you call null?
//        // won't do anything as you can't recall it by anything
    }
}
