package com.miage.app.services;

import com.miage.app.Entity.User;
import com.miage.app.dao.UserDAO;

public class UpdateProfileVisiteur implements UpdateProfile {
    private UserDAO userDAO;
    public UpdateProfileVisiteur(UserDAO userDAO){
        this.userDAO=userDAO;
    }
    @Override
    public void deleteAccount(User user, UserDAO userDAO) {

    }
    @Override
    public void updateUser(User user)
    {
        userDAO.updateUser(user);
    }

}
