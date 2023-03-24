package com.miage.app.dao.jdbc;

import com.miage.app.Entity.User;
import com.miage.app.Entity.Visiteur;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VisiteurBDD extends UserBDD{

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
}
