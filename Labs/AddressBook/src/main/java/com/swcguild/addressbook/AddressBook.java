/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook;

import com.swcguild.consoleio.ConsoleIO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

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
    
    private static final String ADDRESS_FILE = "addresses.txt";
    private static final String DELIMITER = "::";
    
    private HashMap<Integer, Address> addresses = new HashMap<>();
    
    public void loadBook() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(ADDRESS_FILE)));
        
        String currentLine;
        String[] currentTokens;
        
        while (sc.hasNextLine()){
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            int key = Integer.parseInt(currentTokens[0]);
            Address newAddress = new Address();
            newAddress.setNameFirst(currentTokens[1]);
            newAddress.setNameLast(currentTokens[2]);
            newAddress.setStreetAddress(currentTokens[3]);
            newAddress.setCity(currentTokens[4]);
            newAddress.setState(currentTokens[5]);
            newAddress.setZip(currentTokens[6]);
            
        }
    }
    
    int uniqueKey = 0;
    
    
    public void addAddress(Address newAddress){
        newAddress.s
        addresses.put(this.uniqueKey, newAddress);
        
    }
    
    public void removeAddress(){
        
        return ;
    }
    public Address findAddressByLastName(String nameLast){
        for ()
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