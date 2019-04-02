package mtbs.app;


import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentBatuk2 extends Fragment implements View.OnClickListener {

    protected Button btnGejala, btnKlas, btnTindakan, btnBack, btnNext;
    protected Context context;
    protected int n = 0;
    int minteger = 0;
    private FragmentManager fragManager;

    public FragmentBatuk2 () {}

    public FragmentBatuk2(Context context) {
        this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.batuk2, container, false);
        this.btnGejala = result.findViewById(R.id.btnGejala);
        this.btnKlas = result.findViewById(R.id.btnKlas);
        this.btnTindakan = result.findViewById(R.id.btnTindakan);
        this.btnBack = result.findViewById(R.id.btnBack);
        this.btnNext = result.findViewById(R.id.btnNext);
    }


    @Override
    public void onClick(View view) {
        if ( view == this.btnBack ) {
            FragmentTransaction transaction = this.fragManager.beginTransaction();
            transaction.remove(FragmentBatuk2);
            transaction.add(R.id.fragContainer,FragmentBatuk1);
            transaction.commit();
        }
        else if ( view == this.btnNext ) {

        }
    }
}
