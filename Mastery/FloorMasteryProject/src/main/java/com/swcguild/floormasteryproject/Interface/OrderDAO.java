/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.floormasteryproject.Interface;

import com.swcguild.floormasteryproject.DTO.Order;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public interface OrderDAO {

//    create interface first with the following methods from UML
//    then implement in orderBook and it will create the methods with @Override
    
    public HashMap<String,Order> loadOrder(String date)throws FileNotFoundException;
    public HashMap<String, Order> addOrder(Order order,String date);
    public HashMap<String, Order> getOrderMap();
    public HashMap<String, HashMap<String, Order>> getOrderByDates();
    public void setOrderByDates(HashMap<String, HashMap<String, Order>> orderByDates);
    public void setOrderMap(HashMap<String, Order> orderMap) ;
    
    public Order removeOrder(String orderNumber);
    public void saveOrder(String date);
    public void addDate(String date);
    
     public void removeDate(String date);
     public ArrayList<String> getdateKeys();
     public Order getOrder(String input);
     public String dealingWithCommas(String commas);
     public String againdDealingWithCommas(String commas);
}
