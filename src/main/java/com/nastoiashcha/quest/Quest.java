package com.nastoiashcha.quest;

import jakarta.servlet.http.HttpSession;

public interface Quest {

    Question createNextQuestion(int questionId, String answer, HttpSession session);

    boolean isWin(String answer);

    boolean checkAnswer(int questionId, String answer);

    void addCustomSettings(String info, HttpSession session);
}
