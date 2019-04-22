package com.mrabid.pamedhisjav.model;

import java.io.Serializable;

public class Artikel implements Serializable {
    private int id;
    private String title;
    private String deskripsi;
    private String image;

    public Artikel(Artikel artikel) {
        this.id = artikel.getId();
        this.title = artikel.getTitle();
        this.deskripsi = artikel.getDeskripsi();
        this.image = artikel.getImage();
    }

    public Artikel(int id, String title, String deskripsi, String image) {
        this.id = id;
        this.title = title;
        this.deskripsi = deskripsi;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
