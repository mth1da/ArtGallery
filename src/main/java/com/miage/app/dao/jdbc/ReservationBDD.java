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

        try{
            //connexion
            DAOContext.getConnect();

            String query="INSERT INTO RESERVATION (idReservation,date,price,idUser) VALUES (?,?,?,?)";
            st = connexion.prepareStatement(query);

            st.setInt(1, r.getIdReservation());
            st.setDate(2, (Date) r.getDate());
            st.setDouble(3, r.getPrice());
            st.setInt(4,r.getIdUser());

            st.executeUpdate();
        }catch (SQLException e){
            System.out.println("Caught SQLException: " + e.getMessage());
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e){
                System.out.println("Caught SQLException: " + e.getMessage());
            }
        }

    }

    @Override
    public void updateReservation(Reservation r) {

    }

    @Override
    public void deleteReservation(int r) {
        try{
            //connexion
            DAOContext.getConnect();

            String strSql="DELETE FROM reservation WHERE idReservation=? ";
            st = connexion.prepareStatement(strSql);
            st.setInt(1, r);
            st.executeUpdate();

        }catch (SQLException e){
            System.out.println("Caught SQLException: " + e.getMessage());
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e){
                System.out.println("Caught SQLException: " + e.getMessage());
            }
        }

    }



    @Override
    public Reservation getReservationById(int id) {
        Reservation reservation=null;
        try{
            DAOContext.getConnect();

            String query="select * FROM RESERVATION WHERE idReservation= ?";
            st = connexion.prepareStatement(query);

            st.setInt(1, id);
            ResultSet re=st.executeQuery();

            while(re.next()){
                reservation=creatingObject(re);
            }
        }catch (SQLException e){
            System.out.println("Caught SQLException: " + e.getMessage());
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e){
                System.out.println("Caught SQLException: " + e.getMessage());
            }
        }
        return reservation;
    }

    @Override
    public Iterable<Reservation> getAllReservations() {
        List<Reservation> reservationList=new ArrayList<>();
        try{
            //connexion
            DAOContext.getConnect();

            String query="select * FROM RESERVATION";
            st = connexion.prepareStatement(query);
            ResultSet re=st.executeQuery();

            while(re.next()){
                Reservation reservation=creatingObject(re);
                reservationList.add(reservation);
            }
        } catch (SQLException e){
            System.out.println("Caught SQLException: " + e.getMessage());
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e) {
                System.out.println("Caught SQLException: " + e.getMessage());
            }
        }
        return reservationList;
    }

    @Override
    public Iterable<Reservation> getReservationByUser(int id) {
        List<Reservation> reservationList=new ArrayList<>();
        try{
            //connexion
            DAOContext.getConnect();

            String strSql="select * FROM RESERVATION where idUser=? ";
            st = connexion.prepareStatement(strSql);
            st.setInt(1, id);
            ResultSet re=st.executeQuery();
            while(re.next()){
                Reservation reservation=creatingObject(re);
                reservationList.add(reservation);
            }
            DAOContext.getDeconnect();
        } catch (SQLException e){
            System.out.println("Caught SQLException: " + e.getMessage());
        } finally {
            try{
                DAOContext.getDeconnect();
            } catch (SQLException e) {
                System.out.println("Caught SQLException: " + e.getMessage());
            }
        }
        return reservationList;
    }


    @Override
    protected Reservation creatingObject(ResultSet re) {
        try {
            int idReservation = re.getInt("idReservation");
            Date date = re.getDate("date");
            double price = re.getDouble("price");
            int idUser = re.getInt("idUser");
            return new Reservation(idReservation, idUser);
        } catch (SQLException e) {
            System.out.println("Caught SQLException: " + e.getMessage());
        }
        return null;
    }
}
