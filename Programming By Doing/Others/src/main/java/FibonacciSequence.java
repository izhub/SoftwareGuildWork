/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class FibonacciSequence {

    private static int index = 0;
    private static int stoppingPoint = 25;
    
    public static void main(String[] args) {
        
        int n1 = 0;
        int n2 = 1;
        
        System.out.println("index: " + index + " --> " + n1);
        fibonacciSequence(n1,n2);
    }
    
    public static void fibonacciSequence(int n1, int n2){
        
        System.out.println("index: " + index + " --> " + n2);
        
        if(index == stoppingPoint){
            return;
        }
        index++;
        fibonacciSequence(n2, n1 + n2);
    }
}
