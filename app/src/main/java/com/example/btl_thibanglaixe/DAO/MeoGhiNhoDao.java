package com.example.btl_thibanglaixe.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.btl_thibanglaixe.Databases.MeoGhiNhoDatabase;
import com.example.btl_thibanglaixe.Object.MeoGhiNho;

import java.util.ArrayList;
import java.util.List;


public class
MeoGhiNhoDAO {
    MeoGhiNhoDatabase meoGhiNhoDatabase;
    SQLiteDatabase database;
    public MeoGhiNhoDAO(Context context){
        meoGhiNhoDatabase = new MeoGhiNhoDatabase(context);
    }
    public void open(){
        database = meoGhiNhoDatabase.getReadableDatabase();
    }
    public void close(){
        meoGhiNhoDatabase.close();
    }
    public List<MeoGhiNho> getListMeoGhiNho(){
        List<MeoGhiNho> listMeoGhiNho = new ArrayList<>();
        open();
        String cauTruyVan = "select * from MEO";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            int loai = cursor.getInt(1);
            String noiDung = cursor.getString(2);
            MeoGhiNho meoGhiNho = new MeoGhiNho(id,loai,noiDung);
            listMeoGhiNho.add(meoGhiNho);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listMeoGhiNho;
    }
    public List<MeoGhiNho> getListMeoLyThuyet(){
        List<MeoGhiNho> listMeoGhiNho = new ArrayList<>();
        open();
        String cauTruyVan = "select * from MEO";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            int loai = cursor.getInt(1);
            String noiDung = cursor.getString(2);
            MeoGhiNho meoGhiNho = new MeoGhiNho(id,loai,noiDung);
            if (loai==0) listMeoGhiNho.add(meoGhiNho);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listMeoGhiNho;
    }
    public List<MeoGhiNho> getListMeoBienBao(){
        List<MeoGhiNho> listMeoGhiNho = new ArrayList<>();
        open();
        String cauTruyVan = "select * from MEO";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            int loai = cursor.getInt(1);
            String noiDung = cursor.getString(2);
            MeoGhiNho meoGhiNho = new MeoGhiNho(id,loai,noiDung);
            if (loai==1) listMeoGhiNho.add(meoGhiNho);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listMeoGhiNho;
    }
    public List<MeoGhiNho> getListMeoSaHinh(){
        List<MeoGhiNho> listMeoGhiNho = new ArrayList<>();
        open();
        String cauTruyVan = "select * from MEO";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            int loai = cursor.getInt(1);
            String noiDung = cursor.getString(2);
            MeoGhiNho meoGhiNho = new MeoGhiNho(id,loai,noiDung);
            if (loai==2) listMeoGhiNho.add(meoGhiNho);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listMeoGhiNho;
    }
}
