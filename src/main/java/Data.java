import java.sql.*;

public class Data {

    public static void main(String[] arg) throws SQLException {
        Connection con= DriverManager.getConnection("jdbc:mariadb://localhost:3308/ArtGallery","root","meryam");
        Statement statement=con.createStatement();
        ResultSet re=statement.executeQuery("Select * from visiteur");
        while(re.next()){
            System.out.println(re.getString("name"));
        }

    }
}
