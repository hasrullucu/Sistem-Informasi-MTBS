package com.example.sisteminformasimtbs.view.pemeriksaan;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.model.classifier.ColorClassifier;
import com.example.sisteminformasimtbs.model.relation.DiagnosisResult;

import java.util.LinkedList;

public class KlasifikasiListAdapter extends RecyclerView.Adapter<KlasifikasiListAdapter.KlasifikasiViewHolder> {
    private LinkedList<DiagnosisResult> collectionOfClassificationResult ;

    public KlasifikasiListAdapter(LinkedList<DiagnosisResult> collectionOfClassificationResult) {
        this.collectionOfClassificationResult = collectionOfClassificationResult;
    }

    @NonNull
    @Override
    public KlasifikasiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_klasifikasi_test, parent, false);
        KlasifikasiViewHolder viewHolder = new KlasifikasiViewHolder(listItem);
        return viewHolder;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull KlasifikasiViewHolder holder, int position) {
        final DiagnosisResult now = this.collectionOfClassificationResult.get(position) ;
        holder.tv_NamaKlasifikasi.setText( " " + now.getNamaKlasifikasiPenyakit());

        holder.tv_IdKlasifikasi.setText(" " + now.getIdKlasifikasi());
        holder.tv_IdKlasifikasi.setVisibility(View.INVISIBLE);

        // change Background
        int res = ColorClassifier.check(now.getIdKlasifikasi());
        Log.d("color" , "id : " + now.getIdKlasifikasi()+" res : " + res);
        if(res == 2){
            holder.container.setBackgroundColor(Color.parseColor("#FB4040"));
        }else if(res == 1){
            holder.container.setBackgroundColor(Color.parseColor("#FFDF38"));
        }else if(res ==0){
            holder.container.setBackgroundColor(Color.parseColor("#0AA06E"));

        }
    }

    @Override
    public int getItemCount() {
        return this.collectionOfClassificationResult.size();
    }

    public static class KlasifikasiViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_NamaKlasifikasi;
        public TextView tv_IdKlasifikasi ;

        public ConstraintLayout container ;
        public KlasifikasiViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_NamaKlasifikasi =(TextView) itemView.findViewById(R.id.tv_NamaKlasifikasi);
            this.tv_IdKlasifikasi = (TextView) itemView.findViewById(R.id.tv_IdKlasifikasi);
            this.container = (ConstraintLayout) itemView.findViewById(R.id.klasifikasi_container);
        }
    }


}



