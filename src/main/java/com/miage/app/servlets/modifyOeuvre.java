package com.miage.app.servlets;

import com.miage.app.dao.jdbc.DAOContext;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("modifyOeuvre.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection con = DAOContext.getConnect();

            int id =Integer.parseInt(request.getParameter("id"));

            String title = request.getParameter("title");
            Double price = Double.valueOf(request.getParameter("price"));


            PreparedStatement ps = con.prepareStatement("UPDATE oeuvre SET title=?, price=? WHERE idOeuvre=?");

            ps.setString(1, title);
            ps.setDouble(2, price);
            ps.setInt(3, id);

            ps.executeUpdate();

            PrintWriter out = response.getWriter();
            out.println(id);

            //response.sendRedirect("Oeuvres.jsp");

            DAOContext.getDeconnect();

            out.println(title);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
