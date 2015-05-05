/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook;

import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class Address {
    
    private int uniqueKey;
    private String nameFirst;
    private String nameLast;
    private String addressStreet;
    private String addressCity;
    private String addressState;
    private String addressZip;

    public int getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(int uniqueKey) {
        this.uniqueKey= uniqueKey;
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

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public String getAddressZip() {
        return addressZip;
    }

    public void setAddressZip(String addressZip) {
        this.addressZip = addressZip;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.uniqueKey;
        hash = 97 * hash + Objects.hashCode(this.nameFirst);
        hash = 97 * hash + Objects.hashCode(this.nameLast);
        hash = 97 * hash + Objects.hashCode(this.addressStreet);
        hash = 97 * hash + Objects.hashCode(this.addressCity);
        hash = 97 * hash + Objects.hashCode(this.addressState);
        hash = 97 * hash + Objects.hashCode(this.addressZip);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        if (this.uniqueKey != other.uniqueKey) {
            return false;
        }
        if (!Objects.equals(this.nameFirst, other.nameFirst)) {
            return false;
        }
        if (!Objects.equals(this.nameLast, other.nameLast)) {
            return false;
        }
        if (!Objects.equals(this.addressStreet, other.addressStreet)) {
            return false;
        }
        if (!Objects.equals(this.addressCity, other.addressCity)) {
            return false;
        }
        if (!Objects.equals(this.addressState, other.addressState)) {
            return false;
        }
        if (!Objects.equals(this.addressZip, other.addressZip)) {
            return false;
        }
        return true;
    }
    
            
    
}
