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

     private int uniqueKey;
     private String nameFirst;
     private String nameLast;
     private String streetAddress;
     private String city;
     private String state;
     private String zip;

    
     public Address(){}
     
    public int getUniqueKey() {
        return uniqueKey;
    }
    
    public void SetUniqueKey(){
        
    }
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    
}
