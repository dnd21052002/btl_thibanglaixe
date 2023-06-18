package com.example.btl_thibanglaixe.Activities;

import static com.example.btl_thibanglaixe.Activities.ThiSatHachActivity.SIZE;
import static com.example.btl_thibanglaixe.Activities.ThiSatHachActivity.checkDungSai;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btl_thibanglaixe.Adapter.AdapterRecyclerViewLichSuBaiThi;
import com.example.btl_thibanglaixe.Adapter.AdapterRecyclerViewXemDapAn;
import com.example.btl_thibanglaixe.DAO.CauHoiDAO;
import com.example.btl_thibanglaixe.Model.CauHoi;
import com.example.btl_thibanglaixe.R;
import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import java.util.ArrayList;
import java.util.List;

public class XemLaiDapAnActivity extends AppCompatActivity {
    RecyclerView rcv_xemDapAn;
    CauHoiDAO cauHoiDAO;
    public static List<CauHoi> list;
    List<CauHoi> listCauHoi = new ArrayList<CauHoi>();
    AdapterRecyclerViewXemDapAn adapterRecyclerViewXemDapAn;
    Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xemlaidapan);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        rcv_xemDapAn = findViewById(R.id.rcv_xemDapAn);
        cauHoiDAO = new CauHoiDAO(this);
        listCauHoi = cauHoiDAO.getListCauHoi();
        list = new ArrayList<>();
        if (getIntent().getCharExtra("from",' ')=='l') {
            list = AdapterRecyclerViewLichSuBaiThi.getListCauHoi();
            adapterRecyclerViewXemDapAn = new AdapterRecyclerViewXemDapAn(this,list,checkDungSai,'t');
        }
        else {
            for (int i=0;i<SIZE;i++){
                this.list.add(ThiSatHachActivity.list.get(i));
            }
            adapterRecyclerViewXemDapAn = new AdapterRecyclerViewXemDapAn(this,list,checkDungSai,'t');
        }
        rcv_xemDapAn.setAdapter(adapterRecyclerViewXemDapAn);
        rcv_xemDapAn.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rcv_xemDapAn.setOverScrollMode(View.OVER_SCROLL_ALWAYS);
        RecyclerViewHeader header = findViewById(R.id.header);
        header.attachTo(rcv_xemDapAn);
    }
}

