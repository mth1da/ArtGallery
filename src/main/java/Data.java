import java.sql.*;

public class Data {

    public static void main(String[] arg) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/artgallery", "root", "");
        Statement statement = con.createStatement();
        ResultSet re = statement.executeQuery("Select * from visiteur");
        ResultSet res = statement.executeQuery("Insert into reservation (idReservation) values (5)");
        while (re.next()) {
            System.out.println(re.getString("name"));
            System.out.println(res.getString("idReservation"));
        }

    }
}
