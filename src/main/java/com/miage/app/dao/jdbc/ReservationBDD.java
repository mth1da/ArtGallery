package com.miage.app.dao.jdbc;

import com.miage.app.Entity.Reservation;
import com.miage.app.dao.ReservationDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationBDD extends DAOContext implements ReservationDAO {

    @Override
    public void createReservation(Reservation r) {

        try{
            DAOContext.getConnect();
            String strSql="INSERT INTO RESERVATION (idUser,idExhibition) VALUES (?,?)";
            st = connexion.prepareStatement(strSql);
            st.setInt(1,r.getIdUser());
            st.setInt(2,r.getIdExhibition());
            st.executeUpdate();
        }catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e){
                consoleLogger.writeError("Caught SQLException", e);
            }
        }
    }

    public static void main(String[] ar){
        Reservation r=new Reservation(49,1,new Date());
        ReservationDAO or=new ReservationBDD();
        or.createReservation(r);
    }

    @Override
    public void deleteReservation(int r) {
        try{
            DAOContext.getConnect();
            String strSql="DELETE FROM reservation WHERE idReservation=? ";
            st = connexion.prepareStatement(strSql);
            st.setInt(1, r);
            st.executeUpdate();
        }catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e){
                consoleLogger.writeError("Caught SQLException", e);
            }
        }
    }

    @Override
    public Iterable<Reservation> getReservationByUser(int id) {
        List<Reservation> reservationList=new ArrayList<>();
        String strSql="select * FROM RESERVATION where idUser=? ";
        try{
            //connexion
            DAOContext.getConnect();
            st = connexion.prepareStatement(strSql);
            st.setInt(1, id);
            ResultSet re=st.executeQuery();
            while(re.next()){
                Reservation reservation=creatingObject(re);
                reservationList.add(reservation);
            }
        }catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e){
                consoleLogger.writeError("Caught SQLException", e);
            }
        }
        return reservationList;
    }


    @Override
    protected Reservation creatingObject(ResultSet re){
        try{
            int idReservation=re.getInt("idReservation");
            int idUser=re.getInt("idUser");
            int idEx=re.getInt("idExhibition");
            Reservation reservation=new Reservation(idUser,idEx);
            reservation.setIdReservation(idReservation);
            return reservation;
        }  catch (SQLException e) {
            consoleLogger.writeError("Caught SQLException", e);
        }
        return null;
    }


}
