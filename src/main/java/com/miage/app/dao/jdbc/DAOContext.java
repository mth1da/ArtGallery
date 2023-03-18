package com.miage.app.dao.jdbc;

import jakarta.servlet.ServletContext;

import java.sql.*;

public abstract class DAOContext {

    protected static String dbURL="jdbc:mysql://localhost:3306/artgallery";
    protected static String dbPassWord="";
    protected static String dbLogin="root";
    protected static String driver="com.mysql.jdbc.Driver";

    protected abstract Object creatingObject(ResultSet re) throws SQLException ;

    protected Connection connexion=null;
    protected PreparedStatement st = null;

    public static Connection getConnect() {
        Connection con = null;
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/artgallery","root","");
            if (con != null) {
                return con;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
