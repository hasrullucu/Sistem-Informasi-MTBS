package com.example.sisteminformasimtbs.view.riwayat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.model.IndonesiaFormatter;
import com.example.sisteminformasimtbs.model.dataclass.Balita;
import com.example.sisteminformasimtbs.model.dataclass.Diagnosis;
import com.example.sisteminformasimtbs.model.dataclass.Kunjungan;
import com.example.sisteminformasimtbs.model.relation.DiagnosisResult;

import java.util.LinkedList;

public class KunjunganRecyclerViewAdapter extends RecyclerView.Adapter<KunjunganRecyclerViewAdapter.KunjunganViewHolder> {
    private RiwayatBalita_Activity activity ;
    private LinkedList<Kunjungan> listOfKunjungan ;
    private Balita balitaNow;
    @NonNull
    @Override
    public KunjunganViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.listitem_riwayatpemeriksaan, parent, false);
        KunjunganViewHolder viewHolder = new KunjunganViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull KunjunganViewHolder holder, int position) {
        final Kunjungan now = this.listOfKunjungan.get(position) ;
        String formattedTanggalKunjungan  = IndonesiaFormatter.splitAndFormatDate(now.getTanggalKunjungan());
        holder.tanggalPemeriksaanTextView.setText(formattedTanggalKunjungan);
        holder.keluhanTextView.setText(""+now.getKeluhan());

        holder.listKunjunganItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinkedList<DiagnosisResult> collectionOfKlasifikasi = new LinkedList<>();
                // get list of klasifikasi berdasarkan
                LinkedList<Diagnosis> allKlasifikasi = activity.getDb().getAllKlasifikasiBasedByKunjunganId(now.getIdKunjungan());
                for (Diagnosis item: allKlasifikasi){
                    DiagnosisResult diagnosisResultNow = activity.getDb().getKlasifikasiBasedOnIdKlasifikasi(item.getIdKlasifikasi());
                    collectionOfKlasifikasi.add(diagnosisResultNow);

                }

                activity.changeToRiwayatHasilPemeriksaan(collectionOfKlasifikasi,now , balitaNow );
            }
        });
    }

    public KunjunganRecyclerViewAdapter(RiwayatBalita_Activity activity, LinkedList<Kunjungan> listOfKunjungan , Balita balitaNow) {
        this.activity = activity;
        this.listOfKunjungan = listOfKunjungan;
        this.balitaNow = balitaNow;
    }

    @Override
    public int getItemCount() {
        return this.listOfKunjungan.size();
    }

    public static class KunjunganViewHolder extends RecyclerView.ViewHolder{
        private TextView tanggalPemeriksaanTextView;
        private LinearLayout listKunjunganItem ;
        private TextView  keluhanTextView;

        public KunjunganViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tanggalPemeriksaanTextView= (TextView) itemView.findViewById(R.id.tanggalPemeriksaanTextView)  ;
            this.listKunjunganItem= (LinearLayout) itemView.findViewById(R.id.listKunjungan_item);
            this.keluhanTextView = (TextView) itemView.findViewById(R.id.keluhanTextView);

        }
    }
}
