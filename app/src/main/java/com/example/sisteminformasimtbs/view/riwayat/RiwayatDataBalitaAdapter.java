package com.example.sisteminformasimtbs.view.riwayat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.model.dataclass.Balita;

import java.util.LinkedList;

public class RiwayatDataBalitaAdapter extends RecyclerView.Adapter<RiwayatDataBalitaAdapter.RiwayatDataBalitaViewHolder> {
    private RiwayatBalita_Activity activity ;
    private LinkedList<Balita> listofbalita ;

    public RiwayatDataBalitaAdapter(LinkedList<Balita> listofbalita ,RiwayatBalita_Activity activity) {
        this.listofbalita = listofbalita;
        this.activity =activity;
    }

    /**
     * function to update
     * don't forget to notify set data changed
     * @param listofbalita
     */
    public void updateList(LinkedList<Balita> listofbalita){
        this.listofbalita = listofbalita;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RiwayatDataBalitaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_caribalita, parent, false);
        RiwayatDataBalitaViewHolder viewHolder = new RiwayatDataBalitaViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RiwayatDataBalitaViewHolder holder, int position) {
        final Balita now = this.listofbalita.get(position) ;
        holder.namaBalita.setText("" + now.getNama());
        holder.namaIbu.setText("Nama Ibu : " + now.getNamaIbu());


        if(now.getJenisKelamin() == 'P'){
            holder.balitaImageView.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_girl));
        }else{
            holder.balitaImageView.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_boy));
        }
        holder.listBalitaItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity.getApplicationContext() , " item : " + now.getNama() , Toast.LENGTH_LONG).show();
              // request all get all kunjungan based on balita id change to another fragment request data here first
                activity.changeToProfileBalita(now);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.listofbalita.size();
    }

    public static class RiwayatDataBalitaViewHolder extends RecyclerView.ViewHolder{
        private TextView namaBalita;
        private LinearLayout listBalitaItem ;
        private TextView  namaIbu;
        private ImageView balitaImageView;

        public RiwayatDataBalitaViewHolder(@NonNull View itemView) {
            super(itemView);
            this.namaBalita = (TextView) itemView.findViewById(R.id.tv_namaBalita)  ;
            this.listBalitaItem = (LinearLayout) itemView.findViewById(R.id.listBalita_item);
            this.namaIbu = (TextView) itemView.findViewById(R.id.tv_namaIbu);
            this.balitaImageView = (ImageView) itemView.findViewById(R.id.balitaImageView);

        }
    }
}
