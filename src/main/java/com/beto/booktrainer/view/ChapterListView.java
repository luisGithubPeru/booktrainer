package com.beto.booktrainer.view;

import com.beto.booktrainer.model.Book;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ChapterListView {

    private MyFrame myFrame = MyFrame.getInstance();

    public void render(List list, final Runnable runOnChapterCreate, Runnable runReturn) {
        JButton btnCreateChapter = new JButton("Nuevo Capitulo");
        JButton btnReturn = new JButton("Volver");
        btnReturn.addActionListener((e) -> runReturn.run());
        JList jList = new JList();
        jList.setListData(list.toArray());
        jList.setVisibleRowCount(10);
        btnCreateChapter.addActionListener((e) -> runOnChapterCreate.run());
        JPanel jPanel = new JPanel();
        jPanel.add(jList);
        jPanel.add(btnCreateChapter);
        jPanel.add(btnReturn);
        myFrame.getContentPane().removeAll();
        myFrame.getContentPane().add(jPanel);
        myFrame.pack();
    }
}
