package com.example.btl_thibanglaixe.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.btl_thibanglaixe.R;

import java.lang.Runnable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Runnable{

    LinearLayout bt_thiSatHach, bt_bienBao, bt_lyThuyet, bt_meoGhiNho, bt_meoThucHanh, bt_lichSuBaiThi;
    Button bt_a121, bt_b121, bt_cancel1, bt_a122, bt_b122, bt_cancel2;
    Dialog dialogThiSatHach, dialogMeoThucHanh;
    int dem1 = 0,dem2=0, dem3 = 0, dem4 = 0, dem5=0,dem6=0;
    //dem act thi sat hach, bien bao, ly thuyet, meo ghi nho, meo thuc hanh, lichsubaithi to load ad
    public static int dem7=0,dem8=0,dem9=0,dem10=0;
    //dem act ketquathi, xemlaidapan, kinhnghiema, kinhnghiemb to load ad;
    Thread t;
    int time = 0;
    public static boolean checkTime = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        t = new Thread(this);
        t.start();
    }

    public void setControl(){
        bt_thiSatHach = findViewById(R.id.bt_thiSatHach);
        bt_bienBao = findViewById(R.id.bt_bienBao);
        bt_lyThuyet = findViewById(R.id.bt_lyThuyet);
        bt_meoGhiNho = findViewById(R.id.bt_meoGhiNho);
        bt_meoThucHanh = findViewById(R.id.bt_meoThucHanh);
        bt_lichSuBaiThi = findViewById(R.id.bt_lichSuBaiThi);
        bt_thiSatHach.setOnClickListener(this);
        bt_bienBao.setOnClickListener(this);
        bt_lyThuyet.setOnClickListener(this);
        bt_meoGhiNho.setOnClickListener(this);
        bt_meoThucHanh.setOnClickListener(this);
        bt_lichSuBaiThi.setOnClickListener(this);
    }

    public void setDialogThiSatHach(){
        dialogThiSatHach = new Dialog(this);
        dialogThiSatHach.setContentView(R.layout.custom_dialog_thisathach);
        dialogThiSatHach.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogThiSatHach.setCanceledOnTouchOutside(true);
        dialogThiSatHach.show();
        bt_a121 = dialogThiSatHach.findViewById(R.id.bt_a121);
        bt_b121 = dialogThiSatHach.findViewById(R.id.bt_b121);
        bt_cancel1 = dialogThiSatHach.findViewById(R.id.bt_cancel1);
        bt_a121.setOnClickListener(this);
        bt_b121.setOnClickListener(this);
        bt_cancel1.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View view) {
        if (view.getId() == R.id.bt_thiSatHach) {
            setDialogThiSatHach();
        }

        if(view.getId() == R.id.bt_lichSuBaiThi) {
            Intent intent_lichsu = new Intent(MainActivity.this,LichSuBaiThiActivity.class);
            startActivity(intent_lichsu);
            dem6++;
            if (dem6==3 || checkTime){
                dem6 = 0;
                checkTime = false;
            }
        }
        if(view.getId() == R.id.bt_cancel1) {
            dialogThiSatHach.dismiss();
        }

        if(view.getId() == R.id.bt_a121) {
            Intent intentThiSatHachA = new Intent(MainActivity.this, ThiSatHachActivity.class);
            intentThiSatHachA.putExtra("tenBaiThi",'a');
            startActivity(intentThiSatHachA);
            dialogThiSatHach.dismiss();
            dem1++;
            if (dem1==3 || checkTime){
                dem1 = 0;
                checkTime = false;
            }
        }

    }

    @Override
    public void run() {
        while (true) {
            time+=1;
            if (time== 180) {
                checkTime = true;
                time = 0;
                Log.d("Checktime","OK");
            }
            try {
                t.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}