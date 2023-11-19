package com.nastoiashcha.controller;

import com.nastoiashcha.database.service.DBService;
import com.nastoiashcha.database.service.DBServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(name = "EndServlet", value = "/end")
public class EndServlet extends HttpServlet {
    DBService dbService = new DBServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession(true);
        currentSession.invalidate();

        req.getSession(true).setAttribute("list", dbService.getAllUsers());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/end.jsp").forward(req, resp);
    }
}
