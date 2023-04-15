package com.miage.app.services;

import com.miage.app.dao.UserDAO;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Connexion {

    public abstract  String connexionValide(String email,String mdp);

    public abstract boolean mdpValide(String email,String mdp);
    public abstract boolean verifCompteExiste(String email);

}
