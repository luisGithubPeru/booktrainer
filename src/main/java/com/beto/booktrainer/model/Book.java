package com.beto.booktrainer.model;

import java.util.UUID;

public class Book {
    String ID;
    String name;
    String url;

    public Book(String name) {
        this.ID = UUID.randomUUID().toString();
        this.name = name;
    }

    public Book(String name, String url) {
        this(name);
        this.url = url;
    }

    public Book(String ID, String name, String url) {
        this.ID = ID;
        this.name = name;
        this.url = url;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return name;
    }


}

