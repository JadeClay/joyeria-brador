/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author oscar
 */
public class DBConnection {
    
    
    public static Connection getConnection(){ // Static method to connect to the database
        final String dbPath = "jdbc:mysql://localhost:3306/joyeriabrador?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; // Path to the database.
        Connection con = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(dbPath, "root", "oscar27");
        } catch(ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        
        return con;
    }
}
