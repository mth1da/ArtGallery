package com.miage.app.dao.jdbc;

import com.miage.app.Entity.Exhibition;
import com.miage.app.dao.ExhibitionDAO;
import com.miage.app.logging.ConsoleLogger;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExhibitionBDD extends DAOContext implements ExhibitionDAO {

    ConsoleLogger consoleLogger = new ConsoleLogger();
    @Override
    public void createExhibition(Exhibition exhibition) {
        try{
            //connexion
            DAOContext.getConnect();

            String strSql="INSERT INTO exhibition (name,startdate,enddate,place,maxVisitorNb,rooms) VALUES (?,?,?,?,?,?)";
            st = connexion.prepareStatement(strSql);
            st.setString(1, exhibition.getName());
            st.setDate(2, (Date) exhibition.getStartDate());
            st.setDate(3, (Date) exhibition.getEndDate());
            st.setString(4, exhibition.getPlace());
            st.setInt(5, exhibition.getMaxVisitorNb());
            st.setString(6, exhibition.getRooms());
            st.executeQuery();
        }catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        } finally{
            try{
                //Ferme la connexion
                DAOContext.getDeconnect();
            } catch (SQLException e){
                consoleLogger.writeError("Caught SQLException", e);
            }
        }
    }

    @Override
    public void updateExhibition(Exhibition exhibition) {
        try {
            //connexion
            DAOContext.getConnect();

            String query="UPDATE exhibition SET name=?, startdate=?, endDate=?, place=?, maxVisitornbr,rooms  WHERE idExhibition=?";

            st = connexion.prepareStatement(query);
            st.setString(1, exhibition.getName());
            st.setDate(2, (Date) exhibition.getStartDate());
            st.setDate(3, (Date) exhibition.getEndDate());
            st.setString(4, exhibition.getPlace());
            st.setInt(5, exhibition.getMaxVisitorNb());
            st.setString(6, exhibition.getRooms());
            st.executeUpdate();
        }catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        } finally{
            try{
                //Ferme la connexion
                DAOContext.getDeconnect();
            } catch (SQLException e){
                consoleLogger.writeError("Caught SQLException", e);
            }
        }
    }

    @Override
    public void deleteExhibition(Exhibition exhibition) {
        try{
            //connexion
            DAOContext.getConnect();
            String strSql="DELETE FROM exhibition WHERE id=? ";
            st = connexion.prepareStatement(strSql);
            st.setInt(1, exhibition.getIdExhibition());
            st.executeUpdate();
        }catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        } finally{
            try{
                //Ferme la connexion
                DAOContext.getDeconnect();
            } catch (SQLException e){
                consoleLogger.writeError("Caught SQLException", e);
            }
        }
    }

    @Override
    public Exhibition getExhibitionById(int id) {
        Exhibition exhibition=null;
        try{
            //connexion
            DAOContext.getConnect();

            String strSql="select * FROM exhibition WHERE idExhibition= ?";
            st = connexion.prepareStatement(strSql);
            st.setInt(1, id);

            ResultSet re=st.executeQuery();
            while(re.next()){
                exhibition=creatingObject(re);
            }
        }catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        } finally{
            try{
                //Ferme la connexion
                DAOContext.getDeconnect();
            } catch (SQLException e){
                consoleLogger.writeError("Caught SQLException", e);
            }
        }
        return exhibition;
    }

    @Override
    public Iterable<Exhibition> getAllExhibition() {
        List<Exhibition> exhibitionList=new ArrayList<>();
        try{
            //connexion
            DAOContext.getConnect();

            String strSql="select * FROM exhibition";
            st = connexion.prepareStatement(strSql);
            ResultSet re=st.executeQuery();
            while(re.next()){
                Exhibition exhibition=creatingObject(re);
                exhibitionList.add(exhibition);
            }
        }catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        } finally{
            try{
                //Ferme la connexion
                DAOContext.getDeconnect();
            } catch (SQLException e){
                consoleLogger.writeError("Caught SQLException", e);
            }
        }
        return exhibitionList;
    }

    @Override
    protected Exhibition creatingObject(ResultSet re) {

        try{
            int idExhibition=re.getInt("idExhibition");
            String name=re.getString("name");
            Date startDate=re.getDate("startDate");
            Date endDate=re.getDate("endDate");
            String place=re.getString("place");
            int max=re.getInt("maxVisitorNb");
            String room=re.getString("rooms");
            Exhibition exhibition=new Exhibition(idExhibition,name,startDate,endDate,place,max,room);
            return exhibition;
        } catch(SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        }
        return null;
    }
}
