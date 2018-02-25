/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.serverinventory;

import com.swcguild.serverinventory.controller.ServerInventoryController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) {
//        ServerDao doa = new serverDaoInMemImpl();
//        ServerInventoryController controller = new ServerInventoryController(dao);
//        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ServerInventoryController ctl = ctx.getBean("controller", ServerInventoryController.class);
        ctl.run();
        
        
    }
}
