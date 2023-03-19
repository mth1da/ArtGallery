package com.miage.app.services;

import com.miage.app.Entity.User;
import com.miage.app.dao.UserDAO;

public class UpdateProfile {

    private UserDAO userDAO;
    public UpdateProfile(UserDAO userDAO){
        this.userDAO=userDAO;
    }

    public void deleteAccount(User user, UserDAO userDAO) {

    }


    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

}
