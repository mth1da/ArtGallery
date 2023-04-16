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
            System.out.println("Caught SQLException: " + e.getMessage());
        } finally{
            try{
                //Ferme la connexion
                DAOContext.getDeconnect();
            } catch (SQLException e){
                System.out.println("Caught SQLException: " + e.getMessage());
            }
        }
        return exhibitionList;
    }

    @Override
    protected Exhibition creatingObject(ResultSet re) {
        Exhibition exhibition=null;
        try{
            int idExhibition=re.getInt("idExhibition");
            String name=re.getString("name");
            Date startDate=re.getDate("startDate");
            Date endDate=re.getDate("endDate");
            String place=re.getString("place");
            int max=re.getInt("maxVisitorNb");
            String room=re.getString("rooms");
            exhibition=new Exhibition(idExhibition,name,startDate,endDate,place,max,room);
        } catch(SQLException e){
            System.out.println("Caught SQLException: " + e.getMessage());
        }
        return exhibition;
    }
}
