package com.example.btl_thibanglaixe.Adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.btl_thibanglaixe.Model.CauHoi;
import com.example.btl_thibanglaixe.R;

import java.util.ArrayList;
import java.util.List;


public class AdapterRecyclerViewXemDapAn extends RecyclerView.Adapter<AdapterRecyclerViewXemDapAn.RecyclerViewHolder> {
    List<CauHoi> listCauHoi = new ArrayList<CauHoi>();
    Context context;
    private LayoutInflater mInflater;
    boolean[] checkDungSai;
    char c;
    public AdapterRecyclerViewXemDapAn(Context context,List<CauHoi> listCauHoi,boolean[] checkDungSai,char c) {
        this.listCauHoi = listCauHoi;
        this.context = context;
        mInflater = LayoutInflater.from(context);
        this.checkDungSai = checkDungSai;
        this.c = c;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.layout_recyclerview_xemlaidapan,parent,false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.tv_stt.setText((position+1)+"");
        holder.tv_cauHoi.setText(listCauHoi.get(position).getCauHoi());
        if (listCauHoi.get(position).getAnh()==1) {
            holder.anhCauHoi.setImageDrawable(getDrawable(context,position));
            holder.anhCauHoi.setVisibility(View.VISIBLE);
        }
        else holder.anhCauHoi.setVisibility(View.GONE);
        holder.A.setText(listCauHoi.get(position).getA());
        if (listCauHoi.get(position).getDapAn().contains("1")) holder.A.setTextColor(Color.parseColor("#4CAF50"));
        else holder.A.setTextColor(Color.BLACK);
        holder.B.setText(listCauHoi.get(position).getB());
        if (listCauHoi.get(position).getDapAn().contains("2")) holder.B.setTextColor(Color.parseColor("#4CAF50"));
        else holder.B.setTextColor(Color.BLACK);
        if (listCauHoi.get(position).getC().compareTo("")==0){
            holder.view_B_.setVisibility(View.VISIBLE);
            holder.view_B.setVisibility(View.GONE);
        } else {
            holder.view_B_.setVisibility(View.GONE);
            holder.view_B.setVisibility(View.VISIBLE);
        }
        if (listCauHoi.get(position).getC().compareTo("")!=0){
            holder.C.setVisibility(View.VISIBLE);
            holder.C.setText(listCauHoi.get(position).getC());
            if (listCauHoi.get(position).getDapAn().contains("3")) holder.C.setTextColor(Color.parseColor("#4CAF50"));
            else holder.C.setTextColor(Color.BLACK);
            holder.view_C.setVisibility(View.VISIBLE);
            if (listCauHoi.get(position).getD().compareTo("")==0){
                holder.view_C_.setVisibility(View.VISIBLE);
                holder.view_C.setVisibility(View.GONE);
            } else {
                holder.view_C_.setVisibility(View.GONE);
                holder.view_C.setVisibility(View.VISIBLE);
            }
        } else {
            holder.C.setVisibility(View.GONE);
            holder.view_C.setVisibility(View.GONE);
            holder.view_C_.setVisibility(View.GONE);
        }
        if (listCauHoi.get(position).getD().compareTo("")!=0){
            holder.D.setVisibility(View.VISIBLE);
            holder.D.setText(listCauHoi.get(position).getD());
            if (listCauHoi.get(position).getDapAn().contains("4")) holder.D.setTextColor(Color.parseColor("#4CAF50"));
            else holder.D.setTextColor(Color.BLACK);
            holder.view_D.setVisibility(View.VISIBLE);
        } else {
            holder.D.setVisibility(View.GONE);
            holder.view_D.setVisibility(View.GONE);
        }
        if (checkDungSai[position]) holder.img_dungSai.setImageDrawable(getDrawable1(context,"ic_true"));
        else holder.img_dungSai.setImageDrawable(getDrawable1(context,"ic_false"));
        if (!listCauHoi.get(position).getDapAn().contains("1")&&listCauHoi.get(position).getLcA()==1)
            holder.A.setTextColor(Color.RED);
        if (!listCauHoi.get(position).getDapAn().contains("2")&&listCauHoi.get(position).getLcB()==1)
            holder.B.setTextColor(Color.RED);
        if (!listCauHoi.get(position).getDapAn().contains("3")&&listCauHoi.get(position).getLcC()==1)
            holder.C.setTextColor(Color.RED);
        if (!listCauHoi.get(position).getDapAn().contains("4")&&listCauHoi.get(position).getLcD()==1)
            holder.D.setTextColor(Color.RED);
        if (c=='t'){
            holder.img_dungSai.setVisibility(View.VISIBLE);
        } else {
            holder.img_dungSai.setVisibility(View.GONE);
        }
    }

    public Drawable getDrawable(Context context, int position){
        Resources resources = context.getResources();
        final int resourceId = resources.getIdentifier("cauhoi"+listCauHoi.get(position).getId()+"", "drawable",
                context.getPackageName());
        Drawable drawable = resources.getDrawable(resourceId);
        return drawable;
    }

    public Drawable getDrawable1(Context context, String name){
        Resources resources = context.getResources();
        final int resourceId = resources.getIdentifier(name, "drawable",
                context.getPackageName());
        Drawable drawable = resources.getDrawable(resourceId);
        return drawable;
    }

    @Override
    public int getItemCount() {
        return listCauHoi.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView tv_cauHoi, tv_stt;
        ImageView anhCauHoi,img_dungSai;
        TextView A,B,C,D;
        View view_A, view_B, view_C, view_D, view_B_, view_C_;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            tv_stt = itemView.findViewById(R.id.tv_stt);
            tv_cauHoi = itemView.findViewById(R.id.tv_cauHoi);
            anhCauHoi = itemView.findViewById(R.id.anhCauHoi);
            img_dungSai = itemView.findViewById(R.id.img_dungSai);
            A = itemView.findViewById(R.id.A);
            B = itemView.findViewById(R.id.B);
            C = itemView.findViewById(R.id.C);
            D = itemView.findViewById(R.id.D);
            view_A = itemView.findViewById(R.id.view_A);
            view_B = itemView.findViewById(R.id.view_B);
            view_C = itemView.findViewById(R.id.view_C);
            view_D = itemView.findViewById(R.id.view_D);
            view_B_ = itemView.findViewById(R.id.view_B_);
            view_C_ = itemView.findViewById(R.id.view_C_);

        }
    }
}

