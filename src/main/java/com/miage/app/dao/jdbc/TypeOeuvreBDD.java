package com.miage.app.dao.jdbc;

import com.miage.app.Entity.TypeOeuvre;
import com.miage.app.dao.TypeOeuvreDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeOeuvreBDD extends DAOContext implements TypeOeuvreDAO {
    @Override
    public void createType(String name, String description){
        try{
            //connexion
            DAOContext.getConnect();

            String query="INSERT INTO TYPEOEUVRE (nom_type,caracteristique) VALUES (?,?)";
            st = connexion.prepareStatement(query);
            st.setString(1, name);
            st.setString(2, description);
            st.executeUpdate();
        } catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e) {
                consoleLogger.writeError("Caught SQLException", e);
            }
        }
    }

    @Override
    public void deleteType(int idType){
        try{
            //connexion
            DAOContext.getConnect();

            //Requête permettant de supprimer un type d'oeuvre
            String query="DELETE FROM typeoeuvre WHERE id=?";

            st = connexion.prepareStatement(query);

            st.setInt(1, idType);
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
    public Iterable<TypeOeuvre> getAllTypes() {
        List<TypeOeuvre> types=new ArrayList<>();
        try{
            //connexion
            DAOContext.getConnect();

            String query="select * FROM TYPEOEUVRE";
            st = connexion.prepareStatement(query);

            ResultSet result=st.executeQuery();
            while(result.next()){
                TypeOeuvre type= (TypeOeuvre) creatingObject(result);
                types.add(type);
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
        return types;
    }

    @Override
    protected TypeOeuvre creatingObject(ResultSet result) {
        try{
            String nom_type=result.getString("nom_type");
            //String nom= String.valueOf(result.getType());
            String caracteristique=result.getString("caracteristique");
            TypeOeuvre type=new TypeOeuvre(nom_type,caracteristique);
            return type;
        } catch (SQLException e) {
            consoleLogger.writeError("Caught SQLException", e);
        }
        return null;
    }
}
