package com.miage.app.dao.jdbc;

import com.miage.app.Entity.Proprietaire;
import com.miage.app.Entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            consoleLogger.writeError("Caught SQLException", e);
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
