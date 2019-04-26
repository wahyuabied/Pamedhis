package com.mrabid.pamedhisjav.model;

import java.io.Serializable;

public class User implements Serializable {
    private String _id;
    private String idPasien;
    private String username;
    private String password;
    private int role;
    private String token;
    private String nama;
    private String alamat;
    private String noTelp;
    private String golDarah;
    private String jenisKelamin;
    private String nik;
    private String email;

    public User() {
    }

    public User(User user) {
        this._id = user.get_id();
        this.idPasien = user.getIdPasien();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.role = user.getRole();
        this.token = user.getToken();
        this.nama = user.getNama();
        this.alamat = user.getAlamat();
        this.noTelp = user.getNoTelp();
        this.golDarah = user.getGolDarah();
        this.jenisKelamin = user.getJenisKelamin();
        this.nik = user.getNik();
        this.email = user.getEmail();
    }


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(String idPasien) {
        this.idPasien = idPasien;
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

    public String getGolDarah() {
        return golDarah;
    }

    public void setGolDarah(String golDarah) {
        this.golDarah = golDarah;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
