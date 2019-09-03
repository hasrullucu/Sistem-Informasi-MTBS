package com.example.sisteminformasimtbs.testing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sisteminformasimtbs.R;

import java.util.ArrayList;
import java.util.LinkedList;

public class LangkahTindakanAdapter  extends RecyclerView.Adapter<LangkahTindakanAdapter.LangkahTindakanViewHolder> {

    private ArrayList<String> collectionOfLangkahTindakan;

    public LangkahTindakanAdapter(ArrayList<String> collectionOfLangkahTindakan) {
        this.collectionOfLangkahTindakan = collectionOfLangkahTindakan;
    }

    @NonNull
    @Override
    public LangkahTindakanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item_langkahtindakan, parent, false);
        LangkahTindakanViewHolder viewHolder = new LangkahTindakanAdapter.LangkahTindakanViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LangkahTindakanViewHolder holder, int position) {
        final String now = this.collectionOfLangkahTindakan.get(position) ;
        holder.tv_NamaLangkahTindakan.setText( " " + now);
        // layout set onclick
    }

    @Override
    public int getItemCount() {
        return this.collectionOfLangkahTindakan.size();
    }

    public static class LangkahTindakanViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_NamaLangkahTindakan;

        public LangkahTindakanViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_NamaLangkahTindakan = itemView.findViewById(R.id.namaLangkahTindakan);
        }
    }

}