package com.example.btl_thibanglaixe.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.btl_thibanglaixe.Databases.NguoiDungDatabase;

public class NguoiDungDao{
    NguoiDungDatabase nguoiDungDatabase;
    SQLiteDatabase database;
    public NguoiDungDao(Context context){
        nguoiDungDatabase = new NguoiDungDatabase(context);
    }
    public void open(){
        database = nguoiDungDatabase.getReadableDatabase();
    }

    public void openWrite(){
        database = nguoiDungDatabase.getWritableDatabase();
    }
    public void close(){
        nguoiDungDatabase.close();
    }

    public boolean checkUser() {
        open();
        String cauTruyVan = "select * from NguoiDung";
        Cursor cursor = database.rawQuery(cauTruyVan, null);
        if (cursor.getCount() > 0) {
            cursor.close();
            close();
            return true;
        }
        cursor.close();
        close();
        return false;
    }

    public boolean checkLogin(String username, String password) {
        open();
        String cauTruyVan = "select * from NguoiDung where username = '" + username + "' and password = '" + password + "'";
        Cursor cursor = database.rawQuery(cauTruyVan, null);
        if (cursor.getCount() > 0) {
            cursor.close();
            close();
            return true;
        }
        cursor.close();
        close();
        return false;
    }

    public void addUser(String username, String password, String email, String name) {
        openWrite();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password", password);
        values.put("email", email);
        values.put("name", name);
        database.insert("NguoiDung", null, values);
        close();
    }

    public boolean userExist(String username) {
        open();
        String cauTruyVan = "select * from NguoiDung where username = '" + username + "'";
        Cursor cursor = database.rawQuery(cauTruyVan, null);
        if (cursor.getCount() > 0) {
            cursor.close();
            close();
            return true;
        }
        cursor.close();
        close();
        return false;
    }

    public void updatePassword(String username, String password) {
        openWrite();
        ContentValues values = new ContentValues();
        values.put("password", password);
        database.update("NguoiDung", values, "username = '" + username + "'", null);
        close();
    }

}
