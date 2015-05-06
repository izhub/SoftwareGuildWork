/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.floormasteryproject.DAO;

import com.swcguild.floormasteryproject.DTO.Tax;
import com.swcguild.floormasteryproject.Interface.TaxDAO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class TaxDAOFileImpl implements TaxDAO{
    
     private HashMap<String, Tax> taxesMap = new HashMap<>();
   
     public HashMap<String, Tax> getTaxesMap() {
        return taxesMap;
    }

    public void setTaxesMap(HashMap<String, Tax> taxesMap) {
        this.taxesMap = taxesMap;
    }


    @Override
    public ArrayList<String> getListStates() {
        
       return new ArrayList<String>(taxesMap.keySet());
         }

    @Override
    public Tax getTax(String state) {
        return taxesMap.get(state);
        }

    @Override
    public void load() throws FileNotFoundException {
        String nextLine = "";
        String[] array = new String[2];
        Scanner sc = new Scanner(new BufferedReader(new FileReader("taxes.txt")));
        sc.nextLine();

        while (sc.hasNext()) {
            nextLine = sc.nextLine();
            array = nextLine.split(",");
            Tax taxes = new Tax();
            taxes.setState(array[0]);
            taxes.setTaxRate(Double.parseDouble(array[1]));
            taxesMap.put(taxes.getState(), taxes);
        }
    }
    
}
