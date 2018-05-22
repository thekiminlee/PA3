package servlets;

import general.CartItem;
import general.ShoppingCart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kimin
 */
public class Cart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    ShoppingCart cart;
    HttpSession session;
    String itemName;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        session = request.getSession();
        itemName = request.getParameter("item");
        synchronized (session) {
            cart = (ShoppingCart) session.getAttribute("shoppingCart");
            if(cart == null){
                cart = new ShoppingCart();
                session.setAttribute("shoppingCart", cart);                
            } 
        }
        
        String action = request.getParameter("action");
        if(action != null){
            switch (action) {
                case "clear":
                    cart.clearCart();
                    break;
                case "remove":
                    cart.removeItem(request.getParameter("removeItem"));
                    break;
            }
           
        }
        
        if(itemName != null){
            if(cart.updateItem(itemName)){
            } else {
                CartItem item = new CartItem(itemName, request.getParameter("price"));
                cart.addItem(item);                
            }
            session.setAttribute("shoppingCart", cart);
        }

        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("   <head>");
            out.println("        <title>Shopping Cart</title>");
            out.println("        <script type='text/javascript' src=\"static/js/menu_bar.js\"></script>");
            out.println("        <script type='text/javascript' src=\"static/js/item.js\"></script>");
            out.println("        <link rel='stylesheet' type='text/css' href='static/css/menu.css'>");
            out.println("   </head>");
            out.println("   <body>");
            out.println("       <script>indexMenu();</script>");
            out.println("       <div class='main_body'><center>");
            displayCart(out, itemName);
            out.println("       </center></div>");
            out.println("   </body>");
            out.println("</html>");
        }
    }
    
    private void displayCart(PrintWriter out, String itemName){
        int total = 0;
        ArrayList<String> productInfo = new ArrayList<>();
        out.println("<table style='width: 50%; border-spacing: 0px 10px'>");  
        out.println("<div style='width: 50%' align='left'><h2>Customer Check Out</h2></div><hr>");
        if(cart.isEmpty()){
            out.println("Cart is empty");
        } else {
            out.println("<tr'><th>Product Name</th><th>Quantity</th><th>Price</th><th></th></tr>");            
            for(CartItem item : cart.getItems()){
                out.println("<tr><td align='center'>" + item.getName() + "</td>");
                out.println("<td align='center'>" + item.getQuantity() + "</td>");
                out.println("<td align='center'>$" + item.getPrice() + "</td>");
                out.println("<td><form method='post' action='cart?action=remove&removeItem=" + item.getName() + "'><button>Remove</button></form></td></tr>");
                for(int i = 0; i < item.getQuantity(); i++)
                    total += Float.parseFloat(item.getPrice());
                productInfo.add(item.getName() + "," + item.getQuantity());
            }
        }
        out.println("</table>");
        // Clear Button
        out.println("<div style='width: 50%' align='right'>");
        out.println("<form method='post' action='cart?action=clear'>");
        out.println("<input type='submit' value='Clear'></form>");
        
        // Order Form
        out.println("<p>Total = $" + total + ".00</p></div>");
        out.println("<div style='width: 50%' align='left'>");
        out.println("<br><h3>Customer Information</h3><hr style='width: 100%'><br>");
        out.println("<form method='post' action='order_submit?productCount=" + productInfo.size() + "'>");
        int count = 1;
        for(String info : productInfo){
            out.println("<input type='hidden' name='product" + (count++) + "' value='" + info + "'>");
        }
        out.println("First Name: <input type='text' name='first_name' required>");
        out.println("Last Name: <input type=\"text\" name=\"last_name\" required>");
        out.println("Phone Number: <input type=\"text\" id=\"pno\" name=\"phone_number\" pattern=\"[0-9]{10}\" maxlength=\"10\" required><br>");
        out.println("E-Mail: <input type=\"email\" id=\"email\" name=\"e-mail\" required><br>");
        out.println("Address: <input type=\"text\" id=\"address\" name=\"address\" size=\"100\"\" required><br>");
        out.println("Zip Code: <input type=\"text\" name=\"zip_code\" required pattern=\"[0-9]{4,5}\" maxlength=\"5\">");
        out.println("City: <input type=\"textarea\" id=\"city\" name=\"city\" required>");
        out.println("State: <input type=\"text\" id=\"state\" name=\"state\" required><br>");
        out.println("Card Number: <input type=\"text\" id=\"cno\" name=\"card_number\" pattern=\"[0-9]{16}\" maxlength=\"16\" required><br>");
        out.println("Shipping Method: <input type=\"text\" name=\"shipping_method\" required></div>");
        out.println("<div style='width: 50%' align='right'>");
        out.println("<input type='submit' value='Order'></form>");
        out.println("<hr style='width: 100%'></div>");
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
