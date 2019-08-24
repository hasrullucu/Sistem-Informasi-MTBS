package com.example.sisteminformasimtbs.testing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.sisteminformasimtbs.R;

import java.util.LinkedList;

public class TindakanListAdapter extends RecyclerView.Adapter<TindakanListAdapter.TindakanViewHolder> {
    private LinkedList<TindakanResult> listOfTindakanResult ;

    public TindakanListAdapter(LinkedList<TindakanResult> listOfTindakanResult) {
        this.listOfTindakanResult = listOfTindakanResult;
    }

    @NonNull
    @Override
    public TindakanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_tindakan_test, parent, false);
        TindakanViewHolder viewHolder = new TindakanListAdapter.TindakanViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TindakanViewHolder holder, int position) {
        final TindakanResult now = this.listOfTindakanResult.get(position) ;
        holder.idTindakan.setText("" + now.getIdTindakan());
        holder.namaTindakan.setText("" + now.getNamaTindakan());
        holder.tindakanContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext() , "id : "+ now.getIdTindakan() , Toast.LENGTH_SHORT).show();
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
