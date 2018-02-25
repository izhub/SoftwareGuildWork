
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook.Controller;

import com.swcguild.addressbook.DAO.AddressBook;
import com.swcguild.addressbook.DTO.Address;
import com.swcguild.consoleio.ConsoleIO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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

    //code to run the API or UI/App
    public void run() {
        boolean keepGoing = true;
        try {
            book.loadBook();
            while (keepGoing) {
                printMenu();
                int userSelection = con.getInt("Please enter your selection: ");

//int above eats the return carriage, need to add back in so it doens't skip
                con.getString("");

                switch (userSelection) {
                    case 1:
                        con.String("Choice 1. Add new Address");
                        addAddress();
                        break;
                    case 2:
                        con.String("Choice 2: Delete an Address");
                        removeAddress();
                        break;
                    case 3:
                        con.String("Choice 6: Editing");
                        editAddress();
                        break;
                    case 4:
                        con.String("Choice 3: Find an Address");
                        findAddressByLastName();
                        break;
                    case 5:
                        con.String("Choice 4: List Address count");
                        countAddress();
                        break;
                    case 6:
                        con.String("Choice 5: List all Addresses");
                        listAddress();
                        break;                    
                    case 7:
                        con.String("Choice 7: Exit");
                        keepGoing = false;
                        break;
                    default:
                        con.String("Invalid Selection");
                        break;
                }

            }
            con.String("Thanks for playing");
            book.writeBook();
        } catch (FileNotFoundException ex) {
            System.out.println("Error loading address book.");
        } catch (IOException ex) {
            System.out.println("Error writing to file");
        }
    }

    private void printMenu() {
        con.String("\n Home Menu");
        con.String("1. Add address");
        con.String("2. Delete address");
        con.String("3. Edit an address");
        con.String("4. Find Address by last name");
        con.String("5. List address count");
        con.String("6. List all addresses"
                + "");
        con.String("7. Exit");
    }

    private void addAddress() {
        String addMore = "";
        do {
            String nameFirst = con.getString("Enter first name: ");
            String nameLast = con.getString("Enter last name: ");
            String addressStreet = con.getString("Enter street address: ");
            String addressCity = con.getString("Enter city: ");
            String addressState = con.getString("Enter state: ");
            String addressZip = con.getString("Enter zip: ");

            Address currentAddress = new Address();
            currentAddress.setFirstName(nameFirst);
            currentAddress.setLastName(nameLast);
            currentAddress.setStreet(addressStreet);
            currentAddress.setCity(addressCity);
            currentAddress.setState(addressState);
            currentAddress.setZip(addressZip);

            book.addAddress(currentAddress);
            addMore = con.getString("Address added. press 1 to add more or 2 to go to main Menu");
        } while (addMore.equals("1"));
    }

    private void removeAddress() {

        String deleteMore = "";
        do {
            findAddressByLastName();
            
            int key = con.getInt("Enter ID of address to be removed");
            book.removeAddress(key);
            con.getString("Address deleted. press 1 to add more or any key to go to main Menu");
        } while (deleteMore.equals("1"));
    
    }

    private void findAddressByLastName() {
        
        
        String lastName = con.getString("Enter last name to search");
        HashMap<Integer, Address> results = book.findAddressByLastName(lastName);

        if (results.isEmpty()) {
            con.String("Address not found");
            return;
                                
        } else {
            Collection<Address> colAddress = results.values();
            for (Address eachAddress : colAddress) {
                con.String("\r#"+eachAddress.getUniqueKey() + " - "
                        + eachAddress.getFirstName() + " "
                        + eachAddress.getLastName() + "\n"
                        + eachAddress.getStreet() + "\n"
                        + eachAddress.getCity() + ", "
                        + eachAddress.getState() + ","
                        + eachAddress.getZip() + "");

            }
        }
    }

    private void countAddress() {
        con.String("There are " + book.countAddress() + " addresses");
    }

    private void listAddress() {
        Address[] addressList = book.listAddress();

        for (Address address : addressList) {
            con.String(address.getUniqueKey() + "\n" + address.getFirstName() + " "
                    + address.getLastName() + "\n" + address.getStreet() + "\n"
                    + address.getCity() + ", " + address.getState() + " "
                    + address.getZip() + "\n");
        }
    }

    public void editAddress() {

        String lastName = con.getString("Please enter last name to search for: ");
        HashMap<Integer, Address> results = book.findAddressByLastName(lastName);
        Collection<Address> resultCollection;
        if (results.isEmpty()) {
            con.String("Address not found.");
        } else {
            resultCollection = results.values();
            for (Address result : resultCollection) {
                con.String("\rID: "+result.getUniqueKey() + "\n" 
                        + result.getFirstName() + " "
                        + result.getLastName() + "\n" + result.getStreet() + "\n"
                        + result.getCity() + ", " + result.getState() + " "
                        + result.getZip() + "\n");
            }

            int key = con.getInt("Enter ID of address to edit: \n");

            con.String("\r1: " + results.get(key).getFirstName());
            con.String("2: " + results.get(key).getLastName());
            con.String("3: " + results.get(key).getStreet());
            con.String("4: " + results.get(key).getCity());
            con.String("5: " + results.get(key).getState());
            con.String("6: " + results.get(key).getZip());

            int lineNumber = con.getInt("Enter line number to edit \n");
            con.getString("");

            String revisedLine = con.getString("Enter new information");

            switch (lineNumber) {
                case 1:
                    results.get(key).setFirstName(revisedLine);
                    break;
                case 2:
                    results.get(key).setLastName(revisedLine);
                    break;
                case 3:
                    results.get(key).setStreet(revisedLine);
                    break;
                case 4:
                    results.get(key).setCity(revisedLine);
                    break;
                case 5:
                    results.get(key).setState(revisedLine);
                    break;
                case 6:
                    results.get(key).setZip(revisedLine);
                    break;
                case 7:
                    break;
                default:
                    con.String("Invalid option.");
            }
           
            book.updateAddress(results.get(key));
        }
    }
}
