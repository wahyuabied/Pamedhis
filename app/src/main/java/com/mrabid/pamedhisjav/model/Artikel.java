package com.mrabid.pamedhisjav.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Artikel implements Serializable {
    private String _id;
    private String judul;
    private String isi;
    private ArrayList<Dokter> dokter;

    public Artikel(Artikel x) {
        this._id = x.get_id();
        this.judul = x.getJudul();
        this.isi = x.getIsi();
        this.dokter = x.getDokter();
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public ArrayList<Dokter> getDokter() {
        return dokter;
    }

    public void setDokter(ArrayList<Dokter> dokter) {
        this.dokter = dokter;
    }
}
