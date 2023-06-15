package com.example.btl_thibanglaixe.Databases;


import android.content.Context;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Hiep on 11/13/2017.
 */

public class LyThuyetDatabase extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "CauHoi.sqlite";
    private static final int DATABASE_VERSION = 1;
    public LyThuyetDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
