package com.JDBC;

import java.sql.*;
import java.io.*;

public class ImageInsert {
    public static void main(String[] args) {
        try{
            // load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // connection
            String url = "jdbc:mysql://localhost:3306/student";
            String username = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(url,username,password);

            //query
            String q = "insert into image(pimg) values(?)";

            PreparedStatement pstmt = con.prepareStatement(q);

            FileInputStream fis = new FileInputStream("C:\\Users\\Hemant Maurya\\Pictures\\Screenshot 2023-05-22 115955.png");
            pstmt.setBinaryStream(1,fis,fis.available());

            pstmt.executeUpdate();

            System.out.println("Image inserted");

            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
