package com.beto.booktrainer.business;

import com.beto.booktrainer.model.Book;
import com.beto.booktrainer.persistence.BookDAO;

import java.io.File;
import java.util.List;

public class BookManager {
    private List<Book> bookList;
    private BookDAO dao;

    public BookManager() {
        dao = new BookDAO();
        bookList = dao.selectBook();
    }

    public void addBook(File f) {
        Book b = new Book(f.getName(), f.getAbsolutePath());
        dao.insertBook(b);
        bookList.add(b);
    }

    public List<Book> listBooks() {
        return bookList;
    }

}
