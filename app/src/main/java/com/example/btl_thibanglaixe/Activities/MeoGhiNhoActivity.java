package com.example.btl_thibanglaixe.Activities;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
//import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btl_thibanglaixe.Adapter.AdapterRecyclerViewMeoGhiNho;
import com.example.btl_thibanglaixe.DAO.MeoGhiNhoDAO;
import com.example.btl_thibanglaixe.R;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;

public class MeoGhiNhoActivity extends AppCompatActivity {
    RecyclerView rcv_meoGhiNho;
    AdapterRecyclerViewMeoGhiNho adapterRecyclerViewMeoGhiNho;
    MeoGhiNhoDAO meoGhiNhoDAO;
    private StickyRecyclerHeadersDecoration decor;
    Button btn_menu;
    Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meoghinho);
        setControl();
    }
    public void setControl(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        rcv_meoGhiNho = findViewById(R.id.rcv_meoGhiNho);
        rcv_meoGhiNho.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        meoGhiNhoDAO = new MeoGhiNhoDAO(this);
        adapterRecyclerViewMeoGhiNho = new AdapterRecyclerViewMeoGhiNho(this,meoGhiNhoDAO.getListMeoGhiNho());
//        DividerDecoration divider = new DividerDecoration.Builder(this)
//                .setHeight(R.dimen.default_divider_height)
//                .setPadding(R.dimen.default_divider_padding)
//                .setColorResource(R.color.default_header_color)
//                .build();
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);

        rcv_meoGhiNho.setHasFixedSize(true);
        rcv_meoGhiNho.addItemDecoration(divider);
        rcv_meoGhiNho.setAdapter(adapterRecyclerViewMeoGhiNho);
        decor = new StickyRecyclerHeadersDecoration(adapterRecyclerViewMeoGhiNho);
        rcv_meoGhiNho.addItemDecoration(decor, 1);
//        OverScrollDecoratorHelper.setUpOverScroll(rcv_meoGhiNho, OverScrollDecoratorHelper.ORIENTATION_VERTICAL);
        btn_menu = findViewById(R.id.btn_menu);

        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              PopupMenu popupMenu
                      = new PopupMenu(MeoGhiNhoActivity.this,btn_menu);
              popupMenu.getMenuInflater().inflate(R.menu.menu_meoghinho,popupMenu.getMenu());

              popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.item_tatca) {
                            adapterRecyclerViewMeoGhiNho
                                    = new AdapterRecyclerViewMeoGhiNho(MeoGhiNhoActivity.this, meoGhiNhoDAO.getListMeoGhiNho());
                            rcv_meoGhiNho.removeItemDecoration(decor);
                            decor = new StickyRecyclerHeadersDecoration(adapterRecyclerViewMeoGhiNho);
                            rcv_meoGhiNho.addItemDecoration(decor, 1);
                            rcv_meoGhiNho.setAdapter(adapterRecyclerViewMeoGhiNho);
                        }
                        if(item.getItemId() == R.id.item_meolythuyet) {
                            adapterRecyclerViewMeoGhiNho
                                    = new AdapterRecyclerViewMeoGhiNho(MeoGhiNhoActivity.this, meoGhiNhoDAO.getListMeoLyThuyet());
                            rcv_meoGhiNho.removeItemDecoration(decor);
                            decor = new StickyRecyclerHeadersDecoration(adapterRecyclerViewMeoGhiNho);
                            rcv_meoGhiNho.addItemDecoration(decor, 1);
                            rcv_meoGhiNho.setAdapter(adapterRecyclerViewMeoGhiNho);
                        }
                        if(item.getItemId() == R.id.item_meobienbao) {
                            adapterRecyclerViewMeoGhiNho
                                    = new AdapterRecyclerViewMeoGhiNho(MeoGhiNhoActivity.this, meoGhiNhoDAO.getListMeoBienBao());
                            rcv_meoGhiNho.removeItemDecoration(decor);
                            decor = new StickyRecyclerHeadersDecoration(adapterRecyclerViewMeoGhiNho);
                            rcv_meoGhiNho.addItemDecoration(decor, 1);
                            rcv_meoGhiNho.setAdapter(adapterRecyclerViewMeoGhiNho);
                        }
                        if(item.getItemId() == R.id.item_meosahinh){
                            adapterRecyclerViewMeoGhiNho
                                        = new AdapterRecyclerViewMeoGhiNho(MeoGhiNhoActivity.this,meoGhiNhoDAO.getListMeoSaHinh());
                            rcv_meoGhiNho.removeItemDecoration(decor);
                            decor = new StickyRecyclerHeadersDecoration(adapterRecyclerViewMeoGhiNho);
                            rcv_meoGhiNho.addItemDecoration(decor, 1);
                            rcv_meoGhiNho.setAdapter(adapterRecyclerViewMeoGhiNho);
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
