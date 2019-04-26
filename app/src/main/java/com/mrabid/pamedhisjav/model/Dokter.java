package com.mrabid.pamedhisjav.model;

import java.io.Serializable;

public class Dokter implements Serializable {
    private String _id;
    private String username;
    private String password;
    private int role;
    private String token;
    private String noIzin;
    private String nama;
    private String alamat;
    private String noTelp;
    private String email;
    private String image;

    public Dokter(String _id, String username, String password, int role, String token, String noIzin, String nama, String alamat, String noTelp, String email, String image) {
        this._id = _id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.token = token;
        this.noIzin = noIzin;
        this.nama = nama;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.email = email;
        this.image = image;
    }

    public Dokter(Dokter dokter) {
        this._id = dokter.get_id();
        this.username = dokter.getUsername();
        this.password = dokter.getPassword();
        this.role = dokter.getRole();
        this.token = dokter.getToken();
        this.noIzin = dokter.getNoIzin();
        this.nama = dokter.getNama();
        this.alamat = dokter.getAlamat();
        this.noTelp = dokter.getNoTelp();
        this.email = dokter.getEmail();
        this.image = "Default.jpg";
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNoIzin() {
        return noIzin;
    }

    public void setNoIzin(String noIzin) {
        this.noIzin = noIzin;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
