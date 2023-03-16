package com.miage.app.dao.jdbc;

import jakarta.servlet.ServletContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOContext {

    protected static String dbURL="jdbc:mysql://localhost:3306/artGallery";
    protected static String dbPassWord="";
    protected static String dbLogin="root";

    protected static String driver="com.mysql.jdbc.Driver";

    public static Connection getConnect() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(dbURL, dbLogin, dbPassWord);
            if (con != null) {
                return con;

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
