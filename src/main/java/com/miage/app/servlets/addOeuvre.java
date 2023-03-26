package com.miage.app.servlets;

import com.miage.app.Entity.User;
import com.miage.app.dao.UserDAO;
import com.miage.app.dao.jdbc.DAOContext;
import com.miage.app.dao.jdbc.ProprietaireBDD;
import com.miage.app.dao.jdbc.VisiteurBDD;
import com.miage.app.services.Connexion;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "addOeuvre", value = "/addOeuvre")
public class addOeuvre extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("AjoutOeuvre.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Connection con = DAOContext.getConnect();

            String title = request.getParameter("title");
            String name = request.getParameter("name");
            String lastName = request.getParameter("lastName");
            Double price = Double.valueOf(request.getParameter("price"));

            PreparedStatement ps = con.prepareStatement("INSERT INTO oeuvre (title, price) VALUES (?,?)");

            ps.setString(1, title);
            ps.setDouble(2, price);

            PreparedStatement pss = con.prepareStatement("INSERT INTO artiste (name, lastName) VALUES (?,?)");

            pss.setString(1, name);
            pss.setString(2,lastName);

            ps.executeUpdate();
            pss.executeUpdate();

            DAOContext.getDeconnect();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
