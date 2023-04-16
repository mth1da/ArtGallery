package com.miage.app.servlets;

import com.miage.app.dao.OeuvreDAO;
import com.miage.app.dao.TypeOeuvreDAO;
import com.miage.app.dao.jdbc.OeuvreBDD;
import com.miage.app.dao.jdbc.TypeOeuvreBDD;
import com.miage.app.services.GestionOeuvres;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name="deleteTypeServlet", value="/delete-type")
public class DeleteTypeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id =Integer.parseInt(request.getParameter("id"));
        HttpSession s = request.getSession();
        TypeOeuvreDAO type = new TypeOeuvreBDD();

        type.deleteType(id);

        response.sendRedirect("types.jsp");
    }
}
