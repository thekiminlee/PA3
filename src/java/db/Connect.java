
package db;

import java.sql.*;
/**
 *
 * @author kimin
 */
public class Connect {
    private Connection conn;
    
    public Connect() throws ClassNotFoundException{
        
        Class.forName("com.mysql.jdbc.Driver");      
        try{
            conn = DriverManager.getConnection("jdbc:mysql://" + DBCredential.serverName + "/" + DBCredential.dbName, DBCredential.username, DBCredential.password);
        } catch(SQLException e) {
            System.out.println("Failed to connect to database");
        }
    }
    
    public ResultSet executeQuery(String query){
        ResultSet result = null;
        try {
            Statement statement = conn.createStatement();
            result = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Cannot execute given query");
        }
        return result;
    }
    
    public void updateQuery(String query){
        try {
            Statement statement = conn.createStatement();  
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Cannot update given query");
        }
    }    
    
    public void closeConn() throws SQLException {
        conn.close();
    }
   
}
