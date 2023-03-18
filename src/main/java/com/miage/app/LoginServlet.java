package com.miage.app;

import com.miage.app.dao.jdbc.DAOContext;
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

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {

            DAOContext.getConnect();
            //Charger le driver mysql
            Class.forName("com.mysql.jdbc.Driver");

            //Création de la connexion
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/artGallery","root","");

            //Préparer l'état de connexion
            PreparedStatement stm;
            String strSql="select * FROM USER WHERE email=? AND password=? ";

            stm = con.prepareStatement(strSql);
            stm.setString(1, email);
            stm.setString(2, password);

            ResultSet re=stm.executeQuery();

            //Vérifie si l'email et le mot de passe correspondent
            Connexion.connexionValide(response, re);

            out.println("Mot de passe et email incorrects...");

            //ici on ferme la connection
            con.close();

        } catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
