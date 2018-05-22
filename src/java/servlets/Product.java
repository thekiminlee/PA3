package servlets;

import db.Connect;
import general.RecentItems;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kimin
 */
public class Product extends HttpServlet {

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
        
        HttpSession session = request.getSession(true);
        RecentItems recent = (RecentItems) session.getAttribute("recent");
        if(recent == null){
            recent = new RecentItems();
            session.setAttribute("recent", recent);
        }
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("         <title>Products</title>");
            out.println("         <script type='text/javascript' src=\"static/js/menu_bar.js\"></script>");
            out.println("         <link rel='stylesheet' type='text/css' href='static/css/menu.css'>");
            out.println("         <link rel='stylesheet' type='text/css' href='static/css/page_layout.css'");
            out.println("    </head>");
            out.println("    <body>");
            out.println("<script>indexMenu();</script>");
            out.println("       <div class='main_body'>");
            out.println("           <table style='width: 70%' align='center'>");
            out.println("               <tr><th>Product Image</th>");
            out.println("               <th>Product Name</th>");
            out.println("               <th>Price</th></tr>");
            displayProducts(out);
            out.println("           </table>");
            out.println("       </div>");
            out.println("    </body>");
            out.println("</html>");
            
            RequestDispatcher rd = request.getRequestDispatcher("tracking");
            rd.include(request, response);
        }
    }
    
    private void displayProducts(PrintWriter out){
        try{
            int count = 1;
            Connect connection = new Connect();
            ResultSet result = connection.executeQuery("SELECT * FROM products");
            while(result.next()){
                String imagePath = result.getString("picture") + result.getString("image_name");
                out.println("<tr><td><a href='item?product=" + count + "'><img src='" + imagePath + "1.jpg' alt='Product 1'></td></a>");
                String productName = result.getString("name");
                String productType = result.getString("type");
                out.println("<td>" + productName + "<br>Type: " + productType + "</td>");
                String productPrice = result.getString("price");
                out.println("<td>" + productPrice + "</td></tr>");
                count++;
            }
            connection.closeConn();      
        } catch (ClassNotFoundException | SQLException e){
            System.out.println("Cannot display products. Error: " + e);
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
