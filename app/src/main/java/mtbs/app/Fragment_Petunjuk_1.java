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
public class Fragment_Petunjuk_1 extends Fragment implements View.OnClickListener {
    private MainActivity activity;

    private Button btn_Lanjut ;
    private Button btn_Kembali;

    public Fragment_Petunjuk_1() {
        // Required empty public constructor
    }

    public static Fragment_Petunjuk_1 newInstance(MainActivity activity){
        Fragment_Petunjuk_1 res = new Fragment_Petunjuk_1();
        res.activity =activity;
        return res;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_petunjuk1, container, false);
        this.btn_Lanjut = v.findViewById(R.id.btn_Lanjut);
        this.btn_Kembali = v.findViewById(R.id.btn_Kembali);

        this.btn_Lanjut.setOnClickListener(this);
        this.btn_Kembali.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == this.btn_Lanjut.getId()){
            this.activity.changeToPetunjuk_2();
        }else if(v.getId() == this.btn_Kembali.getId()){
            this.activity.changeToHomePage();
        }
    }
}
