package com.miage.app;

import com.miage.app.dao.UserDAO;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lastName=request.getParameter("name");
        String email=request.getParameter("email");
        String firstName=request.getParameter("firstname");
        String city=request.getParameter("city");
        String password=request.getParameter("password");
        PrintWriter out =response.getWriter();
        out.println(lastName);
        out.println(email);
        out.println(firstName);
        out.println(city);
        out.println(password);
        String [] str=new String[5];
        str[0]=lastName;
        str[1]=firstName;
        str[2]=city;
        str[3]=password;
        str[4]=email;
        UserDAO ust=new UserRepository();
        Inscription v=new InscriptionVisiteur(str,ust);
        v.creeCompte();
        UserRepository av=new UserRepository();
        out.println(av.us.get(0));
    }
}
