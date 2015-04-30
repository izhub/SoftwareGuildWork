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
public class Rectangle {
   private int height;
   private int width;
   
   public Rectangle(int height, int width){
       this.height = height;
       this.width = width;
   }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
   
    public int area(){
        return this.height*this.width;
    }
    
    public int perimeter(){
        return 2*this.height+2*this.width;
    }
   
}
