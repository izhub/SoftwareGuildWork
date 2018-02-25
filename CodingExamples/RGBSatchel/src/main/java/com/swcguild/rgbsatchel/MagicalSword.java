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
public class MagicalSword extends Sword implements MagicalItem {

    @Override
    public String getItemName (){
        return "Magical Sword";
    }
    
    @Override
    public int getItemSpellPower() {
      return 10;
    }
    
}
