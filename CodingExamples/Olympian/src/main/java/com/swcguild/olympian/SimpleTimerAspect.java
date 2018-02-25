/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.olympian;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 *
 * @author apprentice
 */
public class SimpleTimerAspect {

    //Around Advice
    public Object timeMethod(ProceedingJoinPoint jp) {
//tie into springFramework at parameter

        Object ret = null;

//Aspects should never cause problem, throw expections, fail gracefully
        try {

            Long start = System.currentTimeMillis();
            ret = jp.proceed();

            Long end = System.currentTimeMillis();
            
            System.out.println("++++++++++++++++++++++++++++++++++++");
            System.out.println(jp.getSignature().getName() + " took " + (end-start) + " milliseconds");
            System.out.println("++++++++++++++++++++++++++++++++++++");
            
        } catch (Throwable t) {
            System.out.println("Exception in SimpleTimerAsppect.");
        }

        return ret;
    }

}
