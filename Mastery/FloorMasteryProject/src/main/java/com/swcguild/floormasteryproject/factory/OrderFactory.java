/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.floormasteryproject.factory;

import com.swcguild.floormasteryproject.DTO.Order;
import com.swcguild.floormasteryproject.DTO.Product;
import com.swcguild.floormasteryproject.DTO.Tax;

/**
 *
 * @author apprentice
 */
public class OrderFactory {

    public static Order buildOrder(String customerName, Tax tax, double area, Product product, String orderNum) {

        Order order = new Order();
        order.setCustomerName(customerName);
        order.setArea(area);
        order.setTaxes(tax);
        order.setProduct(product);
        order.setOrderNumber(orderNum);

        order.setLaborCost(product.getLaborCostPerSqrFoot() * area);
        order.setMaterialCost(product.getCostPerSqrFoot() * area);
        order.setTaxesTotal(tax.getTaxRate() / 100 * (order.getLaborCost() + order.getMaterialCost()));
        order.setTotal(order.getLaborCost() + order.getMaterialCost() + order.getTaxesTotal());
        
        return order;
    }

}
