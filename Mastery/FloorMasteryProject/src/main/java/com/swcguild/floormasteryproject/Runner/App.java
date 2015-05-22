/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.floormasteryproject.Runner;

import com.swcguild.floormasteryproject.Controller.OrderController;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) throws FileNotFoundException, IOException {
//        OrderController controller = new OrderController();
//        controller.run();
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderController ctl = ctx.getBean("controller", OrderController.class);
        ctl.run();
        
    }
}
