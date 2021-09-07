package sv.com.devskodigo.controller;

import java.sql.*;

    class ConnectDB{
    public static void main(String args[]){
    try{
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection(
    //url/database, username, password
    "jdbc:mysql://localhost:3306/flights","flights","Java123$");

    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("SELECT countryName, countryCoords FROM country");
    while(rs.next())
    System.out.println(rs.getString(1)+"  "+rs.getString(2);
    con.close();
    }catch(Exception e){ System.out.println(e);}
    }
    }