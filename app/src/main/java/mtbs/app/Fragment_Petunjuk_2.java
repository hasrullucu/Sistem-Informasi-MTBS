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
public class Fragment_Petunjuk_2 extends Fragment implements  View.OnClickListener{

    private MainActivity activity;

    private Button btn_Lanjut ;
    private Button btn_Kembali ;
    public Fragment_Petunjuk_2() {
        // Required empty public constructor
    }

    public static Fragment_Petunjuk_2 newInstance(MainActivity activity){
        Fragment_Petunjuk_2 fragment_petunjuk_2 = new Fragment_Petunjuk_2();
        fragment_petunjuk_2.activity = activity;
        return fragment_petunjuk_2;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v = inflater.inflate(R.layout.fragment__petunjuk_2, container, false);
       this.btn_Lanjut = v.findViewById(R.id.btn_Lanjut);
       this.btn_Kembali= v.findViewById(R.id.btn_Kembali);

       this.btn_Lanjut.setOnClickListener(this);
       this.btn_Kembali.setOnClickListener(this);

       return v;

    }

    /**
     * Method yang dipanggil ketika button dalam fragment ini ditekan
     * @param view
     */
    @Override
    public void onClick(View view) {
        if(view.getId() == this.btn_Lanjut.getId()){
            this.activity.changeToPetunjuk_3();
        }else{
            this.activity.changeToPetunjuk_1();
        }
    }
}
