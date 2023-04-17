package com.miage.app.dao;


import com.miage.app.Entity.User;

public interface UserDAO {

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    User getUserByMail(String mail);

    boolean getUserConnection(String email,String password);

    int getUserIdByMail(String email);
}
