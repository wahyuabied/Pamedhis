package com.mrabid.pamedhisjav.model;

import java.io.Serializable;

public class Riwayat implements Serializable {
    private int id;
    private Dokter dokter;
    private String tanggal;
    private String lokasi;
    private String diagnosa;


    public Riwayat(int id, Dokter dokter, String tanggal, String lokasi, String diagnosa) {
        this.id = id;
        this.dokter = dokter;
        this.tanggal = tanggal;
        this.lokasi = lokasi;
        this.diagnosa = diagnosa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dokter getDokter() {
        return dokter;
    }

    public void setDokter(Dokter dokter) {
        this.dokter = dokter;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getDiagnosa() {
        return diagnosa;
    }

    public void setDiagnosa(String diagnosa) {
        this.diagnosa = diagnosa;
    }
}
