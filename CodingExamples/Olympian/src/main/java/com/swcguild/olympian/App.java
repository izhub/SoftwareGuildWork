/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.olympian;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) {
//        SkiJumper jumper = new SkiJumper();
//        jumper.competeInEvent();
        
//spring applicationcontext read config file, see the bean and instantitates it
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Olympian usaSkiJumper = ctx.getBean("usaSkiJumper", Olympian.class);
        usaSkiJumper.competeInEvent();
        
        Olympian usaSpeedSkater = ctx.getBean("usaSpeedSkater", Olympian.class);
        usaSpeedSkater.competeInEvent();
        
        Olympian canadianSpeedSkater = ctx.getBean("canadianSpeedSkater",Olympian.class);
        canadianSpeedSkater.competeInEvent();
        
        
//      SkiJumper sj = (SkiJumper) ctx.getBean("superSkiJumper");  casting : (SkiJumper)
                
//        SkiJumper sj = ctx.getBean("superSkiJumper", SkiJumper.class);
//        sj.competeInEvent();
        
//        Event skiJumpEvent = new SkiJumpEvent();
//        Olympian olympianSkiJumper = new Olympian(skiJumpEvent);
//        olympianSkiJumper.competeInEvent();
    }
}
