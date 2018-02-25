/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookwithstreams.DAO;

import com.swcguild.addressbookwithstreams.DTO.Address;
import java.util.List;
import java.util.Map;
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
public class AddressDAOAddGetRemoveTest {

    AddressDAO dao;
    Address a1;
    Address a2;
    Address a3;

    public AddressDAOAddGetRemoveTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        dao = new AddressDAOImpl();

        a1 = new Address();
        a1.setFirstName("BOB");
        a1.setLastName("EVANS");
        a1.setStreet("1 Resuratant lane");
        a1.setCity("Akron");
        a1.setState("OH");
        a1.setZip("44311");

        a2 = new Address();
        a2.setFirstName("Even");
        a2.setLastName("Stevens");
        a2.setStreet("91 Darrow rd");
        a2.setCity("Austin");
        a2.setState("TX");
        a2.setZip("78660");

        a3 = new Address();
        a3.setFirstName("JIM");
        a3.setLastName("MATU");
        a3.setStreet("2 Hudson lane");
        a3.setCity("Hudson");
        a3.setState("OH");
        a3.setZip("44236");
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
    public void getNonExistentAddress() {
        Address testAddy = dao.getAddress(2);
        assertNull(testAddy);

        dao.addAddress(a1); // add a1, now we know it's not empty
        //ask for something else than that and should get nothing back > index[0]
        testAddy = dao.getAddress(2);
        assertNull(testAddy);
    }

    @Test
    public void addGetRemoveTest() {

        //add test
        dao.addAddress(a1);
        Address fromDao = dao.getAddress(a1.getId());
        assertEquals(a1, fromDao);

        dao.addAddress(a2);
        Address fromDao2 = dao.getAddress(a2.getId());
        assertEquals(a2, fromDao2);

        dao.addAddress(a3);
        Address fromDao3 = dao.getAddress(a3.getId());
        assertEquals(a3, fromDao3);

        //---------------------------------------------
        // remove test
        dao.removeAddress(a1.getId());
        Address removeAddy = dao.getAddress(a1.getId());
        assertNull(removeAddy);

        dao.removeAddress(a2.getId());
        Address removeAddy2 = dao.getAddress(a1.getId());
        assertNull(removeAddy2);

        dao.removeAddress(a3.getId());
        Address removeAddy3 = dao.getAddress(a3.getId());
        assertNull(removeAddy3);

        dao.removeAddress(900000);
        Address removeAddy4 = dao.getAddress(900000);
        assertNull(removeAddy4);

    }

    @Test
    public void countTest() {
        //add dao
        //ask for count
        dao.addAddress(a1);
        dao.addAddress(a2);
        dao.addAddress(a3);
        int count = dao.countAddress();
        assertEquals(3, count);
    }

    @Test
    public void getAllAddressTest() {
        //add 3 daos
        //asssert size=3, .contains
        dao.addAddress(a1);
        dao.addAddress(a2);
        dao.addAddress(a3);
        
      //  AssertEqual(3, )
        //NEED TO FINISH
    }

    @Test
    public void editAddressTest() {
        //create a1(above)  //put in dao   //get a1 out
        //change something on dto/ field on a1
        //resave a1    //get from dao

        dao.addAddress(a1);
        a1 = dao.getAddress(a1.getId());
        a1.setLastName("Jones");
        dao.addAddress(a1);
        Address fromDao = dao.getAddress(a1.getId());
        assertEquals(a1, fromDao);

    }

    @Test
    public void searchByLastNameTest() {
        dao.addAddress(a2);
        List<Address> name = dao.searchByLastName("Steven");
        assertEquals(a2.getLastName(), "Stevens");

        dao.addAddress(a1);
        List<Address> name1 = dao.searchByLastName("Evans");
        assertEquals(1, name1.size());

        dao.addAddress(a3);
        List<Address> name2 = dao.searchByLastName("Matu");
        assertEquals(1, name2.size());
    }

    @Test
    public void searchByCityTest() {
        dao.addAddress(a1);
        List<Address> city = dao.searchByCity("Akron");
        assertEquals(a1.getCity(), "Akron");

        dao.addAddress(a2);
        List<Address> city1 = dao.searchByCity("Austin");
        assertEquals(1, city1.size());

        dao.addAddress(a3);
        List<Address> city2 = dao.searchByCity("Hudson");
        assertEquals("Hudson", a3.getCity());
        

    }

    @Test
    public void searchByStateSortByCityTest() {

        dao.addAddress(a1);
        dao.addAddress(a2);
        dao.addAddress(a3);
        Map<String, List<Address>> state = dao.searchByStateSortByCity("OH");
        assertEquals(2, state.size());

        Map<String, List<Address>> state1 = dao.searchByStateSortByCity("TX");
        assertEquals("TX", a2.getState());
        /*
        
         a2.setState(a1.getState());
         a3.setState("notstate");
         dao.addAddress(a1);
         dao.addAddress(a2);
         dao.addAddress(a3);
         assertEquals(2,dao.searchState(a1.getState()).size());
         */
    }

    @Test
    public void searchByZipTest() {
        dao.addAddress(a1);
        List<Address> zip = dao.searchByZip("44311");
        assertEquals(1, zip.size());

        dao.addAddress(a3);
        List<Address> zip1 = dao.searchByZip("44236");
        assertEquals(zip1.get(0), a3);

    }
}
