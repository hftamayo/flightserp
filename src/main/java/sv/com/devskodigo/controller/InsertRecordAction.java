package sv.com.devskodigo.controller;


import java.io.*;
import java.sql.*;

public class InsertRecordAction {

    // url that points to mysql database, 'db' is database
    // name
    static final String url
            = "jdbc:mysql://localhost:3306/flights";

    public static void main(String[] args)
            throws ClassNotFoundException
    {
        try {

            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    url, "flights", "Java123$");


            Statement stmt = conn.createStatement();

            int result = stmt.executeUpdate(
                    "insert into country(countryName,countryCoords) values('Panama','13456789')");

            if (result > 0)
                System.out.println("successfully inserted");

            else
                System.out.println(
                        "unsucessful insertion ");

            conn.close();
        }

        catch (SQLException e) {
            System.out.println(e);
        }
    }
}
