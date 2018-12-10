package com.beto.booktrainer.persistence;

import com.beto.booktrainer.model.Book;
import com.beto.booktrainer.model.Chapter;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public List<Book> listBooks() {
        List<Book> books = new ArrayList();
        books.add(new Book("Routines Manual 1"));
        books.add(new Book("Book 2"));
        books.add(new Book("Book 3"));
        return books;
    }
}
