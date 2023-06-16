package com.example.btl_thibanglaixe.Model;

public class BienBao {
    private String noiDung;
    private String image;
    private int loaiBien;

    public BienBao(String noiDung, String image, int loaiBien) {
        this.noiDung = noiDung;
        this.image = image;
        this.loaiBien = loaiBien;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLoaiBien() {
        return loaiBien;
    }

    public void setLoaiBien(int loaiBien) {
        this.loaiBien = loaiBien;
    }
}
