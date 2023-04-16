package com.miage.app.servlets;

import com.miage.app.Entity.Artiste;
import com.miage.app.dao.ArtisteDAO;
import com.miage.app.dao.jdbc.*;
import com.miage.app.services.GestionOeuvres;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "addOeuvre", value = "/addOeuvre")
public class addOeuvre extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("AjoutOeuvre.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
            HttpSession s = request.getSession();
            int userID=Integer.parseInt(s.getAttribute("userId").toString());
            ArtisteDAO artiste = new ArtisteBDD();
            OeuvreBDD o = new OeuvreBDD();
            GestionOeuvres ges = new GestionOeuvres(o, artiste);

            String title = request.getParameter("title");
            String name = request.getParameter("name");
            String lastName = request.getParameter("lastName");
            Double price = Double.valueOf(request.getParameter("price"));

            Artiste art = artiste.getIdByNameAndLastName(name, lastName);
            ges.addArtiste(art, name, lastName);

            art = artiste.getIdByNameAndLastName(name, lastName);
            ges.creerOeuvre(title, userID, art, price);
            out.println(userID);
            response.sendRedirect("Oeuvres.jsp");
    }
}
