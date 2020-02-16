package com.example.soccerapp;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    public static class DatabaseFunctions{

        public Connection getConnection()throws Exception{

            try {
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://remotemysql.com:3306/fsmgvLmC5f?characterEncoding=latin1&useConfigs=maxPerformance";
                String username = "fsmgvLmC5f";
                String password = "dEEGdJA1v7";
                Class.forName(driver);

                Connection conn = DriverManager.getConnection(url, username, password);
                System.out.println("Connected");

                return conn;
            } catch (Exception e) {
                System.out.println("An error has occured");
                System.out.println(e);
            }

            return null;
        }

        public User GetUser(String usernameEntered, String passwordEntered) throws Exception{


            User testUser;


            Statement stmt = null;
            Connection conn = getConnection();
            String query = "SELECT * FROM USERR WHERE Email='"+usernameEntered+"'";
            try {
                //boolean valid;
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    String email = rs.getString("Email");
                    String userPassword = rs.getString("Pass");
                    String firstName = rs.getString("F_Name");
                    String lastName = rs.getString("L_Name");
                    String DOB = rs.getString("DOB");



                    testUser = new User(email, userPassword, firstName, lastName, DOB);


                    if (testUser.Email.equals(usernameEntered)&& testUser.Pass.equals(passwordEntered)) {
                        //JOptionPane.showMessageDialog(this, "Log In Succesfull");
                        //System.out.println("Log In Succesfull!");
                        return testUser;
                    }
                    else{
                        //System.out.println("Please try again");
                        return null;
                    }
                }
            } catch (SQLException e ) {
                System.err.println(e);
            } finally {
                if (stmt != null) { stmt.close(); }
            }
            return null;

        }

        public void InsertUser(String email, String pass, String F_Name, String L_Name, String DOB) throws Exception{
            try {
                Statement stmt = null;
                Connection conn = getConnection();
                String query = "INSERT INTO USERR(Email, Pass, F_Name, L_Name, DOB) VALUES ('"+email+"','"+pass+"','"+F_Name+"','"+L_Name+"','"+DOB+"')";

                stmt = conn.createStatement();
                stmt.executeUpdate(query);
            }catch (Exception e){
                System.err.println(e);
            }


        }




    }

}
