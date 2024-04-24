/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uts.db;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConDB {
    private static final String DB_HOST="localhost";
    private static final int PORT = 3306;
    private static final String DB_NAME = "taller2_pj_2024_1_v";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://"+DB_HOST+":"+PORT+"/"+DB_NAME+"?serverTimezone=UTC&useSSL=false";
    
    private Connection connection;

    public ConDB() {
        try {
            Class.forName(DRIVER);
            connection=DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        return connection;
    }
    
    public static void main(String [] args) {
        ConDB con = new ConDB();
    }
    
    
    
}
