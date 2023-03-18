package com.miage.app.dao.jdbc;

import jakarta.servlet.ServletContext;

import java.sql.*;

public abstract class DAOContext {

    protected static String dbURL="jdbc:mysql://localhost:3306/artGallery";
    protected static String dbPassWord="";
    protected static String dbLogin="root";
    protected static String driver="com.mysql.jdbc.Driver";

    protected abstract Object creatingObject(ResultSet re) throws SQLException ;

    protected Connection connexion=null;
    protected PreparedStatement st = null;

    public static Connection getConnect() {
        Connection con = null;
        try {
            //Charger la connexion mysql
            Class.forName(driver);

            // Création de la connexion
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