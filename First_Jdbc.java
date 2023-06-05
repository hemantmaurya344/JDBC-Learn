package com.JDBC;

import java.sql.*;
public class First_Jdbc {
    public static void main(String[] args){
        try{
            //loading the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // creating the connection
            String url = "jdbc:mysql://localhost:3306/student";
            String username = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(url,username,password);
            if(con.isClosed())
                System.out.println("Connection is closed");
            else
                System.out.println("Connection is created");

            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
