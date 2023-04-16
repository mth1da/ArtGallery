package com.miage.app.dao.jdbc;

import com.miage.app.Entity.User;
import com.miage.app.Entity.Visiteur;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VisiteurBDD extends UserBDD{

    @Override
    public void updateUser(User r) {
        System.out.println(r.getPreNom());
        System.out.println(r.getNom());
        System.out.println(r.getEmail());

        try {
            //connexion
            DAOContext.getConnect();

            String query="UPDATE user SET firstName=?, lastName=? WHERE email=? AND status=?";
            st = connexion.prepareStatement(query);
            st.setString(1, r.getPreNom());
            st.setString(2, r.getNom());
            st.setString(3, r.getEmail());
            st.setString(4, "visiteur");
            st.executeUpdate();
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

    }
    @Override
    public void deleteUser(User r) {
        try{
            //connexion
            DAOContext.getConnect();

            String query="DELETE FROM user WHERE email= ? AND status= ?";
            st = connexion.prepareStatement(query);
            st.setString(1, r.getEmail());
            st.setString(2, "visiteur");
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

    public int getUserIdBymail(String email){
        int user=0;
        try{
            //connexion
            DAOContext.getConnect();

            String query="select idUser FROM user WHERE email= ? AND status= ?";
            st = connexion.prepareStatement(query);
            st.setString(1, email);
            st.setString(2, "visiteur");
            ResultSet re=st.executeQuery();
            while(re.next()){
                user= re.getInt("idUser");
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
        return user;
    }


    @Override
    public User getUserByMail(String email) {
        User user=null;
        try{
            //connexion
            DAOContext.getConnect();

            String query="select * FROM USER WHERE email= ? AND STATUS= ?";
            st = connexion.prepareStatement(query);
            st.setString(1, email);
            st.setString(2, "visiteur");
            ResultSet re=st.executeQuery();
            while(re.next()){
                user=creatingObject(re);
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
        return user;
    }


    @Override
    protected Iterable<User> getAllUserByStatus() {
        List<User> userList=new ArrayList<>();
        try{
            //connexion
            DAOContext.getConnect();

            String query="select * FROM USER WHERE status= ?";
            st = connexion.prepareStatement(query);
            st.setString(1, "visiteur");
            ResultSet re=st.executeQuery();
            while(re.next()){
                User user=creatingObject(re);
                userList.add(user);
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
        return userList;
    }

    @Override
    protected User creatingObject(ResultSet re) throws SQLException {
        String name=re.getString("lastname");
        String firstname=re.getString("firstname");
        String mail=re.getString("email");
        String password=re.getString("password");
        User user=new Visiteur(name,firstname,password,mail);
        return user;
    }

    @Override
    protected String getStatus() {
        return "visiteur";
    }

    @Override
    public int getUserIdByMail(String email) {
        return super.getUserIdBymail(email);
    }

}
