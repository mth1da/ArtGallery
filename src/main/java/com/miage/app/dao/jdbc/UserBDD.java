package com.miage.app.dao.jdbc;


import com.miage.app.Entity.User;
import com.miage.app.dao.UserDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class UserBDD extends DAOContext implements UserDAO{

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
        }catch (SQLException e){
            System.out.println("Caught SQLException: " + e.getMessage());
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e) {
                System.out.println("Caught SQLException: " + e.getMessage());
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
            System.out.println("Caught SQLException: " + e.getMessage());
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e) {
                System.out.println("Caught SQLException: " + e.getMessage());
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
            System.out.println("Caught SQLException: " + e.getMessage());
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e) {
                System.out.println("Caught SQLException: " + e.getMessage());
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
            System.out.println("Caught SQLException: " + e.getMessage());
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e) {
                System.out.println("Caught SQLException: " + e.getMessage());
            }
        }
        return true;
    }

    protected abstract Iterable<User> getAllUserByStatus();

    protected abstract User creatingObject(ResultSet re);


}
