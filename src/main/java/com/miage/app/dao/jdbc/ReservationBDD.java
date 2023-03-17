package com.miage.app.dao.jdbc;

import com.miage.app.Entity.Reservation;
import com.miage.app.Entity.User;
import com.miage.app.Entity.Visiteur;
import com.miage.app.dao.ReservationDAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationBDD extends DAOContext implements ReservationDAO {

    public ReservationBDD(){
        this.connexion=DAOContext.getConnect();
    }

    @Override
    public void createReservation(Reservation r) {
        String strSql="INSERT INTO RESERVATION (idReservation,date,price,idUser) VALUES (?,?,?,?)";
        try{
            st = connexion.prepareStatement(strSql);
            st.setInt(1, r.getIdReservation());
            st.setDate(2, (Date) r.getDate());
            st.setDouble(3, r.getPrice());
            st.setInt(4,r.getIdUser());
            st.executeUpdate();
        }catch (Exception exception){

        }

    }

    @Override
    public void updateReservation(Reservation r) {

    }

    @Override
    public void deleteReservation(Reservation r) {
        String strSql="DELETE FROM user WHERE idReservation= ?";
        try{
            st = connexion.prepareStatement(strSql);
            st.setInt(1, r.getIdReservation());
            st.executeUpdate();
        }catch (Exception exception){

        }

    }



    @Override
    public Reservation getReservationById(int id) {
        Reservation reservation=null;
        String strSql="select * FROM RESERVATION WHERE idReservation= ?";
        try{
            st = connexion.prepareStatement(strSql);
            st.setInt(1, id);
            ResultSet re=st.executeQuery();
            while(re.next()){
                reservation=creatingObject(re);
            }
        }catch (Exception exception){

        }
        return reservation;
    }

    @Override
    public Iterable<Reservation> getAllReservations() {
        List<Reservation> reservationList=new ArrayList<>();
        String strSql="select * FROM RESERVATION";
        try{
            st = connexion.prepareStatement(strSql);
            ResultSet re=st.executeQuery();
            while(re.next()){
                Reservation reservation=creatingObject(re);
                reservationList.add(reservation);
            }
        }catch (Exception exception){

        }
        return reservationList;
    }


    @Override
    protected Reservation creatingObject(ResultSet re) throws SQLException {
        int idReservation=re.getInt("idReservation");
        Date date=re.getDate("date");
        double price=re.getDouble("price");
        int idUser=re.getInt("idUser");
        Reservation reservation=new Reservation(idReservation,date,price,idUser);
        return reservation;
    }
}
