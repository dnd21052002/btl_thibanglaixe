package com.example.btl_thibanglaixe.Model;

public class MeoGhiNho {
    int id;
    int loai;
    String noiDung;

    public MeoGhiNho(int id, int loai, String noiDung) {
        this.id = id;
        this.loai = loai;
        this.noiDung = noiDung;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
