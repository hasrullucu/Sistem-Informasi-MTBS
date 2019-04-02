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
public class FragmentKlasifikasiTandaBahayaUmum extends Fragment implements View.OnClickListener {
    protected Button btnNext, btnBack, btnGejala, btnKlas, btnTindakan;
    protected Context context;

    public FragmentKlasifikasiTandaBahayaUmum() {
        // Required empty public constructor
    }

    public FragmentKlasifikasiTandaBahayaUmum(Context context){
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.klasifikasitandabahayaumum, container, false);
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
