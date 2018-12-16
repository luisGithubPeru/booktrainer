package com.beto.booktrainer.persistence;

import com.beto.booktrainer.business.BookManager;
import com.beto.booktrainer.model.Book;
import com.beto.booktrainer.model.Chapter;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public void insertBook(Book b) {
        try {
            Connection con = ConnectSQLite.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into book values (?,?,?)");
            ps.setString(1, b.getID());
            ps.setString(2, b.getName());
            ps.setString(3, b.getUrl());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> selectBook() {
        List<Book> list = null;
        try {
            list = new ArrayList<>();
            Connection con = ConnectSQLite.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from book");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book b = new Book(rs.getString("id"), rs.getString("name"), rs.getString("url"));
                list.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
