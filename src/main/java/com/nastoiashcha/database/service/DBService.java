package com.nastoiashcha.database.service;

import com.nastoiashcha.database.User;

import java.util.List;

public interface DBService {
    List<User> getAllUsers();
    int addUser(String name);

    User getUserById(int id);

    void addScoreById(int id, int score);
}
