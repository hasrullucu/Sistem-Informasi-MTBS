package mtbs.app;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentBatuk1 extends Fragment implements View.OnClickListener {

    protected Button btnGejala, btnKlas, btnTindakan, increase, decrease, btnBack, btnNext;
    protected TextView integer_number;
    protected Context context;
    protected int n = 0;
    int minteger = 0;

    public FragmentBatuk1 () {}

    public FragmentBatuk1(Context context) {
        this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.batuk1, container, false);
        this.btnGejala = result.findViewById(R.id.btnGejala);
        this.btnKlas = result.findViewById(R.id.btnKlas);
        this.btnTindakan = result.findViewById(R.id.btnTindakan);
        this.increase = result.findViewById(R.id.increase);
        this.decrease = result.findViewById(R.id.decrease);
        this.btnBack = result.findViewById(R.id.btnBack);
        this.btnNext = result.findViewById(R.id.btnNext);
        this.integer_number = result.findViewById(R.id.integer_number);
        this.btnGejala.setOnClickListener(this);
        this.btnKlas.setOnClickListener(this);
        this.btnTindakan.setOnClickListener(this);
        this.increase.setOnClickListener(this);
        this.decrease.setOnClickListener(this);
        this.btnBack.setOnClickListener(this);
        this.btnNext.setOnClickListener(this);
        this.integer_number.setOnClickListener(this);

    }

    public void increaseInteger(View view) {
        minteger = minteger + 1;
        display(minteger);

    }public void decreaseInteger(View view) {
        minteger = minteger - 1;
        display(minteger);
    }

    private void display(int number) {
        TextView displayInteger = (TextView) integer_number.findViewById();
        displayInteger.setText("" + number);
    }

    @Override
    public void onClick(View v) {

    }
}
