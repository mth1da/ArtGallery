package com.miage.app.servlets;

import com.miage.app.dao.TypeOeuvreDAO;
import com.miage.app.dao.jdbc.TypeOeuvreBDD;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name="addTypeServlet", value="/add-type")
public class AddTypeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession s = request.getSession();
        TypeOeuvreDAO type = new TypeOeuvreBDD();

        String name = request.getParameter("nom_type");
        String description = request.getParameter("description");

        type.createType(name, description);

        response.sendRedirect("types.jsp");
    }
}
