package com.beto.booktrainer.controller;

import com.beto.booktrainer.persistence.BookDAO;
import com.beto.booktrainer.persistence.ChapterDAO;
import com.beto.booktrainer.view.BookChooseView;
import com.beto.booktrainer.view.BookListView;
import com.beto.booktrainer.view.ChapterListView;

public class MainController {

    private BookDAO bookDAO = new BookDAO();
    private ChapterDAO chapterDAO = new ChapterDAO();

    public void renderBookListView() {
        new BookListView().render(bookDAO.listBooks(), () -> renderBookChooseView(), () -> renderChapterListView());
    }

    public void renderBookChooseView() {
        new BookChooseView().render(() -> renderChapterListView(), () -> renderBookListView());
    }

    public void renderChapterListView(){
        new ChapterListView().render(chapterDAO.listChapters(""), () ->{renderBookListView();});
    }


}

