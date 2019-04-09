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
public class FragmentHomePage extends Fragment implements View.OnClickListener {
    private MainActivity activity;

    private Button btn_mulai ;
    private Button btn_petunjuk ;


    public FragmentHomePage() {
        // Required empty public constructor
    }

    public static FragmentHomePage newInstance(MainActivity activity){
        FragmentHomePage res = new FragmentHomePage();
        res.activity = activity;
        return res;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home_page, container, false);
        this.btn_mulai = (Button) v.findViewById(R.id.btn_mulai);
        this.btn_petunjuk = (Button) v.findViewById(R.id.btn_petunjuk);

        this.btn_mulai.setOnClickListener(this);
        this.btn_petunjuk.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == this.btn_mulai.getId() ){

        }else if(v.getId()== this.btn_petunjuk.getId()){
            this.activity.changeToPetunjuk_1();
        }
    }
}
