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
public class Triangle {
    private int side1;
    private int side2;
    private int side3;
    private int height;

    public Triangle(int side1, int side2, int side3, int height){
        this.side1 = side1;
        this.height = height;
        this.side2 = side2;
        this.side3 = side3;
    }
    
    
    public int getSide1() {
        return side1;
    }

    public void setSide1(int side1) {
        this.side1 = side1;
    }

    public int getSide2() {
        return side2;
    }

    public void setSide2(int side2) {
        this.side2 = side2;
    }

    public int getSide3() {
        return side3;
    }

    public void setSide3(int side3) {
        this.side3 = side3;
    }     
    

    public int getBase() {
        return side1;
    }

    public void setBase(int base) {
        this.side1 = base;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public double area() {
        return side1 * height * 0.5;
    }
    public double perimeter(){
        return side1 + side2 + side3;
    }
}
