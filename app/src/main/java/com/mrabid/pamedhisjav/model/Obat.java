package com.mrabid.pamedhisjav.model;

import java.io.Serializable;

public class Obat implements Serializable {
    private String _id;
    private String namaObat;
    private String symbol;
    private String dosis;

    public Obat(Obat o) {
        this._id = o.get_id();
        this.namaObat = o.getNamaObat();
        this.symbol = o.getSymbol();
        this.dosis = o.getDosis();
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNamaObat() {
        return namaObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }
}
