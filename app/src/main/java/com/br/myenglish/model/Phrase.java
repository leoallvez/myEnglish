package com.br.myenglish.model;

/**
 * Created by Leonardo on 01/10/2017.
 */

public class Phrase {
    private String text;
    private String author;


    public Phrase(String text, String author) {
        this.text = text;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
