package com.example.btl_thibanglaixe.Adapter;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.example.btl_thibanglaixe.Activities.MainActivity;
import com.example.btl_thibanglaixe.Activities.XemLaiDapAnActivity;
import static com.example.btl_thibanglaixe.Activities.ThiSatHachActivity.SIZE;
import com.example.btl_thibanglaixe.Model.CauHoi;
import com.example.btl_thibanglaixe.Model.DeThi;
import com.example.btl_thibanglaixe.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterRecyclerViewLichSuBaiThi extends RecyclerView.Adapter<AdapterRecyclerViewLichSuBaiThi.RecyclerViewHolder> {
    public static List<DeThi> listDeThi = new ArrayList<DeThi>();
    Context context;
    private LayoutInflater mInflater;
    public static int pos;
    int dem = 0;
    public AdapterRecyclerViewLichSuBaiThi(Context context,List<DeThi> listDeThi) {
        this.listDeThi = listDeThi;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.layout_recyclerview_lichsubaithi,parent,false);
        return new RecyclerViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.bt_deThi.setText("Đề " + (position + 1));
        holder.bt_deThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                Intent intent_xemDapAn = new Intent(context, XemLaiDapAnActivity.class);
                int SIZE = listDeThi.get(pos).getListCauHoi().size();
                intent_xemDapAn.putExtra("from", 'l');
                context.startActivity(intent_xemDapAn);
            }
        });
    }

    public static List<CauHoi> getListCauHoi(){
        return listDeThi.get(pos).getListCauHoi();
    }

    @Override
    public int getItemCount() {
        return listDeThi.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        Button bt_deThi;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            bt_deThi = itemView.findViewById(R.id.bt_deThi);
            // Calculate ActionBar height
            TypedValue tv = new TypedValue();
            float actionBarHeight = 0;
            if (context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
            {
                actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,context.getResources().getDisplayMetrics());
            }
            float mWidth = (getWidthScreen(context)-convertDpToPixel(100,context))/4;
            float mHeight = (getHeightScreen(context)-actionBarHeight-getStatusBarHeight()-convertDpToPixel(120,context))/5;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int)mWidth,(int)mHeight);
            bt_deThi.setLayoutParams(layoutParams);
        }
    }

    public static int getWidthScreen(Context context){
        Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int mWidthScreen = display.getWidth();
        return mWidthScreen;
    }

    public static int getHeightScreen(Context context){
        Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int mHeightScreen = display.getHeight();
        return mHeightScreen;
    }

    public static float convertDpToPixel(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}

