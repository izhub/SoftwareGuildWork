/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.interestcalculator;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class InterestCalc {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float pBal = 0;
        float aInterest = 0;
        int period = 0;

        float qInt = 0;
        float cBal = 0;
        float iEarned = 0;
        int feq = 0;

        // new amount each quarter is equal to: CurrentBalance * (1 + (QuarterlyInterestRate / 100))
        System.out.println("Enter principal balance: ");
        pBal = sc.nextFloat();
        cBal = pBal;

        System.out.println("Enter interest rate: ");
        aInterest = sc.nextFloat();

        System.out.println("Enter time period of investment: ");
        period = sc.nextInt();

        System.out.println("Enter # for interval time: "
                + "\n\t1. Quaterly \n\t2. Monthly \n\t3. Daily");
        feq = sc.nextInt();

        if (feq == 1) {
            feq = 4;
        } else if (feq == 2) {
            feq = 12;
        } else if (feq == 3) {
            feq = 365;
        } else {
            feq = 1;
        }
        qInt = (aInterest / feq) / 100;

        for (int i = 0; i < period; i++) {
            System.out.println("For year: " + i);

            for (int j = 0; j < feq; j++) {
                System.out.println("Beginning balance: " + cBal);
                iEarned = cBal * qInt;
                cBal = cBal + iEarned;
                System.out.println("Period: " + j + " | Interest earned: " + iEarned + " | Ending balance: " + cBal);
            }
        }

    }
}
