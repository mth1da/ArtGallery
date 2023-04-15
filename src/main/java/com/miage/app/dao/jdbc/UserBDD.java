package com.miage.app.dao.jdbc;


import com.miage.app.Entity.Reservation;
import com.miage.app.Entity.User;
import com.miage.app.dao.ReservationDAO;
import com.miage.app.dao.UserDAO;
import com.miage.app.logging.ConsoleLogger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class UserBDD extends DAOContext implements UserDAO{

    ConsoleLogger consoleLogger = new ConsoleLogger();

    @Override
    public void createUser(User r) {
        try{
            //connexion
            DAOContext.getConnect();

            String query="INSERT INTO USER (firstname,lastname,email,password,status) VALUES (?,?,?,?,?)";
            st = connexion.prepareStatement(query);
            st.setString(1, r.getPreNom());
            st.setString(2, r.getNom());
            st.setString(3, r.getEmail());
            st.setString(4,r.getMdp());
            st.setString(5,r.getType());
            st.executeUpdate();
        } catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e) {
                consoleLogger.writeError("Caught SQLException", e);
            }
        }
    }

    public void updateUser(User r) {
        try {
            //connexion
            DAOContext.getConnect();

            String query="UPDATE user SET firstName=?, lastName=? WHERE email=? AND status=?";
            st = connexion.prepareStatement(query);
            st.setString(1, r.getPreNom());
            st.setString(2, r.getNom());
            st.setString(3, r.getEmail());
            st.setString(4, this.getStatus());
            st.executeUpdate();
            DAOContext.getDeconnect();
        }  catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e) {
                consoleLogger.writeError("Caught SQLException", e);
            }
        }

    }

    public void deleteUser(User r) {
        try{
            //connexion
            DAOContext.getConnect();

            String query="DELETE FROM user WHERE email= ? AND status= ?";
            st = connexion.prepareStatement(query);
            st.setString(1, r.getEmail());
            st.setString(2, this.getStatus());
            st.executeUpdate();
            DAOContext.getDeconnect();
        } catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e) {
                consoleLogger.writeError("Caught SQLException", e);
            }
        }

    }

    @Override
    public User getUserById(int idUser) {
        User user=null;
        try{
            //connexion
            DAOContext.getConnect();

            String query="select * FROM USER WHERE idUser= ?";
            st = connexion.prepareStatement(query);
            st.setInt(1, idUser);

            ResultSet re=st.executeQuery();
            while(re.next()){
                user=creatingObject(re);
            }
        }catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e) {
                consoleLogger.writeError("Caught SQLException", e);
            }
        }
        return user;
    }


    @Override
    public Iterable<User> getAllUser() {
        List<User> userList=new ArrayList<>();
        try{
            //connexion
            DAOContext.getConnect();

            String query="select * FROM USER";
            st = connexion.prepareStatement(query);
            ResultSet re=st.executeQuery();
            while(re.next()){
                User user=creatingObject(re);
                userList.add(user);
            }
        }catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e) {
                consoleLogger.writeError("Caught SQLException", e);
            }
        }
        return userList;
    }

    @Override
    public boolean getUserConnection(String email, String password) {
        try {
            //connexion
            DAOContext.getConnect();

            String query="select * FROM USER WHERE email= ? AND password= ?";
            st = connexion.prepareStatement(query);
            st.setString(1, email);
            st.setString(2, password);
            ResultSet re=st.executeQuery();
            if(re.next()) {
                return true;
            }
        } catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e) {
                consoleLogger.writeError("Caught SQLException", e);
            }
        }
        return true;
    }

    public User getUserByMail(String email) {
        User user=null;
        try{
            //connexion
            DAOContext.getConnect();

            String strSql="select * FROM USER WHERE email= ? AND STATUS= ?";
            st = connexion.prepareStatement(strSql);
            st.setString(1, email);
            st.setString(2, this.getStatus());
            ResultSet re=st.executeQuery();
            while(re.next()){
                user=creatingObject(re);
            }
            DAOContext.getDeconnect();
        }catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e) {
                consoleLogger.writeError("Caught SQLException", e);
            }
        }
        return user;
    }

    protected abstract User creatingObject(ResultSet re);

    protected abstract String getStatus();

    protected Iterable<User> getAllUserByStatus() {
        List<User> userList=new ArrayList<>();
        try{
            //connexion
            DAOContext.getConnect();

            String strSql="select * FROM USER WHERE status= ?";
            st = connexion.prepareStatement(strSql);
            st.setString(1, this.getStatus());
            ResultSet re=st.executeQuery();
            while(re.next()){
                User user=creatingObject(re);
                userList.add(user);
            }
            DAOContext.getDeconnect();
        } catch (SQLException e){
            System.out.println("Caught SQLException: " + e.getMessage());
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e) {
                consoleLogger.writeError("Caught SQLException", e);
            }
        }
        return userList;
    }

    public int getUserIdBymail(String email){
        int user=0;
        try{
            //connexion
            DAOContext.getConnect();

            String strSql="select idUser FROM USER WHERE email= ? AND status= ?";
            st = connexion.prepareStatement(strSql);
            st.setString(1, email);
            st.setString(2, this.getStatus());
            ResultSet re=st.executeQuery();
            while(re.next()){
                user= re.getInt("idUser");
            }
            DAOContext.getDeconnect();
        } catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e) {
                consoleLogger.writeError("Caught SQLException", e);
            }
        }
        return user;
    }

    public static void main(String[] a){

        ReservationDAO re=new ReservationBDD();
        re.deleteReservation(1);

    }

}
