package com.beto.booktrainer.persistence;

import com.beto.booktrainer.model.Book;
import com.beto.booktrainer.model.Chapter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    List<Book> bookList;

    public BookDAO() {
        bookList = new ArrayList();
        Book newBook = new Book("Routines Manual 1");
        Chapter newChapter = new Chapter("Chapter 1");
        newChapter.setPage(10, 20);
        newBook.setChapter(newChapter);
        bookList.add(newBook);
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public Book getBook(String bookID) {
        for (Book b : bookList)
            if (b.getID() == bookID)
                return b;
        return null;
    }

    public void setBook(File bookFile) {
        Book newBook = new Book(bookFile.getName(), bookFile.getAbsolutePath());
        bookList.add(newBook);
    }

    public void setChapter(String bookID, String chapterName, String chapterPages) {
        if (chapterName.isEmpty() || chapterPages.isEmpty())
            return;
        Chapter newChapter = new Chapter(chapterName);
        for (String i : chapterPages.trim().split(",")) {
            if (i.indexOf("-") > -1) {
                String pageInterval[] = i.split("-");
                newChapter.setPage(Integer.parseInt(pageInterval[0]), Integer.parseInt(pageInterval[1]));
            } else
                newChapter.setPage(Integer.parseInt(i));
        }
        getBook(bookID).setChapter(newChapter);
    }
}
