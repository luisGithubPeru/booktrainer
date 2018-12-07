package com.beto.booktrainer.view;

import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame (JPanel panel){
        super();
        getContentPane().add(panel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

}
