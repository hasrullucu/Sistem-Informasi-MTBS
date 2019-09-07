package com.example.sisteminformasimtbs.view.petunjuk;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.sisteminformasimtbs.R;

/**
 *
 */
public class Petunjuk_TahapanMTBS extends Fragment implements View.OnClickListener{
    private LinearLayout btn_Kembali;


    public Petunjuk_TahapanMTBS() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Petunjuk_TahapanMTBS.
     */
    // TODO: Rename and change types and number of parameters
    public static Petunjuk_TahapanMTBS newInstance(String param1, String param2) {
        Petunjuk_TahapanMTBS fragment = new Petunjuk_TahapanMTBS();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View res =  inflater.inflate(R.layout.fragment_petunjuk__tahapan, container, false);
       this.btn_Kembali = res.findViewById(R.id.btn_Kembali);
       this.btn_Kembali.setOnClickListener(this);


        return res ;
    }




    @Override
    public void onClick(View view) {
        if(view == this.btn_Kembali){
            Petunjuk_Activity activity = (Petunjuk_Activity) getActivity();
            activity.goToMenuPetunjuk();
        }
    }


}
