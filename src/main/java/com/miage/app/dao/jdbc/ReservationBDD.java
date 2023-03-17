package com.miage.app.dao.jdbc;

import com.miage.app.Entity.Reservation;
import com.miage.app.Entity.User;
import com.miage.app.dao.ReservationDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationBDD extends DAOContext implements ReservationDAO {

    public ReservationBDD(){
        this.connexion=DAOContext.getConnect();
    }

    @Override
    public void createReservation(Reservation r) {

    }

    @Override
    public void updateReservation(Reservation r) {

    }

    @Override
    public void deleteReservation(Reservation r) {

    }



    @Override
    public Reservation getReservationById(int id) {
        Reservation reservation=null;
        String strSql="select * FROM RESERVATION WHERE id= ?";
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
        return null;
    }


    @Override
    protected Reservation creatingObject(ResultSet re) throws SQLException {
        return null;
    }
}
