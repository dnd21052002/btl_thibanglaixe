package com.example.btl_thibanglaixe.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.btl_thibanglaixe.R;


public class MeoThucHanhAActivity extends AppCompatActivity {
    TextView tv_kinhNghiemThiA;
    androidx.appcompat.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meothuchanha);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        tv_kinhNghiemThiA = findViewById(R.id.tv_kinhNghiemThiA);
        tv_kinhNghiemThiA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeoThucHanhAActivity.this, KinhNghiemThiAActivity.class);
                startActivity(intent);
            }
        });

        ScrollView scrollView = findViewById(R.id.scrollView);
        scrollView.setOverScrollMode(View.OVER_SCROLL_NEVER);
    }
}
