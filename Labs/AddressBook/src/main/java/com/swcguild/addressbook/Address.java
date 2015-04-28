/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook;

/**
 *
 * @author apprentice
 */
// this is a DTO (Data Transfer Object) aka domain object

/* Domain/data class for the Class Address application.  Holds all
  information about an address.  This domain class is used by both the
  Address UI/App and AddressBook classes to accomplish their respective 
  tasks.

right click on Address and check “insert code” then select “getters and setters” ; 
checking on the “encapsulate...” will make the types private

*/        
public class Address {
    

     private String nameFirst;
     private String nameLast;
     private String streetAddress;     

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String street) {
        this.streetAddress = street;
    }     
    
}
