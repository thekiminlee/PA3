package servlets;

import db.Connect;
import general.RecentItems;
import general.RecentProduct;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kimin
 */
public class Item extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private String productName;
    private String imagePath;
    private String product;
    HttpSession session;
    RecentItems recent;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        product = request.getParameter("product");   
        
        session = request.getSession(false);
        recent = (RecentItems) session.getAttribute("recent");        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("   <head>");
            out.println("        <title>Product " + product +"</title>");
            out.println("        <script type='text/javascript' src=\"static/js/menu_bar.js\"></script>");
            out.println("        <script type='text/javascript' src=\"static/js/item.js\"></script>");
            out.println("        <link rel='stylesheet' type='text/css' href='static/css/menu.css'>");
            out.println("        <link rel='stylesheet' type='text/css' href='static/css/items.css'");
            out.println("   </head>");
            out.println("   <body>");
            out.println("       <script>indexMenu();</script>");
            out.println("       <div class='main_body'>");
            displayDetail(out, product);             
            out.println("       </div>");
            out.println("   </body>");
            out.println("</html>");
        }
    }
    
    private void displayDetail(PrintWriter out, String product){
        try{
            Connect connection = new Connect();
            String query = "SELECT * FROM products WHERE id=" + product;
            ResultSet result = connection.executeQuery(query);
            if(result.next()){
                imagePath = result.getString("picture") + result.getString("image_name");
                productName = result.getString("name");
                String productPrice = result.getString("price");
                String productDescription = result.getString("description");
                out.println("       <table><tr><td id='mainImageCell'>");
                out.println("           <img id='mainImage' src='" + imagePath + "1.jpg' alt='Product 1'></td>");
                out.println("           <td id='description'>");
                out.println("               <b>" + productName + "</b>");
                out.println("               <p>" + productDescription + "</p><br><br>$" + productPrice + "<br><br>");
                out.println("               <form method='post' action='cart?item=" + productName + "&price=" + productPrice + "'>");
                out.println("                   <input type='submit' value='Add to Cart'></form></td>");
                out.println("       </tr></table>");
                
                // Thumbnails
                out.println("       <table><tr><td>");
                int imageCount = result.getInt("image_count");
                for(int i = 0; i < imageCount; i++){
                    out.println("<img class='thumbnails' id='thumbnail" + (i+1) + "' onClick='switchImage(\"thumbnail" + (i+1) + "\")' src='" + imagePath + (i+1) + ".jpg' alt='" + productName + (i+1) + "'>");
                }
                out.println("       </td></tr></table>");
            }  
            if(recent == null){
                recent = new RecentItems();
                session.setAttribute("recent", recent);
            } else {
                recent.addItem(new RecentProduct(productName, imagePath + "1.jpg", product ));
        }
            connection.closeConn();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e);
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
