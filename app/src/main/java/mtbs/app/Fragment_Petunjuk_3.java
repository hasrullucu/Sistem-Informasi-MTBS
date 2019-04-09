package mtbs.app;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Petunjuk_3 extends Fragment implements View.OnClickListener{
    private MainActivity activity;

    private Button btn_Kembali ;
    private Button btn_Menu ;

    public Fragment_Petunjuk_3() {
        // Required empty public constructor
    }

    public static Fragment_Petunjuk_3 newInstance(MainActivity activity){
        Fragment_Petunjuk_3 fragment_petunjuk_3  = new Fragment_Petunjuk_3();
        fragment_petunjuk_3.activity = activity;
        return fragment_petunjuk_3;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment__petunjuk_3, container, false);
        this.btn_Kembali = v.findViewById(R.id.btn_Kembali);
        this.btn_Menu    = v.findViewById(R.id.btn_MenuUtama) ;


        this.btn_Kembali.setOnClickListener(this);
        this.btn_Menu.setOnClickListener(this);
        return v ;
    }

    /**
     * Method listener ketika suatu button ditekan
     * @param view
     */
    @Override
    public void onClick(View view) {
//        jika button yang ditekan adalah button kembali , kembali ke petunjuk 2
        if(view.getId() == this.btn_Kembali.getId()){
            this.activity.changeToPetunjuk_2();
        }
//        Jika Button yang ditekan adalah button menu , kembali ke menu utama
        else if(view.getId() == this.btn_Menu.getId()){
            this.activity.changeToHomePage();
        }
    }
}
