package com.mrabid.pamedhisjav.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Resep implements Serializable {
    private String _id;
    private String idRiwayat;
    private int status;
    private String idPasien;
    private ArrayList<Obat> resep;
    private ArrayList<BlockRiwayat> riwayat;
    private ArrayList<Dokter> dokter_docs;

    public Resep(Resep r) {
        this._id = r.get_id();
        this.idRiwayat = r.getIdRiwayat();
        this.status = r.getStatus();
        this.idPasien = r.getIdPasien();
        this.resep = r.getResep();
        this.riwayat = r.getRiwayat();
        this.dokter_docs = r.getDokter_docs();
    }

    public ArrayList<Dokter> getDokter_docs() {
        return dokter_docs;
    }

    public void setDokter_docs(ArrayList<Dokter> dokter_docs) {
        this.dokter_docs = dokter_docs;
    }

    public ArrayList<BlockRiwayat> getRiwayat() {
        return riwayat;
    }

    public void setRiwayat(ArrayList<BlockRiwayat> riwayat) {
        this.riwayat = riwayat;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getIdRiwayat() {
        return idRiwayat;
    }

    public void setIdRiwayat(String idRiwayat) {
        this.idRiwayat = idRiwayat;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(String idPasien) {
        this.idPasien = idPasien;
    }

    public ArrayList<Obat> getResep() {
        return resep;
    }

    public void setResep(ArrayList<Obat> resep) {
        this.resep = resep;
    }
}
