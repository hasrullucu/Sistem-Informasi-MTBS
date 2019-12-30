package com.example.sisteminformasimtbs.view.pemeriksaan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.model.dataclass.Balita;

import java.util.LinkedList;

public class CariBalitaAdapter extends RecyclerView.Adapter<CariBalitaAdapter.CariBalitaViewHolder>  {

    private PemeriksaanMain_Activity activity ;
    private LinkedList<Balita> listofbalita ;

    public CariBalitaAdapter(LinkedList<Balita> listofbalita , PemeriksaanMain_Activity activity) {
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
    public CariBalitaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_caribalita, parent, false);
        CariBalitaViewHolder viewHolder = new CariBalitaViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CariBalitaViewHolder holder, int position) {
        final Balita now = this.listofbalita.get(position) ;
        holder.namaBalita.setText("" + now.getNama());
        holder.namaIbu.setText("Nama Ibu : " + now.getNamaIbu());

        holder.listBalitaItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity.getApplicationContext() , " item : " + now.getNama() , Toast.LENGTH_LONG).show();
                activity.loadedBalita = now;
                activity.changeToDataDiri_1();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.listofbalita.size();
    }

    public static class CariBalitaViewHolder extends RecyclerView.ViewHolder{
        private TextView namaBalita;
        private LinearLayout listBalitaItem ;
        private TextView  namaIbu;

        public CariBalitaViewHolder(@NonNull View itemView) {
            super(itemView);
            this.namaBalita = (TextView) itemView.findViewById(R.id.tv_namaBalita)  ;
            this.listBalitaItem = (LinearLayout) itemView.findViewById(R.id.listBalita_item);
            this.namaIbu = (TextView) itemView.findViewById(R.id.tv_namaIbu);

        }
    }
}
