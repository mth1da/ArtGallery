package com.miage.app.servlets;

import com.miage.app.dao.jdbc.DAOContext;
import com.miage.app.dao.jdbc.OeuvreBDD;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "modifyOeuvre", value = "/modifyOeuvre")
public class modifyOeuvre extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("modifyOeuvre.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

            int id =Integer.parseInt(request.getParameter("id"));

            String title = request.getParameter("title");
            Double price = Double.valueOf(request.getParameter("price"));

            OeuvreBDD o = new OeuvreBDD();
            o.updateOeuvre(title, price, id);

            response.sendRedirect("Oeuvres.jsp");

    }
}
