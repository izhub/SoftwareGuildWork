/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookwithstreams.controller;

import com.swcguild.addressbookwithstreams.DAO.AddressDAO;
import com.swcguild.addressbookwithstreams.DAO.AddressDAOImpl;
import com.swcguild.addressbookwithstreams.DTO.Address;
import com.swcguild.consoleio.ConsoleIO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class AddressBookController {

    ConsoleIO con = new ConsoleIO();
    AddressDAO dao = new AddressDAOImpl();

    public void run() throws IOException {
        int userChoice;

        try {
            dao.loadBook();

            do {
                printMenu();
                userChoice = con.getInt("Please select from the options above:\r");
                con.getString("");

                switch (userChoice) {
                    case 1:
                        addAddress();
                        break;
                    case 2:
                        removeAddress();
                        break;
                    case 3:
                        editAddress();
                        break;
                    case 4:
                        countAddress();
                        break;
                    case 5:
                        listAllAddresses();
                        break;
                    case 6:
                        searchByLastName();
                        break;
                    case 7:
                        searchByCity();
                        break;
                    case 8:
                        searchByStateSortByCity();
                        break;
                    case 9:
                        searchByZip();
                        break;
                    case 10:
                        break;
                    default:
                        con.String("Invalid choice");
                        break;
                }
            } while (userChoice != 10);
            dao.writeBook();
        } catch (FileNotFoundException e) {
            con.String("Error Loading...");
        } catch (IOException e) {
            con.String("Error writing to file...");
        }
    }

    private void printMenu() {
        con.String("+++++++++++++++++++++++++++++++++++++++++++++++");
        con.String("                        Address Book Menu");
        con.String("+++++++++++++++++++++++++++++++++++++++++++++++");
        con.String("1. Add address");
        con.String("2. Remove address");
        con.String("3. Edit Address");
        con.String("4. List address count");
        con.String("5. List all addresses");
        con.String("6. Search by last name");
        con.String("7. Search by City");
        con.String("8. Search by State");
        con.String("9. Search by Zip");
        con.String("10. Exit");
        con.String("+++++++++++++++++++++++++++++++++++++++++++++++");
    }

    private void addAddress() {
        String addMore = "";
        do {
            String firstName = con.getString("Enter first name: ").toUpperCase();
            String lastName = con.getString("Enter last name: ").toUpperCase();
            String street = con.getString("Enter street address: ");
            String city = con.getString("Enter city: ").toUpperCase();
            String state = con.getString("Enter state: ").toUpperCase();
            String zip = con.getString("Enter zip: ");

            Address newAddress = new Address();
            newAddress.setFirstName(firstName);
            newAddress.setLastName(lastName);
            newAddress.setStreet(street);
            newAddress.setCity(city);
            newAddress.setState(state);
            newAddress.setZip(zip);
            dao.addAddress(newAddress);

            addMore = con.getString("Press 1 to add more or enter to exit");
        } while (addMore.equals("1"));

    }

    private void removeAddress() {
        String deleteMore = "";

        do {
            searchByLastName();

            int remove = con.getInt("\rEnter ID to remove");
            //   con.getString("");
            dao.removeAddress(remove);

            deleteMore = con.getString("Press 1 to delete more or enter to exit");

        } while (deleteMore.equals("1"));
    }

    private void editAddress() {
        searchByLastName();

        int id = con.getInt("\rEnter ID of address to edit:");

        if (id < dao.countAddress()) {
            boolean gogo = false;
            do {
                con.String("\r1: " + dao.getAddress(id).getFirstName());
                con.String("2: " + dao.getAddress(id).getLastName());
                con.String("3: " + dao.getAddress(id).getStreet());
                con.String("4: " + dao.getAddress(id).getCity());
                con.String("5: " + dao.getAddress(id).getState());
                con.String("6: " + dao.getAddress(id).getZip());

                int lineNumber = con.getInt("Enter line number to edit \n");
                con.getString("");

                String revisedLine = con.getString("Enter new information");
                switch (lineNumber) {
                    case 1:
                        dao.getAddress(id).setFirstName(revisedLine);
                            break;
                    case 2:
                        dao.getAddress(id).setLastName(revisedLine);
                        dao.getAddress(id);
                        break;
                    case 3:
                        dao.getAddress(id).setStreet(revisedLine);
                        dao.getAddress(id);
                        break;
                    case 4:
                        dao.getAddress(id).setCity(revisedLine);
                        dao.getAddress(id);
                        break;
                    case 5:
                        dao.getAddress(id).setState(revisedLine);
                        dao.getAddress(id);
                        break;
                    case 6:
                        dao.getAddress(id).setZip(revisedLine);
                        dao.getAddress(id);
                        break;

                    default:
                        con.String("Invalid option.");
                }
            } while (gogo);
        } else {
            con.String("Invalid choiice");
        }
    }

    private void countAddress() {
        con.String("Total Addresses: " + dao.countAddress());

    }

    private void listAllAddresses() {

        List<Address> all = dao.getAllAddress();
        all.stream()
                .forEach(a -> {
                    con.String("\rID:" + a.getId() + " " + a.getFirstName() + " " + a.getLastName()
                            + "\r" + a.getStreet() + "\r" + a.getCity() + ", "
                            + a.getState() + " " + a.getZip());
                });
    }

    private void searchByLastName() {
        String lName = con.getString("Enter last name to search");

        List<Address> temp = dao.searchByLastName(lName);
        temp.stream()
                .forEach(c -> {
                    if (!c.getLastName().equalsIgnoreCase(lName)) {
                        con.String("Not found");
                    } else {
                        con.String("\rID: " + c.getId() + " " + c.getFirstName()
                                + " " + c.getLastName() + "\r"
                                + c.getStreet() + "\r" + c.getCity() + ", "
                                + c.getState() + " " + c.getZip());
                    }
                });

    }

    private void searchByCity() {
        String city = con.getString("Enter city to search");

        List<Address> temp = dao.searchByCity(city);
        temp.stream()
                .forEach(c -> {
                    if (c.getCity().isEmpty()) {
                        con.String("Not found");
                    } else {
                        con.String("\rID:" + c.getId() + " " + c.getFirstName()
                                + " " + c.getLastName() + "\r"
                                + c.getStreet() + "\r" + c.getCity() + ", "
                                + c.getState() + " " + c.getZip());
                    }
                });
    }

    private void searchByStateSortByCity() {
        String state = con.getString("Enter state to search");

        Map<String, List<Address>> stateByCity
                = dao.searchByStateSortByCity(state);
        Set<Entry<String, List<Address>>> entry1 = stateByCity.entrySet();
        entry1.stream()
                .forEach(e -> {
                    con.String(e.getKey());
                    List<Address> addy = e.getValue();
                    addy.stream()
                    .forEach(a -> {
                        if (a.getState().isEmpty()) {
                            con.String("Not found");
                        } else {
                            con.String("\rID:" + a.getId() + " " + a.getFirstName() + " " + a.getLastName());
                            con.String(a.getStreet());
                            con.String(a.getCity() + "," + a.getState() + " " + a.getZip());
                        }
                    });
                });

    }

    private void searchByZip() {
        String zip = con.getString("Enter Zip to search");

        List<Address> temp = dao.searchByZip(zip);
        temp.stream()
                .forEach(z -> {
                    if (z.getZip().isEmpty()) {
                        con.String("Not found");
                    } else {
                        con.String("\rID:" + z.getId() + " " + z.getFirstName()
                                + " " + z.getLastName() + "\r"
                                + z.getStreet() + "\r" + z.getCity() + ", " + z.getState()
                                + " " + z.getZip());
                    }
                });
    }

}
