/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.floormasteryproject.Interface;

import com.swcguild.floormasteryproject.DTO.Order;
import java.io.FileNotFoundException;
import java.util.Date;

/**
 *
 * @author apprentice
 */
public interface OrderDAO {

//    create interface first with the following methods from UML
//    then implement in orderBook and it will create the methods with @Override
    
    public void loadOrder(String date)throws FileNotFoundException;
    public Order addOrder(Order order);
    public Order removeOrder(String orderNumber);
    public void saveOrder(String date);
    
}
