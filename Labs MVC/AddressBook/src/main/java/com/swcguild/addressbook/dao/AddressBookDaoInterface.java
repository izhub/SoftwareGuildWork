/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook.dao;

import com.swcguild.addressbook.dto.Address;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface AddressBookDaoInterface {
    
  public Address addAddress(Address address);

public void removeAddress(int id);

public void updateAddress(Address address);

public List<Address> getAllAddress();

public Address getAddressById(int id);

public List<Address> searchAddress (Map<SearchTerm, String> criteria);
      
//Map has SearchTerm as keys to guarantee that callers will only
// be able to specify valid search criteria
}
