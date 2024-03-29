package com.miage.app.servlets;

import com.miage.app.dao.ReservationDAO;
import com.miage.app.dao.jdbc.ReservationBDD;
import com.miage.app.services.GestionReservation;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "buyExhibition", value = "/buyExb")
public class BuyExhibitionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idE=Integer.parseInt(request.getParameter("idExibi"));
        HttpSession s=request.getSession();
        int userID=Integer.parseInt(s.getAttribute("userId").toString());
        ReservationDAO reserva=new ReservationBDD();
        GestionReservation ges=new GestionReservation(reserva);
        System.out.println(userID+" "+idE);
        ges.buyExhibition(idE,userID,new Date());
        response.sendRedirect("Reservation.jsp");
    }

}