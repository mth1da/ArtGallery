package com.miage.app.dao.jdbc;

import com.miage.app.Entity.Reservation;
import com.miage.app.Entity.User;
import com.miage.app.Entity.Visiteur;
import com.miage.app.dao.UserDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserBDD extends DAOContext implements UserDAO{

    public UserBDD(){
        this.connexion=DAOContext.getConnect();
    }

    @Override
    public void createUser(User r) {
        String strSql="INSERT INTO VISITEUR (name,firstname,mail,city,password) VALUES (?,?,?,?,?)";
        try{
            st = connexion.prepareStatement(strSql);
            st.setString(1, r.getNom());
            st.setString(2, r.getPreNom());
            st.setString(3, r.getEmail());
            st.setString(4,r.getCity());
            st.setString(5,r.getMdp());
            st.executeUpdate();
        }catch (Exception exception){

        }
    }

    @Override
    public void updateUser(User r) {

    }

    @Override
    public void deleteUser(User r) {
        String strSql="DELETE FROM VISITEUR WHERE mail= ?";
        try{
            st = connexion.prepareStatement(strSql);
            st.setString(1, r.getEmail());
            st.executeUpdate();
        }catch (Exception exception){

        }

    }

    @Override
    public User getUserById(int idUser) {
        User user=null;
        String strSql="select * FROM VISITEUR WHERE id= ?";
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
        String strSql="select * FROM VISITEUR WHERE mail= ?";
        try{
            st = connexion.prepareStatement(strSql);
            st.setString(1, email);
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
    public Iterable<User> getAllUser() {
        List<User> userList=new ArrayList<>();
        String strSql="select * FROM VISITEUR";
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
        String name=re.getString("name");
        String firstname=re.getString("firstname");
        String mail=re.getString("mail");
        String city=re.getString("city");
        String password=re.getString("password");
        User user=new Visiteur(name,firstname,mail,city,password);
        return user;
    }
}
