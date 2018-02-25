/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.inferfacerefresher;

import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) {
        TaxDAO taxDAO = new TaxDAOMemoryImpl();
        
        ArrayList<String>  states = taxDAO.getStates();
        Double rate = taxDAO.getRate("OH");
        
        for(String state: states){
            System.out.println(state);
        }
    }
}
