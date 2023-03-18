package com.miage.app;

import com.miage.app.dao.UserDAO;
import com.miage.app.dao.jdbc.ProprietaireBDD;
import com.miage.app.services.Inscription;
import com.miage.app.services.InscriptionProprietaire;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "ServletUser", urlPatterns = "/svUser")
public class SignupServletUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String [] str=new String[4];
        str[0]=request.getParameter("name");
        str[1]=request.getParameter("firstname");
        str[2]=request.getParameter("password");
        str[3]=request.getParameter("email");
        String status=request.getParameter("status");
        String rep="";
        UserDAO ust=null;
        Inscription v=null;
        if(status.equals("visiteur")){
            ust=new ProprietaireBDD();
            v=new InscriptionProprietaire(str,ust);
        }else if(status.equals("proprietaire")){
            ust=new ProprietaireBDD();
            v=new InscriptionProprietaire(str,ust);
        }
        rep=v.creeCompte();
        PrintWriter out = response.getWriter();
        out.println(rep);
    }
}
