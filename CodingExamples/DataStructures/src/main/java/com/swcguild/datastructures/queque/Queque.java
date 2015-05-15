/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructures.queque;

/**
 *
 * @author apprentice
 */
public interface Queque extends Iterable{
    
    public void enqueque(Object item);
    public Object dequeque();
    
    public boolean isEmpty();
    public int size();
    public Object[] getArray();
    
}
