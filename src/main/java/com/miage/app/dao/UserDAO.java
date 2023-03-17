package com.miage.app.dao;

import com.miage.app.Entity.Reservation;
import com.miage.app.Entity.User;

public interface UserDAO {

    public abstract void createUser(User r);

    public abstract void updateUser(User r);

    public abstract void deleteUser(User r);

    public abstract User getUserById(int id);

    public abstract User getUserByMail(String mail);

    public abstract Iterable<User> getAllUser();

}
