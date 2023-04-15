package com.miage.app.servlets;

import com.miage.app.dao.ReservationDAO;
import com.miage.app.dao.jdbc.ReservationBDD;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteReservatio", value = "/deleteReser")
public class DeleteReservationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ReservationDAO re = new ReservationBDD();
        int idR = Integer.parseInt(request.getParameter("idRe"));

        re.deleteReservation(idR);
        
        response.sendRedirect("Reservation.jsp");
    }

}
