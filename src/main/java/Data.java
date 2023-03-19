import com.miage.app.Entity.User;
import com.miage.app.Entity.Visiteur;
import com.miage.app.dao.UserDAO;
import com.miage.app.dao.jdbc.DAOContext;
import com.miage.app.dao.jdbc.VisiteurBDD;

import java.sql.*;

public class Data {

    public static void main(String[] arg) throws SQLException {

        //Création de la connexion
        Connection con= DriverManager.getConnection("jdbc:mariadb://localhost:3308/artGallery","root","meryam");

        //Création d'un état de connexion
     //  Statement statement=con.createStatement();

        //Création d'une requête de sélection
     //   ResultSet re=statement.executeQuery("Select * from user where");

   //     while(re.next()){
      //      System.out.println(re.getString("firstName"));
    //    }

        User r=new Visiteur("Ghulam","Meryam","ijij","mrm@gmail.com");

        /**User user=new Visiteur("amel","naloufi","okkk","OKKK");**/
        /**dao.createUser(user);**/

        r.setNom("sfkgnjfgn");
        r.setPrenom("mez");


        PreparedStatement st =null;

        System.out.println(r.getNom());
        System.out.println(r.getPreNom());
        System.out.println(r.getEmail());
        System.out.println(r.getPreNom());
                String query="UPDATE user SET firstname=?, lastname=? WHERE email=? AND status=?";
        try {

            st = con.prepareStatement(query);
            st.setString(1, r.getPreNom());
            st.setString(2, r.getNom());
            st.setString(3, r.getEmail());
            st.setString(4, "visiteur");
            st.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    }

