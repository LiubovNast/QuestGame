package com.nastoiashcha.database.service;

import com.nastoiashcha.database.DBList;
import com.nastoiashcha.database.User;

import java.util.List;

public class DBServiceImpl implements DBService {

    @Override
    public List<User> getAllUsers() {
        return DBList.getDBList();
    }

    @Override
    public int addUser(String name) {
        List<User> users = getAllUsers();
        int size = users.size();
        User user = new User(name, size + 1);
        DBList.getDBList().add(user);
        return size + 1;
    }

    @Override
    public User getUserById(int id) {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (user.getId() == id) return user;
        }
        return null;
    }

    @Override
    public void addScoreById(int id, int score) {
        User user = getUserById(id);
        DBList.getDBList().remove(user);
        if (user != null) {
            user.setScore(user.getScore() + score);
        }
        DBList.getDBList().add(user);
    }
}
