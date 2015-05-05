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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class OrderBook implements OrderDAO {

    int orderNumber = 1;
    private HashMap<String, Order> orderMap = new HashMap<>();
    private HashMap<String, Taxes> taxesMap = new HashMap<>();
    private HashMap<String, Product> productMap = new HashMap<>();

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

    @Override
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

    @Override
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
            product.setLaborCostPerSqrFoot(Double.parseDouble(array[2]));
            productMap.put(product.getId(), product);
            id++;
        }
    }

    @Override
    public Order addOrder(Order order) {
        order.setLaborCost(order.getLaborCost() * order.getArea());
        order.setMaterialCost(order.getProduct().getCostPerSqrFoot() * order.getArea());
        order.setTaxesTotal(order.getTaxes().getTaxRate() / 100 * (order.getMaterialCost() + order.getLaborCost()));
        order.setTotal(order.getLaborCost() + order.getMaterialCost() + order.getTaxesTotal());

        if (order.getOrderNumber().equals("0")) {
            order.setOrderNumber(String.valueOf(orderNumber));
            orderNumber++;
        }
        return orderMap.put(order.getOrderNumber(), order);

    }

    @Override
    public void loadOrder(String date) throws FileNotFoundException {
      String nextLine = "";
      String[] array = new String[12];
      Scanner sc = new Scanner(new BufferedReader(new FileReader("Orders_" + date+".txt")));
     
      sc.nextLine();
      
      while(sc.hasNext()){
          nextLine = sc.nextLine();
          array = nextLine.split(",");
          Order order = new Order();
          order.setOrderNumber(array[0]);
          order.setCustomerName(array[1]);
          
          Taxes tx = new Taxes();
          tx.setState(array[2]);
          tx.setTaxRate(Double.parseDouble(array[3]));
          order.setTaxes(tx);
           
          Product product = new Product();
          product.setProducType(array[4]);
          order.setArea(Double.parseDouble(array[5]));
          product.setCostPerSqrFoot(Double.parseDouble(array[6]));
          product.setLaborCostPerSqrFoot(Double.parseDouble(array[7]));
          order.setProduct(product);
          
          order.setMaterialCost(Double.parseDouble(array[8]));
          order.setLaborCost(Double.parseDouble(array[9]));
         
          order.setTaxesTotal(Double.parseDouble(array[10]));
          order.setTotal(Double.parseDouble(array[11]));
          orderMap.put(order.getOrderNumber(), order);
          orderNumber  = Integer.parseInt(array[0])+1;
      }
      
    }

    @Override
    public Order removeOrder(String orderNumber) {
        return orderMap.remove(orderNumber);
    }

    @Override
    public void saveOrder(String date) {
        try {
            PrintWriter out = new PrintWriter(new FileWriter("Orders_" + date+".txt"));
            out.println("order,customerName,state,taxrate,producttype,"
                    + "area,costperquarefoot,laborcostpersquarefoot,"
                    + "materialcost,laborcost,tax,total");
            for (Order order : orderMap.values()) {
                out.println(order.getOrderNumber() + "," + order.getCustomerName()
                        + "," + order.getTaxes().getState() + "," + order.getTaxes().getTaxRate()
                        + "," + order.getProduct().getProducType() + "," + order.getArea()
                        + "," + order.getProduct().getCostPerSqrFoot() + ","
                        + order.getProduct().getLaborCostPerSqrFoot() + ","
                        + order.getMaterialCost() + "," + order.getLaborCost() + ","
                        + order.getTaxesTotal()+","+order.getTotal());
                out.flush();
            }
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(OrderBook.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

}
