package com.miage.app.dao.repository;

import com.miage.app.Entity.Reservation;
import com.miage.app.Entity.User;
import com.miage.app.dao.UserDAO;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements UserDAO {
    public static List<User> us=new ArrayList<>();
    @Override
    public void createUser(User r) {
        us.add(r);
    }

    @Override
    public void updateUser(User r) {

    }

    @Override
    public void deleteUser(User r) {

    }

    @Override
    public Reservation getUserById(int id) {
        return null;
    }

    @Override
    public Iterable<Reservation> getAllUser() {
        return null;
    }
}
