package com.miage.app.dao.jdbc;

import com.miage.app.Entity.Critique;
import com.miage.app.dao.CritiqueDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CritiqueBDD extends DAOContext implements CritiqueDAO {



    @Override
    public void createCritique(Critique cr) {
        try{
            //Requête permettant de créer une nouvelle critique avec les données récupérées
            DAOContext.getConnect();

            String query="INSERT INTO CRITIQUE (idCritique,commentaire,note,idOeuvre,idUser) VALUES (?,?,?,?,?)";
            st = connexion.prepareStatement(query);

            st.setInt(1, cr.getIdCritique());
            st.setString(2, cr.getCommentaire());
            st.setInt(3, cr.getNote());
            st.setInt(4, cr.getOeuvre());
            st.setInt(5, cr.getUser());

            st.executeUpdate();
        }catch (SQLException e ){
            System.out.println("Caught SQLException: " + e.getMessage());
        } finally{
            try{
                //Ferme la connexion
                DAOContext.getDeconnect();
            } catch(SQLException e){
                System.out.println("Caught SQLException: " + e.getMessage());
            }
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
        try{
            //connexion
            DAOContext.getConnect();

            //Requête permettant de supprimer une critique
            String query="DELETE FROM CRITIQUE WHERE idCritique= ?";

            st = connexion.prepareStatement(query);
            st.setInt(1, cr.getIdCritique());

            st.executeUpdate();

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
    }

    @Override
    public Critique getCritiqueById(int id) {
        Critique critique=null;

        try{
            //connexion
            DAOContext.getConnect();

            String query="select * FROM CRITIQUE WHERE idCritique= ?";
            st = connexion.prepareStatement(query);

            st.setInt(1, id);
            ResultSet re=st.executeQuery();

            while(re.next()){
                critique=creatingObject(re);
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
        return critique;
    }

    @Override
    public Iterable<Critique> getAllCritiques() {
        List<Critique> critiqueList=new ArrayList<>();
        try{
            //connexion
            DAOContext.getConnect();

            String query="select * FROM CRITIQUE";
            st = connexion.prepareStatement(query);

            ResultSet re=st.executeQuery();
            while(re.next()){
                Critique critique=creatingObject(re);
                critiqueList.add(critique);
            }
        }catch (SQLException e ){
            System.out.println("Caught SQLException: " + e.getMessage());
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e){
                System.out.println("Caught SQLException: " + e.getMessage());
            }
        }
        return critiqueList;
    }


    @Override
    protected Critique creatingObject(ResultSet re)  {

        try{
            int idCritique=re.getInt("idCritique");
            String commentaire=re.getString("commentaire");
            int note=re.getInt("note");
            int idOeuvre=re.getInt("idOeuvre");
            int idUser=re.getInt("idUser");
            return new Critique(idCritique,commentaire,note,idOeuvre,idUser);
        } catch (SQLException e){
            System.out.println("Caught SQLException: " + e.getMessage());
        }
       return null;
    }
}
