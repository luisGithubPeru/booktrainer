package com.beto.booktrainer.controller;

import com.beto.booktrainer.model.Book;
import com.beto.booktrainer.model.Chapter;
import com.beto.booktrainer.persistence.BookDAO;
import com.beto.booktrainer.view.*;

public class MainController {

    private BookDAO bookDAO = new BookDAO();

    public void renderBookListView() {
        new BookListView().render(bookDAO.getBookList(), () -> renderBookCreateView(), (book) -> renderChapterListView(book));
    }

    public void renderBookCreateView() {
        new BookCreateView().render(() -> renderBookListView(), (file) -> bookDAO.setBook(file));
    }

    public void renderChapterListView(Book book) {
        new ChapterListView().render(book.getChapterList(), () -> renderChapterCreateView(book), () -> renderBookListView(), (Chapter chapter) -> renderChapterSimulatorView(book, chapter));
    }

    public void renderChapterCreateView(Book book) {
        new ChapterCreateView().render(null, (chapterName, chapterPages) -> {
                    bookDAO.setChapter(book.getID(), chapterName, chapterPages);
                    renderChapterListView(book);
                }
        );
    }

    public void renderChapterSimulatorView(Book book, Chapter chapter) {
        try {
            new ChapterSimulatorView(book, chapter,()->renderChapterListView(book));
        } catch (Exception e) {
        }
    }


}

