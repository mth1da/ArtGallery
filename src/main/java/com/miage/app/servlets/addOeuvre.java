package com.miage.app.servlets;

import com.miage.app.Entity.Artiste;
import com.miage.app.dao.jdbc.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "addOeuvre", value = "/addOeuvre")
public class addOeuvre extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("AjoutOeuvre.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

            HttpSession s=request.getSession();
            int userID=Integer.parseInt(s.getAttribute("userId").toString());
            ArtisteBDD artiste = new ArtisteBDD();
            OeuvreBDD o = new OeuvreBDD();

            String title = request.getParameter("title");
            String name = request.getParameter("name");
            String lastName = request.getParameter("lastName");
            Double price = Double.valueOf(request.getParameter("price"));

            Artiste art = artiste.getIdByNameAndLastName(name, lastName);

            if(art == null) {
                artiste.createArtiste(name, lastName);
            }

            art = artiste.getIdByNameAndLastName(name, lastName);
            o.createOeuvre(title, userID, art, price);

            response.sendRedirect("Oeuvres.jsp");
    }
}
