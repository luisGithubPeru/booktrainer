package com.beto.booktrainer.persistence;

import com.beto.booktrainer.model.Book;
import com.beto.booktrainer.model.Chapter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    List<Book> books;

    public BookDAO() {
        books = new ArrayList();
        books.add(new Book("Routines Manual 1"));
        books.add(new Book("Book 2"));
        books.add(new Book("Book 3"));
    }

    public List<Book> listBooks() {

        return books;
    }

    public void addBook(File bookFile) {
        Book newBook = new Book(bookFile.getName(), bookFile.getAbsolutePath());
        books.add(newBook);
    }
}
