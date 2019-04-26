package com.mrabid.pamedhisjav.model.response;


import com.mrabid.pamedhisjav.model.BlockRiwayat;

import java.io.Serializable;
import java.util.ArrayList;


public class ResponseRiwayat implements Serializable {
    private boolean status;
    private String message;
    private ArrayList<BlockRiwayat> data;

    public ResponseRiwayat(ResponseRiwayat x) {
        this.status = x.getStatus();
        this.message = x.getMessage();
        this.data = x.getData();
    }

    public boolean getStatus() {
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

    public ArrayList<BlockRiwayat> getData() {
        return data;
    }

    public void setData(ArrayList<BlockRiwayat> data) {
        this.data = data;
    }
}
