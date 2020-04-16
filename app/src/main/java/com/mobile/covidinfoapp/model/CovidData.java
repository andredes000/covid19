package com.mobile.covidinfoapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CovidData {
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("kode")
    @Expose
    public String kode;
    @SerializedName("total_odp")
    @Expose
    public String totalOdp;
    @SerializedName("pdp")
    @Expose
    public String pdp;
    @SerializedName("positif")
    @Expose
    public String positif;
    @SerializedName("odp_dalam_pemantauan")
    @Expose
    public String odpDalamPemantauan;
    @SerializedName("odp_selesai_pemantauan")
    @Expose
    public String odpSelesaiPemantauan;
    @SerializedName("pdp_masih_dirawat")
    @Expose
    public String pdpMasihDirawat;
    @SerializedName("pdp_meninggal")
    @Expose
    public String pdpMeninggal;
    @SerializedName("pdp_isolasidirumah")
    @Expose
    public String pdpIsolasidirumah;
    @SerializedName("pdp_pulangdan_sehat")
    @Expose
    public String pdpPulangdanSehat;
    @SerializedName("covid_dirawat")
    @Expose
    public String covidDirawat;
    @SerializedName("covid_isolasi_dirumah")
    @Expose
    public String covidIsolasiDirumah;
    @SerializedName("covid_meninggal")
    @Expose
    public String covidMeninggal;
    @SerializedName("covid_sembuh")
    @Expose
    public String covidSembuh;
    @SerializedName("waktu")
    @Expose
    public String waktu;

    public CovidData() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getTotalOdp() {
        return totalOdp;
    }

    public void setTotalOdp(String totalOdp) {
        this.totalOdp = totalOdp;
    }

    public String getPdp() {
        return pdp;
    }

    public void setPdp(String pdp) {
        this.pdp = pdp;
    }

    public String getPositif() {
        return positif;
    }

    public void setPositif(String positif) {
        this.positif = positif;
    }

    public String getOdpDalamPemantauan() {
        return odpDalamPemantauan;
    }

    public void setOdpDalamPemantauan(String odpDalamPemantauan) {
        this.odpDalamPemantauan = odpDalamPemantauan;
    }

    public String getOdpSelesaiPemantauan() {
        return odpSelesaiPemantauan;
    }

    public void setOdpSelesaiPemantauan(String odpSelesaiPemantauan) {
        this.odpSelesaiPemantauan = odpSelesaiPemantauan;
    }

    public String getPdpMasihDirawat() {
        return pdpMasihDirawat;
    }

    public void setPdpMasihDirawat(String pdpMasihDirawat) {
        this.pdpMasihDirawat = pdpMasihDirawat;
    }

    public String getPdpMeninggal() {
        return pdpMeninggal;
    }

    public void setPdpMeninggal(String pdpMeninggal) {
        this.pdpMeninggal = pdpMeninggal;
    }

    public String getPdpIsolasidirumah() {
        return pdpIsolasidirumah;
    }

    public void setPdpIsolasidirumah(String pdpIsolasidirumah) {
        this.pdpIsolasidirumah = pdpIsolasidirumah;
    }

    public String getPdpPulangdanSehat() {
        return pdpPulangdanSehat;
    }

    public void setPdpPulangdanSehat(String pdpPulangdanSehat) {
        this.pdpPulangdanSehat = pdpPulangdanSehat;
    }

    public String getCovidDirawat() {
        return covidDirawat;
    }

    public void setCovidDirawat(String covidDirawat) {
        this.covidDirawat = covidDirawat;
    }

    public String getCovidIsolasiDirumah() {
        return covidIsolasiDirumah;
    }

    public void setCovidIsolasiDirumah(String covidIsolasiDirumah) {
        this.covidIsolasiDirumah = covidIsolasiDirumah;
    }

    public String getCovidMeninggal() {
        return covidMeninggal;
    }

    public void setCovidMeninggal(String covidMeninggal) {
        this.covidMeninggal = covidMeninggal;
    }

    public String getCovidSembuh() {
        return covidSembuh;
    }

    public void setCovidSembuh(String covidSembuh) {
        this.covidSembuh = covidSembuh;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }
}
