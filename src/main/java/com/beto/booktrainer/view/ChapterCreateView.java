package com.beto.booktrainer.view;

import javax.swing.*;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ChapterCreateView {

    private MyFrame myFrame = MyFrame.getInstance();

    public void render(List list, final BiConsumer<String,String> runOnCreate) {
        JTextField txtChapterName = new JTextField();
        JTextField txtChapterPages = new JTextField();
        JButton btnSubmit = new JButton("Guardar");
        btnSubmit.addActionListener((e) -> runOnCreate.accept(txtChapterName.getText(), txtChapterPages.getText()));
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, 1));
        jPanel.add(new JLabel("Nombre de capitulo"));
        jPanel.add(txtChapterName);
        jPanel.add(new JLabel("Paginas : pag1,pag2,pag3-pag10,..."));
        jPanel.add(txtChapterPages);
        jPanel.add(btnSubmit);
        myFrame.getContentPane().removeAll();
        myFrame.getContentPane().add(jPanel);
        myFrame.pack();
    }
}
