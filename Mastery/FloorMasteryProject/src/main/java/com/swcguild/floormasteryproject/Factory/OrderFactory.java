/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.floormasteryproject.Factory;

import com.swcguild.floormasteryproject.DTO.Order;
import com.swcguild.floormasteryproject.DTO.Product;
import com.swcguild.floormasteryproject.DTO.Tax;

/**
 *
 * @author apprentice
 */
public class OrderFactory {

    public static Order buildOrder(String date, String customerName, Tax tax, double area, Product product, String orderNum) {

        Order order = new Order();
        order.setCustomerName(customerName);
        order.setArea(area);
        order.setTaxes(tax);
        order.setProduct(product);
        order.setOrderNumber(orderNum);
        order.setDate(date);
        order.setLaborCost(product.getLaborCostPerSqrFoot() * area);
        order.setMaterialCost(product.getCostPerSqrFoot() * area);
        order.setTaxesTotal(tax.getTaxRate() / 100 * (order.getLaborCost() + order.getMaterialCost()));
        order.setTotal(order.getLaborCost() + order.getMaterialCost() + order.getTaxesTotal());
        
        return order;
    }

    public static String changeDate(String input) {
        
        if(input.length()!=8){
            return "";
        }
        
        
         String month = (input.substring(0, 2));
         String day = (input.substring(2, 4));
         String year = (input.substring(4));
         
         if((Integer.parseInt(month)>12)||(Integer.parseInt(month)<1)){
             return "";
         }
         if((Integer.parseInt(day)>31)||(Integer.parseInt(day)<1)){
             return "";
         }
         if((Integer.parseInt(year)>2020)||(Integer.parseInt(year)<2010)){
             return "";
         }
         return input;
         
    }

}
