package com.miage.app.dao.jdbc;

import com.miage.app.Entity.Reservation;
import com.miage.app.dao.ReservationDAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationBDD extends DAOContext implements ReservationDAO {

    @Override
    public void createReservation(Reservation r) {

        String strSql="INSERT INTO RESERVATION (idUser,idExhibition) VALUES (?,?)";
        try{
            DAOContext.getConnect();
            st = connexion.prepareStatement(strSql);
            st.setInt(1,r.getIdUser());
            st.setInt(2,r.getIdExhibition());
            st.executeQuery();
            DAOContext.getDeconnect();
        }catch (Exception ignored){

        }

    }

    @Override
    public void updateReservation(Reservation r) {
    }

    @Override
    public void deleteReservation(int r) {
        String strSql="DELETE FROM reservation WHERE idReservation=? ";
        try{
            DAOContext.getConnect();
            st = connexion.prepareStatement(strSql);
            st.setInt(1, r);
            st.executeUpdate();
            DAOContext.getDeconnect();
        }catch (Exception ignored){

        }

    }



    @Override
    public Reservation getReservationById(int id) {
        Reservation reservation=null;
        String strSql="select * FROM RESERVATION WHERE idReservation= ?";
        try{
            DAOContext.getConnect();
            st = connexion.prepareStatement(strSql);
            st.setInt(1, id);
            ResultSet re=st.executeQuery();
            while(re.next()){
                reservation=creatingObject(re);
            }
            DAOContext.getDeconnect();
        }catch (Exception ignored){

        }
        return reservation;
    }

    @Override
    public Iterable<Reservation> getAllReservations() {
        List<Reservation> reservationList=new ArrayList<>();
        String strSql="select * FROM RESERVATION";
        try{
            DAOContext.getConnect();
            st = connexion.prepareStatement(strSql);
            ResultSet re=st.executeQuery();
            while(re.next()){
                Reservation reservation=creatingObject(re);
                reservationList.add(reservation);
            }
            DAOContext.getDeconnect();
        }catch (Exception ignored){

        }
        return reservationList;
    }

    @Override
    public Iterable<Reservation> getReservationByUser(int id) {
        List<Reservation> reservationList=new ArrayList<>();
        String strSql="select * FROM RESERVATION where idUser=? ";
        try{
            DAOContext.getConnect();
            st = connexion.prepareStatement(strSql);
            st.setInt(1, id);
            ResultSet re=st.executeQuery();
            while(re.next()){
                Reservation reservation=creatingObject(re);
                reservationList.add(reservation);
            }
            DAOContext.getDeconnect();
        }catch (Exception ignored){

        }
        return reservationList;
    }


    @Override
    protected Reservation creatingObject(ResultSet re) throws SQLException {
        int idReservation=re.getInt("idReservation");
        Date date=re.getDate("date");
        int idUser=re.getInt("idUser");
        int idEx=re.getInt("idExhibition");
        Reservation reservation=new Reservation(idUser,idEx);
        reservation.setIdReservation(idReservation);
        return reservation;
    }
}
