package com.beto.booktrainer.persistence;

import com.beto.booktrainer.model.Book;

import java.sql.*;

public class ConnectSQLite {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + System.getenv("USERPROFILE") + "/book.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists book");
            statement.executeUpdate("create table book (id string, name string, url string)");
            Book b = new Book("Routines Manual 1", "C:\\Users\\beto\\IdeaProjects\\booktrainer\\Manual-de-Rutinas.pdf");

            String query = String.format("insert into book values('%s', '%s', '%s')", b.getID(), b.getName(), b.getUrl());
            statement.executeUpdate(query);
            ResultSet rs = statement.executeQuery("select * from book");
            while (rs.next()) {
                for (int i = 1; i <= 3; i++)
                    System.out.println(rs.getString(i));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
    }
}
