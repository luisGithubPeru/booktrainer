package com.beto.booktrainer.business;

import com.beto.booktrainer.model.Book;
import com.beto.booktrainer.model.Chapter;
import com.beto.booktrainer.persistence.ChapterDAO;

import java.util.ArrayList;
import java.util.List;

public class ChapterManager {

    private List<Chapter> chapterList;
    private ChapterDAO dao;

    public ChapterManager(Book book){
        dao = new ChapterDAO();
        chapterList = dao.selectChapter(book.getID());
    }

    public void addChapter(Book b, String name, String pages) {
        if (name.isEmpty()) return;

        List<Integer> pageList = new ArrayList();
        for (String page : pages.trim().split(","))
            if (page.indexOf("-") > -1) {
                String pageArr[] = page.split("-");
                for (int i = Integer.parseInt(pageArr[0]); i <= Integer.parseInt(pageArr[1]); i++)
                    pageList.add(i);
            } else {
                pageList.add(Integer.parseInt(page));
            }

        Chapter c = new Chapter(b.getID(),name);
        c.setPageList(pageList);
        dao.insertChapter(c);
        chapterList.add(c);
    }

    public List<Chapter> listChapters(){
        return chapterList;
    }

}
