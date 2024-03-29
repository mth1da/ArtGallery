package com.miage.app.dao.repository;


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
        us.remove(r);
    }

    @Override
    public User getUserByMail(String mail) {
        User user=null;
        for(User currUser : us){
            if(currUser.getEmail().equals(mail)){
                user=currUser;
            }
        }
        return user;
    }

    @Override
    public boolean getUserConnection(String email, String password) {
        return true;
    }

    @Override
    public int getUserIdByMail(String email) {
        return 0;
    }
}
