package mtbs.app;

public class Initializer_Petunjuk extends Initializer{
    private MainActivity activity;
    // fragment petunjuk 1
    private Fragment_Petunjuk_1 petunjuk_1;
    // fragment petunjuk 2
    private Fragment_Petunjuk_2 petunjuk_2;



    // fragment petunjuk 3
    private Fragment_Petunjuk_3 petunjuk_3;

    public Initializer_Petunjuk(MainActivity activity) {
       this.activity = activity;
       // buat semua fragment yang dibutuhkan
       initAll();
    }

    /**
     * Method dipanggil setelah constructor kelas ini dibuat
     */
    @Override
    public void initAll() {

        this.petunjuk_1 = Fragment_Petunjuk_1.newInstance(activity);
        this.petunjuk_2 = Fragment_Petunjuk_2.newInstance(activity);
        this.petunjuk_3 = Fragment_Petunjuk_3.newInstance(activity);
    }

    public Fragment_Petunjuk_2 getPetunjuk_2() {
        return petunjuk_2;
    }

    public Fragment_Petunjuk_1 getPetunjuk_1() {
        return petunjuk_1;
    }

    public Fragment_Petunjuk_3 getPetunjuk_3() {
        return petunjuk_3;
    }
}
