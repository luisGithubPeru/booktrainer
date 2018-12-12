package com.beto.booktrainer.view;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.function.Consumer;

public class BookCreateView {

    public void render(final Runnable runReturn, Consumer<File> runCreateBook) {

        File workingDirectory = new File(System.getProperty("user.dir"));
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setCurrentDirectory(workingDirectory);
        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PDF", "pdf"));
        jFileChooser.setAcceptAllFileFilterUsed(false);
        int result = jFileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            runCreateBook.accept(jFileChooser.getSelectedFile());
        }
        runReturn.run();
    }
}
