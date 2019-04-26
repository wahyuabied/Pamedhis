package com.mrabid.pamedhisjav.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Resep implements Serializable {
    private int id;
    private String penerima;
    private String tanggal;
    private String jumlah;
    private Dokter dokter;
    private String status;
    private ArrayList<Obat> obats;

    public Resep(int id, String penerima, String tanggal, String jumlah, Dokter dokter,String status) {
        this.id = id;
        this.penerima = penerima;
        this.tanggal = tanggal;
        this.jumlah = jumlah;
        this.dokter = dokter;
        this.status = status;
    }

    public Resep(int id, String penerima, String tanggal, String jumlah, Dokter dokter, String status, ArrayList<Obat> obats) {
        this.id = id;
        this.penerima = penerima;
        this.tanggal = tanggal;
        this.jumlah = jumlah;
        this.dokter = dokter;
        this.status = status;
        this.obats = obats;
    }

    public ArrayList<Obat> getObats() {
        return obats;
    }

    public void setObats(ArrayList<Obat> obats) {
        this.obats = obats;
    }

    public Resep() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPenerima() {
        return penerima;
    }

    public void setPenerima(String penerima) {
        this.penerima = penerima;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public Dokter getDokter() {
        return dokter;
    }

    public void setDokter(Dokter dokter) {
        this.dokter = dokter;
    }
}
