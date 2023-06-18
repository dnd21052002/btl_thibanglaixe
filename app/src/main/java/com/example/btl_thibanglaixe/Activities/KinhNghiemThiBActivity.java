package com.example.btl_thibanglaixe.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.btl_thibanglaixe.R;

public class KinhNghiemThiBActivity extends AppCompatActivity {

    Toolbar toolbar;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kinhnghiemthib);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        ScrollView scrollView = findViewById(R.id.scrollView);
        scrollView.setOverScrollMode(View.OVER_SCROLL_ALWAYS);
    }
}
