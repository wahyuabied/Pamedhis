package com.mrabid.pamedhisjav.model.response;

import com.mrabid.pamedhisjav.model.Dokter;

import java.io.Serializable;

public class ResponseDokter implements Serializable {
    private boolean status;
    private String message;
    private Dokter data;

    public ResponseDokter(ResponseDokter x) {
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

    public Dokter getData() {
        return data;
    }

    public void setData(Dokter data) {
        this.data = data;
    }
}
