package com.beto.booktrainer.persistence;

import com.beto.booktrainer.model.Chapter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChapterDAO {

    public boolean insertChapter(Chapter c) {
        try {
            Connection con = ConnectSQLite.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into chapter values (?,?,?)");
            ps.setString(1, c.getBookID());
            ps.setString(2, c.getName());
            for (int page : c.getPageList()) {
                ps.setInt(3, page);
                ps.executeUpdate();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Chapter> selectChapter(String bookID) {
        List<Chapter> list = null;
        try {
            list = new ArrayList<>();
            Connection con = ConnectSQLite.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from chapter where bookID = ?");
            ps.setString(1, bookID);
            ResultSet rs = ps.executeQuery();
            Chapter c = null;
            while (rs.next()) {
                if (c == null || !c.getName().equals(rs.getString("name"))) {
                    c = new Chapter(bookID, rs.getString("name"));
                    list.add(c);
                }
                c.addPage(rs.getInt("page"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
