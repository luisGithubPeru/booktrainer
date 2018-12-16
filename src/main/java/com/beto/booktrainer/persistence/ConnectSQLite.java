package com.beto.booktrainer.persistence;

import com.beto.booktrainer.model.Book;

import java.sql.*;

public class ConnectSQLite {

    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            if (connection == null)
                connection = DriverManager.getConnection("jdbc:sqlite:" + System.getenv("USERPROFILE") + "/book.db");
        } catch (Exception e) {
            connection = null;
        }
        return connection;
    }

    public static boolean closeConnection() {
        try {
            connection.close();
            connection = null;
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            Connection connection = ConnectSQLite.getConnection();
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            statement.executeUpdate("drop table if exists book");
            statement.executeUpdate("drop table if exists chapter");
            statement.executeUpdate("create table book (id string, name string, url string)");
            statement.executeUpdate("create table chapter (bookID string, name string, page integer)");

            Book b = new Book("Routines Manual 1", "C:\\Users\\beto\\IdeaProjects\\booktrainer\\Manual-de-Rutinas.pdf");

            String query = "insert into book values(?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, b.getID());
            ps.setString(2, b.getName());
            ps.setString(3, b.getUrl());
            ps.executeUpdate();

            query = "insert into chapter values(?,?,?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, b.getID());
            ps.setString(2, "Chapter 1");
            ps.setString(3, "10");
            ps.executeUpdate();
            ps.setString(3, "11");
            ps.executeUpdate();
            ps.setString(3, "12");
            ps.executeUpdate();

            ResultSet rs = statement.executeQuery("select * from book");
            while (rs.next()) {
                for (int i = 1; i <= 3; i++)
                    System.out.println(rs.getString(i));
            }

            rs = statement.executeQuery("select * from chapter");
            while (rs.next()) {
                for (int i = 1; i <= 3; i++)
                    System.out.println(rs.getString(i));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
