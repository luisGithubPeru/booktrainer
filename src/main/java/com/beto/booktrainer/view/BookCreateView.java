package com.beto.booktrainer.view;

import javax.swing.*;
import java.io.File;
import java.util.function.Consumer;

public class BookCreateView {

    public void render(final Runnable runReturn, Consumer<File> runCreateBook) {

        File workingDirectory = new File(System.getProperty("user.dir"));
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setCurrentDirectory(workingDirectory);
        int result = jFileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            runCreateBook.accept(jFileChooser.getSelectedFile());
        }
        runReturn.run();
    }
}
