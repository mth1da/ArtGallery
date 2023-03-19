package com.miage.app.Entity;

public abstract class  User {
        private int id;
        private String nom;
        private String prenom;
        private String mdp;
        private final String email;

        private String status;
        private boolean estConnecte;

        protected User(String nom,String prenom,String mdp,String email, String status)
        {
                this.nom=nom;
                this.prenom=prenom;
                this.mdp=mdp;
                this.email=email;
                this.status=status;
        }

        public void setConnexion(boolean resp)
        {
                this.estConnecte=resp;
        }

        public int getId()
        {
                return this.id;
        }

        public String getNom()
        {
                return this.nom;
        }

        public void setNom(String nom)
        {
                this.nom=nom;
        }

        public String getPreNom()
        {
                return this.prenom;
        }

        public void setPrenom(String prenom)
        {
                this.prenom=prenom;
        }

        public String getMdp()
        {
                return this.mdp;
        }

        public void setMdp(String mdp)
        {
                this.mdp=mdp;
        }

        public String getEmail()
        {
                return this.email;
        }

        public String getStatus()
        {
                return this.status;
        }

        public void setStatus(String status)
        {
                this.status=status;
        }

        public abstract String getType();

        public boolean getInfoConnexion()
        {
                return this.estConnecte;
        }

        public abstract void displayUser();


}
