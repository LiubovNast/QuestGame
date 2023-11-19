package com.nastoiashcha.service;

import com.nastoiashcha.database.QuestList;
import com.nastoiashcha.quest.Question;

import java.util.List;


public class QuestionListServiceImpl implements QuestionService {
    @Override
    public List<Question> getAllQuestion() {
        return QuestList.getQuestions();
    }

    @Override
    public Question getQuestById(int id) {
        List<Question> list = getAllQuestion();
        for (Question quest : list
        ) {
            if (quest.getId() == id) {
                return quest;
            }
        }
        return null;
    }

    @Override
    public void addQuestion(Question question) {
        QuestList.getQuestions().add(question);
    }
}
