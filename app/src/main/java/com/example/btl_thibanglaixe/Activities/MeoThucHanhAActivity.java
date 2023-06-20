package com.example.btl_thibanglaixe.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
//import androidx.appcompat.app.ActionBar;
//import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.example.btl_thibanglaixe.R;
//import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

public class MeoThucHanhAActivity extends AppCompatActivity {
    TextView tv_kinhNghiemThiA;
    android.support.v7.widget.Toolbar toolbar;
    private InterstitialAd mInterstitialAd;
    int dem = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meothuchanha);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //Nếu quảng cáo đã tắt tiến hành load quảng cáo
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_id));
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                loadInterstitialAd();
            }
        });
        //Load sẵn quảng cáo khi ứng dụng mở
        loadInterstitialAd();
        tv_kinhNghiemThiA = findViewById(R.id.tv_kinhNghiemThiA);
        tv_kinhNghiemThiA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeoThucHanhAActivity.this,KinhNghiemThiAActivity.class);
                startActivity(intent);
                MainActivity.dem9++;
                if (MainActivity.dem9==3 || MainActivity.checkTime){
                    MainActivity.dem9 = 0;
                    MainActivity.checkTime = false;
                    mInterstitialAd.show();
                }
            }
        });
        ScrollView scrollView = findViewById(R.id.scrollView);
        OverScrollDecoratorHelper.setUpOverScroll(scrollView);
    }
    //Load InterstitialAd
    private void loadInterstitialAd() {
        if (mInterstitialAd != null) {
            AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .build();

            mInterstitialAd.loadAd(adRequest);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!mInterstitialAd.isLoaded())loadInterstitialAd();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!mInterstitialAd.isLoaded())loadInterstitialAd();
    }
}
