package com.hitch.startup.model;

/**
 * Created by XWSPH on 08/08/2017.
 */

public class StartUp {
    private int number;
    private String name;
    private String hashtag;
    private String auteur;
    private String url;
    private int images;

    //const

    public StartUp(int number, String name, String hashtag, String auteur, String url, int images) {
        this.number = number;
        this.name = name;
        this.hashtag = hashtag;
        this.auteur = auteur;
        this.url = url;
        this.images = images;
    }


    //getters and setters


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
