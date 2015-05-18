/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookwithstreams.DAO;

import com.swcguild.addressbookwithstreams.DTO.Address;
import com.swcguild.consoleio.ConsoleIO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class AddressDAOImpl implements AddressDAO {

    ConsoleIO con = new ConsoleIO();
    Map<Integer, Address> addressMap = new HashMap<>();

    private static final String ADDRESS_FILE = "addresses.txt";
    private static final String DELIMITER = "::";
    
    public static int counter = 0;

    @Override
    public void loadBook() throws FileNotFoundException {
        Scanner file = new Scanner(new BufferedReader(new FileReader(ADDRESS_FILE)));
    
        String fileLine;
        String[] lineTokens;
    try {    
        while(file.hasNextLine()){
            fileLine = file.nextLine();
            lineTokens = fileLine.split(DELIMITER);
            
            Address newAddress = new Address();
            newAddress.setId(Integer.parseInt(lineTokens[0]));
            newAddress.setFirstName(lineTokens[1]);
            newAddress.setLastName(lineTokens[2]);
            newAddress.setStreet(lineTokens[3]);
            newAddress.setState(lineTokens[4]);
            newAddress.setZip(lineTokens[5]);
            addressMap.put(counter, newAddress);
             
            counter = Integer.parseInt(lineTokens[0]);
        }
    }catch(NumberFormatException ex){} 
        file.close();
    }
    @Override
    public void writeBook() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(ADDRESS_FILE));
        
        Collection<Address> address = addressMap.values();
                
        for (Address addy : address){
            out.println(addy.getId() + DELIMITER +
                    addy.getFirstName() + DELIMITER +
                    addy.getLastName() + DELIMITER +
                    addy.getStreet() + DELIMITER +
                    addy.getCity() + DELIMITER +
                    addy.getState() + DELIMITER +
                    addy.getZip());
            
            out.flush();
        }
        out.close();
        
    }
    
    @Override
    public void addAddress(Address newAddress) {
        newAddress.setId(++counter);
        addressMap.put(newAddress.getId(), newAddress);

    }

    @Override
    public void removeAddress(int id) {
       if(addressMap.containsKey(id)){
           addressMap.remove(id);
       } else con.String("Not Found");
    }

    @Override
    public void editAddress(int id, Address currentAddress) {
        if (addressMap.keySet().contains(id)){
            addressMap.put(id, currentAddress);
        }

    }

    @Override
    public int countAddress() {
        return addressMap.size();
    }

    @Override
    public Address getAddress(int id) {
        return addressMap.get(id);
    }

    @Override
    public List<Address> getAllAddress() {

        return addressMap.values().stream()
                .collect(Collectors.toList());

    }

    @Override
    public List<Address> searchByLastName(String byNameAddress) {

        return addressMap.values().stream()
                .filter(addy -> addy.getLastName().equalsIgnoreCase(byNameAddress))
                .collect(Collectors.toList());
    }

    @Override
    public List<Address> searchByCity(String byCity) {

        return addressMap.values().stream()
                .filter(city -> city.getCity().equalsIgnoreCase(byCity))
                .collect(Collectors.toList());

    }

    @Override
    public Map<String, List<Address>> searchByStateSortByCity(String byState) {

        return addressMap.values()
                .stream()
                .filter(addr -> addr.getState().equalsIgnoreCase(byState))
                .collect(Collectors.groupingBy(Address::getCity));

    }

    @Override
    public List<Address> searchByZip(String byZip) {

        return addressMap.values().stream()
                .filter(zip -> zip.getZip().equalsIgnoreCase(byZip))
                .collect(Collectors.toList());
    }

}
