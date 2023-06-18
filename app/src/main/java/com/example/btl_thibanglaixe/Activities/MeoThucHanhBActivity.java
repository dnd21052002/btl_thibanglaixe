package com.example.btl_thibanglaixe.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.btl_thibanglaixe.R;

public class MeoThucHanhBActivity extends AppCompatActivity {
    TextView tv_kinhNghiemThiB;
    Toolbar toolbar;

    int dem = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meothuchanhb);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        tv_kinhNghiemThiB = findViewById(R.id.tv_kinhNghiemThiB);
        tv_kinhNghiemThiB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeoThucHanhBActivity.this,KinhNghiemThiBActivity.class);
                startActivity(intent);
            }
        });
        ScrollView scrollView = findViewById(R.id.scrollView);
        scrollView.setOverScrollMode(View.OVER_SCROLL_ALWAYS);
    }

}
