package com.miage.app.servlets;

import com.miage.app.dao.jdbc.DAOContext;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "deleteOeuvre", value = "/deleteOeuvre")
public class deleteOeuvre extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("SuppOeuvre.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection con = DAOContext.getConnect();

            int id =Integer.parseInt(request.getParameter("id"));

            PreparedStatement ps = con.prepareStatement("DELETE FROM oeuvre WHERE idOeuvre=?");

            ps.setInt(1, id);

            ps.executeUpdate();

            response.sendRedirect("Oeuvres.jsp");

            DAOContext.getDeconnect();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
