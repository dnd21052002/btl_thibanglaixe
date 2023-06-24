package com.example.btl_thibanglaixe.Activities;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Dialog;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.btl_thibanglaixe.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout bt_thiSatHach, bt_bienBao, bt_lyThuyet, bt_meoGhiNho, bt_meoThucHanh, bt_lichSuBaiThi;
    Button bt_a121, bt_b121, bt_cancel1, bt_a122, bt_b122, bt_cancel2, bt_cancel3, bt_logout, bt_dongY1;
    Dialog dialogThiSatHach, dialogMeoThucHanh, dialogDangXuat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
    }

    public void setControl(){
        bt_thiSatHach = findViewById(R.id.bt_thiSatHach);
        bt_bienBao = findViewById(R.id.bt_bienBao);
        bt_lyThuyet = findViewById(R.id.bt_lyThuyet);
        bt_meoGhiNho = findViewById(R.id.bt_meoGhiNho);
        bt_meoThucHanh = findViewById(R.id.bt_meoThucHanh);
        bt_lichSuBaiThi = findViewById(R.id.bt_lichSuBaiThi);
        bt_logout = findViewById(R.id.btn_logout);
        bt_thiSatHach.setOnClickListener(this);
        bt_bienBao.setOnClickListener(this);
        bt_lyThuyet.setOnClickListener(this);
        bt_meoGhiNho.setOnClickListener(this);
        bt_meoThucHanh.setOnClickListener(this);
        bt_lichSuBaiThi.setOnClickListener(this);
        bt_logout.setOnClickListener(this);
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
    public void setDialogMeoThucHanh(){
        dialogMeoThucHanh = new Dialog(this);
        dialogMeoThucHanh.setContentView(R.layout.custom_dialog_meothuchanh);
        dialogMeoThucHanh.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogMeoThucHanh.setCanceledOnTouchOutside(true);
        dialogMeoThucHanh.show();
        bt_a122 = dialogMeoThucHanh.findViewById(R.id.bt_a122);
        bt_b122 = dialogMeoThucHanh.findViewById(R.id.bt_b122);
        bt_cancel2 = dialogMeoThucHanh.findViewById(R.id.bt_cancel2);
        bt_a122.setOnClickListener(this);
        bt_b122.setOnClickListener(this);
        bt_cancel2.setOnClickListener(this);
    }

    public void setDialogDangXuat() {
        dialogDangXuat = new Dialog(this);
        dialogDangXuat.setContentView(R.layout.custom_dialog_dangxuat);
        dialogDangXuat.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogDangXuat.setCanceledOnTouchOutside(true);
        dialogDangXuat.show();
        bt_cancel3 = dialogDangXuat.findViewById(R.id.bt_cancel3);
        bt_dongY1 = dialogDangXuat.findViewById(R.id.bt_dongY1);
        bt_cancel3.setOnClickListener(this);
        bt_dongY1.setOnClickListener(this);

    }

    public void onClick(View view) {
        if (view.getId() == R.id.btn_logout) {
            setDialogDangXuat();
        }
        if (view.getId() == R.id.bt_cancel3) {
            dialogDangXuat.dismiss();
        }
        if (view.getId() == R.id.bt_dongY1) {
            Intent intentDangNhap = new Intent(MainActivity.this, DangNhapActivity.class);
            startActivity(intentDangNhap);
        }
        if (view.getId() == R.id.bt_thiSatHach) {
            setDialogThiSatHach();
        }
        if(view.getId() == R.id.bt_bienBao){
            Intent intentBienBao = new Intent(this,BienBaoActivity.class);
            startActivity(intentBienBao);
        }
        if(view.getId() == R.id.bt_meoGhiNho){
            Intent intentMeoGhiNho = new Intent(this,MeoGhiNhoActivity.class);
            startActivity(intentMeoGhiNho);
        }

        if(view.getId() == R.id.bt_meoThucHanh) {
                setDialogMeoThucHanh();
        }
        if (view.getId() == R.id.bt_lyThuyet) {
            Intent intentLyThuyet = new Intent(MainActivity.this, LyThuyetActivity.class);
            startActivity(intentLyThuyet);

        }

        if(view.getId() == R.id.bt_lichSuBaiThi) {
            Intent intent_lichsu = new Intent(MainActivity.this,LichSuBaiThiActivity.class);
            startActivity(intent_lichsu);
        }
        if(view.getId() == R.id.bt_cancel1) {
            dialogThiSatHach.dismiss();
        }

        if(view.getId() == R.id.bt_cancel2) {
            dialogMeoThucHanh.dismiss();
        }

        if(view.getId() == R.id.bt_a121) {
            Intent intentThiSatHachA = new Intent(MainActivity.this, ThiSatHachActivity.class);
            intentThiSatHachA.putExtra("tenBaiThi",'a');
            startActivity(intentThiSatHachA);
            dialogThiSatHach.dismiss();
        }

        if(view.getId() == R.id.bt_b121) {
            Intent intentThiSatHachB = new Intent(MainActivity.this, ThiSatHachActivity.class);
            intentThiSatHachB.putExtra("tenBaiThi",'b');
            startActivity(intentThiSatHachB);
            dialogThiSatHach.dismiss();
        }

        if(view.getId() == R.id.bt_a122){
            Intent intentThucHanhA = new Intent(MainActivity.this,MeoThucHanhAActivity.class);
            startActivity(intentThucHanhA);
            dialogMeoThucHanh.dismiss();
        }
        if(view.getId() == R.id.bt_b122){
            Intent intentThucHanhB = new Intent(MainActivity.this,MeoThucHanhBActivity.class);
            startActivity(intentThucHanhB);
            dialogMeoThucHanh.dismiss();
        }

    }

}