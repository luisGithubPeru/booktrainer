package com.beto.booktrainer.persistence;

import com.beto.booktrainer.model.Book;
import com.beto.booktrainer.model.Chapter;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class ChapterDAO {

    List<Chapter> chapters;

    public ChapterDAO() {
        chapters = new ArrayList();
        Chapter chapter = new Chapter("Chapter 1");
        chapter.setPage(10, 20);
        chapters.add(chapter);
    }

    public List<Chapter> listChapters(String bookID) {
        return chapters;
    }

    public void addChapter(String name, String pages) {
        if (name.isEmpty() || pages.isEmpty())
            return;
        Chapter newChapter = new Chapter(name);
        pages = pages.trim();
        String[] pagesRequest = pages.split(",");
        for (String i : pagesRequest) {
            if (i.indexOf("-") > -1) {
                String pageInterval[] = i.split("-");
                newChapter.setPage(Integer.parseInt(pageInterval[0]), Integer.parseInt(pageInterval[1]));
            } else
                newChapter.setPage(Integer.parseInt(i));
        }
        chapters.add(newChapter);
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
