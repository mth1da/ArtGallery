import java.sql.*;

public class Data {

    public static void main(String[] arg) throws SQLException {

        //Création de la connexion
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/artGallery","root","");

        //Création d'un état de connexion
        Statement statement=con.createStatement();

        //Création d'une requête de sélection
        ResultSet re=statement.executeQuery("Select * from user");

        //Tant que l'on parcourt les données de la table
        while(re.next()){
            //On affiche la récupération du nom
            System.out.println(re.getString("firstName"));
        }

    }
}
