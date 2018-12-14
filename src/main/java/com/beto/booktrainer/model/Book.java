package com.beto.booktrainer.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Book {
    String ID;
    String name;
    String url;
    List<Chapter> chapterList = new ArrayList<Chapter>();

    public Book(String name) {
        this.ID = UUID.randomUUID().toString();
        this.name = name;
    }

    public Book(String name, String url) {
        this(name);
        this.url = url;
    }

    public String getID() {
        return ID;
    }
    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public void setChapter(Chapter chapter) {
        this.chapterList.add(chapter);
    }

    public List<Chapter> getChapterList(){return this.chapterList;}

    @Override
    public String toString() {
        return name;
    }


}

