package com.JDBC;
import java.sql.*;
import java.util.Scanner;

public class Insert{
    public static void main(String[] args){
        try{
            // load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // creating the connection
            String url = "jdbc:mysql://localhost:3306/student";
            String username = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(url,username,password);

            // accessing the db
            // creating query
            String q = "create table studentData(sId int(20) primary key auto_increment,sName varchar(200) not null, sCourse varchar(150))";

            // create statement
            Statement stmt = con.createStatement();

            // execute query

//            stmt.executeUpdate(q);

            System.out.println("Table is created");


            // parameterized query
            String s = "INSERT INTO studentData(sName,sCourse) Values (?,?)";
            PreparedStatement pstmt = con.prepareStatement(s);

            String name = "";
            String cours = "";
            Scanner in = new Scanner(System.in);
            System.out.println("Enter name: " );
            name = in.next();
            System.out.println("Enter Course: ");
            cours = in.next();

            pstmt.setString(1,name);
            pstmt.setString(2,cours);
            System.out.println("enter 0 to exit");

            pstmt.execute();

            con.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}