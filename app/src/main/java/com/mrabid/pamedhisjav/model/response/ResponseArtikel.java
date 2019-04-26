package com.mrabid.pamedhisjav.model.response;

import com.mrabid.pamedhisjav.model.Artikel;

import java.io.Serializable;
import java.util.ArrayList;

public class ResponseArtikel implements Serializable {
    private boolean status;
    private String message;
    private ArrayList<Artikel> data;

    public ResponseArtikel(ResponseArtikel x) {
        this.status = x.isStatus();
        this.message = x.getMessage();
        this.data = x.getData();
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Artikel> getData() {
        return data;
    }

    public void setData(ArrayList<Artikel> data) {
        this.data = data;
    }
}
