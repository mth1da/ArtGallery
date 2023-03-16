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

        PrintWriter out = response.getWriter();

        String status = request.getParameter("status");
        out.println(status);

        /**String email=request.getParameter("email");
        String [] str=new String[5];
        str[0]=request.getParameter("name");
        str[1]=request.getParameter("firstname");
        str[2]=request.getParameter("status");
        str[3]=request.getParameter("password");
        str[4]=request.getParameter("email");
        UserDAO ust=new UserRepository();
        Inscription v=new InscriptionVisiteur(str,ust);
        v.creeCompte();**/
    }
}
