package com.nastoiashcha.database;

import java.util.ArrayList;
import java.util.List;

public class DBList {
    private static List<User> users;
    private DBList() {
        users = new ArrayList<>();
    }

    public static List<User> getDBList() {
        if (users == null) {
            new DBList();
        }
        return users;
    }
}
