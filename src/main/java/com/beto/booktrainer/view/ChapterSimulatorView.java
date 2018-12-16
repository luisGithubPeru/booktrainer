package com.beto.booktrainer.view;

import com.beto.booktrainer.model.Book;
import com.beto.booktrainer.model.Chapter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

public class ChapterSimulatorView {

    private MyFrame myFrame = MyFrame.getInstance();
    File file;
    LinkedList<Integer> pageBuffer;
    JPanel jPanel;
    PDDocument doc;
    PDFRenderer renderer;
    Chapter chapter;
    JLabel jLabelImage;

    public ChapterSimulatorView(Book book, Chapter chapter, Runnable runFinish) throws IOException {
        this.chapter = chapter;
        file = new File(book.getUrl());
        doc = PDDocument.load(file);
        renderer = new PDFRenderer(doc);
        pageBuffer = new LinkedList<>();
        pageBuffer.add(this.getRandomPage());
        JButton btnPrevious = new JButton("Anterior");
        JButton btnNextRandom = new JButton("Siguiente (aleatoria)");
        JButton btnFinish = new JButton("Finalizar");

        jLabelImage = new JLabel(new ImageIcon(renderer.renderImage(pageBuffer.peek())));
        jPanel = new JPanel();
        jPanel.add(btnPrevious);
        jPanel.add(jLabelImage);
        jPanel.add(btnNextRandom);
        jPanel.add(btnFinish);
        myFrame.getContentPane().removeAll();
        myFrame.getContentPane().add(jPanel);
        myFrame.pack();

        btnPrevious.addActionListener((e) -> {
            if (pageBuffer.size() > 1)
                pageBuffer.pollLast();
            this.showImage(pageBuffer.peekLast());
        });

        btnNextRandom.addActionListener((e) -> {
            int randomPage;
            while ((randomPage = this.getRandomPage()) == pageBuffer.peekLast()) {}
            this.pageBuffer.addLast(randomPage);
            this.showImage(randomPage);
        });

        btnFinish.addActionListener(e -> {
            try {
                doc.close();
                runFinish.run();
            } catch (Exception ex) {
            }
        });
    }

    public void showImage(int pageNumber) {
        try {
            int componentIndex = -1;
            Component[] components = jPanel.getComponents();

            for (int i = 0; i < components.length; i++)
                if (components[i].equals(jLabelImage))
                    componentIndex = i;

            jLabelImage = new JLabel(new ImageIcon(renderer.renderImage(pageNumber)));
            jPanel.remove(componentIndex);
            jPanel.add(jLabelImage, componentIndex);
            jPanel.revalidate();
        } catch (Exception e) {
        }
    }

    public int getRandomPage() {
        int randomPageIndex = new Random().nextInt(chapter.getPageList().size());
        return chapter.getPageList().get(randomPageIndex) - 1 ;
    }


}
