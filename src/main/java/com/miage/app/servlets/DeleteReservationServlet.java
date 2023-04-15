package com.miage.app.servlets;

import com.miage.app.Entity.Reservation;
import com.miage.app.dao.ReservationDAO;
import com.miage.app.dao.jdbc.ReservationBDD;
import com.miage.app.services.GestionReservation;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteReservatio", value = "/deleteReser")
public class DeleteReservationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idR=Integer.parseInt(request.getParameter("idRe"));
        ReservationDAO r=new ReservationBDD();
        GestionReservation ges=new GestionReservation(r);
        ges.deleteReservation(idR);
        response.sendRedirect("Reservation.jsp");
    }

}
