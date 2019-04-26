package com.mrabid.pamedhisjav.model;

import java.io.Serializable;

public class Riwayat implements Serializable {
    private String idPasien;
    private String tanggal;
    private String idDokter;
    private int umur;
    private int beratBadan;
    private int tinggiBadan;
    private String riwayatKesehatanKeluarga;
    private String keluhanUtama;
    private String diagnosa;
    private String larangan;
    private String pemeriksaPenunjang;
    private String perawatan;
    private String advis;
    private String head;
    private String neck;
    private String thorax;
    private String abdomen;
    private String ekstremitas;
    private String catatan;

    public Riwayat(Riwayat riwayat) {
        this.idPasien = riwayat.getIdPasien();
        this.tanggal = riwayat.getTanggal();
        this.idDokter = riwayat.getIdDokter();
        this.umur = riwayat.getUmur();
        this.beratBadan = riwayat.getBeratBadan();
        this.tinggiBadan = riwayat.getTinggiBadan();
        this.riwayatKesehatanKeluarga = riwayat.getRiwayatKesehatanKeluarga();
        this.keluhanUtama = riwayat.getKeluhanUtama();
        this.diagnosa = riwayat.getDiagnosa();
        this.larangan = riwayat.getLarangan();
        this.pemeriksaPenunjang = riwayat.getPemeriksaPenunjang();
        this.perawatan = riwayat.getPerawatan();
        this.advis = riwayat.getAdvis();
        this.head = riwayat.getHead();
        this.neck = riwayat.getNeck();
        this.thorax = riwayat.getThorax();
        this.abdomen = riwayat.getAbdomen();
        this.ekstremitas = riwayat.getEkstremitas();
        this.catatan = riwayat.getCatatan();
    }

    public String getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(String idPasien) {
        this.idPasien = idPasien;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(String idDokter) {
        this.idDokter = idDokter;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public int getBeratBadan() {
        return beratBadan;
    }

    public void setBeratBadan(int beratBadan) {
        this.beratBadan = beratBadan;
    }

    public int getTinggiBadan() {
        return tinggiBadan;
    }

    public void setTinggiBadan(int tinggiBadan) {
        this.tinggiBadan = tinggiBadan;
    }

    public String getRiwayatKesehatanKeluarga() {
        return riwayatKesehatanKeluarga;
    }

    public void setRiwayatKesehatanKeluarga(String riwayatKesehatanKeluarga) {
        this.riwayatKesehatanKeluarga = riwayatKesehatanKeluarga;
    }

    public String getKeluhanUtama() {
        return keluhanUtama;
    }

    public void setKeluhanUtama(String keluhanUtama) {
        this.keluhanUtama = keluhanUtama;
    }

    public String getDiagnosa() {
        return diagnosa;
    }

    public void setDiagnosa(String diagnosa) {
        this.diagnosa = diagnosa;
    }

    public String getLarangan() {
        return larangan;
    }

    public void setLarangan(String larangan) {
        this.larangan = larangan;
    }

    public String getPemeriksaPenunjang() {
        return pemeriksaPenunjang;
    }

    public void setPemeriksaPenunjang(String pemeriksaPenunjang) {
        this.pemeriksaPenunjang = pemeriksaPenunjang;
    }

    public String getPerawatan() {
        return perawatan;
    }

    public void setPerawatan(String perawatan) {
        this.perawatan = perawatan;
    }

    public String getAdvis() {
        return advis;
    }

    public void setAdvis(String advis) {
        this.advis = advis;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }

    public String getThorax() {
        return thorax;
    }

    public void setThorax(String thorax) {
        this.thorax = thorax;
    }

    public String getAbdomen() {
        return abdomen;
    }

    public void setAbdomen(String abdomen) {
        this.abdomen = abdomen;
    }

    public String getEkstremitas() {
        return ekstremitas;
    }

    public void setEkstremitas(String ekstremitas) {
        this.ekstremitas = ekstremitas;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }
}
