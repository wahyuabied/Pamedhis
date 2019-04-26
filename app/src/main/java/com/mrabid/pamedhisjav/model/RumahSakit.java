package com.mrabid.pamedhisjav.model;

import java.io.Serializable;

public class RumahSakit implements Serializable {
    private String nama;
    private String longitude;
    private String latitude;

    public RumahSakit(String nama, String latitude, String longitude) {
        this.nama = nama;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
