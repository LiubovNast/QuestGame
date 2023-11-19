package com.nastoiashcha.controller;

import com.nastoiashcha.database.service.DBService;
import com.nastoiashcha.database.service.DBServiceImpl;
import com.nastoiashcha.magic.MagicQuest;
import com.nastoiashcha.quest.Quest;
import com.nastoiashcha.quest.Question;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(name = "InitServlet", value = "/")
public class InitServlet extends HttpServlet {
    private final int START_ID = 0;
    private final Quest quest = new MagicQuest();

    private final DBService dbService = new DBServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession(true);
        currentSession.setAttribute("message", "This is restart page");
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession(true);

        String name = req.getParameter("name");

        int id = dbService.addUser(name);

        currentSession.setAttribute("user", id);

        Question question = quest.createNextQuestion(START_ID, name, currentSession);

        currentSession.setAttribute("question", question.getQuestion());
        currentSession.setAttribute("id", question.getId());
        currentSession.setAttribute("variants", question.getVariants());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/quest.jsp").forward(req, resp);
    }
}
