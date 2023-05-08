package com.example;
import java.sql.*;

public final class App 
{
    public static void main( String[] args )
    {
        String url = "jdbc:mysql://localhost:3307/java_cloud_db";
        String username = "root";
        String password = "1234"; 
        //String username = System.getenv("DB_USER");
        //String password = System.getenv("DB_PASS");
        //String url = "jdbc:mysql://localhost:" + System.getenv("DB_PORT") + "/" + System.getenv("DB_NAME");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = java.sql.DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM imp");
            while (rs.next()) {
                System.out.println(rs.getInt("Id") + " " + rs.getString("Name") + " " + rs.getString("SurName") + " " + rs.getInt("PhoneN") + " " + rs.getString("Location"));
            }
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}