package mtbs.app;

public class Initializer_Petunjuk extends Initializer{
    private MainActivity activity;
    // fragment petunjuk 1
    private Petunjuk_1 petunjuk_1;

    public Initializer_Petunjuk(MainActivity activity) {
       this.activity = activity;
       initAll();
    }


    @Override
    public void initAll() {
        this.petunjuk_1 = Petunjuk_1.newInstance(activity);
    }

    public Petunjuk_1 getPetunjuk_1() {
        return petunjuk_1;
    }
}
