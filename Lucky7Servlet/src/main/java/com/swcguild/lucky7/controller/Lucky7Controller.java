/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.lucky7.controller;

import java.io.IOException;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author apprentice
 */
@WebServlet(name = "Lucky7Controller", urlPatterns = {"/Lucky7Controller"})
public class Lucky7Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String guestAnswer = request.getParameter("answer");
        String errorMsg = "Enter real dollar amount";
        String responseMsg = "";
//
//        try {
//            bet = Integer.parseInt(request.getParameter("answer"));
//
//        } catch (Exception e) {
////            request.setAttribute("responseMessage", errorMsg);
////            RequestDispatcher rd = request.getRequestDispatcher("response.jsp");
////            rd.forward(request, response);
//        }

        Random r = new Random();
        
        int roll = 1;
        int money = 0;
        int maxMoney = 0;
        int maxRoll = 0;
         
          
        do {
            int dice1 = 1 +r.nextInt(6); // 1 + becuase index starts at 0 
            int dice2 = 1 + r.nextInt(6);
            roll++;     
               
        if (dice1 + dice2 == 7) {
            money = money + 4;
        } else {
            money -= 1;
        }
        if (money > maxMoney){
            maxMoney = money;
            maxRoll = roll;
        }
        
        } while (money > 0);

        responseMsg = ("You are broke after " + roll + "You should have quit after " + maxRoll
                + " when you had " + maxMoney);

        request.setAttribute("responseMsg", responseMsg);
        RequestDispatcher rd = request.getRequestDispatcher("response.jsp");
        rd.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
