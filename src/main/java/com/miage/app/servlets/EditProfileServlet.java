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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>EditProfileServlet</title>");
            out.println("</head>");
            out.println("<body>");

            // fetch all data
            String userFistName = request.getParameter("firstname");
            String userLastName = request.getParameter("lastname");
            String userPassword = request.getParameter("password");
            String userStatus = request.getParameter("status");

            //get the user from the session...
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("currentUser");
            user.setNom(userLastName);
            user.setPrenom(userFistName);
            user.setMdp(userPassword);


            //update database....
            if(userStatus.equals("visiteur")){
                UserDAO userr=new VisiteurBDD();
                UpdateProfile update=new UpdateProfileVisiteur(userr);
                //update.updateUser();
            }else if(userStatus.equals("proprietaire")){
                UserDAO userr=new ProprietaireBDD();
                UpdateProfile update=new UpdateProfileProprietaire(userr);
                //update.updateUser(userr);
            }



            out.println("</body>");
            out.println("</html>");
        }
    }
}
