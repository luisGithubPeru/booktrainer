package com.beto.booktrainer.view;

import javax.swing.*;

public class MyFrame extends JFrame {

    private static MyFrame instance = null;

    public static MyFrame getInstance() {
        if (instance == null) {
            instance = new MyFrame();
            instance.setVisible(true);
            instance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        return instance;
    }

    private MyFrame() {
        super();
    }

    public void updateContent(JPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel);
        pack();
    }

}
