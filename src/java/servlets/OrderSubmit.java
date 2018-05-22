/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import db.Connect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kimin
 */
public class OrderSubmit extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        
        try{
            Connect connection = new Connect();
                           
            // Item Information
            
            int itemCount = Integer.parseInt(request.getParameter("productCount"));
            for(int i = 0; i < itemCount; i++){
                String info = request.getParameter("product" + (i+1));
                String[] productInfo = info.split(",");
                String productName = productInfo[0];
                String productCount = productInfo[1];
                // Customer Information
                String firstName = request.getParameter("first_name");
                String lastName = request.getParameter("last_name");
                String phoneNum = request.getParameter("phone_number");
                String email = request.getParameter("e-mail");
                String address = request.getParameter("address") + " " + request.getParameter("city") + ", " + request.getParameter("state") + " " + request.getParameter("zip_code");
                String cardNum = request.getParameter("card_number");
                String shipping = request.getParameter("shipping_method");

                // Database update with customer information

                String query = "INSERT INTO purchased (first_name, last_name, phone_num, email, product, quantity, address, card_num, shipping) VALUES ('" 
                                    + firstName + "','" + lastName + "','" + phoneNum + "','" + email + "','" + productName + "','" + productCount + "','" + address + "','"
                                    + cardNum + "','" + shipping + "')";
                connection.updateQuery(query);   
            }

            connection.closeConn();   
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: Database insertion error " + e);
        }
        
        try (PrintWriter out = response.getWriter()) {                       
            RequestDispatcher rd = request.getRequestDispatcher("order_detail");
            rd.forward(request, response);
        }
        
        
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
