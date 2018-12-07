package com.beto.booktrainer;

import com.beto.booktrainer.model.Book;
import com.beto.booktrainer.model.Chapter;
import com.beto.booktrainer.view.MyFrame;
import com.beto.booktrainer.view.MyPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {

    static List<Book> books = new ArrayList();

    static {
        Book book = new Book("Routines Manual 1");
        Chapter chapter = new Chapter("Openings");
        chapter.setPage(10, 20);
        book.addChapter(chapter);
        chapter = new Chapter("Transition");
        chapter.setPage(25, 30);
        book.addChapter(chapter);
        books.add(book);
        book = new Book("Prueba 2");
        books.add(book);
    }

    public static void main(String[] args) {
        System.out.println(books.get(0).toString());
        JPanel panel = new MyPanel(books);
        JFrame frame = new MyFrame(panel);
    }
}
