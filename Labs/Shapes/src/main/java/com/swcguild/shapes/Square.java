/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.shapes;

/**
 *
 * @author apprentice
 */
public class Square extends Shapes{
    private int side;
    
    public Square(int side){ this.side = side;}
    
    public int area(){return this.side*this.side;}
    public int perimeter(){return 4*this.side;}

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }
    
}
