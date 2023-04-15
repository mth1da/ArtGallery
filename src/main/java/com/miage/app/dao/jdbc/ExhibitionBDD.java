package com.miage.app.dao.jdbc;

import com.miage.app.Entity.Exhibition;
import com.miage.app.dao.ExhibitionDAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExhibitionBDD extends DAOContext implements ExhibitionDAO {
    @Override
    public void createExhibition(Exhibition exhibition) {
        String strSql="INSERT INTO exhibition (name,startdate,enddate,place,maxVisitorNb,rooms) VALUES (?,?,?,?,?,?)";
        try{
            DAOContext.getConnect();
            st = connexion.prepareStatement(strSql);
            st.setString(1, exhibition.getName());
            st.setDate(2, (Date) exhibition.getStartDate());
            st.setDate(3, (Date) exhibition.getEndDate());
            st.setString(4, exhibition.getPlace());
            st.setInt(5, exhibition.getMaxVisitorNb());
            st.setString(6, exhibition.getRooms());
            st.executeQuery();
            DAOContext.getDeconnect();
        }catch (Exception ignored){

        }
    }

    @Override
    public void updateExhibition(Exhibition exhibition) {
        String query="UPDATE exhibition SET name=?, startdate=?, endDate=?, place=?  WHERE idExhibition=?";
        try {
            DAOContext.getConnect();
            st = connexion.prepareStatement(query);
            st.setString(1, exhibition.getName());
            st.setDate(2, (Date) exhibition.getStartDate());
            st.setDate(3, (Date) exhibition.getEndDate());
            st.setString(4, exhibition.getPlace());
            st.executeUpdate();
            DAOContext.getDeconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteExhibition(Exhibition exhibition) {
        String strSql="DELETE FROM exhibition WHERE id=? ";
        try{
            DAOContext.getConnect();
            st = connexion.prepareStatement(strSql);
            st.setInt(1, exhibition.getIdExhibition());
            st.executeUpdate();
            DAOContext.getDeconnect();
        }catch (Exception ignored){

        }
    }

    @Override
    public Exhibition getExhibitionById(int id) {
        Exhibition exhibition=null;
        String strSql="select * FROM exhibition WHERE idExhibition= ?";
        try{
            DAOContext.getConnect();
            st = connexion.prepareStatement(strSql);
            st.setInt(1, id);

            ResultSet re=st.executeQuery();
            while(re.next()){
                exhibition=creatingObject(re);
            }
            DAOContext.getDeconnect();
        }catch (Exception ignored){

        }
        return exhibition;
    }

    @Override
    public Iterable<Exhibition> getAllExhibition() {
        List<Exhibition> exhibitionList=new ArrayList<>();
        String strSql="select * FROM exhibition";
        try{
            DAOContext.getConnect();
            st = connexion.prepareStatement(strSql);
            ResultSet re=st.executeQuery();
            while(re.next()){
                Exhibition exhibition=creatingObject(re);
                exhibitionList.add(exhibition);
            }
            DAOContext.getDeconnect();
        }catch (Exception ignored){

        }
        return exhibitionList;
    }

    @Override
    protected Exhibition creatingObject(ResultSet re) throws SQLException {
        int idExhibition=re.getInt("idExhibition");
        String name=re.getString("name");
        Date startDate=re.getDate("startDate");
        Date endDate=re.getDate("endDate");
        String place=re.getString("place");
        int max=re.getInt("maxVisitorNb");
        String room=re.getString("rooms");
        Exhibition exhibition=new Exhibition(idExhibition,name,startDate,endDate,place,max,room);
        return exhibition;
    }
}
