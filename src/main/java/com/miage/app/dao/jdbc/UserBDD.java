package com.miage.app.dao.jdbc;

import com.miage.app.Entity.Proprietaire;
import com.miage.app.Entity.Reservation;
import com.miage.app.Entity.User;
import com.miage.app.Entity.Visiteur;
import com.miage.app.dao.UserDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserBDD extends DAOContext implements UserDAO{
    Connection connexion=null;
    PreparedStatement st = null;


    @Override
    public void createUser(User r) {
        connexion = DAOContext.getConnect();
        String strSql="INSERT INTO USER (firstname,lastname,email,password,status) VALUES (?,?,?,?,?)";
        try{
            st = connexion.prepareStatement(strSql);
            st.setString(1, r.getPreNom());
            st.setString(2, r.getNom());
            st.setString(3, r.getEmail());
            st.setString(4,r.getMdp());
            st.setString(5,r.getType());
            st.executeUpdate();
        }catch (Exception exception){

        }
    }

    @Override
    public void updateUser(User r) {

    }

    @Override
    public void deleteUser(User r) {
        connexion = DAOContext.getConnect();
        String strSql="DELETE FROM user WHERE email= ?";
        try{
            st = connexion.prepareStatement(strSql);
            st.setString(1, r.getEmail());
            st.executeUpdate();
        }catch (Exception exception){

        }

    }

    public User creatingUserObject(ResultSet re) throws SQLException {
        User user=null;
        String name=re.getString("lastname");
        String firstname=re.getString("firstname");
        String mail=re.getString("email");
        String status=re.getString("status");
        String password=re.getString("password");
        if(status=="visiteur"){
            user=new Visiteur(name,firstname,mail,password);
        }else{
            user=new Proprietaire(name,firstname,mail,password);
        }

        return user;
    }

    @Override
    public User getUserById(int idUser) {
        User user=null;
        connexion = DAOContext.getConnect();
        String strSql="select * FROM USER WHERE idUser= ?";
        try{
            st = connexion.prepareStatement(strSql);
            st.setInt(1, idUser);
            ResultSet re=st.executeQuery();
            while(re.next()){
                user=creatingObject(re);
            }
        }catch (Exception exception){

        }
        System.out.println(user);
        return user;
    }

    @Override
    public User getUserByMail(String email) {
        User user=null;
        connexion = DAOContext.getConnect();
        String strSql="select * FROM USER WHERE email= ?";
        try{
            st = connexion.prepareStatement(strSql);
            st.setString(1, email);
            ResultSet re=st.executeQuery();
            while(re.next()){
                user=creatingUserObject(re);
            }
        }catch (Exception exception){

        }
        System.out.println(user);
        return user;
    }

    @Override
    public Iterable<User> getAllUser() {
        List<User> userList=new ArrayList<>();
        connexion = DAOContext.getConnect();
        String strSql="select * FROM USER";
        try{
            st = connexion.prepareStatement(strSql);
            ResultSet re=st.executeQuery();
            while(re.next()){
                User user=creatingObject(re);
                userList.add(user);
            }
        }catch (Exception exception){

        }
        return userList;
    }

    @Override
    protected User creatingObject(ResultSet re) throws SQLException {
        String name=re.getString("lastname");
        String firstname=re.getString("firstname");
        String mail=re.getString("email");
        String status=re.getString("status");
        String password=re.getString("password");
        User user=new Visiteur(name,firstname,mail,password);
        return user;
    }
}
