package com.beto.booktrainer.persistence;

import com.beto.booktrainer.model.Book;
import com.beto.booktrainer.model.Chapter;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class ChapterDAO {

    public List<Chapter> listChapters(String bookID) {
        List<Chapter> chapters = new ArrayList();
        Chapter chapter = new Chapter("Chapter 1");
        chapter.setPage(10, 20);
        chapters.add(chapter);
        chapter = new Chapter("Chapter 2");
        chapter.setPage(25, 30);
        chapter.setPage(35, 38);
        chapters.add(chapter);
        return chapters;
    }

    public static void main(String args[]) {
        try {
            //Class.forName("postgresql.Driver");
            InetAddress db = InetAddress.getByName("localhost");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //String url = "jdbc:sqlserver://" + db.getHostAddress() + ":1433;instance=SQLEXPRESS;databaseName=UPM;";
            String url = "jdbc:sqlserver://betobeto:1433;instance=SQLEXPRESS;databaseName=UPM;";
            System.out.println(url);
            Connection con = DriverManager.getConnection(url, "sa", "password");
            //Connection con = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
