/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kimin
 */
public class OrderDetail extends HttpServlet {

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
                
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("         <title>Products</title>");
            out.println("         <script type='text/javascript' src=\"static/js/menu_bar.js\"></script>");
            out.println("         <link rel='stylesheet' type='text/css' href='static/css/menu.css'>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("       <script>indexMenu();</script>");
            out.println("       <div class='main_body'><center>");
            out.println("           <h1>Order Summary</h1><hr>");
            out.println("               Customer: " + request.getParameter("first_name") + " " + request.getParameter("last_name"));
            out.println("               <br>Phone Number: " + request.getParameter("phone_number"));
            out.println("               <br>E-Mail: " + request.getParameter("e-mail"));
            out.println("               <br><br><u>Products</u> <br>");
            int itemCount = Integer.parseInt(request.getParameter("productCount"));
            for(int i = 0; i < itemCount; i++){
                String info = request.getParameter("product" + (i+1));
                String[] productInfo = info.split(",");
                String productName = productInfo[0];
                String productCount = productInfo[1];
                out.println(productName + ": " + productCount + "<br>");
            }
            out.println("               <br>Address: " + request.getParameter("address") + " " + request.getParameter("city") + ", " + request.getParameter("state") + " " + request.getParameter("zip_code"));
            out.println("               <br>Card Number: " + request.getParameter("card_number"));
            out.println("               <br>Shipping Method: " + request.getParameter("shipping_method"));
            out.println("       </center></div>");
            out.println("   </body>");
            out.println("</html>");
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
