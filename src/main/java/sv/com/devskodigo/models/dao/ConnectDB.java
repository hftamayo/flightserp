package sv.com.devskodigo.models.dao;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

class ConnectDB{
    public static void main(String args[]){
        Properties properties = new Properties();
        String filePath = "/src/main/java/sv/com/devskodigo/models/dao/flights.properties";

        try{
            FileInputStream fis = new FileInputStream(filePath);
            properties.load(fis);

            Class.forName("com.mysql.cj.jdbc.Driver");
            //url/database, username, password
            /*
            Connection con=DriverManager.getConnection(,"","");

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT countryName, countryCoords FROM country");
            while(rs.next()){
                System.out.println(rs.getString(1)+"  "+rs.getString(2));
            }
            con.close();

             */
        }catch(Exception e){ System.out.println(e);}
    }
}