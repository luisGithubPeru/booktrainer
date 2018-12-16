package com.beto.booktrainer.presentation;

import com.beto.booktrainer.business.BookManager;
import com.beto.booktrainer.business.ChapterManager;
import com.beto.booktrainer.model.Book;
import com.beto.booktrainer.model.Chapter;
import com.beto.booktrainer.view.*;

public class MainController {

    private BookManager bookManager = new BookManager();
    private ChapterManager chapterManager;

    public void renderBookListView() {
        new BookListView().render(bookManager.listBooks(), () -> renderBookCreateView(), (book) -> renderChapterListView(book));
    }

    public void renderBookCreateView() {
        new BookCreateView().render(() -> renderBookListView(), (file) -> bookManager.addBook(file));
    }

    public void renderChapterListView(Book book) {
        chapterManager = new ChapterManager(book);
        new ChapterListView().render(chapterManager.listChapters(), () -> renderChapterCreateView(book), () -> renderBookListView(), (Chapter chapter) -> renderChapterSimulatorView(book, chapter));
    }

    public void renderChapterCreateView(Book book) {
        new ChapterCreateView().render(null, (chapterName, chapterPages) -> {
                    chapterManager.addChapter(book,chapterName, chapterPages);
                    renderChapterListView(book);
                }
        );
    }

    public void renderChapterSimulatorView(Book book, Chapter chapter) {
        try {
            new ChapterSimulatorView(book, chapter, () -> renderChapterListView(book));
        } catch (Exception e) {
        }
    }


}

