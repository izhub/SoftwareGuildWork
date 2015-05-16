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
public class LinkedListQueque implements Queque {

    private Node first;
    private Node last;
    private int numItems;
    private Object[] items;
    
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

    private class Node {

        Object item;
        Node next;
    }

    @Override
    public void enqueque(Object item) {
        Node prevLast = last;
        last = new Node();
        last.item = item;        
        numItems++;
        if (prevLast != null) {
            prevLast.next = last;
        }
        if (numItems == 1) {
            first = last;
        }

    }

    @Override
    public Object dequeque() {
        Object ret = first.item;
        first = first.next;
        numItems--;
        return ret;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return numItems;
    }

    @Override
    public Object[] getArray() {
return items;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator {

        Node end = first;

        @Override
        public boolean hasNext() {
            return end != null;
        }

        @Override
        public Object next() {
            if (end == null) {
                return null;
            }
            Object ret = end.item;
            end = end.next;
            return ret;
        }

    }

}
