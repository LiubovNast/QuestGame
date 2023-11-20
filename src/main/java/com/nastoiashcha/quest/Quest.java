package com.nastoiashcha.quest;

import jakarta.servlet.http.HttpSession;

public interface Quest {

    Question createQuest(HttpSession session);

    boolean checkAnswer(int questionId, String answer);
}
