package com.beto.booktrainer.view;

import com.beto.booktrainer.model.Book;
import com.beto.booktrainer.model.Chapter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Function;
import java.util.function.Supplier;

public class ChapterSimulatorView {

    private MyFrame myFrame = MyFrame.getInstance();
    File file;
    Queue<Integer> pageBuffer;
    JPanel jPanel;
    PDDocument doc;

    public ChapterSimulatorView(Book book, Chapter chapter) throws IOException {
        file = new File("C:\\Users\\beto\\IdeaProjects\\booktrainer\\",
                "Manual-de-Rutinas.pdf");
        //file = new File(book.getUrl());

        doc = PDDocument.load(file);
        PDFRenderer renderer = new PDFRenderer(doc);
        pageBuffer = new LinkedList<>();
        pageBuffer.add(chapter.getPageList().get(0));
        BufferedImage image = renderer.renderImage(pageBuffer.peek());

        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel(new ImageIcon(image)));
        myFrame.getContentPane().removeAll();
        myFrame.getContentPane().add(jPanel);
        myFrame.pack();
    }

    public void render(Supplier getPreviousImage)  {
        JButton btnPrevious = new JButton("Anterior");
        JButton btnNextRandom = new JButton("Siguiente (aleatoria)");
        JButton btnFinish = new JButton("Finalizar");

        ImageIcon image = new ImageIcon("C:\\Users\\Meneer\\Pictures\\image.png");
        JLabel imageLabel = new JLabel(image);
        imageLabel.setBounds(10, 10, 400, 400);
        imageLabel.setVisible(true);

        btnPrevious.addActionListener((e) -> {
            getPreviousImage.get();
        });

        btnFinish.addActionListener(e -> {
            try {
                doc.close();
            } catch (Exception ex) {
            }
        });

    }
}
