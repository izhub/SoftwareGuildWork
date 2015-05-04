/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.floormasteryproject.DAO;

import com.swcguild.floormasteryproject.DTO.Order;
import com.swcguild.floormasteryproject.DTO.Product;
import com.swcguild.floormasteryproject.DTO.Taxes;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class OrderBook {
    int orderNumber = 1;
    private HashMap<String, Order> orderMap = new HashMap<>();
    private HashMap<String, Taxes> taxesMap = new HashMap<>();
    private HashMap<String, Product> productMap = new HashMap<>();

    public void loadTaxes() throws FileNotFoundException {
        String nextLine = "";
        String[] array = new String[2];
        Scanner sc = new Scanner(new BufferedReader(new FileReader("taxes.txt")));
        sc.nextLine();

        while (sc.hasNext()) {
            nextLine = sc.nextLine();
            array = nextLine.split(",");
            Taxes taxes = new Taxes();
            taxes.setState(array[0]);
            taxes.setTaxRate(Double.parseDouble(array[1]));
            taxesMap.put(taxes.getState(), taxes);
        }
    }

    public void loadProduct() throws FileNotFoundException {
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
            product.setLaborcost(Double.parseDouble(array[2]));
            productMap.put(product.getId(), product);
            id++;
        }
    }

    public HashMap<String, Order> getOrderMap() {
        return orderMap;
    }

    public void setOrderMap(HashMap<String, Order> orderMap) {
        this.orderMap = orderMap;
    }

    public HashMap<String, Taxes> getTaxesMap() {
        return taxesMap;
    }

    public void setTaxesMap(HashMap<String, Taxes> taxesMap) {
        this.taxesMap = taxesMap;
    }

    public HashMap<String, Product> getProductMap() {
        return productMap;
    }

    public void setProductMap(HashMap<String, Product> productMap) {
        this.productMap = productMap;
    }

    public void addOrder(Order order) {
        order.setOrderNumber(String.valueOf(orderNumber));
        order.setLaborCost(order.getLaborCost()* order.getArea());
        order.setMaterialCost(order.getProduct().getCostPerSqrFoot()*order.getArea());
        order.setTaxesTotal(order.getTaxes().getTaxRate()/100 * (order.getMaterialCost() + order.getLaborCost()));
        order.setTotal(order.getLaborCost() + order.getMaterialCost() + order.getTaxesTotal());
        orderNumber++;
        orderMap.put(order.getOrderNumber(), order);
        
    }
    

}
