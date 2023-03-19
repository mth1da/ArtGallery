
package com.miage.app.dao.jdbc;

import jakarta.servlet.ServletContext;

import java.sql.*;

public abstract class DAOContext {

    protected static String dbURL="jdbc:mariadb://localhost:3308/artGallery";
    protected static String dbPassWord="meryam";
    protected static String dbLogin="root";


    protected abstract Object creatingObject(ResultSet re) throws SQLException ;


    //attribut connection qui sera récupérer par les classes filles pour la connection avec la bdd
    protected static Connection connexion=null;
    protected PreparedStatement st = null;

    protected static String driver="org.mariadb.jdbc.Driver";

    public static Connection getConnect() {
        try {
            Class.forName(driver);
            connexion = DriverManager.getConnection(dbURL, dbLogin, dbPassWord);
            if (connexion != null) {
                return connexion;

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }




    public static void getDeconnect() throws SQLException {
        connexion.close();
    }

}