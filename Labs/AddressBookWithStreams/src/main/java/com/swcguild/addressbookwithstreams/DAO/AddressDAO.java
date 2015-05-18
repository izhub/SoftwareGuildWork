/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookwithstreams.DAO;

import com.swcguild.addressbookwithstreams.DTO.Address;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface AddressDAO {
    
       public void loadBook() throws FileNotFoundException;
       public void writeBook() throws IOException;
        public void addAddress(Address newAddress);
        public void removeAddress(int id);
        public void editAddress(int id, Address currentAddress);
        public int countAddress();
        
        public Address getAddress(int id);
        public List<Address> getAllAddress();
        public List<Address> searchByLastName(String byNameAddress);
        public List<Address> searchByCity(String byCity);
        public Map<String, List<Address>> searchByStateSortByCity(String byState);
        public List<Address> searchByZip(String byZip);
}
