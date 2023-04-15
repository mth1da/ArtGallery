package com.miage.app.servlets;

import com.miage.app.dao.OeuvreDAO;
import com.miage.app.dao.jdbc.OeuvreBDD;
import com.miage.app.services.GestionOeuvres;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "deleteOeuvre", value = "/deleteOeuvre")
public class deleteOeuvre extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("SuppOeuvre.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

            int id =Integer.parseInt(request.getParameter("id"));
            OeuvreDAO o = new OeuvreBDD();
            GestionOeuvres ges = new GestionOeuvres(o, null);

            ges.suppOeuvre(id);

            response.sendRedirect("Oeuvres.jsp");
    }
}
