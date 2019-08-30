package com.example.sisteminformasimtbs.view.petunjuk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.sisteminformasimtbs.R;

public class Petunjuk_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petunjuk);
        goToMenuPetunjuk();
    }

    public void goToPetunjuk1(){
        changeFragment(new Petunjuk_DefinisiMTBS());
    }

    public void goToPetunjuk2(){
        changeFragment(new Petunjuk_FungsiMTBS());
    }

    public void goToPetunjuk3(){
        changeFragment(new Petunjuk_TahapanMTBS());
    }

    public void goToMenuPetunjuk(){changeFragment(PetunjukMenu_Fragment.newInstance());}

    private void changeFragment(Fragment fragTarget){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragContainer , fragTarget);
        ft.commit();
    }


}
