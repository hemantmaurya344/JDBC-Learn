package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select {
    public static void main(String[] args) {
        try {
            // load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // creating the connection
            String url = "jdbc:mysql://localhost:3306/student";
            String username = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(url, username, password);

            String q = "SELECT * FROM studentData";

            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(q);

            while(set.next()){
                int id = set.getInt("sId");
                String name = set.getNString("sName");
                String course = set.getString(3);
                System.out.println(id+" "+name+" "+course);
            }
            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
