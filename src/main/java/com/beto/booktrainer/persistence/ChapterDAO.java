package com.beto.booktrainer.persistence;

import com.beto.booktrainer.model.Book;
import com.beto.booktrainer.model.Chapter;

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
}
