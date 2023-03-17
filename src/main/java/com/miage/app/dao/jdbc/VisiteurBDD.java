package com.miage.app.dao.jdbc;

import com.miage.app.Entity.User;
import com.miage.app.Entity.Visiteur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VisiteurBDD extends UserBDD{


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