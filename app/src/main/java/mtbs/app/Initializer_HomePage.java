package mtbs.app;

public class Initializer_HomePage extends Initializer  {
    private MainActivity activity;
    private HomePage homePage ;

    public Initializer_HomePage(MainActivity activity){
        this.activity= activity;
        initAll();
    }

    public void initAll() {
        this.homePage = HomePage.newInstance(this.activity);
    }

    public HomePage getHomePage() {
        return homePage;
    }
}
