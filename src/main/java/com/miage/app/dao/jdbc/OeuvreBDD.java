package com.miage.app.dao.jdbc;

import com.miage.app.Entity.Oeuvre;
import com.miage.app.Entity.TableauOeuvre;
import com.miage.app.Entity.User;
import com.miage.app.Entity.Visiteur;
import com.miage.app.dao.OeuvreDAO;
import com.miage.app.dao.UserDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OeuvreBDD extends DAOContext implements OeuvreDAO {

    public OeuvreBDD(){
        this.connexion=DAOContext.getConnect();
    }

    @Override
    public void createOeuvre(Oeuvre o) {
        try{
            DAOContext.getConnect();

            //Requête permettant de créer une nouvelle oeuvre avec les données récupérées
            String query=""; //à compléter
            st = connexion.prepareStatement(query);

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
    public void updateOeuvre(Oeuvre o) {

    }

    @Override
    public void deleteOeuvre(Oeuvre o) {
        try{
            //connexion
            DAOContext.getConnect();

            //Requête permettant de supprimer une oeuvre
            String query="";

            st = connexion.prepareStatement(query);


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
    public Oeuvre getOeuvreById(int o) {
        return null;
    }

    @Override
    public Iterable<Oeuvre> getAllOeuvres() {
        return null;
    }

    @Override
    public Iterable<Oeuvre> getAllUserOeuvres(int id) {
        List<Oeuvre> oeuvreList=new ArrayList<>();
        try{
            //connexion
            DAOContext.getConnect();

            String query="select * FROM OEUVRE WHERE idUser= ?";
            st = connexion.prepareStatement(query);
            st.setInt(1, id);

            ResultSet re=st.executeQuery();
            while(re.next()){
                Oeuvre oeuvre=creatingObject(re);
                oeuvreList.add(oeuvre);
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
        return oeuvreList;
    }

    @Override
    protected Oeuvre creatingObject(ResultSet re) {

        try{
            int id=re.getInt("idOeuvre");
            String title=re.getString("title");
            int idArtist=re.getInt("idArtiste");
            int idUser=re.getInt("idUser");
            double price=re.getDouble("price");
            Oeuvre user=new TableauOeuvre(id,title,idArtist,idUser,price);
            return user;
        } catch (SQLException e) {
            System.out.println("Caught SQLException: " + e.getMessage());
        }
        return null;
    }
}
