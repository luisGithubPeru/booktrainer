package com.beto.booktrainer.view;

import com.beto.booktrainer.model.Book;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ChapterListView {

    private MyFrame myFrame = MyFrame.getInstance();

    public void render(List list, final Runnable runOnCreate) {
        JButton jButtonCreate = new JButton("Nuevo Capitulo");
        JList jList = new JList();
        jList.setListData(list.toArray());
        jList.setVisibleRowCount(10);
        jButtonCreate.addActionListener((e)-> runOnCreate.run());
        JPanel jPanel = new JPanel();
        jPanel.add(jList);
        jPanel.add(jButtonCreate);
        myFrame.getContentPane().removeAll();
        myFrame.getContentPane().add(jPanel);
        myFrame.pack();
    }
}
