package com.miage.app;

import com.miage.app.Entity.Artiste;
import com.miage.app.Entity.User;
import com.miage.app.Entity.Visiteur;
import com.miage.app.dao.CritiqueDAO;
import com.miage.app.dao.UserDAO;
import com.miage.app.dao.jdbc.CritiqueBDD;
import com.miage.app.dao.jdbc.UserBDD;

import java.util.List;

public class Main {
    public static void main(String[] args){
        UserDAO u=new UserBDD();
        User user=new Visiteur("kk","kkk","ivry","lefl@");
        UserDAO dao=new UserBDD();
    //    dao.createUser(user);
        dao.getUserById(1).displayUser();
      //  dao.deleteUser(user);
        Iterable<User> po=dao.getAllUser();
        for(User us:po){
            us.displayUser();
        }

    }
}
