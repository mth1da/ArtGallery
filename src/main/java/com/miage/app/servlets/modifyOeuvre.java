package com.miage.app.servlets;

import com.miage.app.dao.OeuvreDAO;
import com.miage.app.dao.jdbc.OeuvreBDD;
import com.miage.app.services.GestionOeuvres;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

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

            OeuvreDAO o = new OeuvreBDD();
            GestionOeuvres ges = new GestionOeuvres(o,null);

            ges.modifOeuvre(title, price, id);

            response.sendRedirect("Oeuvres.jsp");

    }
}
