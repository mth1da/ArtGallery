package com.miage.app;

import com.miage.app.dao.UserDAO;
import com.miage.app.dao.jdbc.DAOContext;
import com.miage.app.dao.jdbc.ProprietaireBDD;
import com.miage.app.dao.jdbc.UserBDD;
import com.miage.app.dao.jdbc.VisiteurBDD;
import com.miage.app.dao.repository.UserRepository;
import com.miage.app.services.Inscription;
import com.miage.app.services.InscriptionProprietaire;
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
        if(status.equals("visiteur")){
            UserDAO ust=new VisiteurBDD();
            Inscription v=new InscriptionVisiteur(str,ust);
            v.creeCompte();
        }else if(status.equals("proprietaire")){
            UserDAO ust=new ProprietaireBDD();
            Inscription v=new InscriptionProprietaire(str,ust);
            v.creeCompte();
        }

    }
}
