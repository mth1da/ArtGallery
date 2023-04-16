package com.miage.app.servlets;

import com.miage.app.Entity.User;
import com.miage.app.dao.UserDAO;
import com.miage.app.dao.jdbc.ProprietaireBDD;
import com.miage.app.dao.jdbc.VisiteurBDD;
import com.miage.app.services.Connexion;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidParameterException;

@WebServlet(name = "UserServlet", value = "/loginuser")
public class LoginUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        try{
            String status=request.getParameter("status");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            UserDAO userDAO=null;
            try{
                if(status.equals("visiteur")){
                    userDAO=new VisiteurBDD();
                }else if(status.equals("proprietaire")){
                    userDAO=new ProprietaireBDD();
                }
            } catch(IllegalArgumentException e){
                System.out.println("Caught Exception: " + e.getMessage());
            }

            Connexion con=new Connexion(userDAO);
            String rep=con.connexionValide(email,password);
            if(rep.equals("")){
                try{
                    out.println("Connexion réussie");
                    HttpSession s=request.getSession();
                    s.setAttribute("currentUser",email);
                    s.setAttribute("status",status);
                    s.setAttribute("userId",userDAO.getUserIdByMail(email));
                    out.println(s.getAttribute("userId"));
                    response.sendRedirect("Home.jsp");
                } catch (NullPointerException e){
                    System.out.println("Caught Exception: " + e.getMessage());
                }

            }else{
                out.println(rep);
            }
        } catch (InvalidParameterException e){
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}

