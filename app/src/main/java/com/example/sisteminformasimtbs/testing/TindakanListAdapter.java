package com.example.sisteminformasimtbs.testing;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.model.Pemeriksaan;
import com.example.sisteminformasimtbs.view.pemeriksaan.PemeriksaanMain;

import java.util.ArrayList;
import java.util.LinkedList;

import static com.example.sisteminformasimtbs.R.color.redstatus;

public class TindakanListAdapter extends RecyclerView.Adapter<TindakanListAdapter.TindakanViewHolder> {
    private PemeriksaanMain activity ;
    private LinkedList<TindakanResult> listOfTindakanResult ;

    public TindakanListAdapter(LinkedList<TindakanResult> listOfTindakanResult , PemeriksaanMain activity) {
        this.listOfTindakanResult = listOfTindakanResult;
        this.activity =activity;
    }

    @NonNull
    @Override
    public TindakanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_tindakan_test, parent, false);
        TindakanViewHolder viewHolder = new TindakanListAdapter.TindakanViewHolder(listItem);
        return viewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(@NonNull TindakanViewHolder holder, int position) {
        final TindakanResult now = this.listOfTindakanResult.get(position) ;
        holder.idTindakan.setText("" + now.getIdTindakan());
        holder.namaTindakan.setText("" + now.getNamaTindakan());
       final ArrayList<String> res = activity.presenter.getLangkahTindakan(now.getIdTindakan());
        final int size = res.size() ;
        if(size == 0) holder.idTindakan.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);

        if(now.getNamaTindakan().equals("RUJUK SEGERA")){
            holder.idTindakan.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_warning , 0);
            holder.tindakanContainer.setBackgroundColor(activity.getResources().getColor(redstatus));
        }

        holder.tindakanContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(size >0){
                    Intent i = new Intent(activity , LangkahTindakanActivity.class) ;
                    i.putStringArrayListExtra("langkahtindakan" , res);
                    activity.startActivity(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listOfTindakanResult.size();
    }

    public static class TindakanViewHolder extends RecyclerView.ViewHolder{
        private TextView namaTindakan;
        private LinearLayout tindakanContainer ;
        private TextView idTindakan;

        public TindakanViewHolder(@NonNull View itemView) {
            super(itemView);
            this.namaTindakan = (TextView) itemView.findViewById(R.id.namaTindakan)  ;
            this.tindakanContainer = (LinearLayout) itemView.findViewById(R.id.tindakanContainer);
            this.idTindakan = (TextView) itemView.findViewById(R.id.idTindakan);

        }
    }
}
