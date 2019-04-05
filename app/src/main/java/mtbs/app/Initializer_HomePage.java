package mtbs.app;

/**
 * Kelas inisialisasi untuk fragment home page
 *
 */
public class Initializer_HomePage extends Initializer  {
    private MainActivity activity;
    private FragmentHomePage homePage ;

    public Initializer_HomePage(MainActivity activity){
        this.activity= activity;
        initAll();
    }

    /**
     *
     *
     */
    public void initAll() {
        this.homePage = FragmentHomePage.newInstance(this.activity);
    }

    /**
     * Getter untuk fragment home page
     * @return
     */
    public FragmentHomePage getHomePage() {
        return homePage;
    }
}
