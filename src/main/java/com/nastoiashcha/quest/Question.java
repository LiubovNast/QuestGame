package com.nastoiashcha.quest;

import java.util.List;

public class Question {
    private final int id;
    private final String question;

    private final List<String> variants;

    private final String answer;
    

    private final int nextId;

    public Question(int id, String question, List<String> variants, String answer, int nextId) {
        this.id = id;
        this.question = question;
        this.variants = variants;
        this.answer = answer;
        this.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getVariants() {
        return variants;
    }

    public String getAnswer() {
        return answer;
    }

    public int getNextId() {
        return nextId;
    }
}
