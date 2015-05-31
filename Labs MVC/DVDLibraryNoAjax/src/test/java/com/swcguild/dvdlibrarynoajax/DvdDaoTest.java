/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrarynoajax;

import com.swcguild.dvdlibrarynoajax.dao.DVDDaoInMemImpl;
import com.swcguild.dvdlibrarynoajax.dao.SearchTerm;
import com.swcguild.dvdlibrarynoajax.model.DVD;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

/**
 *
 * @author apprentice
 */
public class DvdDaoTest {

    private DVDDaoInMemImpl dao;
    DVD d1;
    DVD d2;
    DVD d3;
    DVD d4;
    DVD d5;
    
    public DvdDaoTest() {
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
        
        dao = ctx.getBean("DVDDao", DVDDaoInMemImpl.class);
        
        d1 = new DVD();
        d1.setDvdId(0);
        d1.setTitle("American Pie");
        d1.setDirector("Paul Weitz");
        d1.setMpaaRating("R");
        d1.setReleaseDate("1995-01-01");
        d1.setStudio("Univerasl Studio");

        d2 = new DVD();
        d2.setDvdId(1);
        d2.setTitle("Jumanji");
        d2.setDirector("Joe Jonston");
        d2.setMpaaRating("PG");
        d2.setReleaseDate("1995-02-05");
        d2.setStudio("TriStar");

        d3 = new DVD();
        d3.setDvdId(2);
        d3.setTitle("The Shawshank Redemption");
        d3.setDirector("Frank Darabont");
        d3.setMpaaRating("R");
        d3.setReleaseDate("2000-05-06");
        d3.setStudio("Columbia Pictures");

        d4 = new DVD();
        d4.setDvdId(3);
        d4.setTitle("The Shawshank Redemption");
        d4.setDirector("Franky Darabont");
        d4.setMpaaRating("R");
        d4.setReleaseDate("2000-05-06");
        d4.setStudio("Columbia Pictures");

        d5=new DVD();
        d5.setDvdId(4);
        d5.setDirector("zee rana");
        d5.setTitle("Jinn");
        d5.setReleaseDate("2000-05-06");
        d5.setMpaaRating("PG");
        d5.setStudio("ZeeStar");
        
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
    public void getAddRemoveTest() {

       
        dao.addDvd(d5);
        
        DVD fromDv = dao.getDvdById(d5.getDvdId());
        //    assertEquals(d1.getTitle(),dvd.getTitle());
        assertEquals(d5.getTitle(),fromDv.getTitle());
        
//        
//        dao.removeDvd(dvd.getId());
//        assertNull(dao.getDvdById(dvd.getId()));


    }

    @Test
    public void addUpdateDvdTest(){
        
        dao.addDvd(d1);
        
        d1.setDirector("Zee Rana");
        dao.updateDvd(d1);
        DVD fromDb = dao.getDvdById(d1.getDvdId());
        assertEquals(fromDb, d1);
        
    }
    @Test
    public void getAllTest() {

        dao.addDvd(d1);
        dao.addDvd(d2);
        dao.addDvd(d3);

        List<DVD> cList = dao.getAllDvds();
        assertEquals(3, cList.size());

    }
    
    @Test
    public void searchDvd(){
        dao.addDvd(d1);
        dao.addDvd(d2);
        dao.addDvd(d3);
        dao.addDvd(d4);
        
        //create search criteria
        Map<SearchTerm, String> criteria = new HashMap<>();
        
        criteria.put(SearchTerm.DIRECTOR, "Franky Darabont");
        List<DVD> cList = dao.searchDvds(criteria);
        assertEquals(1, cList.size());
        assertEquals(d4, cList.get(0));
        
        criteria.clear();
        
        //new search criteria 
        criteria.put(SearchTerm.TITLE, "Jumanji");
        cList = dao.searchDvds(criteria);
        assertEquals(1, cList.size());
                }

//    @Test
//    public void getDvdByTitleTest() {
//        dao.addDvd(d1);
//        dao.addDvd(d2);
//        dao.addDvd(d3);
//        dao.addDvd(d4);
//        
//        List<DVD> title = dao.getByTitle("American Pie");
//        //    assertEquals(1, title.size());
////        assertEquals(d1.getTitle(), title.get(0).getTitle());
//        assertEquals("American Pie", title.get(0).getTitle());
//
//        List<DVD> title2 = dao.getByTitle("Jumanji");
//        assertEquals(1, title2.size());
//
//        List<DVD> title4 = dao.getByTitle("The Shawshank Redemption");
//        assertEquals(2, title4.size());
//
//    }
//
//    @Test
//    public void getDvdByRatingTest() {
//        dao.addDvd(d1);
//        dao.addDvd(d2);
//        dao.addDvd(d3);
//        dao.addDvd(d4);
//        
//        List<DVD> rate = dao.getByRating("R");
//        assertEquals(3, rate.size());
//        
//        List<DVD> rate1 = dao.getByRating("PG");
//        assertEquals(1, rate1.size());
//       
//    }
//
//    @Test
//    public void getDvdByStudioTest() {
//        dao.addDvd(d1);
//        dao.addDvd(d2);
//        dao.addDvd(d3);
//        dao.addDvd(d4);
//        
//        List<DVD> studio = dao.getByStudio("TriStar");
//        assertEquals(1, studio.size());
//        
//        List<DVD> studio1 = dao.getByStudio("Columbia Pictures");
//        assertEquals(2, studio1.size());
//    }
}
