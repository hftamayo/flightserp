package sv.com.devskodigo.models.dao;
/*
pendiente de documentar
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

class ConnectDB{
    public static void main(String args[]){
        Properties properties = new Properties();
        String filePath = "./src/main/java/sv/com/devskodigo/models/dao/flights.properties";
         final String COUNTRY_SELECT = "SELECT countryName, countryCoords FROM country";


        try{
            FileInputStream fis = new FileInputStream(filePath);
            properties.load(fis);

            Class.forName("com.mysql.cj.jdbc.Driver");
            //url/database, username, password

            Connection con=DriverManager.getConnection(properties.getProperty("DB_URL"),
                    properties.getProperty("DB_USERNAME"),properties.getProperty("DB_PASSWORD"));

            PreparedStatement preparedStatement = con.prepareStatement(COUNTRY_SELECT);

            ResultSet rs= preparedStatement.executeQuery();

            while(rs.next()){
                System.out.println(rs.getString(1)+"  "+rs.getString(2));
            }
            con.close();

        }catch(FileNotFoundException fnf) {
            System.out.println(fnf);
        }catch(SQLException sqle){
            System.out.println(sqle);
        }catch(IOException ioe){
            System.out.println(ioe);
        }catch(ClassNotFoundException cnfe){
            System.out.println(cnfe);
        }
    }
}