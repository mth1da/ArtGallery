package com.miage.app;

import com.miage.app.dao.UserDAO;
import com.miage.app.dao.jdbc.DAOContext;
import com.miage.app.dao.jdbc.ProprietaireBDD;
import com.miage.app.dao.jdbc.VisiteurBDD;
import com.miage.app.services.Connexion;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name="LoginServlet",urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>");
        out.println("</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("Hello I am your Servlet ");
        out.println("</body>");
        out.println("</html>");
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
        Connexion con=new Connexion(userDAO);
        String rep=con.connexionValide(email,password);
        if(rep.equals("")){
            out.println("Connexion réussi");
            response.sendRedirect("Home.jsp");
        }else{
            out.println(rep);
        }

    }
}
