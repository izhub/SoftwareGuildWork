/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.gui;

/**
 *
 * @author apprentice
 */
import javax.swing.*;

public class BoringWindow extends JFrame {
    public static void main(String[] args) {
        
        JFrame f = new BoringWindow();
        f.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE);
        f.setSize(300,200);
        f.setVisible (true);
    }
}
