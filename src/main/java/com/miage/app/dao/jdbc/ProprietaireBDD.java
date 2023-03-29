package com.miage.app.dao.jdbc;

import com.miage.app.Entity.Proprietaire;
import com.miage.app.Entity.User;
import com.miage.app.Entity.Visiteur;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProprietaireBDD extends UserBDD{

    @Override
    public void updateUser(User r) {
        try {
            //connexion
            DAOContext.getConnect();

            String query="UPDATE user SET firstname=?, lastname=? WHERE email=? AND status=?";
            st = connexion.prepareStatement(query);

            st.setString(1, r.getPreNom());
            st.setString(2, r.getNom());
            st.setString(3, r.getEmail());
            st.setString(4, "proprietaire");

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
            st.setString(2, "proprietaire");
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

            String query="select idUser FROM USER WHERE email= ? AND status= ?";
            st = connexion.prepareStatement(query);
            st.setString(1, email);
            st.setString(2, "proprietaire");
            ResultSet re=st.executeQuery();
            while(re.next()){
                user= re.getInt("idUser");
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
    public User getUserByMail(String email) {
        User user=null;
        try{
            //connexion
            DAOContext.getConnect();

            String query="select * FROM USER WHERE email= ? AND status= ?";
            st = connexion.prepareStatement(query);
            st.setString(1, email);
            st.setString(2, "proprietaire");
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
    protected Iterable<User> getAllUserByStatus() {
        List<User> userList=new ArrayList<>();
        try{
            DAOContext.getConnect();

            String query="select * FROM USER WHERE status= ?";
            st = connexion.prepareStatement(query);

            st.setString(1, "proprietaire");
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
    protected User creatingObject(ResultSet re)  {
        try{
            String name=re.getString("lastname");
            String firstname=re.getString("firstname");
            String mail=re.getString("email");
            String password=re.getString("password");
            User user=new Visiteur(name,firstname,password,mail);
            return user;
        }catch (SQLException e) {
            System.out.println("Caught SQLException: " + e.getMessage());
        }
        return null;
    }

    public static void main(String[] arg){
        User u=new Proprietaire("merr","mere","azerty","naloufi.amel@gmail.com");
        UserBDD bdd=new ProprietaireBDD();

        bdd.updateUser(u);

    }


}
