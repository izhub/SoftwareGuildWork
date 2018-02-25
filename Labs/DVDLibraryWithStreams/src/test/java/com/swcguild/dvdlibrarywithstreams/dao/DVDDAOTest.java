/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrarywithstreams.dao;

import com.swcguild.dvdlibrarywithstreams.DAO.DVDDAO;
import com.swcguild.dvdlibrarywithstreams.DAO.DVDDAOImpl;
import com.swcguild.dvdlibrarywithstreams.DTO.DVD;
import java.util.List;
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
public class DVDDAOTest {

    DVDDAO dao;
    DVD d1;
    DVD d2;
    DVD d3;

    public DVDDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        dao = new DVDDAOImpl();

        d1 = new DVD();
        d1.setTitle("American Pie");
        d1.setDirector("Paul Weitz");
        d1.setRating("R");
        d1.setReleaseDate("1995");
        d1.setStudio("Universal Studio");

        d2 = new DVD();
        d2.setTitle("Jumanji");
        d2.setDirector("Joe Jonston");
        d2.setRating("PG");
        d2.setReleaseDate("1995");
        d2.setStudio("TriStar");

        d3 = new DVD();
        d3.setTitle("The Shawshank Redemption");
        d3.setDirector("Frank Darabont");
        d3.setRating("R");
        d3.setReleaseDate("2000");
        d3.setStudio("Columbia Pictures");

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
    public void getNonExistentTest() {
        DVD dummyDvd = dao.findDVDById(2);
        assertNull(dummyDvd);

        dao.addDVD(d1);
        dummyDvd = dao.findDVDById(2);
        assertNull(dummyDvd);
    }

    @Test
    public void addGetRemoveTest() {
        //add test
        dao.addDVD(d1);
        DVD fromDao = dao.findDVDById(d1.getId());
        assertEquals(d1, fromDao);

        dao.addDVD(d2);
        DVD fromDao2 = dao.findDVDById(d2.getId());
        assertEquals(d2, fromDao2);

        dao.addDVD(d3);
        DVD fromDao3 = dao.findDVDById(d3.getId());
        assertEquals(d3, fromDao3);

        //remove test
        dao.removeDVD(d1.getId());
        DVD removeDvd = dao.findDVDById(d1.getId());
        assertNull(removeDvd);

        dao.removeDVD(d2.getId());
        DVD removeDvd2 = dao.findDVDById(d2.getId());
        assertNull(removeDvd2);

        dao.removeDVD(d3.getId());
        DVD removeDvd3 = dao.findDVDById(d3.getId());
        assertNull(removeDvd3);

        dao.removeDVD(9999999);
        DVD removeDvd4 = dao.findDVDById(9999999);
        assertNull(removeDvd4);
    }

    @Test   //passed
    public void countTest() {
        //add dvd // ask for count
        dao.addDVD(d1);
        dao.addDVD(d2);
        dao.addDVD(d3);
        int count = dao.countDVD();
        assertEquals(3, count);
    }

    @Test   //passed
    public void getAllDVDTest() {
        //add dvds ; assert
        dao.addDVD(d1);
        dao.addDVD(d2);
        dao.addDVD(d3);
        dao.listAllDVD();

    }

    @Test   //passed
    public void editDVDTest() {
        //create d1(above) : put in dao : get it out
        // change something in field : resave : get from fromdao

        dao.addDVD(d1);
        d1 = dao.findDVDById(d1.getId());
        d1.setRating("PG-13");
        dao.addDVD(d1);
        DVD fromDao = dao.findDVDById(d1.getId());
        assertEquals(d1, fromDao);

        dao.addDVD(d2);
        d2 = dao.findDVDById(d2.getId());
        d2.setDirector("Bobby");
        dao.addDVD(d2);
        DVD fromDao2 = dao.findDVDById(d2.getId());
        assertEquals(d2, fromDao2);
    }

    @Test
    public void getDVDTest() {
        dao.addDVD(d1);
        DVD getdvd = dao.findDVDById(d1.getId());
        assertEquals(d1, getdvd);

        dao.addDVD(d2);
        DVD getdvd2 = dao.findDVDById(d2.getId());
        assertEquals(d2, getdvd2);

        dao.addDVD(d3);
        DVD getdvd3 = dao.findDVDById(d3.getId());
        assertEquals(d3, getdvd3);

    }

    @Test
    public void searchByTitleTest() {
        dao.addDVD(d1);
        List<DVD> title = dao.searchDVDByTitle("American Pie");
        assertEquals(1, title.size());
    }

    @Test
    public void searchDVDByYearsTest() {

    }

    @Test
    public void searchDVDByRatingTest() {
        dao.addDVD(d1);
        List<DVD> rating = dao.searchDVDByRating("R");
        assertEquals(1, rating.size());
    }

    @Test
    public void searchDVDByDirectorThanRatingTest() {
        dao.addDVD(d1);
        dao.addDVD(d2);
        dao.addDVD(d3);
// do this        
    }

    @Test
    public void searchDVDByStudioTest() {
        dao.addDVD(d1);
        dao.addDVD(d2);
        dao.addDVD(d3);
        
        List<DVD> studio = dao.searchDVDByStudio("Universal Studio");
        assertEquals(1, studio.size());
        
        List<DVD> studio2 = dao.searchDVDByStudio("TriStar");
        assertEquals(d2.getStudio(), "TriStar");
    }

    @Test
    public void listNewDVDsTest() {

    }

    @Test
    public void listOldDVDsTest() {

    }

    @Test
    public void avgMovieAgeTest() {

    }

    @Test
    public void avgNotesTest() {

    }
}
