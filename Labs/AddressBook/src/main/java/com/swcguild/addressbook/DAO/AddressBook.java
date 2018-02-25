/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook.DAO;

import com.swcguild.addressbook.DTO.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
//Design an AddressBook class that has a Collection of Address objects.


public class AddressBook {
/*
// Data Access Object that handles storing data in memory and reading and writing 
//data from persistent storage
    
    // Create a constant for the name of the AddressBook file.  We do this to improve
    // readability and maintainability.  If we want to change the name of the
    // roster file, we just have to change it in one place.  
 public static final String ADDRESSBOOK_FILE = "address.txt";

    // Create a constant for the delimiter we use to separate the pieces of
    //  data on each line of ADDRESSBOOK_FILE
 public static final String DELIMITER = "::";
*/    
    private static final String ADDRESS_FILE = "addresses.txt";
    private static final String DELIMITER = "::";
    
    private HashMap<Integer, Address> addresses = new HashMap<>();
    
    int uniqueKey = 0;
    
    public void loadBook() throws FileNotFoundException{
        Scanner file = new Scanner(new BufferedReader(new FileReader(ADDRESS_FILE)));
        
        //this.uniqueKey = Integer.parseInt(file.nextLine());
        
        String fileLine;
        String[] lineTokens;
        
        while (file.hasNextLine()){
            fileLine = file.nextLine();
            lineTokens = fileLine.split(DELIMITER);
            int key = Integer.parseInt(lineTokens[0]);
            
            Address newAddress = new Address();
            newAddress.setUniqueKey(key);
            newAddress.setFirstName(lineTokens[1]);
            newAddress.setLastName(lineTokens[2]);
            newAddress.setStreet(lineTokens[3]);
            newAddress.setCity(lineTokens[4]);
            newAddress.setState(lineTokens[5]);
            newAddress.setZip(lineTokens[6]);
            
            addresses.put(key, newAddress);            
            
            uniqueKey = ++key;
        }
        file.close();
    }
    
    public void writeBook() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(ADDRESS_FILE));
        
//        Set<Integer> keys = addresses.keySet();
        Collection<Address> address = addresses.values();
    //    out.println(uniqueKey);
        out.flush();
        
        for(Address addy : address){
            String newLine = addy.getUniqueKey() + DELIMITER +
                    addy.getFirstName() + DELIMITER +
                    addy.getLastName() + DELIMITER +
                    addy.getStreet()+ DELIMITER +
                    addy.getCity() + DELIMITER +
                    addy.getState() + DELIMITER +
                    addy.getZip() +  DELIMITER;
            out.println(newLine);
            out.flush();
        }
        out.close();
    }
// It should also have methods to do the following:
//a. Add an address
//b. Remove an address
//c. Find an address by last name
//d. Return a count of Addresses in the AddressBook
//e. Return all of the Addresses in the AddressBoo

// phase II: Add code to allow the user to edit an address.
// phase III: Add code to initialize your address book from a file. 
// Also add code to allow the user so save his/her address back to the file.

    public void addAddress(Address newAddress){
        newAddress.setUniqueKey(uniqueKey);
        addresses.put(uniqueKey, newAddress);
        uniqueKey++;
        System.out.println(uniqueKey);
    }
    
    public void removeAddress(int key){
        addresses.remove(key);
    }
// returns HashMap in case there are multiple addresses in the search result
    public HashMap<Integer, Address>findAddressByLastName(String nameLast){
        HashMap<Integer, Address> result = new HashMap<>();
        Set<Integer> searchKeys = addresses.keySet();
        
        for (int key : searchKeys){
            Address currentAddress = addresses.get(key);
            if(currentAddress.getLastName().equals(nameLast)){
                result.put(key, addresses.get(key));
            }
        }
        return result;
    }
    
    public int countAddress(){
        return addresses.size();
    }
    
    public Address[] listAddress(){
        
        Address[] addressList = new Address[addresses.size()];
        Set<Integer>keys = addresses.keySet();
        int i =0;
        
        for (int key : keys){
            addressList[i++] = addresses.get(key);
        }
        return addressList;
    }
    
    public void updateAddress(Address newInfo){
        addresses.put(newInfo.getUniqueKey(), newInfo);
    }
    
    //------------------------------------------------------------------------
        @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.addresses);
        hash = 83 * hash + this.uniqueKey;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AddressBook other = (AddressBook) obj;
        if (!Objects.equals(this.addresses, other.addresses)) {
            return false;
        }
        if (this.uniqueKey != other.uniqueKey) {
            return false;
        }
        return true;
    }
}
