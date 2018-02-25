/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryv3.test;

import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import com.swcguild.dvdlibrary.dto.Dvd;
import com.swcguild.dvdlibraryv3.DVDLibraryInMemImplZahidIqbal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
public class DvdDaoTest {

    DvdLibraryDao dao;
    Dvd d1;
    Dvd d2;
    Dvd d3;
    Dvd d4;

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
        dao = new DVDLibraryInMemImplZahidIqbal();

        d1 = new Dvd();
        d1.setId(1);
        d1.setTitle("American Pie");
        d1.setDirector("Paul Weitz");
        d1.setMpaaRating("R");
        d1.setReleaseDate(LocalDate.parse("1995-01-01", DateTimeFormatter.ISO_DATE));
        d1.setStudio("Univerasl Studio");

        d2 = new Dvd();
        d2.setId(2);
        d2.setTitle("Jumanji");
        d2.setDirector("Joe Jonston");
        d2.setMpaaRating("PG");
        d2.setReleaseDate(LocalDate.parse("1995-02-05", DateTimeFormatter.ISO_DATE));
        d2.setStudio("TriStar");

        d3 = new Dvd();
        d3.setId(3);
        d3.setTitle("The Shawshank Redemption");
        d3.setDirector("Frank Darabont");
        d3.setMpaaRating("R");
        d3.setReleaseDate(LocalDate.parse("2000-05-06", DateTimeFormatter.ISO_DATE));
        d3.setStudio("Columbia Pictures");

        d4 = new Dvd();
        d4.setId(4);
        d4.setTitle("The Shawshank Redemption");
        d4.setDirector("Frank Darabont");
        d4.setMpaaRating("R");
        d4.setReleaseDate(LocalDate.parse("2000-05-06", DateTimeFormatter.ISO_DATE));
        d4.setStudio("Columbia Pictures");

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

        dao.add(d1);
        Dvd dvd = dao.getById(d1.getId());
        //    assertEquals(d1.getTitle(),dvd.getTitle());
        assertEquals(d1, dvd);

        dao.add(d2);
        Dvd dvd2 = dao.getById(d2.getId());
        assertEquals(d2.getTitle(), dvd2.getTitle());

        dao.add(d3);
        Dvd dvd3 = dao.getById(d3.getId());
        assertEquals(d3.getTitle(), dvd3.getTitle());

        //remove test
        dao.remove(d1.getId());
        Dvd dvdr = dao.getById(d1.getId());
        assertNull(dvdr);

        dao.remove(d2.getId());
        Dvd dr2 = dao.getById(d2.getId());
        assertNull(dr2);

        dao.remove(d3.getId());
        Dvd dr3 = dao.getById(d3.getId());
        assertNull(dr3);

    }

    @Test
    public void getAllTest() {

        dao.add(d1);
        dao.add(d2);
        dao.add(d3);

        int dvd = dao.listAll().size();
        assertEquals(3, dvd);

    }

    @Test
    public void getDvdByTitleTest() {
        dao.add(d1);
        dao.add(d2);
        dao.add(d3);
        dao.add(d4);
        List<Dvd> title = dao.getByTitle("American Pie");
        //    assertEquals(1, title.size());
//        assertEquals(d1.getTitle(), title.get(0).getTitle());
        assertEquals("American Pie", title.get(0).getTitle());

        List<Dvd> title2 = dao.getByTitle("Jumanji");
        assertEquals(1, title2.size());

        List<Dvd> title4 = dao.getByTitle("The Shawshank Redemption");
        assertEquals(2, title4.size());

    }

    @Test
    public void getDvdByRatingTest() {
        dao.add(d1);
        dao.add(d2);
        dao.add(d3);
        dao.add(d4);
        
        List<Dvd> rate = dao.getByRating("R");
        assertEquals(3, rate.size());
        
        List<Dvd> rate1 = dao.getByRating("PG");
        assertEquals(1, rate1.size());
       
    }

    @Test
    public void getDvdByStudioTest() {
        dao.add(d1);
        dao.add(d2);
        dao.add(d3);
        dao.add(d4);
        
        List<Dvd> studio = dao.getByStudio("TriStar");
        assertEquals(1, studio.size());
        
        List<Dvd> studio1 = dao.getByStudio("Columbia Pictures");
        assertEquals(2, studio1.size());
    }
}
