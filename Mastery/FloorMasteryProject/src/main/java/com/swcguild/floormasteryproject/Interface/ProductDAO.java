/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.floormasteryproject.Interface;

import com.swcguild.floormasteryproject.DTO.Product;
import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public interface ProductDAO {
    public HashMap<String, Product> getListProduct();
    public Product getProduct(String productid);
    public void load()throws FileNotFoundException;
    
}
