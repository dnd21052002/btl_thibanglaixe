package com.example.btl_thibanglaixe.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.btl_thibanglaixe.Model.MeoGhiNho;
import com.example.btl_thibanglaixe.R;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

import java.util.ArrayList;
import java.util.List;

public class AdapterRecyclerViewMeoGhiNho extends RecyclerView.Adapter<AdapterRecyclerViewMeoGhiNho.RecyclerViewHolder> implements StickyRecyclerHeadersAdapter<AdapterRecyclerViewMeoGhiNho.HeaderHolder>  {

    List<MeoGhiNho> listMeoGhiNho = new ArrayList<MeoGhiNho>();
    Context context;
    private final LayoutInflater mInflater;

    public AdapterRecyclerViewMeoGhiNho(Context context,List<MeoGhiNho> listMeoGhiNho) {
        this.listMeoGhiNho = listMeoGhiNho;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

//    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.layout_recyclerview_meoghinho, parent, false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.tv_noiDung.setText(listMeoGhiNho.get(position).getNoiDung());
    }

    @Override
    public int getItemCount() {
        return listMeoGhiNho.size();
    }

    @Override
    public long getHeaderId(int position) {
        return (long) listMeoGhiNho.get(position).getLoai();
    }

    @Override
    public HeaderHolder onCreateHeaderViewHolder(ViewGroup parent) {
        final View view = mInflater.inflate(R.layout.header_bienbao, parent, false);
        return new HeaderHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(HeaderHolder viewholder, int position) {
        String headerName = "";
        if (getHeaderId(position)==0){
            headerName = "MẸO CÂU HỎI LÝ THUYẾT";
        } else if (getHeaderId(position)==1){
            headerName = "MẸO CÂU HỎI BIỂN BÁO";
        } else if (getHeaderId(position)==2){
            headerName = "MẸO CÂU HỎI SA HÌNH";
        }
        viewholder.header.setText(headerName);
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView tv_noiDung;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            tv_noiDung = itemView.findViewById(R.id.tv_noiDung);
        }
    }

    static class HeaderHolder extends RecyclerView.ViewHolder {
        public TextView header;

        public HeaderHolder(View itemView) {
            super(itemView);
            header = (TextView) itemView;
        }
    }
}
