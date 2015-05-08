/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.floormasteryproject.DAO;

import com.swcguild.floormasteryproject.Interface.OrderDAO;
import com.swcguild.floormasteryproject.DTO.Order;
import com.swcguild.floormasteryproject.DTO.Product;
import com.swcguild.floormasteryproject.DTO.Tax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class OrderDAOFileImpl implements OrderDAO {

    int orderNumber = 1;
    private HashMap<String, Order> orderMap = new HashMap<>();

    private HashMap<String, HashMap<String, Order>> orderByDates = new HashMap<>();

    public HashMap<String, Order> getOrderMap() {

        return orderMap;
    }

    public HashMap<String, HashMap<String, Order>> getOrderByDates() {
        return orderByDates;
    }

    public void setOrderByDates(HashMap<String, HashMap<String, Order>> orderByDates) {
        this.orderByDates = orderByDates;
    }

    public void setOrderMap(HashMap<String, Order> orderMap) {
        this.orderMap = orderMap;
    }

    @Override
    public HashMap<String, Order> addOrder(Order order, String date) {
        
        orderMap = orderByDates.get(date);
        orderMap.put(order.getOrderNumber(), order);

        return orderByDates.put(date, orderMap);

    }

    @Override
    public HashMap<String, Order> loadOrder(String date) throws FileNotFoundException {
        HashMap<String, Order> orderMap = new HashMap<>();
        String nextLine = "";
        String[] array = new String[12];
        Scanner sc = new Scanner(new BufferedReader(new FileReader("Orders_" + date + ".txt")));
        
        sc.nextLine();

        while (sc.hasNext()) {
            String name;
            nextLine = sc.nextLine();
            array = nextLine.split(",");
            Order order = new Order();
            order.setOrderNumber(array[0]);
            name = againdealingwithfuckingcommas(array[1]);
            order.setCustomerName(name);

            Tax tx = new Tax();
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
            order.setDate(date);
            orderMap.put(order.getOrderNumber(), order);

        }
        return orderMap;
    }

    @Override
    public Order removeOrder(String orderNumber) {
        HashMap<String, Order> map = new HashMap();
        String dateKey = "";
        Order order;
        String date = "";
        ArrayList<String> dateKeys = new ArrayList<>(orderByDates.keySet());
        int i = 0;
        for (HashMap<String, Order> orders : orderByDates.values()) {
            dateKey = dateKeys.get(i);
            for (String key : orders.keySet()) {
                if (key.equals(orderNumber)) {
                    map = orders;
                    date = dateKey;
                }
            }

            i++;
        }
        order = map.remove(orderNumber);
        orderByDates.put(date, map);
        return order;
    }

    @Override
    public void saveOrder(String date) {
        orderMap = orderByDates.get(date);
        
        try {
            PrintWriter out = new PrintWriter(new FileWriter("Orders_" + date + ".txt"));
            out.println("order,customerName,state,taxrate,producttype,"
                    + "area,costperquarefoot,laborcostpersquarefoot,"
                    + "materialcost,laborcost,tax,total");
            for (Order order : orderMap.values()) {
                String name = dealingwithfuckingcommas(order.getCustomerName());
                out.println(order.getOrderNumber() + "," + name
                        + "," + order.getTaxes().getState() + "," + order.getTaxes().getTaxRate()
                        + "," + order.getProduct().getProducType() + "," + order.getArea()
                        + "," + order.getProduct().getCostPerSqrFoot() + ","
                        + order.getProduct().getLaborCostPerSqrFoot() + ","
                        + order.getMaterialCost() + "," + order.getLaborCost() + ","
                        + order.getTaxesTotal() + "," + order.getTotal());
                out.flush();
            }
            out.close();
            
        } catch (IOException ex) {
            Logger.getLogger(OrderDAOFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addDate(String date) {
        try {
            orderByDates.put(date, loadOrder(date));
        } catch (Exception e) {
            HashMap<String, Order> orderMap = new HashMap<>();
            orderByDates.put(date, orderMap);
        }

    }

    public void removeDate(String date) {
        orderByDates.remove(date);
    }

    public ArrayList<String> getdateKeys() {
        ArrayList<String> dateKeys = new ArrayList(orderByDates.keySet());
        return dateKeys;
    }

   
    public Order getOrder(String input) {
        Order order = new Order();
        for(HashMap<String, Order> orders:orderByDates.values()){
            for(String key: orders.keySet()){
                if(input.equals(key)){
                    order = orders.get(key);
                }
            }
        }
        
           return order;     
    }
    public String dealingwithfuckingcommas(String fuckingCommas){
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<fuckingCommas.length(); i++){
            if(Character.toString(fuckingCommas.charAt(i)).equals(",")){
                sb.append("~");
            }else{
                sb.append(fuckingCommas.charAt(i));
            }
        }
        return sb.toString();
    }
    
     public String againdealingwithfuckingcommas(String fuckingCommas){
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<fuckingCommas.length(); i++){
            if(Character.toString(fuckingCommas.charAt(i)).equals("~")){
                sb.append(",");
            }else{
                sb.append(fuckingCommas.charAt(i));
            }
        }
        return sb.toString();
    }
}
