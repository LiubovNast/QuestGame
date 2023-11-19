package com.nastoiashcha.database;

public class User {
    private final int id;
    private final String name;

    private int score;

    private String info;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
        this.info = "";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
