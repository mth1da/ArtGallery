package com.miage.app;

import com.miage.app.dao.UserDAO;
import com.miage.app.dao.jdbc.DAOContext;
import com.miage.app.dao.jdbc.UserBDD;
import com.miage.app.dao.repository.UserRepository;
import com.miage.app.services.Inscription;
import com.miage.app.services.InscriptionVisiteur;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;




@WebServlet(name = "Servlet", urlPatterns = "/servlet")
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getParameter("status");
        String [] str=new String[4];
        str[0]=request.getParameter("name");
        str[1]=request.getParameter("firstname");
        str[2]=request.getParameter("password");
        str[3]=request.getParameter("email");
        PrintWriter out = response.getWriter();
        out.println(str[0]);
        out.println(str[1]);
        out.println(str[2]);
        out.println(str[3]);
        out.println(status);
        UserDAO ust=new UserBDD();
        Inscription v=new InscriptionVisiteur(str,ust);
        v.creeCompte();
    }
}
