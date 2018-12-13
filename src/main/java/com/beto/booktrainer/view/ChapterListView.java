package com.beto.booktrainer.view;

import com.beto.booktrainer.model.Book;
import com.beto.booktrainer.model.Chapter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.function.Consumer;

public class ChapterListView {

    private MyFrame myFrame = MyFrame.getInstance();

    public void render(List list, final Runnable runOnChapterCreate, Runnable runReturn, Consumer<Chapter> runOnChapterSelection) {
        JButton btnCreateChapter = new JButton("Nuevo Capitulo");
        btnCreateChapter.addActionListener((e) -> runOnChapterCreate.run());

        JButton btnReturn = new JButton("Volver");
        btnReturn.addActionListener((e) -> runReturn.run());

        JList jList = new JList();
        jList.setListData(list.toArray());
        jList.setVisibleRowCount(10);
        jList.addListSelectionListener((e)-> {runOnChapterSelection.accept((Chapter)jList.getSelectedValue());});

        JPanel jPanel = new JPanel();
        jPanel.add(jList);
        jPanel.add(btnCreateChapter);
        jPanel.add(btnReturn);

        myFrame.getContentPane().removeAll();
        myFrame.getContentPane().add(jPanel);
        myFrame.pack();
    }
}
