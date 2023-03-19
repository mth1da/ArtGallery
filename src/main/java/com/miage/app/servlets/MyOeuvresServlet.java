package com.miage.app.servlets;

import com.miage.app.Entity.Oeuvre;
import com.miage.app.Entity.User;
import com.miage.app.dao.OeuvreDAO;
import com.miage.app.dao.UserDAO;
import com.miage.app.dao.jdbc.OeuvreBDD;
import com.miage.app.dao.jdbc.ProprietaireBDD;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "oeuvresServlet", value = "/oeuvres")
public class MyOeuvresServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("ijijdfij");
        HttpSession s=request.getSession();
        String userEmail = s.getAttribute("currentUser").toString();
        UserDAO userDAO=new ProprietaireBDD();
        User us=userDAO.getUserByMail(userEmail);
        OeuvreDAO oe=new OeuvreBDD();
        response.sendRedirect("Oeuvres.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
