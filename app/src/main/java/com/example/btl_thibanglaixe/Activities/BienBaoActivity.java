package com.example.btl_thibanglaixe.Activities;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btl_thibanglaixe.Adapter.AdapterRecylerViewBienBao;
import com.example.btl_thibanglaixe.DAO.BienBaoDAO;
import com.example.btl_thibanglaixe.R;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;
public class BienBaoActivity extends AppCompatActivity {
    RecyclerView rcv_bienBao;
    AdapterRecylerViewBienBao adapterRecyclerViewBienBao;
    BienBaoDAO bienBaoDAO;
    private StickyRecyclerHeadersDecoration decor;
    Button btn_menu;
    Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienbao);
        setControl();
    }
    public void setControl(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        rcv_bienBao = findViewById(R.id.rcv_bienBao);
        rcv_bienBao.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        bienBaoDAO = new BienBaoDAO(this);
        adapterRecyclerViewBienBao = new AdapterRecylerViewBienBao(this,bienBaoDAO.getListBienBao());

//        DividerDecoration divider = new DividerDecoration.Builder(this)
//                .setHeight(R.dimen.default_divider_height)
//                .setPadding(R.dimen.default_divider_padding)
//                .setColorResource(R.color.default_header_color)
//                .build();
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);

        rcv_bienBao.setHasFixedSize(true);
        rcv_bienBao.addItemDecoration(divider);
        rcv_bienBao.setAdapter(adapterRecyclerViewBienBao);
        decor = new StickyRecyclerHeadersDecoration(adapterRecyclerViewBienBao);
        rcv_bienBao.addItemDecoration(decor, 1);
        rcv_bienBao.setOverScrollMode(View.OVER_SCROLL_ALWAYS);
        btn_menu = findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu
                        = new PopupMenu(BienBaoActivity.this,btn_menu);
                popupMenu.getMenuInflater().inflate(R.menu.menu_bienbao,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getItemId() == R.id.item_tatca){
                            adapterRecyclerViewBienBao
                                    = new AdapterRecylerViewBienBao(BienBaoActivity.this,bienBaoDAO.getListBienBao());
                            rcv_bienBao.removeItemDecoration(decor);
                            decor = new StickyRecyclerHeadersDecoration(adapterRecyclerViewBienBao);
                            rcv_bienBao.addItemDecoration(decor, 1);
                            rcv_bienBao.setAdapter(adapterRecyclerViewBienBao);

                        }
                        if(item.getItemId() == R.id.item_nguyhiem){
                            adapterRecyclerViewBienBao
                                    = new AdapterRecylerViewBienBao(BienBaoActivity.this,bienBaoDAO.getListBienBaoNguyHiem());
                            rcv_bienBao.removeItemDecoration(decor);
                            decor = new StickyRecyclerHeadersDecoration(adapterRecyclerViewBienBao);
                            rcv_bienBao.addItemDecoration(decor, 1);
                            rcv_bienBao.setAdapter(adapterRecyclerViewBienBao);
                        }
                        if(item.getItemId() == R.id.item_cam){
                            adapterRecyclerViewBienBao
                                    = new AdapterRecylerViewBienBao(BienBaoActivity.this,bienBaoDAO.getListBienBaoCam());
                            rcv_bienBao.removeItemDecoration(decor);
                            decor = new StickyRecyclerHeadersDecoration(adapterRecyclerViewBienBao);
                            rcv_bienBao.addItemDecoration(decor, 1);
                            rcv_bienBao.setAdapter(adapterRecyclerViewBienBao);
                        }
                        if(item.getItemId() == R.id.item_hieulenh){
                            adapterRecyclerViewBienBao
                                    = new AdapterRecylerViewBienBao(BienBaoActivity.this,bienBaoDAO.getListBienBaoHieuLenh());
                            rcv_bienBao.removeItemDecoration(decor);
                            decor = new StickyRecyclerHeadersDecoration(adapterRecyclerViewBienBao);
                            rcv_bienBao.addItemDecoration(decor, 1);
                            rcv_bienBao.setAdapter(adapterRecyclerViewBienBao);
                        }
                        if(item.getItemId() == R.id.item_chidan){
                            adapterRecyclerViewBienBao
                                    = new AdapterRecylerViewBienBao(BienBaoActivity.this,bienBaoDAO.getListBienBaoChiDan());
                            rcv_bienBao.removeItemDecoration(decor);
                            decor = new StickyRecyclerHeadersDecoration(adapterRecyclerViewBienBao);
                            rcv_bienBao.addItemDecoration(decor, 1);
                            rcv_bienBao.setAdapter(adapterRecyclerViewBienBao);
                        }
                        if(item.getItemId() == R.id.item_phu){
                            adapterRecyclerViewBienBao
                                    = new AdapterRecylerViewBienBao(BienBaoActivity.this,bienBaoDAO.getListBienBaoPhu());
                            rcv_bienBao.removeItemDecoration(decor);
                            decor = new StickyRecyclerHeadersDecoration(adapterRecyclerViewBienBao);
                            rcv_bienBao.addItemDecoration(decor, 1);
                            rcv_bienBao.setAdapter(adapterRecyclerViewBienBao);
                        }
                        return true;
                    }
                });
                popupMenu.setGravity(Gravity.CENTER_HORIZONTAL);
                popupMenu.show();
            }
        });
    }
}
