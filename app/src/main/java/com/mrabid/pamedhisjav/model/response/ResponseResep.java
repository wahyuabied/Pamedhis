package com.mrabid.pamedhisjav.model.response;

import com.mrabid.pamedhisjav.model.Resep;

import java.io.Serializable;
import java.util.ArrayList;

public class ResponseResep implements Serializable {
    private boolean status;
    private String message;
    private ArrayList<Resep> data;

    public ResponseResep(ResponseResep rr) {
        this.status = rr.isStatus();
        this.message = rr.getMessage();
        this.data = rr.getData();
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

    public ArrayList<Resep> getData() {
        return data;
    }

    public void setData(ArrayList<Resep> data) {
        this.data = data;
    }
}
