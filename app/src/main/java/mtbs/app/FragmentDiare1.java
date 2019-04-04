package mtbs.app;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDiare1 extends Fragment implements View.OnClickListener{
    protected Button btnNext, btnBack, btnGejala, btnKlas, btnTindakan;
    protected Context context;
    protected MainActivity activity;

    public FragmentDiare1() {
        // Required empty public constructor
    }

    public FragmentDiare1(Context context){
        this.context=context;
    }

    public static FragmentDiare1 newInstance(MainActivity activity){
        FragmentDiare1 result = new FragmentDiare1();
        result.activity=activity;
        return result;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.diare1, container, false);
        this.btnBack = result.findViewById(R.id.btnBack);
        this.btnNext = result.findViewById(R.id.btnNext);
        this.btnGejala = result.findViewById(R.id.btnGejala);
        this.btnKlas = result.findViewById(R.id.btnKlas);
        this.btnTindakan = result.findViewById(R.id.btnTindakan);
        this.btnBack.setOnClickListener(this);
        this.btnNext.setOnClickListener(this);
        this.btnGejala.setOnClickListener(this);
        this.btnKlas.setOnClickListener(this);
        this.btnTindakan.setOnClickListener(this);
        return result;
    }

    @Override
    public void onClick(View view) {
        if(view==btnBack){

        }
        else if(view==btnNext){

        }
        else if(view==btnGejala){

        }
        else if(view==btnKlas){

        }
        else if(view==btnTindakan){

        }
    }

}

