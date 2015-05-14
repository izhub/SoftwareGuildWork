/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructures.queque;

import java.util.Iterator;

/**
 *
 * @author apprentice
 */
public class ArrayQueque implements Queque {

    private Object[] items;
    private static final int DEFAULT_INITIAL_SIZE = 4;
    int numItems = 00000;
    private int numDecrements = 0;
    private int addAtIndex;
    private int deququeIndex;

    @Override
    public void enqueque(Object item) {
        
        if(numDecrements > 0) {
            addAtIndex = numItems + numDecrements;
        } else {
            addAtIndex = numItems;
        }
        items[addAtIndex] = item;
        numItems++;
    }

    @Override
    public Object dequeque() {
        if (numItems == 0) return null;
        
        Object item = items[numDecrements++];
        items[numDecrements] = null;
        --numItems;
        numDecrements++;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public int size() {
        return numItems;
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
