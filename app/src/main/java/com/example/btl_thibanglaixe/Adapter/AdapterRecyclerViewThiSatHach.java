package com.example.btl_thibanglaixe.Adapter;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.btl_thibanglaixe.Model.CauHoi;
import com.example.btl_thibanglaixe.R;

public class AdapterRecyclerViewThiSatHach extends RecyclerView.Adapter<AdapterRecyclerViewThiSatHach.RecyclerViewHolder> {
    CauHoi cauHoi;
    int pos;
    Context context;
    private LayoutInflater mInflater;
    public AdapterRecyclerViewThiSatHach(Context context,CauHoi cauHoi,int pos) {
        this.cauHoi = cauHoi;
        this.context = context;
        this.pos = pos;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.layout_recyclerview_thisathach,parent,false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        if (cauHoi.getLcA()==0) holder.A.setChecked(false);
        else holder.A.setChecked(true);
        if (cauHoi.getLcB()==0) holder.B.setChecked(false);
        else holder.B.setChecked(true);
        if (cauHoi.getLcC()==0) holder.C.setChecked(false);
        else holder.C.setChecked(true);
        if (cauHoi.getLcD()==0) holder.D.setChecked(false);
        else holder.D.setChecked(true);
        holder.tv_stt.setText((pos+1)+"");
        holder.tv_cauHoi.setText(cauHoi.getCauHoi());
        if (cauHoi.getAnh()==1) {
            holder.anhCauHoi.setImageDrawable(getDrawable(context,position));
            holder.anhCauHoi.setVisibility(View.VISIBLE);
        }
        else holder.anhCauHoi.setVisibility(View.GONE);
        holder.A.setText(cauHoi.getA());
        holder.B.setText(cauHoi.getB());
        if (cauHoi.getC().compareTo("")==0){
            holder.view_B_.setVisibility(View.VISIBLE);
            holder.view_B.setVisibility(View.GONE);
        } else {
            holder.view_B_.setVisibility(View.GONE);
            holder.view_B.setVisibility(View.VISIBLE);
        }
        if (cauHoi.getC().compareTo("")!=0){
            holder.C.setVisibility(View.VISIBLE);
            holder.C.setText(cauHoi.getC());
            holder.view_C.setVisibility(View.VISIBLE);
            if (cauHoi.getD().compareTo("")==0){
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
        if (cauHoi.getD().compareTo("")!=0){
            holder.D.setVisibility(View.VISIBLE);
            holder.D.setText(cauHoi.getD());
            holder.view_D.setVisibility(View.VISIBLE);
        } else {
            holder.D.setVisibility(View.GONE);
            holder.view_D.setVisibility(View.GONE);
        }
    }

    public Drawable getDrawable(Context context, int position){
        Resources resources = context.getResources();
        final int resourceId = resources.getIdentifier("cauhoi"+cauHoi.getId()+"", "drawable",
                context.getPackageName());
        Drawable drawable = resources.getDrawable(resourceId);
        return drawable;
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public StringBuilder getDA(){
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        if (cauHoi.getLcA()==1) sb.append("1");
        if (cauHoi.getLcB()==1) sb.append("2");
        if (cauHoi.getLcC()==1) sb.append("3");
        if (cauHoi.getLcD()==1) sb.append("4");
        for (int i=0;i<sb.length();i++){
            sb1.append(sb.charAt(i)+"-");
        }
        if (sb1.length()!=0) sb1.deleteCharAt(sb1.length()-1);
        return sb1;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements CompoundButton.OnCheckedChangeListener{
        TextView tv_stt, tv_cauHoi;
        ImageView anhCauHoi;
        CheckBox A, B, C, D;
        View view_A, view_B, view_C, view_D, view_B_, view_C_;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            tv_stt = itemView.findViewById(R.id.tv_stt);
            tv_cauHoi = itemView.findViewById(R.id.tv_cauHoi);
            anhCauHoi = itemView.findViewById(R.id.anhCauHoi);
            A = itemView.findViewById(R.id.A);
            B = itemView.findViewById(R.id.B);
            C = itemView.findViewById(R.id.C);
            D = itemView.findViewById(R.id.D);
            if (cauHoi.getLcA()==0) A.setChecked(false);
            else A.setChecked(true);
            if (cauHoi.getLcB()==0) B.setChecked(false);
            else B.setChecked(true);
            if (cauHoi.getLcC()==0) C.setChecked(false);
            else C.setChecked(true);
            if (cauHoi.getLcD()==0) D.setChecked(false);
            else D.setChecked(true);
            A.setOnCheckedChangeListener(this);
            B.setOnCheckedChangeListener(this);
            C.setOnCheckedChangeListener(this);
            D.setOnCheckedChangeListener(this);
            view_A = itemView.findViewById(R.id.view_A);
            view_B = itemView.findViewById(R.id.view_B);
            view_C = itemView.findViewById(R.id.view_C);
            view_D = itemView.findViewById(R.id.view_D);
            view_B_ = itemView.findViewById(R.id.view_B_);
            view_C_ = itemView.findViewById(R.id.view_C_);
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (A.isChecked()) cauHoi.setLcA(1);
            else cauHoi.setLcA(0);
            if (B.isChecked()) cauHoi.setLcB(1);
            else cauHoi.setLcB(0);
            if (C.isChecked()) cauHoi.setLcC(1);
            else cauHoi.setLcC(0);
            if (D.isChecked()) cauHoi.setLcD(1);
            else cauHoi.setLcD(0);
//            list.set(pos,cauHoi);
            Log.d("s = ",(cauHoi.getLcA()+"")+(cauHoi.getLcB()+"")+(cauHoi.getLcC()+"")+(cauHoi.getLcD()+""));
        }
    }
}
