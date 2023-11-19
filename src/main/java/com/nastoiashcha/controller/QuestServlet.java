package com.nastoiashcha.controller;

import com.nastoiashcha.database.User;
import com.nastoiashcha.database.service.DBService;
import com.nastoiashcha.database.service.DBServiceImpl;
import com.nastoiashcha.magic.MagicQuest;
import com.nastoiashcha.quest.Quest;
import com.nastoiashcha.quest.Question;
import com.nastoiashcha.service.QuestionListServiceImpl;
import com.nastoiashcha.service.QuestionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "QuestServlet", value = "/quest")
public class QuestServlet extends HttpServlet {

    DBService dbService = new DBServiceImpl();
    private final QuestionService questionService = new QuestionListServiceImpl();
    private final Quest quest = new MagicQuest();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession(true);
        String answer = req.getParameter("answer");
        int user_id = (int) currentSession.getAttribute("user");

        if (quest.isWin(answer)) {
            dbService.addScoreById(user_id, 5);

            currentSession.invalidate();
            User user = dbService.getUserById(user_id);
            setAttributeForEnd(req.getSession(true), user.getName() + ", You are winner!!!", true, user.getInfo());
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/end.jsp").forward(req, resp);
        }
        int id = (int) currentSession.getAttribute("id");
        if (quest.checkAnswer(id, answer)) {
            dbService.addScoreById(user_id, 2);
            id++;
            currentSession.setAttribute("id", id);
            Question question = questionService.getQuestById(id);
            currentSession.setAttribute("question", question.getQuestion());
            currentSession.setAttribute("variants", question.getVariants());
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/quest.jsp").forward(req, resp);
        } else {
            currentSession.invalidate();

            setAttributeForEnd(req.getSession(true), "This is end... or not!?", false, "");

            getServletContext().getRequestDispatcher("/WEB-INF/jsp/end.jsp").forward(req, resp);
        }
    }

    private void setAttributeForEnd(HttpSession session, String message, boolean isWin, String info) {
        if (isWin) {
            quest.addCustomSettings(info, session);
        }
        session.setAttribute("message", message);
        session.setAttribute("list", dbService.getAllUsers());
        questionService.getAllQuestion().clear();
    }
}
