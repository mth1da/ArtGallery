package com.miage.app.Fonctionnalitees;

import com.miage.app.Personne.User;

public interface InsciptionService {
    public User getUser();

    public boolean getStatutInscription();

    public User creeCompte();

    public boolean verifCompteExiste(String email);

    public boolean verifPseudoExiste(String pseudo);

    public boolean mdpValide(String mdp);

    public void saveAccount(User user);

    public void deleteAccount(User user);

}
