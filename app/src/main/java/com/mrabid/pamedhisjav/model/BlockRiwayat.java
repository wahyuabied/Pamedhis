package com.mrabid.pamedhisjav.model;

import java.io.Serializable;
import java.util.ArrayList;

public class BlockRiwayat implements Serializable {
    private Riwayat data;
    private String _id;
    private int index;
    private String hash;
    private String previousHash;
    private String timestamp;
    private int __v;
    private ArrayList<Dokter> dokter_docs;

    public BlockRiwayat(BlockRiwayat blockRiwayat) {
        this.data = blockRiwayat.getData();
        this._id = blockRiwayat.get_id();
        this.index = blockRiwayat.getIndex();
        this.hash = blockRiwayat.getHash();
        this.previousHash = blockRiwayat.getPreviousHash();
        this.timestamp = blockRiwayat.getTimestamp();
        this.__v = blockRiwayat.get__v();
        this.dokter_docs = blockRiwayat.getDokter_docs();
    }

    public ArrayList<Dokter> getDokter_docs() {
        return dokter_docs;
    }

    public void setDokter_docs(ArrayList<Dokter> dokter_docs) {
        this.dokter_docs = dokter_docs;
    }

    public Riwayat getData() {
        return data;
    }

    public void setData(Riwayat data) {
        this.data = data;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }
}
