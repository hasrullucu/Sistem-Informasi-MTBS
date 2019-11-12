package com.example.sisteminformasimtbs.view.pemeriksaan;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sisteminformasimtbs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HasilPemeriksaan2 extends Fragment {


    public HasilPemeriksaan2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        return textView;
    }

}
