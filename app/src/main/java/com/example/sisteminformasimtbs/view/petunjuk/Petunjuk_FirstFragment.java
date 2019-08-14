package com.example.sisteminformasimtbs.view.petunjuk;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sisteminformasimtbs.R;


/**
 *
 */
public class Petunjuk_FirstFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button btn_Lanjut;
    private Button btn_Kembali;


    public Petunjuk_FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Petunjuk_FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Petunjuk_FirstFragment newInstance(String param1, String param2) {
        Petunjuk_FirstFragment fragment = new Petunjuk_FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View res =  inflater.inflate(R.layout.fragment_petunjuk__first, container, false);
        this.btn_Lanjut = res.findViewById(R.id.btn_Lanjut);
        this.btn_Lanjut.setOnClickListener(this);

        this.btn_Kembali = res.findViewById(R.id.btn_Kembali);
        this.btn_Kembali.setOnClickListener(this);

        return res;
    }





    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == this.btn_Lanjut.getId()){
            ((Petunjuk_Activity) getActivity()).goToPetunjuk2();
        }else if(view.getId() == this.btn_Kembali.getId()){
            getActivity().finish();
        }
    }


}
