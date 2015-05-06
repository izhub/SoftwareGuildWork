/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.floormasteryproject.DAO;

import com.swcguild.floormasteryproject.DTO.Product;
import com.swcguild.floormasteryproject.Interface.ProductDAO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ProductDAOFileImpl implements ProductDAO {

    private HashMap<String, Product> productMap = new HashMap<>();

    public HashMap<String, Product> getProductMap() {
        return productMap;
    }

    public void setProductMap(HashMap<String, Product> productMap) {
        this.productMap = productMap;
    }

    @Override
    public HashMap<String, Product> getListProduct() {
        return productMap;
    }

    @Override
    public Product getProduct(String productid) {
        return productMap.get(productid);
    }

    @Override
    public void load() throws FileNotFoundException {
        String nextLine = "";
        String[] array = new String[3];
        Scanner sc = new Scanner(new BufferedReader(new FileReader("product.txt")));
        sc.nextLine();
        int id = 1;

        while (sc.hasNext()) {
            nextLine = sc.nextLine();
            array = nextLine.split(",");
            Product product = new Product();
            product.setId(String.valueOf(id));
            product.setProducType(array[0]);
            product.setCostPerSqrFoot(Double.parseDouble(array[1]));
            product.setLaborCostPerSqrFoot(Double.parseDouble(array[2]));
            productMap.put(product.getId(), product);
            id++;
        }
    }

}
