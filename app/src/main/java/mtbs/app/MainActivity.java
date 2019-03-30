package mtbs.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Initializer_HomePage initializer_homePage;
    private Initializer_Petunjuk initializer_petunjuk;
    private FragmentManager fragmentManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.fragmentManager = this.getSupportFragmentManager();
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
        HomePage now = this.initializer_homePage.getHomePage();
        changeFragment(now);
    }

    public void changeToPetunjuk_1(){
        Petunjuk_1 now = this.initializer_petunjuk.getPetunjuk_1();
        changeFragment(now);
    }

    private void initAll(){
        this.initializer_homePage = new Initializer_HomePage(this);
        this.initializer_petunjuk = new Initializer_Petunjuk(this);

    }




}
