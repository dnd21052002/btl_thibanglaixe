package com.example.btl_thibanglaixe.Databases;

import android.content.Context;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;



public class NguoiDungDatabase extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "NguoiDung.sqlite";
    private static final int DATABASE_VERSION = 1;
    public NguoiDungDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
