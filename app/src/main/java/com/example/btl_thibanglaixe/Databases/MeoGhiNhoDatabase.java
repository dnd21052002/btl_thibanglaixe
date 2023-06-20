package com.example.btl_thibanglaixe.Databases;

import android.content.Context;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class MeoGhiNhoDatabase extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "MEO.sqlite";
    private static final int DATABASE_VERSION = 1;
    public MeoGhiNhoDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
