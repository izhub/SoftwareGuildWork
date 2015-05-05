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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author apprentice
 */
public class OrderController {

    ConsoleIO con = new ConsoleIO();
    OrderBook orderBook = new OrderBook();
    String input = "";

    public void run() throws FileNotFoundException {
        Date date = new Date();
        SimpleDateFormat sdfDate = new SimpleDateFormat("MMddyyyy");
        String today = sdfDate.format(date);

        orderBook.loadProduct();
        orderBook.loadTaxes();

        boolean exit = false;

        try {
            orderBook.loadOrder(today);
        } catch (Exception e) {

        }
//  do the swtich and menu first; add do/while next; try/catch next
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
            try {
                switch (input) {
                    case "1":
                        display(orderBook);
                        break;
                    case "2":
                        addOrder();
                        break;
                    case "3":
                        editOrder();
                        break;
                    case "4":
                        removeOrder();
                        break;
                    case "5":
                        orderBook.saveOrder(today);
                        break;
                    case "6":
                        exit = true;
                        break;
                    default:
                        con.String("Invalid choice");
                        break;
                }
            } catch (Exception e) {
                con.String("error don't do that");
            }

        } while (!exit);
    }

    private void idk() throws FileNotFoundException {
        OrderBook ob = new OrderBook();
        con.String("input date: 1. Today 2. Month 3. Year ");
        input = con.getString("");

        switch (input) {
            case "1":
                input = con.getString("Enter date in the format of MMDDYYYY");
                ob.loadOrder(input);
                display(ob);
                break;
            case "2":
                int year = Calendar.getInstance().get(Calendar.YEAR);
                int month = Calendar.getInstance().get(Calendar.MONTH);

                for (int i = 0; i < 31; i++) {
                    try {
                        StringBuilder day = new StringBuilder();
                        if (i < 10) {
                            day.append("0");
                        }
                        day.append(i);
                        ob.loadOrder(String.valueOf(month) + day.toString() + String.valueOf(year));
                    } catch (Exception e) {

                    }
                }
                display(ob);
                break;
            case "3":
                

        }
    }

    private void addOrder() {

        Order order = new Order();

        input = con.getString("Enter Customer Name: ");
        order.setCustomerName(input);

        input = con.getString("Enter area: ");
        order.setArea(Double.parseDouble(input));

        // display product keys and value maps for input option that follows
        for (Product product : orderBook.getProductMap().values()) {
            con.String(product.getId() + " " + product.getProducType()
                    + " Cost per sqr foot: $" + product.getCostPerSqrFoot()
                    + " Labor cost per sqr foot: $" + product.getLaborCostPerSqrFoot());
        }
        input = con.getString("Enter product number: ");
        order.setProduct(orderBook.getProductMap().get(input));

        // display product keys and value maps for input option that follows
        for (Taxes tax : orderBook.getTaxesMap().values()) {
            con.String("State: " + tax.getState() + "\tTax rate: " + tax.getTaxRate());
        }
        input = con.getString("Enter state: ");
        order.setTaxes(orderBook.getTaxesMap().get(input.toUpperCase()));

        // display product keys and value maps for option that follows
        con.String("Customer name: " + order.getCustomerName()
                + " Area: " + order.getArea() + " State: " + order.getTaxes().getState()
                + " Product: " + order.getProduct().getProducType());

        input = con.getString("Do you wisn to commit: (Y N)");
        if (input.equalsIgnoreCase("Y")) {
            con.String("yes added");
            orderBook.addOrder(order);  //takes order from addOrder and saves to orderBook

        }
    }

    private void display(OrderBook orderBook) {

        for (Order order : orderBook.getOrderMap().values()) {
            con.String(order.getOrderNumber() + " " + order.getCustomerName()
                    + " " + order.getProduct().getProducType() + " " + order.getTotal());
        }

    }

    private void editOrder() {
        display(orderBook);
        input = con.getString("Enter order number to edit: ");
        Order order = new Order();
        order = orderBook.getOrderMap().get(input);

        con.String("Enter to keep name or type new name \r" + order.getCustomerName());
        input = con.getString("");

//     if user typed in new name:
        if (!input.equals("")) {
            order.setCustomerName(input);
        }
//------------------------------------------------------------------------------
        con.String("Enter to keep Area or type new area \r" + order.getArea());
        input = con.getString("");

//    if user typed in new state:    
        if (!input.equals("")) {
            order.setArea(Double.parseDouble(input));
        }
//------------------------------------------------------------------------------

//  get list of states/tax to display first; also prints out key: 
        for (Taxes tax : orderBook.getTaxesMap().values()) {
            con.String("State: " + tax.getState() + "\tTax rate: " + tax.getTaxRate());
        }

        con.String("Enter to keep state or type new state \r" + order.getTaxes().getState());
        input = con.getString("");

//  if user typed in new state:
        if (!input.equals("")) {
            order.setTaxes(orderBook.getTaxesMap().get(input.toUpperCase()));
        }
//------------------------------------------------------------------------------

//  get a list of product types and their values:
        for (Product product : orderBook.getProductMap().values()) {
            con.String(product.getId() + " " + product.getProducType()
                    + " Cost per sqr foot: $" + product.getCostPerSqrFoot()
                    + " Labor cost per sqr foot: $" + product.getLaborCostPerSqrFoot());
        }

        con.String("Enter to keep product type or update to new product type\r"
                + order.getProduct().getProducType());
        input = con.getString("");

//  if user typed in new product type:
        if (!input.equals("")) {
            order.setProduct(orderBook.getProductMap().get(input));
        }
//------------------------------------------------------------------------------

        orderBook.addOrder(order);
        display(orderBook);
    }

    public void removeOrder() {
        display(orderBook);

        input = con.getString("Enter order number to remove: ");
        orderBook.removeOrder(input);
    }

}
