/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.floormasteryproject;

import com.swcguild.floormasteryproject.Controller.OrderController;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) {
        OrderController controller = new OrderController();
        controller.run();
    }
}