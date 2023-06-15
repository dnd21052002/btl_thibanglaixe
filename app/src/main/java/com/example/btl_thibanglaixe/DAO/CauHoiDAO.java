package com.example.btl_thibanglaixe.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.btl_thibanglaixe.Databases.LyThuyetDatabase;
import com.example.btl_thibanglaixe.Model.CauHoi;

import java.util.ArrayList;
import java.util.List;

public class CauHoiDAO {
    LyThuyetDatabase lyThuyetDatabase;
    SQLiteDatabase database;
    public CauHoiDAO(Context context){
        lyThuyetDatabase = new LyThuyetDatabase(context);
    }
    public void open(){
        database = lyThuyetDatabase.getReadableDatabase();
    }
    public void close(){
        lyThuyetDatabase.close();
    }
    public List<CauHoi> getListCauHoi(int i){
        List<CauHoi> listCauHoi = new ArrayList<>();
        open();
        String cauTruyVan = "select * from CAUHOI where id between "+((i-1)*25+1)+" and "+(i*25)+"";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            String cauHoi = cursor.getString(1);
            int anh = cursor.getInt(2);
            String A = cursor.getString(3);
            String B = cursor.getString(4);
            String C = cursor.getString(5);
            String D = cursor.getString(6);
            String dapAn = cursor.getString(7);
            CauHoi cauhoi = new CauHoi(id,cauHoi,anh,A,B,C,D,dapAn);
            listCauHoi.add(cauhoi);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        Log.d("SIZE = ",listCauHoi.size()+"");
        return listCauHoi;
    }
    public List<CauHoi> getListCauHoi(){
        List<CauHoi> listCauHoi = new ArrayList<>();
        open();
        String cauTruyVan = "select * from CAUHOI";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            String cauHoi = cursor.getString(1);
            int anh = cursor.getInt(2);
            String A = cursor.getString(3);
            String B = cursor.getString(4);
            String C = cursor.getString(5);
            String D = cursor.getString(6);
            String dapAn = cursor.getString(7);
            CauHoi cauhoi = new CauHoi(id,cauHoi,anh,A,B,C,D,dapAn);
            listCauHoi.add(cauhoi);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        Log.d("SIZE = ",listCauHoi.size()+"");
        return listCauHoi;
    }
}
