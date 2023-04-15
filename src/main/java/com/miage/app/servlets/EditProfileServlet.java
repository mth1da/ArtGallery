package com.miage.app.servlets;

import com.miage.app.Entity.User;
import com.miage.app.dao.UserDAO;
import com.miage.app.dao.jdbc.ProprietaireBDD;
import com.miage.app.dao.jdbc.UserBDD;
import com.miage.app.dao.jdbc.VisiteurBDD;
import com.miage.app.services.*;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "editProfile", urlPatterns = "/editservlet")
public class EditProfileServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        // fetch all data
        HttpSession s = request.getSession();

        String userFistName = request.getParameter("firstname");
        String userLastName = request.getParameter("lastname");
        String userStatus = s.getAttribute("status").toString();
        String userEmail = s.getAttribute("currentUser").toString();

        UserDAO userDAO = null;
        User user = null;

        //update database....
        if(userStatus.equals("visiteur")){
            userDAO = new VisiteurBDD();
        }else if(userStatus.equals("proprietaire")){
            userDAO = new ProprietaireBDD();
        }

        user = userDAO.getUserByMail(userEmail);

        user.setNom(userLastName);
        user.setPrenom(userFistName);

        UpdateProfile update = new UpdateProfile(userDAO);
        update.updateUser(user);

        response.sendRedirect("Home.jsp");
    }
}

