package com.beto.booktrainer.controller;

import com.beto.booktrainer.model.Chapter;
import com.beto.booktrainer.persistence.BookDAO;
import com.beto.booktrainer.persistence.ChapterDAO;
import com.beto.booktrainer.view.BookCreateView;
import com.beto.booktrainer.view.BookListView;
import com.beto.booktrainer.view.ChapterCreateView;
import com.beto.booktrainer.view.ChapterListView;

public class MainController {

    private BookDAO bookDAO = new BookDAO();
    private ChapterDAO chapterDAO = new ChapterDAO();

    public void renderBookListView() {
        new BookListView().render(bookDAO.listBooks(), () -> renderBookChooseView(), () -> renderChapterListView());
    }

    public void renderBookChooseView() {
        new BookCreateView().render(() -> renderBookListView(), (file) -> bookDAO.addBook(file));
    }

    public void renderChapterListView() {
        new ChapterListView().render(chapterDAO.listChapters(""), () -> renderChapterCreateView(), () -> renderBookListView());
    }

    public void renderChapterCreateView() {
        new ChapterCreateView().render(null, (title, pages) -> {
                    chapterDAO.addChapter(title, pages);
                    renderChapterListView();
                }
        );
    }


}

