
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook;

import com.swcguild.consoleio.ConsoleIO;
import java.io.FileNotFoundException;
import java.io.IOException;
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
                        con.String("Choice 3: Find an Address");
                        findAddressByLastName();
                        break;
                    case 4:
                        con.String("Choice 4: List Address count");
                        countAddress();
                        break;
                    case 5:
                        con.String("Choice 5: List all Addresses");
                        listAddress();
                        break;
                    case 6:
                        con.String("Choice 6: Editing");
                        editAddress();
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
        con.print("\n Home Menu");
        con.print("1. Add address");
        con.print("2. Delete address");
        con.print("3. Find Address by last name");
        con.print("4. List address count");
        con.print("5. List all addresses");
        con.print("6. Edit an address");
        con.print("7. Exit");
    }

    private void addAddress() {
        String nameFirst = con.getString("Enter first name: ");
        String nameLast = con.getString("Enter last name: ");
        String addressStreet = con.getString("Enter street address: ");
        String addressCity = con.getString("Enter city: ");
        String addressState = con.getString("Enter state: ");
        String addressZip = con.getString("Enter zip: ");

        Address currentAddress = new Address();
        currentAddress.setNameFirst(nameFirst);
        currentAddress.setNameLast(nameLast);
        currentAddress.setAddressStreet(addressStreet);
        currentAddress.setAddressCity(addressCity);
        currentAddress.setAddressState(addressState);
        currentAddress.setAddressZip(addressZip);

        book.addAddress(currentAddress);
        int menu = con.getInt("Address added. press 1 to go to main Menu");

    }

    private void removeAddress() {
        findAddressByLastName();
        int key = con.getInt("Enter ID of address to be removed");
        book.removeAddress(key);
        con.String("Address removed.");
    }

    private void findAddressByLastName() {

        String lastName = con.getString("Enter last name to search for address");
        HashMap<Integer, Address> results = book.findAddressByLastName(lastName);

        if (results.isEmpty()) {
            con.String("Address not found");
        } else {
            Collection<Address> resultCollection = results.values();
            for (Address result : resultCollection) {
                con.String(result.getUniqueKey() + "\n"
                        + result.getNameFirst() + "\n" + result.getNameLast()
                        + "\n" + result.getAddressStreet() + "\n"
                        + result.getAddressCity() + "\n" + result.getAddressState()
                        + "\n" + result.getAddressZip() + "\n");

            }
        }
    }

    private void countAddress() {
        con.String("There are " + book.countAddress() + " addresses");
    }

    private void listAddress() {
        Address[] addressList = book.listAddress();

        for (Address address : addressList) {
            con.String(address.getUniqueKey() + "\n" + address.getNameFirst() + " "
                    + address.getNameLast() + "\n" + address.getAddressStreet() + "\n"
                    + address.getAddressCity() + ", " + address.getAddressState() + " "
                    + address.getAddressZip() + "\n");
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
                con.String(result.getUniqueKey() + "\n" + result.getNameFirst() + " "
                        + result.getNameLast() + "\n" + result.getAddressStreet() + "\n"
                        + result.getAddressCity() + ", " + result.getAddressState() + " "
                        + result.getAddressZip() + "\n");
            }

            int key = con.getInt("Enter ID of address to edit: \n");

            con.String("1: " + results.get(key).getNameFirst());
            con.String("2: " + results.get(key).getNameLast());
            con.String("3: " + results.get(key).getAddressStreet());
            con.String("4: " + results.get(key).getAddressCity());
            con.String("5: " + results.get(key).getAddressState());
            con.String("6: " + results.get(key).getAddressZip());

            int lineNumber = con.getInt("Enter line number to edit \n");
            con.getString("");

            String revisedLine = con.getString("Enter new information");

            switch (lineNumber) {
                case 1:
                    results.get(key).setNameFirst(revisedLine);
                    break;
                case 2:
                    results.get(key).setNameLast(revisedLine);
                    break;
                case 3:
                    results.get(key).setAddressStreet(revisedLine);
                    break;
                case 4:
                    results.get(key).setAddressCity(revisedLine);
                    break;
                case 5:
                    results.get(key).setAddressState(revisedLine);
                    break;
                case 6:
                    results.get(key).setAddressZip(revisedLine);
                    break;
                default:
                    con.String("Invalid option.");
            }
            book.updateAddress(results.get(key));
        }
    }
}
