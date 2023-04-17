package com.miage.app.servlets;

import com.miage.app.dao.UserDAO;
import com.miage.app.dao.jdbc.ProprietaireBDD;
import com.miage.app.dao.jdbc.VisiteurBDD;
import com.miage.app.services.Connexion;
import com.miage.app.services.ConnexionLocal;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "UserServlet", value = "/loginuser")
public class LoginUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String status=request.getParameter("status");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserDAO userDAO=null;
        if(status.equals("visiteur")){
            userDAO=new VisiteurBDD();
        }else if(status.equals("proprietaire")){
            userDAO=new ProprietaireBDD();
        }
        Connexion con=new ConnexionLocal(userDAO);
        String rep=con.connexionValide(email,password);
        if(!rep.startsWith("!Erreur")){
            out.println("Connexion réussi");
            HttpSession s=request.getSession();
            s.setAttribute("currentUser",email);
            s.setAttribute("status",status);
            s.setAttribute("userId",Integer.parseInt(rep));
           // out.println(s.getAttribute("currentUser"));
            response.sendRedirect("Home.jsp");
        }else{
            out.println(rep);
        }

    }
}

