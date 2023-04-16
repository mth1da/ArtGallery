package com.miage.app.dao.jdbc;


import com.miage.app.Entity.User;
import com.miage.app.dao.UserDAO;
import java.sql.*;

public abstract class UserBDD extends DAOContext implements UserDAO{

    @Override
    public void createUser(User r) {
        try{
            DAOContext.getConnect();
            String strSql="INSERT INTO USER (firstname,lastname,email,password,status) VALUES (?,?,?,?,?)";
            st = connexion.prepareStatement(strSql);
            st.setString(1, r.getPreNom());
            st.setString(2, r.getNom());
            st.setString(3, r.getEmail());
            st.setString(4,r.getMdp());
            st.setString(5,r.getType());
            st.executeQuery();
        }catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e){
                consoleLogger.writeError("Caught SQLException", e);
            }
        }
    }

    @Override
    public boolean getUserConnection(String email, String password) {
        try {
            DAOContext.getConnect();
            String strSql="select * FROM USER WHERE email= ? AND password= ?";
            st = connexion.prepareStatement(strSql);
            st.setString(1, email);
            st.setString(2, password);
            ResultSet re=st.executeQuery();
            if(re.next()) {
                return true;
            }
        }catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e){
                consoleLogger.writeError("Caught SQLException", e);
            }
        }
        return false;
    }

    public User getUserByMail(String email) {
        User user=null;
        String strSql="select * FROM USER WHERE email= ? AND STATUS= ?";
        try{
            DAOContext.getConnect();
            st = connexion.prepareStatement(strSql);
            st.setString(1, email);
            st.setString(2, this.getStatus());
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
            } catch (SQLException e){
                consoleLogger.writeError("Caught SQLException", e);
            }
        }
        return user;
    }

    protected abstract User creatingObject(ResultSet re) ;

    protected abstract String getStatus();

    public void updateUser(User r) {
        try {
            DAOContext.getConnect();
            String query="UPDATE user SET firstName=?, lastName=? WHERE email=? AND status=?";
            st = connexion.prepareStatement(query);
            st.setString(1, r.getPreNom());
            st.setString(2, r.getNom());
            st.setString(3, r.getEmail());
            st.setString(4, this.getStatus());
            st.executeUpdate();
        }catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e){
                consoleLogger.writeError("Caught SQLException", e);
            }
        }

    }

    public void deleteUser(User r) {
        try{
            DAOContext.getConnect();
            String strSql="DELETE FROM user WHERE email= ? AND status= ?";
            st = connexion.prepareStatement(strSql);
            st.setString(1, r.getEmail());
            st.setString(2, this.getStatus());
            st.executeUpdate();
        }catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e){
                consoleLogger.writeError("Caught SQLException", e);
            }
        }

    }

    public int getUserIdBymail(String email){
        int user=0;
        try{
            DAOContext.getConnect();
            String strSql="select idUser FROM USER WHERE email= ? AND status= ?";
            st = connexion.prepareStatement(strSql);
            st.setString(1, email);
            st.setString(2, this.getStatus());
            ResultSet re=st.executeQuery();
            while(re.next()){
                user= re.getInt("idUser");
            }
        }catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e){
                consoleLogger.writeError("Caught SQLException", e);
            }
        }
        return user;
    }

}
