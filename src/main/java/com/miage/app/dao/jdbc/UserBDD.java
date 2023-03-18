package com.miage.app.dao.jdbc;

import com.miage.app.Entity.Proprietaire;
import com.miage.app.Entity.Reservation;
import com.miage.app.Entity.User;
import com.miage.app.Entity.Visiteur;
import com.miage.app.dao.UserDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class UserBDD extends DAOContext implements UserDAO{

    @Override
    public void createUser(User r) {
        String strSql="INSERT INTO USER (firstname,lastname,email,password,status) VALUES (?,?,?,?,?)";
        try{
            DAOContext.getConnect();
            st = connexion.prepareStatement(strSql);
            st.setString(1, r.getPreNom());
            st.setString(2, r.getNom());
            st.setString(3, r.getEmail());
            st.setString(4,r.getMdp());
            st.setString(5,r.getType());
            st.executeUpdate();
            DAOContext.getDeconnect();
        }catch (Exception ignored){

        }
    }

    @Override
    public void updateUser(User r) {

    }

    @Override
    public User getUserById(int idUser) {
        User user=null;
        String strSql="select * FROM USER WHERE idUser= ?";
        try{
            DAOContext.getConnect();
            st = connexion.prepareStatement(strSql);
            st.setInt(1, idUser);

            ResultSet re=st.executeQuery();
            while(re.next()){
                user=creatingObject(re);
            }
            DAOContext.getDeconnect();
        }catch (Exception ignored){

        }
        return user;
    }


    @Override
    public Iterable<User> getAllUser() {
        List<User> userList=new ArrayList<>();
        String strSql="select * FROM USER";
        try{
            DAOContext.getConnect();
            st = connexion.prepareStatement(strSql);
            ResultSet re=st.executeQuery();
            while(re.next()){
                User user=creatingObject(re);
                userList.add(user);
            }
            DAOContext.getDeconnect();
        }catch (Exception ignored){

        }
        return userList;
    }

    @Override
    public boolean getUserConnection(String email, String password) {
        String strSql="select * FROM USER WHERE email= ? AND password= ?";
        try {
            DAOContext.getConnect();
            st = connexion.prepareStatement(strSql);
            st.setString(1, email);
            st.setString(2, password);
            ResultSet re=st.executeQuery();
            if(re.next()) {
                return true;
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }

    protected abstract Iterable<User> getAllUserByStatus();

    protected abstract User creatingObject(ResultSet re) throws SQLException;


}
