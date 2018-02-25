/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.olympian;

/**
 *
 * @author apprentice
 */
public class Olympian {
    private Event event;
    private String country = "USA";

    public String getCountry() {
        return country;
    }

    private Olympian(Event event){          //constructor //decoupled from event:Depdendency Injection DI
        this.event = event;
    }
    
    public String competeInEvent(){
        System.out.println("Now competing for" + country + ":");
        return event.compete();
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
}
