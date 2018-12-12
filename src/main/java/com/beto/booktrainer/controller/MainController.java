package com.beto.booktrainer.controller;

import com.beto.booktrainer.model.Book;
import com.beto.booktrainer.persistence.BookDAO;
import com.beto.booktrainer.view.BookCreateView;
import com.beto.booktrainer.view.BookListView;
import com.beto.booktrainer.view.ChapterCreateView;
import com.beto.booktrainer.view.ChapterListView;

public class MainController {

    private BookDAO bookDAO = new BookDAO();

    public void renderBookListView() {
        new BookListView().render(bookDAO.getBookList(), () -> renderBookCreateView(), (book) -> renderChapterListView(book));
    }

    public void renderBookCreateView() {
        new BookCreateView().render(() -> renderBookListView(), (file) -> bookDAO.setBook(file));
    }

    public void renderChapterListView(Book book) {
        new ChapterListView().render(book.getChapterList(), () -> renderChapterCreateView(book), () -> renderBookListView());
    }

    public void renderChapterCreateView(Book book) {
        new ChapterCreateView().render(null, (chapterName, chapterPages) -> {
                    bookDAO.setChapter(book.getID(),chapterName,chapterPages);
                    renderChapterListView(book);
                }
        );
    }

    public void renderPageListView(){

    }


}

