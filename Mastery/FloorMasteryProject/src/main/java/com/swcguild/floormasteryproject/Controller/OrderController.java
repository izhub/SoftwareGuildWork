/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.floormasteryproject.Controller;

import com.swcguild.consoleio.ConsoleIO;
import com.swcguild.floormasteryproject.DAO.OrderDAOFileImpl;
import com.swcguild.floormasteryproject.DAO.ProductDAOFileImpl;
import com.swcguild.floormasteryproject.DAO.TaxDAOFileImpl;
import com.swcguild.floormasteryproject.DTO.Order;
import com.swcguild.floormasteryproject.DTO.Product;
import com.swcguild.floormasteryproject.DTO.Tax;
import com.swcguild.floormasteryproject.factory.OrderFactory;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class OrderController {

    ConsoleIO con = new ConsoleIO();
    OrderDAOFileImpl orderBook = new OrderDAOFileImpl();
    String input = "";
    String config = "";
    ProductDAOFileImpl productBook = new ProductDAOFileImpl();
    TaxDAOFileImpl taxBook = new TaxDAOFileImpl();

    int orderNumber = 0;
    Date date = new Date();
    SimpleDateFormat sdfDate = new SimpleDateFormat("MMddyyyy");
    String today = sdfDate.format(date);
    String selectedDate = today;

    public void run() throws FileNotFoundException, IOException {
        loadCofnig();

        orderBook.addDate(today);

        productBook.load();
        taxBook.load();

        boolean exit = false;

        try {
            orderBook.loadOrder(today);
        } catch (Exception e) {

        }
//  do the swtich and menu first; add do/while next; try/catch next
        do {
            StringBuilder sb = new StringBuilder();
            sb.append(selectedDate.substring(0, 2));
            sb.append("/");
            sb.append(selectedDate.substring(2, 4));
            sb.append("/");
            sb.append(selectedDate.substring(4));
            con.String("***********************************************************");
            con.String("*                    Flooring Program                     *");
//            con.String("* Open dates: "+orderBook.getdateKeys());
            con.String("* selected date:  " + sb);
            if (!config.equals("test")) {
                con.String("* 1. Enter Date                                           *");
            }

            con.String("* 2. Display Orders                                       *");
            con.String("* 3. Add an Order                                         *");
            con.String("* 4. Edit an Order                                        *");
            con.String("* 5. Remove an Order                                      *");
            con.String("* 6. Save Current Work                                    *");
            con.String("* 7. Quit                                                 *");
            con.String("*                                                         *");
            con.String("***********************************************************");

            input = con.getString("");
            try {
                switch (input) {

                    case "1":
                        if (config.equals("test")) {
                            break;
                        }
                        enterDate();
                        break;
                    case "2":
                        display(orderBook);
                        break;
                    case "3":
                        addOrder();
                        break;
                    case "4":
                        editOrder();
                        break;
                    case "5":
                        removeOrder();
                        break;
                    case "6":
                        saveOrder();

                        break;
                    case "7":
                        exit = true;
                        break;
                    default:
                        con.String("Invalid choice");
                        break;
                }
            } catch (Exception e) {
                con.String("Invalid input");
            }

        } while (!exit);
        saveConfig();
    }

    private void addOrder() throws IOException {

        Order order = new Order();

        String name;
        double area;
        String productNum;
        String state;
        String date = selectedDate;

        orderNumber++;

        name = con.getString("Enter Customer Name: ");

        area = con.getDoubleMinMax("\nEnter area: ", 1, 100000);

        // display product keys and value maps for input option that follows
        for (Product product : productBook.getListProduct().values()) {
            con.String(product.getId() + " " + product.getProducType()
                    + " Cost/sqr foot: $" + product.getCostPerSqrFoot()
                    + " Labor/sqr foot: $" + product.getLaborCostPerSqrFoot());
        }
        productNum = String.valueOf(con.intMinMax("Product Number: ", 1, 4));

        // display product keys and value maps for input option that follows
        boolean exit = false;
        do {
            for (String state1 : taxBook.getListStates()) {
                con.String("State: " + state1);
            }
            state = con.getString("\nEnter state from the list above: ").toUpperCase();
            for (String state1 : taxBook.getListStates()) {
                if (state.equals(state1)) {
                    exit = true;
                }
            }
        } while (!exit);

        Tax tax = taxBook.getTax(state);
        Product product = productBook.getProduct(productNum);

        if (!config.equals("test")) {
            do {
                input = con.getString("date " + selectedDate + " hit enter to keep or enter new date MMDDYYYY");
                if (input.equals("")) {
                    date = selectedDate;
                } else {
                    date = OrderFactory.changeDate(input);
                }

            } while (date.equals(""));
            if (!date.equals(selectedDate)) {
                orderBook.saveOrder(selectedDate);
                orderBook.addDate(date);
            }
        } else {
            date = selectedDate;
        }

        order = OrderFactory.buildOrder(date, name, tax, area, product, String.valueOf(orderNumber));

        // display product keys and value maps for option that follows
        con.String("\nCustomer name: " + order.getCustomerName()
                + "\nState: " + order.getTaxes().getState()
                + "\nArea: " + order.getArea()
                + "\rProduct: " + order.getProduct().getProducType()
                + "\nCost/sqr Foot: $" + order.getProduct().getCostPerSqrFoot()
                + "\nLabor Cost/sqr Foot: $" + order.getProduct().getLaborCostPerSqrFoot()
                + "\nMaterial Cost: $" + String.format("%.2f", order.getMaterialCost())
                + "\nlabor Cost: $" + String.format("%.2f", order.getLaborCost())
                + "\nTax rate: $" + order.getTaxes().getTaxRate()
                + "\nTax: $" + String.format("%.2f", order.getTaxesTotal())
                + "\nTotal: $" + String.format("%.2f", order.getTotal()));

        input = con.getString("Do you wisn to save order: (Y N)");
        if (input.equalsIgnoreCase("Y")) {
            con.String("yes added");
            saveConfig();
            orderBook.addOrder(order, date);  //takes order from addOrder and saves to orderBook

        } else {
            con.String("not added order canceled");
        }
    }

    private void display(OrderDAOFileImpl orderBook) {
//        for(HashMap<String,Order> orderMap: orderBook.getOrderByDates().values()){
//            for (Order order : orderMap.values()) {
//            con.String(order.getOrderNumber() + " " + order.getCustomerName()
//                    + " " + order.getProduct().getProducType() + " " + order.getTotal()+"  " + order.getDate());
//        }
//
//        }

        for (Order order : orderBook.getOrderByDates().get(selectedDate).values()) {
            StringBuilder sb = new StringBuilder();
            sb.append(order.getDate().substring(0, 2));
            sb.append("/");
            sb.append(order.getDate().substring(2, 4));
            sb.append("/");
            sb.append(order.getDate().substring(4));

            con.String("Order Number: " + order.getOrderNumber() + "  Name: "
                    + order.getCustomerName() + "  State: " + order.getTaxes().getState()
                    + "  Product: " + order.getProduct().getProducType()
                    + "  Sqr/Foot: $" + order.getProduct().getCostPerSqrFoot()
                    + "  Labor/Sqr: $" + order.getProduct().getLaborCostPerSqrFoot()
                    + "  Total: $" + String.format("%.2f", order.getTotal())
                    + "   Date: " + sb.toString());
        }

    }

    private void editOrder() {

        display(orderBook);
        input = con.getString("Enter order number to edit: ");

        Order order = new Order();

        order = orderBook.getOrder(input);
        if (order.getCustomerName().isEmpty()) {
            con.String("no such order");
            return;
        }

        String date = order.getDate();

        con.String("Enter to keep name or type new name \r" + order.getCustomerName());
        input = con.getString("");

//     if user typed in new name:
        if (!input.equals("")) {
            order.setCustomerName(input);
        }
//------------------------------------------------------------------------------
        do {
            con.String("Enter to keep Area or type new area \r" + order.getArea());
            input = con.getString("");

            if (!input.equals("")) {
                order.setArea(Double.parseDouble(input));

            } else {
                break;
            }

        } while (Double.parseDouble(input) < 13 || Double.parseDouble(input) > 1000000);

//------------------------------------------------------------------------------
//  get list of states/tax to display first; also prints out key: 
        String state = order.getTaxes().getState();
        boolean exit = false;
        do {
            for (String state1 : taxBook.getListStates()) {
                con.String("State: " + state1);
            }
            con.String("Enter to keep state or type new state from the list above \r" + order.getTaxes().getState());
            input = con.getString("");
            input = input.toUpperCase();
            if (input.equals("")) {
                input = order.getTaxes().getState();
            }
            for (String state1 : taxBook.getListStates()) {
                if (input.equals(state1)) {
                    exit = true;
                }
            }
        } while (!exit);

        order.setTaxes(taxBook.getTax(input.toUpperCase()));

//  if user typed in new state:
//------------------------------------------------------------------------------
//  get a list of product types and their values:
        do {

            exit = true;
            for (Product product : productBook.getListProduct().values()) {
                con.String(product.getId() + " " + product.getProducType()
                        + " Cost/sqr foot: $" + product.getCostPerSqrFoot()
                        + " Labor/sqr foot: $" + product.getLaborCostPerSqrFoot());
            }

            con.String("\nEnter to keep product type or update from list above\r"
                    + order.getProduct().getProducType());
            input = con.getString("");

//  if user typed in new product type:
            if (!input.equals("")) {
                try {
                    if (Integer.parseInt(input) < 0 || Integer.parseInt(input) > 4) {
                        exit = false;
                    } else {
                        order.setProduct(productBook.getProduct(input));
                    }
                } catch (Exception e) {
                    exit = false;
                }

            }

        } while (!exit);

        if (!config.equals("test")) {
            do {
                input = con.getString("date " + selectedDate 
                        + " hit enter to keep or enter new date MMDDYYYY: year range 2010-2015");
                if (input.equals("")) {
                    date = order.getDate();
                } else {
                    date = OrderFactory.changeDate(input);
                }

            } while (date.equals(""));
            orderBook.addDate(date);
            order.setDate(date);
        }
//------------------------------------------------------------------------------
        orderBook.addDate(order.getDate());
        order = OrderFactory.buildOrder(order.getDate(), order.getCustomerName(),
                order.getTaxes(), order.getArea(), order.getProduct(), order.getOrderNumber());
        orderBook.removeOrder(order.getOrderNumber());
        orderBook.addOrder(order, order.getDate());

        con.String("\nCustomer name: " + order.getCustomerName()
                + "\nState: " + order.getTaxes().getState()
                + "\nArea: " + order.getArea()
                + "\rProduct: " + order.getProduct().getProducType()
                + "\nCost/sqr Foot: $" + order.getProduct().getCostPerSqrFoot()
                + "\nLabor Cost/sqr Foot: $" + order.getProduct().getLaborCostPerSqrFoot()
                + "\nMaterial Cost: $" + String.format("%.2f",order.getMaterialCost())
                + "\nlabor Cost: $" + String.format("%.2f", order.getLaborCost())
                + "\nTax rate: $" + order.getTaxes().getTaxRate()
                + "\nTax: $" + String.format("%.2f", order.getTaxesTotal())
                + "\nTotal: $" + String.format("%.2f", order.getTotal()));

        con.getString("\nEnter to continue...");

        display(orderBook);
    }

    public void removeOrder() {
        display(orderBook);

        input = con.getString("Enter order number to remove: ");
        orderBook.removeOrder(input);
    }

    public void saveConfig() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter("config.txt"));

//       test/prod,orderNumber
        out.println("test/prod, orderNumber");
        out.println(config + "," + orderNumber);
        out.flush();
        out.close();
    }

    public void loadCofnig() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader("config.txt")));

        String[] array = new String[2];
        String line;

        sc.nextLine();

        line = sc.nextLine();
        array = line.split(",");
        config = array[0];
        orderNumber = Integer.parseInt(array[1]);
    }

    private void enterDate() {
        String date = "";

        boolean add = true;
        do {
            input = con.getString("enter date in form of MMDDYYYY: year range 2010-2015");
            input = OrderFactory.changeDate(input);

        } while (input.equals(""));
        selectedDate = input;

        for (String aDate : orderBook.getdateKeys()) {
            if (aDate.equals(input)) {
                add = false;
            }
        }
        if (add) {
            orderBook.addDate(input);
        }

    }

private void saveOrder() {
        for (String date : orderBook.getOrderByDates().keySet()) {
            orderBook.saveOrder(date);
        }

    }
}
