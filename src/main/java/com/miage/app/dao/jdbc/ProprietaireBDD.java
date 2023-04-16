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
    protected User creatingObject(ResultSet re) {
        try{
            String name=re.getString("lastname");
            String firstname=re.getString("firstname");
            String mail=re.getString("email");
            String password=re.getString("password");
            User user=new Proprietaire(name,firstname,password,mail);
            return user;
        }catch (SQLException e) {
            System.out.println("Caught SQLException: " + e.getMessage());
        }
        return null;

    }

    @Override
    protected String getStatus() {
        return "proprietaire";
    }

    @Override
    public int getUserIdByMail(String email) {
        return super.getUserIdBymail(email);
    }
}
