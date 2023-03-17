package com.miage.app.dao.jdbc;

import com.miage.app.Entity.Critique;
import com.miage.app.Entity.User;
import com.miage.app.Entity.Visiteur;
import com.miage.app.dao.CritiqueDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CritiqueBDD extends DAOContext implements CritiqueDAO {

    public CritiqueBDD(){
        this.connexion=DAOContext.getConnect();
    }

    @Override
    public void createCritique(Critique cr) {
        String strSql="INSERT INTO CRITIQUE (idCritique,commentaire,note,idOeuvre,idUser) VALUES (?,?,?,?,?)";
        try{
            st = connexion.prepareStatement(strSql);
            st.setInt(1, cr.getIdCritique());
            st.setString(2, cr.getCommentaire());
            st.setInt(3, cr.getNote());
            st.setInt(4, cr.getOeuvre());
            st.setInt(5, cr.getUser());
            st.executeUpdate();
        }catch (Exception exception){

        }

    }

    @Override
    public void updateCritiqueNote(Critique cr) {

    }

    @Override
    public void updateCritiqueComment(Critique cr) {

    }


    @Override
    public void deleteCritique(Critique cr) {
        String strSql="DELETE FROM CRITIQUE WHERE ID= ?";
        try{
            st = connexion.prepareStatement(strSql);
            st.setInt(1, cr.getIdCritique());
            st.executeUpdate();
        }catch (Exception exception){

        }
    }

    @Override
    public Critique getCritiqueById(int id) {
        Critique critique=null;
        String strSql="select * FROM CRITIQUE WHERE idCritique= ?";
        try{
            st = connexion.prepareStatement(strSql);
            st.setInt(1, id);
            ResultSet re=st.executeQuery();
            while(re.next()){
                critique=creatingObject(re);
            }
        }catch (Exception exception){

        }
        return critique;
    }

    @Override
    public Iterable<Critique> getAllCritiques() {
        List<Critique> critiqueList=new ArrayList<>();
        String strSql="select * FROM CRITIQUE";
        try{
            st = connexion.prepareStatement(strSql);
            ResultSet re=st.executeQuery();
            while(re.next()){
                Critique critique=creatingObject(re);
                critiqueList.add(critique);
            }
        }catch (Exception exception){

        }
        return critiqueList;
    }


    @Override
    protected Critique creatingObject(ResultSet re) throws SQLException  {
        int idCritique=re.getInt("idCritique");
        String commentaire=re.getString("commentaire");
        int note=re.getInt("note");
        int idOeuvre=re.getInt("idOeuvre");
        int idUser=re.getInt("idUser");
        Critique critique=new Critique(idCritique,commentaire,note,idOeuvre,idUser);
        return critique;
    }
}
