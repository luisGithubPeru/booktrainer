package com.beto.booktrainer.model;

import java.util.ArrayList;
import java.util.List;

public class Chapter {
    String bookID;
    String name;
    List<Integer> pageList = new ArrayList();

    public Chapter(String name) {
        this.name = name;
    }

    public Chapter(String bookID, String name) {
        this(name);
        this.bookID = bookID;
    }

    public String getBookID() {
        return bookID;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getPageList() {
        return pageList;
    }

    public void setPageList(List<Integer> pageList) {
        this.pageList = pageList;
    }

    public void addPage(int pageNumber) {
        pageList.add(pageNumber);
    }

    @Override
    public String toString() {
        return name;
    }
}
