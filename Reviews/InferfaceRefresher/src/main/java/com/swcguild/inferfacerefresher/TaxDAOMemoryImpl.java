/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.inferfacerefresher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author apprentice
 */
// design and implement of the interface

public class TaxDAOMemoryImpl implements TaxDAO {
    
    private Map<String, Double> taxRate;
    
    public TaxDAOMemoryImpl(){
        
        taxRate = new HashMap<>();
        
        taxRate.put("OH", 6.25);
        taxRate.put("PA", 6.5);
        taxRate.put("MI", 5.75);
    }
//
    @Override
    public Double getRate(String state) {
        return taxRate.get(state)  ;
                }

    @Override
    public ArrayList<String> getStates() {
        Set<String> keys = taxRate.keySet();
      return new ArrayList<String> (taxRate.keySet());
    }
    //create an App class to put main in it
}
