package com.miage.app.services;

import com.miage.app.Entity.User;
import com.miage.app.dao.UserDAO;

public interface UpdateProfile {

    public void deleteAccount(User user, UserDAO userDAO);

    public void updateUser(User user);

}
