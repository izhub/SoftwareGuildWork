/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmachine.dto;

/**
 *
 * @author apprentice
 */
public class Change {
    
    private int quarter;
    private int dime;
    private int nickle;
    

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    public int getDime() {
        return dime;
    }

    public void setDime(int dime) {
        this.dime = dime;
    }

    public int getNickle() {
        return nickle;
    }

    public void setNickle(int nickle) {
        this.nickle = nickle;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.quarter;
        hash = 97 * hash + this.dime;
        hash = 97 * hash + this.nickle;
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
        final Change other = (Change) obj;
        if (this.quarter != other.quarter) {
            return false;
        }
        if (this.dime != other.dime) {
            return false;
        }
        if (this.nickle != other.nickle) {
            return false;
        }
        return true;
    }
    
    
}
