package com.miage.app.servlets;

import com.miage.app.Entity.Reservation;
import com.miage.app.dao.ReservationDAO;
import com.miage.app.dao.UserDAO;
import com.miage.app.dao.jdbc.ProprietaireBDD;
import com.miage.app.dao.jdbc.ReservationBDD;
import com.miage.app.dao.jdbc.VisiteurBDD;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "buyExhibition", value = "/buyExb")
public class BuyExhibitionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int idE = Integer.parseInt(request.getParameter("idExibi"));
        HttpSession s=request.getSession();

        String userStatus = s.getAttribute("status").toString();
        String userEmail = s.getAttribute("currentUser").toString();

        UserDAO us = null;
        if(userStatus.equals("visiteur")){
            us = new VisiteurBDD();
        }else if(userStatus.equals("proprietaire")){
            us = new ProprietaireBDD();
        }

        int idUser = us.getUserIdByMail(userEmail);
        ReservationDAO reserva = new ReservationBDD();
        Reservation r = new Reservation(idUser,idE);

        reserva.createReservation(r);
        s.setAttribute("userId",idUser);

        response.sendRedirect("Reservation.jsp");
    }

}
