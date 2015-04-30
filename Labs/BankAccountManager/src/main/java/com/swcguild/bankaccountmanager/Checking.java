/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.bankaccountmanager;

/**
 *
 * @author apprentice
 */
public class Checking extends Account{
    public Checking(){}
    
    public void deposit(double amount){super.balance += amount;}
    public void withdraw(double amount){
        super.balance -= amount;
    }
    
}
