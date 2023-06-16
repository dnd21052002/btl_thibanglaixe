package com.example.btl_thibanglaixe.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.btl_thibanglaixe.Databases.BienBaoDatabase;
import com.example.btl_thibanglaixe.Model.BienBao;

import java.util.ArrayList;
import java.util.List;

public class BienBaoDAO {
    BienBaoDatabase bienBaoDatabase;
    SQLiteDatabase database;
    public BienBaoDAO(Context context){
        bienBaoDatabase = new BienBaoDatabase(context);
    }
    public void open(){
        database = bienBaoDatabase.getReadableDatabase();
    }
    public void close(){
        bienBaoDatabase.close();
    }
    public List<BienBao> getListBienBao(){
        List<BienBao> listBienBao = new ArrayList<>();
        open();
        String cauTruyVan = "select * from BIENBAO";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String image = cursor.getString(0);
            String noiDung = cursor.getString(1);
            int loaiBien = cursor.getInt(2);
            BienBao bienBao;
            if (image.compareTo("0")!=0) {
                bienBao = new BienBao(noiDung,"bienbao"+image,loaiBien);
                listBienBao.add(bienBao);
            }
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listBienBao;
    }
    public List<BienBao> getListBienBaoNguyHiem(){
        List<BienBao> listBienBao = new ArrayList<>();
        open();
        String cauTruyVan = "select * from BIENBAO where loaibien = 1";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String image = cursor.getString(0);
            String noiDung = cursor.getString(1);
            int loaiBien = cursor.getInt(2);
            BienBao bienBao;
            if (image.compareTo("0")!=0) {
                bienBao = new BienBao(noiDung,"bienbao"+image,loaiBien);
                listBienBao.add(bienBao);
            }
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listBienBao;
    }
    public List<BienBao> getListBienBaoCam(){
        List<BienBao> listBienBao = new ArrayList<>();
        open();
        String cauTruyVan = "select * from BIENBAO where loaibien = 2";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String image = cursor.getString(0);
            String noiDung = cursor.getString(1);
            int loaiBien = cursor.getInt(2);
            BienBao bienBao;
            if (image.compareTo("0")!=0) {
                bienBao = new BienBao(noiDung,"bienbao"+image,loaiBien);
                listBienBao.add(bienBao);
            }
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listBienBao;
    }
    public List<BienBao> getListBienBaoHieuLenh(){
        List<BienBao> listBienBao = new ArrayList<>();
        open();
        String cauTruyVan = "select * from BIENBAO where loaibien = 3";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String image = cursor.getString(0);
            String noiDung = cursor.getString(1);
            int loaiBien = cursor.getInt(2);
            BienBao bienBao;
            if (image.compareTo("0")!=0) {
                bienBao = new BienBao(noiDung,"bienbao"+image,loaiBien);
                listBienBao.add(bienBao);
            }
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listBienBao;
    }
    public List<BienBao> getListBienBaoChiDan(){
        List<BienBao> listBienBao = new ArrayList<>();
        open();
        String cauTruyVan = "select * from BIENBAO where loaibien = 4";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String image = cursor.getString(0);
            String noiDung = cursor.getString(1);
            int loaiBien = cursor.getInt(2);
            BienBao bienBao;
            if (image.compareTo("0")!=0) {
                bienBao = new BienBao(noiDung,"bienbao"+image,loaiBien);
                listBienBao.add(bienBao);
            }
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listBienBao;
    }
    public List<BienBao> getListBienBaoPhu(){
        List<BienBao> listBienBao = new ArrayList<>();
        open();
        String cauTruyVan = "select * from BIENBAO where loaibien = 5";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String image = cursor.getString(0);
            String noiDung = cursor.getString(1);
            int loaiBien = cursor.getInt(2);
            BienBao bienBao;
            if (image.compareTo("0")!=0) {
                bienBao = new BienBao(noiDung,"bienbao"+image,loaiBien);
                listBienBao.add(bienBao);
            }
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listBienBao;
    }
}
