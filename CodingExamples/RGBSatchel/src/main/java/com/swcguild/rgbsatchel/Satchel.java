/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.rgbsatchel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class Satchel {

    private int weightLimit;
    private int currentWeight = 0;

    //to hold item name and object, create hasmap
    // rename to 'Map' to delcare it as hashmap (Polymorpheism)
    Map<String, Item> itemMap = new HashMap<>();

    public Satchel(int weightLimit) {
        this.weightLimit = weightLimit;
    }

    public boolean addToSatchel(Item item) {
        if ((item.getItemweight() + this.currentWeight) > this.weightLimit) {
            return false;
        } else {
            currentWeight += item.getItemweight();
            itemMap.put(item.getItemName(), item);
            return true;
        }
    }
    public Item removeFromSatchel(String itemName){
        Item temp = itemMap.remove(itemName);
        if (temp != null){
            currentWeight -= temp.getItemweight();
        }
        return temp;
    }
    public List<String> listItemsInSatchel(){
        Set<String> itemNames = itemMap.keySet();
        List<String> itemNameList = new ArrayList<>(itemNames);
        return itemNameList;
    }
}
