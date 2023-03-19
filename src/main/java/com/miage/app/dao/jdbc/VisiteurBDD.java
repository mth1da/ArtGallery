package com.miage.app.dao.jdbc;

import com.miage.app.Entity.User;
import com.miage.app.Entity.Visiteur;
import com.miage.app.services.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VisiteurBDD extends UserBDD{


    @Override
    public void deleteUser(User r) {
        String strSql="DELETE FROM user WHERE email= ? AND status= ?";
        try{
            DAOContext.getConnect();
            st = connexion.prepareStatement(strSql);
            st.setString(1, r.getEmail());
            st.setString(2, "visiteur");
            st.executeUpdate();
            DAOContext.getDeconnect();
        }catch (Exception ignored){

        }

    }

    public int getUserIdBymail(String email){
        int user=0;
        String strSql="select idUser FROM USER WHERE email= ? AND status= ?";
        try{
            DAOContext.getConnect();
            st = connexion.prepareStatement(strSql);
            st.setString(1, email);
            st.setString(2, "visiteur");
            ResultSet re=st.executeQuery();
            while(re.next()){
                user= re.getInt("id");
            }
            DAOContext.getDeconnect();
        }catch (Exception ignored){

        }
        return user;
    }

    @Override
    public User getUserByMail(String email) {
        User user=null;
        String strSql="select * FROM USER WHERE email= ? AND STATUS= ?";
        try{
            DAOContext.getConnect();
            st = connexion.prepareStatement(strSql);
            st.setString(1, email);
            st.setString(2, "visiteur");
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
    protected Iterable<User> getAllUserByStatus() {
        List<User> userList=new ArrayList<>();
        String strSql="select * FROM USER WHERE status= ?";
        try{
            DAOContext.getConnect();
            st = connexion.prepareStatement(strSql);
            st.setString(1, "visiteur");
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
    protected User creatingObject(ResultSet re) throws SQLException {
        String name=re.getString("lastname");
        String firstname=re.getString("firstname");
        String mail=re.getString("email");
        String password=re.getString("password");
        User user=new Visiteur(name,firstname,mail,password);
        return user;
    }

    @Override
    public void updateUser(User r) {
        String query="UPDATE user SET firstname=?, lastname=? WHERE email=? AND status=?";
        try {
            DAOContext.getConnect();
            st = connexion.prepareStatement(query);
            st.setString(1, r.getPreNom());
            st.setString(2, r.getNom());
            st.setString(3, r.getEmail());
            st.setString(4, "visiteur");
            st.executeUpdate();
            DAOContext.getDeconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
