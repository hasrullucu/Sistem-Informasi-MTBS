package mtbs.app;
import mtbs.app.model.DatabaseHelper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    // kelas inisialisasi fragment homepage
    private Initializer_HomePage initializer_homePage;
    // kelas inisialisasi fragment semua petunjuk
    private Initializer_Petunjuk initializer_petunjuk;
    private FragmentManager fragmentManager;

    // database
   private DatabaseHelper db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.fragmentManager = this.getSupportFragmentManager();
        Log.d("ea" , "berhasilhorray");
        this.db = new DatabaseHelper(getApplicationContext() , this);
        initAll();
        changeToHomePage();


    }

    /**
     *
     * @param
     */
    private void changeFragment(Fragment now){
        FragmentTransaction fragmentTransaction = this.fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragContainer , now);
        fragmentTransaction.commit();
    }

    public void changeToHomePage(){
        FragmentHomePage now = this.initializer_homePage.getHomePage();
        changeFragment(now);
    }

    public void changeToPetunjuk_1(){
        Fragment_Petunjuk_1 now = this.initializer_petunjuk.getPetunjuk_1();
        changeFragment(now);
    }

    public void changeToPetunjuk_2(){
        Fragment_Petunjuk_2 now = this.initializer_petunjuk.getPetunjuk_2();
        changeFragment(now);
    }

    public void changeToPetunjuk_3(){
        Fragment_Petunjuk_3 now = this.initializer_petunjuk.getPetunjuk_3();
        changeFragment(now);
    }


    private void initAll(){
        this.initializer_homePage = new Initializer_HomePage(this);
        this.initializer_petunjuk = new Initializer_Petunjuk(this);

    }


    @Override
    public void onClick(View v) {
        Log.d("" , "masuk main activity");
    }
}
