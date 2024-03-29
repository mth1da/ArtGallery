
package com.miage.app.dao.jdbc;

import com.miage.app.logging.ConsoleLogger;

import java.sql.*;

public abstract class DAOContext {

    protected static String dbURL="jdbc:mysql://localhost:3306/artGallery";
    protected static String dbPassWord="";
    protected static String dbLogin="root";
    protected static String driver="com.mysql.cj.jdbc.Driver";

    protected static Connection connexion=null;
    protected PreparedStatement st = null;

    protected ConsoleLogger consoleLogger;

    public DAOContext(){
        consoleLogger = new ConsoleLogger();
    }

    protected abstract Object creatingObject(ResultSet re) ;

    public static Connection getConnect() {
        Connection con = null;
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