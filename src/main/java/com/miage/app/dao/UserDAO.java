package com.miage.app.dao;


import com.miage.app.Entity.User;

public interface UserDAO {

    public abstract void createUser(User r);

    public abstract void updateUser(User r);

    public abstract void deleteUser(User r);

    public abstract User getUserByMail(String mail);

    public abstract boolean getUserConnection(String email,String password);

    public abstract int getUserIdByMail(String email);
}
