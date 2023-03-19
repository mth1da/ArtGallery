package com.miage.app.services;

import com.miage.app.Entity.User;
import com.miage.app.dao.UserDAO;

public class UpdateProfile {

    private final UserDAO userDAO;
    public UpdateProfile(UserDAO userDAO){
        this.userDAO=userDAO;
    }

    public void deleteAccount(User user, UserDAO userDAO) {

    }


    public void updateUser(User user) {
        this.userDAO.updateUser(user);
    }

}