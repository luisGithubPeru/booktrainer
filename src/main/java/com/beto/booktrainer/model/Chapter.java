package com.beto.booktrainer.model;

import java.util.ArrayList;
import java.util.List;

public class Chapter {
    String name;
    List pageList = new ArrayList();

    public Chapter(String name) {
        this.name = name;
    }

    public void setPage(int pageNumber) {
        pageList.add(pageNumber);
    }

    public void setPage(int firstPage, int lastPage) {
        for (int i = firstPage; i <= lastPage && i > 0; i++)
            pageList.add(i);
    }

    @Override
    public String toString() {
        return name;
    }
}
