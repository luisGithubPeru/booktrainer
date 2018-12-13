package com.beto.booktrainer.view;

import com.beto.booktrainer.model.Book;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.function.Consumer;

public class BookListView {

    private MyFrame myFrame = MyFrame.getInstance();

    public void render(List list, final Runnable runOnButtonClick, Consumer<Book> runOnListSelection) {
        JButton jButtonNewBook = new JButton("Nuevo Libro");
        jButtonNewBook.addActionListener((e) -> runOnButtonClick.run());

        JList jList = new JList();
        jList.setListData(list.toArray());
        jList.setVisibleRowCount(10);
        jList.addListSelectionListener((e) ->
                runOnListSelection.accept((Book) jList.getSelectedValue())
        );
        JPanel jPanel = new JPanel();
        jPanel.add(jList);
        jPanel.add(jButtonNewBook);
        myFrame.getContentPane().removeAll();
        myFrame.getContentPane().add(jPanel);
        myFrame.pack();
    }
}
