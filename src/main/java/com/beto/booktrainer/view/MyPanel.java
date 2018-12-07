package com.beto.booktrainer.view;

import com.beto.booktrainer.model.Book;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MyPanel extends JPanel {
    JList jlist = new JList();
    JButton jbutton = new JButton();

    public MyPanel(List list) {
        jlist.setListData(list.toArray());
        jlist.setVisibleRowCount(10);
        jbutton = new JButton("Nuevo libro");
        add(jlist);
        add(jbutton);
    }
}
