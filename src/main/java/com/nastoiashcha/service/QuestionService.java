package com.nastoiashcha.service;

import com.nastoiashcha.quest.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestion();

    Question getQuestById(int id);

    void addQuestion(Question question);
}
