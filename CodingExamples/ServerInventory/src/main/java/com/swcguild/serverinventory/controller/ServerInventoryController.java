/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.serverinventory.controller;

import com.swcguild.consoleio.ConsoleIO;
import com.swcguild.serverinventory.DAO.ServerDAO;
import com.swcguild.serverinventory.DAO.ServerDAOInMemImpl;

/**
 *
 * @author apprentice
 */
public class ServerInventoryController {

    ConsoleIO con = new ConsoleIO();
    ServerDAO dao = new ServerDAOInMemImpl();

    public ServerInventoryController (ServerDAOInMemImpl dao){
        this.dao = dao;
    }
    public void run() {

        int userChoice; 
        do {
            printMenu();
            userChoice = con.getInt("Plese choose from the above options: \r");

            switch (userChoice) {
                case 1:
                    addServer();
                    break;
                case 2:
                    removeServer();
                    break;
                case 3:
                    listServersByManufacturer();
                    break;
                case 4:
                    listServersOlderThan();
                    break;
                case 5:
                    listServersOlderThanByMake();
                    break;
                case 6:
                    getAveragServerAge();
                    break;
                case 7:
                    break;
                default:
                    con.String("Invalid choice");
                    break;
            }
        } while (userChoice != 7);

    }

    private void printMenu() {
        con.String("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        con.String("1. Add Server");
        con.String("2. Remove Server");
        con.String("3. List Servers by Manufacturer");
        con.String("4. List Servers older than date");
        con.String("5. List Servers older than group by Make");
        con.String("6. Get Average Server age");
        con.String("7. Exit");
        con.String("+++++++++++++++++++++++++++++++++++++++++++++++++++++\r");

    }

    private void addServer() {
        con.String("ADD SERVER...");
    }

    private void removeServer() {
        con.String("REMOVE SERVER");
    }

    private void listServersByManufacturer() {
        con.String("List Servers by Manufacturer");
    }

    private void listServersOlderThan() {
        con.String("LIST SERVERS BY OLDER THAN");
    }

    private void listServersOlderThanByMake() {
        con.String("LIST SERVERS OLDA THAN GROUP BY MAKE");
    }

    private void getAveragServerAge() {
        con.String("GET AVERAGE");
    }
}
