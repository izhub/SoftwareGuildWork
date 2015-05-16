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
    private int head = 0;
    private int tail = 0;

      public ArrayQueque() {
        this(DEFAULT_INITIAL_SIZE);

    }
      
    public ArrayQueque(int size) {
        items = new Object[size];
    }  

    @Override
    public void enqueque(Object item) {

        if (tail >= items.length) {
            tail = 0;
        }
        if (tail == head && numItems == items.length) {
            resize(numItems * 2);
        }

//        if (tail == head && numItems == 0) {
//            items[tail] = item;
//            tail++;
//            numItems++;
//        } else if (tail != head)/* && numItems < items.length)*/ {
//            items[tail] = item;
//            tail++;
//            numItems++;
//        }
        items[tail] = item;
        tail++;
        numItems++;

    }

    @Override
    public Object dequeque() {

        if (numItems == 0) {
            return null;
        }

        if (head >= items.length) {
            head = 0;
        }

        if (numItems == items.length / 4) {
            resize(items.length / 2);
        }

        Object item = items[head];
        items[head] = null;
        --numItems;
        head++;
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

    private void resize(int newSize) {

        Object[] temp = new Object[newSize];

        if (head < tail) {
            for (int i = head, j = 0; j < numItems; i++, j++) {
                temp[j] = items[i];
            }
        } else {
            for (int i = head; i < numItems; i++) {
                if (i == (items.length - 1)) {
                    i = 0;
                }
                temp[i] = items[i];

            }

        }
        /*
        OR....FOR LOOP: 
        
        for (int i = 0, current = head; i < numItems; i++, current++){
            temp[i] = items[current % items.length];
        }
        
        head = 0;
        tail = numItems;
        items = temp;
        */
    }

    @Override
    public Iterator iterator() {
        return new ThisIterator();
    }

    @Override
    public Object[] getArray() {
        return items;
    }

    @Override
    public void prepend() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void append() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class ThisIterator implements Iterator {

        private int i = head;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Object next() {
            if (i == items.length) {
                i = 0;
            }
            return items[i++];
        }

    }

}
