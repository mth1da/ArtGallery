package com.miage.app.servlets;

import com.miage.app.dao.jdbc.DAOContext;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "modifyOeuvre", value = "/modifyOeuvre")
public class modifyOeuvre extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("modifyOeuvre.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection con = DAOContext.getConnect();

            HttpSession s=request.getSession();

            int userID=Integer.parseInt(s.getAttribute("userId").toString());

            String title = request.getParameter("title");
            String name = request.getParameter("name");
            String lastName = request.getParameter("lastName");
            Double price = Double.valueOf(request.getParameter("price"));


            PreparedStatement ps = con.prepareStatement("INSERT INTO oeuvre (title, idUser, price) VALUES (?,?,?)");

            ps.setString(1, title);
            ps.setInt(2, userID);
            ps.setDouble(3, price);

            PreparedStatement pss = con.prepareStatement("INSERT INTO artiste (name, lastName) VALUES (?,?)");

            pss.setString(1, name);
            pss.setString(2,lastName);

            ps.executeUpdate();
            pss.executeUpdate();

            response.sendRedirect("Oeuvres.jsp");

            DAOContext.getDeconnect();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
