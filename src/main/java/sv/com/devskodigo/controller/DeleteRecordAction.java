package sv.com.devskodigo.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteRecordAction {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/flights";

        String username = "flights";
        String password = "Java123$";

        try (Connection connection =
                     DriverManager.getConnection(url, username, password)) {


            String sql = "DELETE FROM country WHERE countryId = ?";
            String countryId = "3";

            PreparedStatement statement = connection.prepareStatement(sql);

            // Pass a value of a isbn that will tell the database which
            // records in the database to be deleted. Remember that when
            // using a statement object the index parameter is start from
            // 1 not 0 as in the Java array data type index.
            statement.setString(1, countryId);


            int rows = statement.executeUpdate();

            System.out.println(rows + " record(s) deleted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}