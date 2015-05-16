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
public class ArrayQuequeDriver {
    public static void main(String[] args) {
        
        Queque q = new LinkedListQueque(); // change ArrayQueque to LinkedListQueque
        
                
        q.enqueque("a");
        q.enqueque("b");
        q.enqueque("c");
        q.enqueque("d");
        
        System.out.println(q.dequeque());
        System.out.println(q.dequeque());
        System.out.println(q.dequeque());
        
        
    }
}
