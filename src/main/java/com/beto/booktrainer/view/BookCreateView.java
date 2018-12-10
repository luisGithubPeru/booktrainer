package com.beto.booktrainer.view;

import javax.swing.*;
import java.io.File;

public class BookCreateView {

    public void render(final Runnable runApprove, final Runnable runCancel) {

        File workingDirectory = new File(System.getProperty("user.dir"));
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setCurrentDirectory(workingDirectory);
        int result = jFileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            runApprove.run();
        } else if (result == JFileChooser.CANCEL_OPTION) {
            runCancel.run();
        }
    }
}
