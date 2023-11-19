package com.nastoiashcha.service;

import com.nastoiashcha.database.QuestList;
import com.nastoiashcha.quest.Question;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuestionListServiceImplTest {
private static final QuestionService questionService = new QuestionListServiceImpl();

    @BeforeAll
    static void setUp() {
        for (int i = 0; i< 10; i++) {
            questionService.addQuestion(new Question(i,
                    "quest" + i,
                    Collections.singletonList("variants"),
                    "answer" + i,
                    i + 1));
        }
    }

    @Test
    void getAllQuestion() {
        List<Question> dbListQuest = QuestList.getQuestions();
        List<Question> questions = questionService.getAllQuestion();
        assertEquals(dbListQuest, questions);
        assertEquals(dbListQuest.size(), questions.size());
    }

    @Test
    void getQuestById() {
        for (int i = 0; i< 10; i++) {
            Question question = questionService.getQuestById(i);
            assertEquals("quest" + i, question.getQuestion());
            assertEquals("answer" + i, question.getAnswer());
            assertEquals(i + 1, question.getNextId());
        }
    }

    @ParameterizedTest
    @CsvSource({
            "Some questions, first, first, 2",
            "Second questions, second, second, 3",
            "Third questions, third, third, 4"
    })
    void addQuestion(String quest, String variant, String answer, int nextId) {
        List<String> variants = Collections.singletonList(variant);
        int id = questionService.getAllQuestion().size();
        Question question = new Question(id, quest, variants, answer, nextId);
        questionService.addQuestion(question);
        Question expectedQuestion = questionService.getQuestById(id);
        assertEquals(question, expectedQuestion);
        assertEquals(question.getQuestion(), expectedQuestion.getQuestion());
        assertEquals(question.getAnswer(), expectedQuestion.getAnswer());
        assertEquals(question.getNextId(), expectedQuestion.getNextId());
    }
}