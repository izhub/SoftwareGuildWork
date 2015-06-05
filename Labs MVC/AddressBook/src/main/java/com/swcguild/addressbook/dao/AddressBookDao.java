/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook.dao;

import com.swcguild.addressbook.dto.Address;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class AddressBookDao implements AddressBookDaoInterface{

    private Map<Integer, Address> addressMap = new HashMap<>();
    private static int idCounter=0;
    
    @Override
    public Address addAddress(Address address) {
     address.setId(idCounter);
     addressMap.put(address.getId(), address);
     idCounter++;
     return address;
    }

    @Override
    public void removeAddress(int id) {
        addressMap.remove(id);
    }

    @Override
    public void updateAddress(Address address) {
        addressMap.put(address.getId(), address);
    }

    @Override
    public List<Address> getAllAddress() {
        Collection<Address> c = addressMap.values();
        return new ArrayList(c);
    }

    @Override
    public Address getAddressById(int id) {
        return addressMap.get(id);
    }

    @Override
    public List<Address> searchAddress(Map<SearchTerm, String> criteria) {
        
        //get all search terms from the map
        String firstNameCriteria = criteria.get(SearchTerm.FIRST_NAME);
        String lastNameCriteria = criteria.get(SearchTerm.LAST_NAME);
        String streetCriteria = criteria.get(SearchTerm.STREET);
        String cityCriteria = criteria.get(SearchTerm.CITY);
        String stateCriteria = criteria.get(SearchTerm.STATE);
        String zipCriteria = criteria.get(SearchTerm.ZIP);
        
        //delcare all prepdicte conditions
        Predicate<Address> firstNameMatches;
        Predicate<Address> lastNameMatches;
        Predicate<Address> streetMatches;
        Predicate<Address> cityMatches;
        Predicate<Address> stateMatches;
        Predicate<Address> zipMatches;
        
        //placeholder predicate : always returns true
        //used for search terms that are empty
        Predicate<Address> truePredicate = (a) -> {return true; };
        
        //assign values to predicates; if empty - default truePredicate
        firstNameMatches = (firstNameCriteria == null || firstNameCriteria.isEmpty())
                ? truePredicate
                :(a) -> a.getFirstName().equalsIgnoreCase(firstNameCriteria);
    
        lastNameMatches = (lastNameCriteria == null || lastNameCriteria.isEmpty())
                ? truePredicate
                :(a) -> a.getLastName().equalsIgnoreCase(lastNameCriteria);
        
        streetMatches = (streetCriteria == null || streetCriteria.isEmpty())
                ? truePredicate
                : (a) -> a.getStreet().equalsIgnoreCase(streetCriteria);
        
        cityMatches = (cityCriteria == null || cityCriteria.isEmpty()
                ? truePredicate
                : (a) -> a.getCity().equalsIgnoreCase(cityCriteria));
        
        stateMatches = (stateCriteria == null || stateCriteria.isEmpty())
                ? truePredicate
                : (a) -> a.getState().equalsIgnoreCase(stateCriteria);
        
        zipMatches = (zipCriteria == null || zipCriteria.isEmpty())
                ? truePredicate
                : (a) -> a.getZip().equalsIgnoreCase(zipCriteria);
        
        //return list of addresses that match given criteria
        return addressMap.values().stream()
                .filter(firstNameMatches
                        .and (lastNameMatches)
                        .and(streetMatches) 
                        .and (cityMatches)
                        .and (stateMatches)
                        .and (zipMatches))
                .collect((Collectors.toList()));
    }
    
  
}
