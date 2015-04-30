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
public abstract class Account {
    protected double balance;
    
    public Account(){}
    
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    
}
