package com.example.btl_thibanglaixe.Model;

import java.io.Serializable;

public class CauHoi implements Serializable{
    private int id;
    private String cauHoi;
    private int anh;
    private String A;
    private String B;
    private String C;
    private String D;
    private String dapAn;
    private int lcA, lcB, lcC, lcD;

    public CauHoi(int id, String cauHoi, int anh, String a, String b, String c, String d, String dapAn) {
        this.id = id;
        this.cauHoi = cauHoi;
        this.anh = anh;
        A = a;
        B = b;
        C = c;
        D = d;
        this.dapAn = dapAn;
    }


    public int getLcA() {
        return lcA;
    }

    public void setLcA(int lcA) {
        this.lcA = lcA;
    }

    public int getLcB() {
        return lcB;
    }

    public void setLcB(int lcB) {
        this.lcB = lcB;
    }

    public int getLcC() {
        return lcC;
    }

    public void setLcC(int lcC) {
        this.lcC = lcC;
    }

    public int getLcD() {
        return lcD;
    }

    public void setLcD(int lcD) {
        this.lcD = lcD;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    public String getDapAn() {
        return dapAn;
    }

    public void setDapAn(String dapAn) {
        this.dapAn = dapAn;
    }
}

