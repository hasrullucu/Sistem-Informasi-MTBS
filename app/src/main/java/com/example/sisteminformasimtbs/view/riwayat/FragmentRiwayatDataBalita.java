package com.example.sisteminformasimtbs.view.riwayat;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.database.DatabaseHelper;
import com.example.sisteminformasimtbs.model.dataclass.Balita;

import java.util.LinkedList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRiwayatDataBalita extends Fragment implements View.OnClickListener{
    private LinearLayout btn_Kembali;

    private RiwayatBalita_Activity activity ;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private EditText searchBalita_EditText;

    private DatabaseHelper db;



    public FragmentRiwayatDataBalita() {
        // Required empty public constructor
    }

    public static FragmentRiwayatDataBalita newInstance(RiwayatBalita_Activity activity , DatabaseHelper db){
        FragmentRiwayatDataBalita res = new FragmentRiwayatDataBalita();
        res.activity = activity ;
        res.db  = db;
        return res;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View res = inflater.inflate(R.layout.fragment_fragment_riwayat_data_balita, container, false);
//
        this.btn_Kembali = res.findViewById(R.id.btn_Kembali);
        this.btn_Kembali.setOnClickListener(this);

        this.searchBalita_EditText = res.findViewById(R.id.searchBalita_EditText);
        this.searchBalita_EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Toast.makeText(getContext() , "search" , Toast.LENGTH_LONG).show();
                String keyword = searchBalita_EditText.getText().toString();
                if(keyword != ""){
                    LinkedList<Balita> balitaSearched = db.getBalitaLikeName(keyword);
                    RiwayatDataBalitaAdapter adapter = (RiwayatDataBalitaAdapter) mAdapter;
                    adapter.updateList(balitaSearched);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        this.recyclerView = res.findViewById(R.id.recyclerViewDataBalita) ;
//        LinkedList<Balita> allBalita = new LinkedList<>();
        LinkedList<Balita> allBalita = db.getAllBalita();
        Log.d("size" , "jumlah Balita : " + allBalita.size());
        this.mAdapter = new RiwayatDataBalitaAdapter(allBalita, activity);
//        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        this.recyclerView.setAdapter(this.mAdapter);
        return res;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == this.btn_Kembali.getId()){
            this.activity.finish();
        }
    }
}
