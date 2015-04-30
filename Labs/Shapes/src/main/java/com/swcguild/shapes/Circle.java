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
public class Circle {

    private double radius;
    private double PI = Math.PI;

    public Circle(int radius) {
        this.radius = radius;
        this.PI = PI;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double Area() {
        return PI * radius * radius;
    }

    public double Perimeter() {

        return 2 * PI * radius;
    }
}
