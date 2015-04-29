/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook;

import com.swcguild.consoleio.ConsoleIO;

/**
 *
 * @author apprentice
 */

//Design a AddressBookController class. This class should do the following:
//a. It must handle all the interaction with the user.
//b. It must use the ConsoleIOClass from a previous lab to handle all console input
//and output.
//c. It must use the AddressBook class to store Address objects.
        
public class AddressBookController {
    
    AddressBook book = new AddressBook();
    ConsoleIO con = new ConsoleIO();
    
    // code to run there App or UI
    
    public void run(){
        
        
              
    }
    
    private void printMenu() {
        con.print("Home Menu");
        con.print("1. Add Address");
        con.print("2. Delete Address");
        con.print("3. Find Address");
        con.print("4. List Address Coutn");  
        con.print("5. List All Addresses");
        con.print("5. Exit");
        }
    
    private void addAddress(){
        
        String nameFirst = con.getString("Please Enter First Name: ");
        String nameLast = con.getString("Please Enter Last Name: ");
        String streetAddress = con.getString("Please enter Street Address: ");
        Address currentAddress = new Address();
        currentAddress.setNameFirst(nameFirst);
        currentAddress.setNameLast(nameLast);
        currentAddress.setStreetAddress(streetAddress);
        book.addAddress(currentAddress);
        con.getString("Address Add. Press 1 to go to Main Menu"); // need link to main menu
    }
    
    private void removeAddress(){
        
        
    }
    private void findAddressByLastName(){
        
    }
    private void countAddress(){
        
    }
    private void listAddress(){
        
    }
}