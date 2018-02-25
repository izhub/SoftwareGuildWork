/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.rgbsatchel;

/**
 *
 * @author apprentice
 */
public class RPGSatchel {
    public static void main(String[] args) {
        Sword weapon = new Sword();
        Shield protection = new Shield("Large Shield", 30);
        Satchel backpack = new Satchel(150);
        
        backpack.addToSatchel(weapon);
        backpack.addToSatchel(protection);
        
        Potion magicPotion = new Potion(); // can also say Item magicPotion for reference
        backpack.addToSatchel(magicPotion);
        
        MagicalSword sword2 = new MagicalSword();
        backpack.addToSatchel(sword2);
    }
}
