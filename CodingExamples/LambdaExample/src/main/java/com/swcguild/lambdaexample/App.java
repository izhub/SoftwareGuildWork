/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.lambdaexample;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) {
        
        List<Server> servers = new ArrayList<>();
        
        Server one = new Server();
        one.setIp("192.168.1.1");
        one.setMake("Dell");
        one.setName("web01");
        one.setNumProcessors(9);
        one.setPurchaseDate(LocalDate.parse("2010-01-01",DateTimeFormatter.ISO_DATE));
        one.setRam("8GB");
        servers.add(one);
        
        Server two = new Server();
        two.setIp("192.168.1.1");
        two.setMake("Dell");
        two.setName("web02");
        two.setNumProcessors(9);
        two.setPurchaseDate(LocalDate.parse("2013-01-01",DateTimeFormatter.ISO_DATE));
        two.setRam("24GB");
        servers.add(two);
        
        Server three = new Server();
        three.setIp("192.168.1.1");
        three.setMake("Dell");
        three.setName("web03");
        three.setNumProcessors(9);
        three.setPurchaseDate(LocalDate.parse("2014-01-01",DateTimeFormatter.ISO_DATE));
        three.setRam("8GB");
        servers.add(three);
        
        Server four = new Server();
        four.setIp("192.168.1.1");
        four.setMake("HP");
        four.setName("web01");
        four.setNumProcessors(9);
        four.setPurchaseDate(LocalDate.parse("2001-01-01",DateTimeFormatter.ISO_DATE));
        four.setRam("8GB");
        servers.add(four);
        
        Server five = new Server();
        five.setIp("192.168.1.1");
        five.setMake("IBM");
        five.setName("web02");
        five.setNumProcessors(9);
        five.setPurchaseDate(LocalDate.parse("2001-01-01",DateTimeFormatter.ISO_DATE));
        five.setRam("8GB");
        servers.add(five);
        
        String make = "dELL";
        System.out.println("All " + make + " servers in inventory: ");
              
        servers
                .stream()
                .filter(s -> s.getMake().equalsIgnoreCase(make))
                .forEach(e -> System.out.println(e.getName()));
    
        
    }
}
