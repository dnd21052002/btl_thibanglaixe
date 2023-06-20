package com.example.btl_thibanglaixe.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.btl_thibanglaixe.Object.MeoGhiNho;
import com.example.btl_thibanglaixe.R;

import java.util.ArrayList;
import java.util.List;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedViewHolder;

public class AdapterRecyclerViewMeoGhiNho extends SectionedRecyclerViewAdapter<AdapterRecyclerViewMeoGhiNho.HeaderViewHolder, AdapterRecyclerViewMeoGhiNho.ItemViewHolder> {
    private Context context;
    private List<MeoGhiNho> listMeoGhiNho;
    private LayoutInflater inflater;

    AdapterRecyclerViewMeoGhiNho(Context context, List<MeoGhiNho> listMeoGhiNho) {
        this.context = context;
        this.listMeoGhiNho = listMeoGhiNho;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.header_bienbao, parent, false);
        return new HeaderViewHolder(view);
    }

    @Override
    public ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.layout_recyclerview_meoghinho, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(HeaderViewHolder holder, int section, boolean expanded) {
        MeoGhiNho meoGhiNho = listMeoGhiNho.get(getSectionItems(section).get(0));
        String headerName = "";
        if (meoGhiNho.getLoai() == 0) {
            headerName = "MẸO CÂU HỎI LÝ THUYẾT";
        } else if (meoGhiNho.getLoai() == 1) {
            headerName = "MẸO CÂU HỎI BIỂN BÁO";
        } else if (meoGhiNho.getLoai() == 2) {
            headerName = "MẸO CÂU HỎI SA HÌNH";
        }
        holder.header.setText(headerName);
    }

    @Override
    public void onBindItemViewHolder(ItemViewHolder holder, int section, int position, boolean selected) {
        holder.tvNoiDung.setText(listMeoGhiNho.get(getSectionItems(section).get(position)).getNoiDung());
    }

    @Override
    public int getSectionCount() {
        return listMeoGhiNho.size() > 0 ? 3 : 0;
    }

    @Override
    public int getItemCount(int section) {
        int count = 0;
        for (int i = 0; i < listMeoGhiNho.size(); i++) {
            if (listMeoGhiNho.get(i).getLoai() == section) {
                count++;
            }
        }
        return count;
    }

    static class ItemViewHolder extends SectionedViewHolder {
        TextView tvNoiDung;

        ItemViewHolder(View itemView) {
            super(itemView);
            tvNoiDung = itemView.findViewById(R.id.tv_noiDung);
        }
    }

    static class HeaderViewHolder extends SectionedViewHolder {
        TextView header;

        HeaderViewHolder(View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.tvHeader);
        }
    }
}
