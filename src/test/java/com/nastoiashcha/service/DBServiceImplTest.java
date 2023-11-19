package com.nastoiashcha.service;

import com.nastoiashcha.database.User;
import com.nastoiashcha.database.service.DBService;
import com.nastoiashcha.database.service.DBServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DBServiceImplTest {

    private static final DBService dbService = new DBServiceImpl();

    @Test
    void getAllUsers() {
        List<User> users = dbService.getAllUsers();
        assertNotNull(users);
    }

    @Test
    void addUser() {
    }

    @Test
    void getUserById() {
    }

    @Test
    void addScoreById() {
    }
}