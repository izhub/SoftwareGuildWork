/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook;

import java.io.FileNotFoundException;
import java.io.IOException;
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
public class AddressBookTest {
    AddressBook addBook;
    
    public AddressBookTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        addBook = new AddressBook();
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
    public void isEmptyTest(){
        
        assertEquals(0, addBook.countAddress());
    }
    @Test
    public void addAddressTest(){
        Address address = new Address();
        addBook.addAddress(address);
        assertEquals(1, addBook.countAddress());
    }
    @Test
    public void removeAddressTest(){
        Address address = new Address();
        addBook.addAddress(address);
        addBook.removeAddress(address.getUniqueKey());
        assertEquals(0, addBook.countAddress());
    }
    @Test
    public void findAddressTest(){
        Address address = new Address();
        address.setNameLast("last");
        addBook.addAddress(address);
        assertEquals(address, addBook.findAddressByLastName("last").get(0));
    }
    @Test
    public void saveAddressTest() throws FileNotFoundException, IOException{
       Address address = new Address();
       address.setNameFirst("first");
       address.setNameLast("last");
       address.setAddressStreet(" main street");
       address.setAddressCity("Akron");
       address.setAddressState("Ohio");
       address.setAddressZip("44231");
       addBook.addAddress(address);
       AddressBook address2 = new AddressBook();
       addBook.writeBook();
       address2.loadBook();
//       assertEquals(addBook, address2);
       assertTrue(addBook.equals(address2));
       
    }
}
