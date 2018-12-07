package com.beto.booktrainer.model;

import java.util.ArrayList;
import java.util.List;

public class Book {
    String name;
    List<Chapter> chapterList = new ArrayList<Chapter>();

    public Book(String name) {
        this.name = name;
    }

    public void addChapter(Chapter chapter) {
        this.chapterList.add(chapter);
    }

    @Override
    public String toString() {
        return name;
    }
}

