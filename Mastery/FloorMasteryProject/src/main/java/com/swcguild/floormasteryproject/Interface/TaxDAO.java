/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.floormasteryproject.Interface;

import com.swcguild.floormasteryproject.DTO.Tax;
import java.io.FileNotFoundException;
import static java.lang.System.load;
import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public interface TaxDAO {
    
    public ArrayList<String> getListStates();
    public Tax getTax(String state);
    public void load() throws FileNotFoundException;
}
