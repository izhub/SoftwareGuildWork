/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructures.stack;

import java.util.Iterator;
import static java.util.Spliterators.iterator;

/**
 *
 * @author apprentice
 */
public class LinkedListStack implements Stack {

    private Node first;
    private int numItems;

    private class Node {

        Object item;
        Node next;
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
    public void push(Object item) {
        Node prevfirst = first;
        first = new Node();
        first.item = item;
        first.next = prevfirst;
        numItems++;
    }

    @Override
    public Object pop() {
        Object ret = first.item;  //return object not node
        first = first.next;
        numItems--;
        return ret;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator {

        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            //null check, can take iterator of an empty, first current will be null
            if (current == null){
                return null;
            }
            Object ret = current.item;
            current = current.next;
            return ret;     //returning objects inside nodes, not nodes
        }

    }
}
