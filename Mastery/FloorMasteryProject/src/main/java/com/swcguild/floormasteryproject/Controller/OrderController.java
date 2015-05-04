/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.floormasteryproject.Controller;

import com.swcguild.consoleio.ConsoleIO;
import com.swcguild.floormasteryproject.DAO.OrderBook;
import com.swcguild.floormasteryproject.DTO.Order;
import com.swcguild.floormasteryproject.DTO.Product;
import com.swcguild.floormasteryproject.DTO.Taxes;
import java.io.FileNotFoundException;

/**
 *
 * @author apprentice
 */
public class OrderController {
    ConsoleIO con = new ConsoleIO();
    OrderBook orderBook = new OrderBook();
    String input ="";
    
    public void run() throws FileNotFoundException {
        
        orderBook.loadProduct();
        orderBook.loadTaxes();
        
        boolean exit = false;
        
    
        do {
        con.String("***********************************************************");
        con.String("*                    Flooring Program                     *");
        con.String("*                                                         *");
        con.String("* 1. Display Orders                                       *");
        con.String("* 2. Add an Order                                         *");
        con.String("* 3. Edit an Order                                        *");
        con.String("* 4. Remove an Order                                      *");
        con.String("* 5. Save Current Work                                    *");
        con.String("* 6. Quit                                                 *");
        con.String("*                                                         *");
        con.String("***********************************************************");
        
        input = con.getString("");
        switch(input){
            case "1":
                display();
                break;
            case "2":
                addOrder();
                break;
            case "3":
//                editOrder();
                break;
            case "4":
                con.String("Remove to be implemented");
                break;
            case "5":
                con.String("Save to be implemented");
                break;
            case "6":
                exit = true;
                break;
            default:
                con.String("Invalid choice");
                break;                            
        }
        }while (!exit);
    }

    private void addOrder() {
        
        Order order = new Order();
        
        input = con.getString("Enter Customer Name: ");
        order.setCustomerName(input);
        
        input = con.getString("Enter area: ");
        order.setArea(Double.parseDouble(input));
        
        for (Product product: orderBook.getProductMap().values()){
            con.String(product.getId() + " "+ product.getProducType() + 
                    " Cost per sqr foot: $"+ product.getCostPerSqrFoot() 
            + " Labor cost per sqr foot: $"+ product.getLaborcost());
        }
        input = con.getString("Enter product number: ");
        order.setProduct(orderBook.getProductMap().get(input));
        
        for (Taxes tax : orderBook.getTaxesMap().values()){
            con.String("State: "+tax.getState() + "\tTax rate: " +tax.getTaxRate());
        }
        input = con.getString("Enter state: ");
        order.setTaxes(orderBook.getTaxesMap().get(input.toUpperCase()));
        
        con.String("Customer name: " + order.getCustomerName() + 
                " Area: "+ order.getArea() +" State: "+order.getTaxes().getState()
        + " Product: "+ order.getProduct().getProducType() );
        
        input = con.getString("Do you wisn to commit: (Y N)");
        if (input.equalsIgnoreCase("Y")){
            con.String("yes added");
            orderBook.addOrder(order);
            
        } 
    }

    private void display() {
        
        for(Order order : orderBook.getOrderMap().values()){
            con.String(order.getOrderNumber() + " " + order.getCustomerName() +
                " " + order.getProduct().getProducType() + " " +order.getTotal());
        }
                
    }
    
    
    
    
}
