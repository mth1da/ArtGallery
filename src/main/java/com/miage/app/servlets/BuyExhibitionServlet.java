package com.miage.app.servlets;

import com.miage.app.Entity.Reservation;
import com.miage.app.dao.ReservationDAO;
import com.miage.app.dao.UserDAO;
import com.miage.app.dao.jdbc.ProprietaireBDD;
import com.miage.app.dao.jdbc.ReservationBDD;
import com.miage.app.dao.jdbc.UserBDD;
import com.miage.app.dao.jdbc.VisiteurBDD;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@WebServlet(name = "buyExhibition", value = "/buyExb")
public class BuyExhibitionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        int idE=Integer.parseInt(request.getParameter("idExibi"));
        HttpSession s=request.getSession();
        String userStatus = s.getAttribute("status").toString();
        String userEmail = s.getAttribute("currentUser").toString();
        int userID=Integer.parseInt(s.getAttribute("userId").toString());
        UserDAO us=null;
        if(userStatus.equals("visiteur")){
            us=new VisiteurBDD();
            System.out.println("trouvez le id!!!!!!!!!!");
        }else if(userStatus.equals("proprietaire")){
            us=new ProprietaireBDD();
            System.out.println("trouvez le id!!!!!!!!!!");
        }
        int idUser=us.getUserIdByMail(userEmail);
        ReservationDAO reserva=new ReservationBDD();
        Date dt= new Date();
        Reservation r=new Reservation(idUser,idE);
        reserva.createReservation(r);
        s.setAttribute("userId",idUser);
        response.sendRedirect("Reservation.jsp");
    }

}
