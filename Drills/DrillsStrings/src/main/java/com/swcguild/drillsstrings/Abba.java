/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.drillsstrings;

/**
 *
 * @author apprentice
 */
public class Abba {
    
// Given two strings, a and b, return the result of putting them together in
//  the order abba, e.g. "Hi" and "Bye" returns "HiByeByeHi". 
    
// Abba("Hi", "Bye") -> "HiByeByeHi"
// Abba("Yo", "Alice") -> "YoAliceAliceYo"
// Abba("What", "Up") -> "WhatUpUpWhat"

public String Abba(String a, String b) {
    
    return a+b+b+a;

}
}
