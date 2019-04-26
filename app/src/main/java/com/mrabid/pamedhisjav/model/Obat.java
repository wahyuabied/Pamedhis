package com.mrabid.pamedhisjav.model;

import java.io.Serializable;

public class Obat implements Serializable {
    private int id;
    private String name;
    private String symbol;

    public Obat(int id, String name) {
        this.id = id;
        this.name = name;
        this.symbol = "R";
    }

    public Obat(Obat obat) {
        this.id = obat.getId();
        this.name = obat.getName();
        this.symbol = obat.getSymbol();
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
