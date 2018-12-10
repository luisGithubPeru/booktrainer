package com.beto.booktrainer.view;

import com.beto.booktrainer.model.Book;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BookListView {

    private MyFrame myFrame = MyFrame.getInstance();

    public void render(List list, final Runnable runOnButtonClick, Runnable runOnListSelection) {
        JButton jButtonNewBook = new JButton("Nuevo Libro");
        JList jList = new JList();
        jList.setListData(list.toArray());
        jList.setVisibleRowCount(10);
        jButtonNewBook.addActionListener((e) -> runOnButtonClick.run());
        jList.addListSelectionListener((e) -> runOnListSelection.run());
        JPanel jPanel = new JPanel();
        jPanel.add(jList);
        jPanel.add(jButtonNewBook);
        myFrame.getContentPane().removeAll();
        myFrame.getContentPane().add(jPanel);
        myFrame.pack();
    }
}
