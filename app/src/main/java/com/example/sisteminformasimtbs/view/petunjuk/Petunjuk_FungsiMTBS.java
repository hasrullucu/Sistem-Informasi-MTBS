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
public class Petunjuk_FungsiMTBS extends Fragment implements View.OnClickListener {

    private Button btn_Kembali;
    private Button btn_Lanjut ;



    public Petunjuk_FungsiMTBS() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Petunjuk_SecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Petunjuk_FungsiMTBS newInstance(String param1, String param2) {
        Petunjuk_FungsiMTBS fragment = new Petunjuk_FungsiMTBS();
        Bundle args = new Bundle();
        fragment.setArguments(args);
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
        View res = inflater.inflate(R.layout.fragment_petunjuk__second, container, false);
        this.btn_Lanjut = res.findViewById(R.id.btn_Lanjut);
        this.btn_Lanjut.setOnClickListener(this);

        this.btn_Kembali = res.findViewById(R.id.btn_Selanjutnya);
        this.btn_Kembali.setOnClickListener(this);

        return res;
    }




    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onClick(View view) {
        if(this.btn_Lanjut.getId() == view.getId()){
            ((Petunjuk_Activity)getActivity()).goToPetunjuk3();
        }else if(this.btn_Kembali.getId() == view.getId()){
            ((Petunjuk_Activity) getActivity()).goToPetunjuk1();
        }
    }
}
