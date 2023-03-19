package com.miage.app.dao.repository;

import com.miage.app.Entity.Artiste;
import com.miage.app.dao.ArtisteDAO;
import java.util.ArrayList;
import java.util.List;

public class ArtisteRepository implements ArtisteDAO {
    private static List<Artiste> artisteList=new ArrayList<>();
    @Override
    public void createArtiste(Artiste artiste) {
        artisteList.add(artiste);
    }

    @Override
    public void updateArtiste(Artiste artiste) {

    }
    @Override
    public void deleteArtiste(Artiste artiste) {
        artisteList.remove(artiste);
    }

    @Override
    public Artiste getArtisteById(int id) {

        //Retourne l'artiste à partir de l'id
        Artiste artiste=null;
        for(Artiste currArtiste : artisteList){
            if(currArtiste.getId()==id){
                artiste=currArtiste;
            }
        }
        return artiste;
    }

    @Override
    public List<Artiste> getAllArtistes() {
        return artisteList;
    }

}
