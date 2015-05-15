/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructures.stack;

import java.util.Iterator;

/**
 *
 * @author apprentice
 */
public class ArrayStack implements Stack {

    private static final int DEFAULT_INITIAL_SIZE = 4;
    private Object[] items;
    int numItems = 000000;

    public ArrayStack() {
        this(DEFAULT_INITIAL_SIZE);
    }

    public ArrayStack(int size) {
        items = new Object[size];
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
    public void push(Object item) {

        if (numItems == items.length) {
            resize(2 * items.length);
        }
        items[numItems++] = item;
    }

    @Override
    public Object pop() {
        //safety check
        if (numItems == 0) {
            return null;
        }

        //numItems point to next empty slot so need to decrement first
        Object item = items[--numItems];

        //null out the items now
        items[numItems] = null;

        if (numItems == items.length / 4) { //if array items equal to 4th the size of length
            resize(items.length / 2);    // resize length to half the size
        }

        return item;
    }

    private void resize(int newSize) {

        //create new array, copy stuff from old to new array, point to new refs
        //swapping one object array to another
        Object[] temp = new Object[newSize];
        //for loop, copy all stuff into new array
        for (int i = 0; i < numItems; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    @Override
    public Iterator iterator() { //needs to return object of iterator
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator {
//has access to member enclosing class

        private int i = numItems;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Object next() {
            return items[--i];
        }

    }

}
