package com.mrabid.pamedhisjav.model;

import java.io.Serializable;

public class Dokter implements Serializable {
    private int id;
    private String name;
    private String image;
    private String spesialis;
    private String noTelp;


    public Dokter(int id, String name, String image, String spesialis, String noTelp) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.spesialis = spesialis;
        this.noTelp = noTelp;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSpesialis() {
        return spesialis;
    }

    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }
}
