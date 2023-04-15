package com.miage.app.servlets;

import com.miage.app.dao.jdbc.OeuvreBDD;
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

            OeuvreBDD o = new OeuvreBDD();
            o.deleteOeuvre(id);

            response.sendRedirect("Oeuvres.jsp");
    }
}
