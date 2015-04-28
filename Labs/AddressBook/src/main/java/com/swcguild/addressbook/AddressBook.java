/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook;

/**
 *
 * @author apprentice
 */

// Data Access Object that handles storing data in memory and reading and writing 
//data from persistent storage

//Design an AddressBook class that has a Collection of Address objects. It should 
//  also have methods to do the following:
//a. Add an address
//b. Remove an address
//c. Find an address by last name
//d. Return a count of Addresses in the AddressBook
//e. Return all of the Addresses in the AddressBoo

// phase II: Add code to allow the user to edit an address.
// phase III: Add code to initialize your address book from a file. 
// Also add code to allow the user so save his/her address back to the file.

public class AddressBook {
    ConsoleIO con = new ConsoleIO();
    
    
    
    public Address addAddress(){
        
        return ;
    }
    
    public Address removeAddress(){
        
        return ;
    }
    public Address findAddressByLastName(String namLast){
        
        return ;
    }
    public Address countAddress(){
        
        return ;
    }
    public Address listAddress(){
        
        return ;
    }
}
/*
    // Create a constant for the name of the AddressBook file.  We do this to improve
    // readability and maintainability.  If we want to change the name of the
    // roster file, we just have to change it in one place.  
 public static final String ADDRESSBOOK_FILE = "address.txt";

    // Create a constant for the delimiter we use to separate the pieces of
    //  data on each line of ADDRESSBOOK_FILE
 public static final String DELIMITER = "::";
*/