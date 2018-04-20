package com.hitch.startup.model;

/**
 * Created by XWSPH on 12/09/2017.
 */

public class Quotes {
    private String auteur;
    private String content;
    private String date;


    //const

    public Quotes(String auteur, String content, String date) {
        this.auteur = auteur;
        this.content = content;
        this.date = date;
    }

    //getters


    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
