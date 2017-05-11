/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pembukuan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author MS
 */
public class ConnectionClass {
    
   private String databaseName="pembukuan", username="root", password="";
    public Statement statement;
    
    public void setConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
             statement =DriverManager.getConnection("jdbc:mysql://localhost:3306/"+databaseName, username, password).createStatement();
             databaseName="pembukuan";
        } catch (ClassNotFoundException | SQLException e) {
            databaseName="test";
             setConnection();
        }
    }
    
    public void closeConnection(){
        try {
            statement.close();
        } catch (SQLException ex) {
        }
    }
}
