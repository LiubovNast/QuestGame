package com.nastoiashcha.database;

import com.nastoiashcha.quest.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestList {

    private static List<Question> questions;
    private QuestList() {
        questions = new ArrayList<>();
    }

    public static List<Question> getQuestions() {
        if (questions == null) {
            new QuestList();
        }
        return questions;
    }
}
