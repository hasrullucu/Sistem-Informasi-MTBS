package mtbs.app.model;

public class Endemis {
    private int idEndemis ;
    private String jenisEndemis ;

    public Endemis(int idEndemis, String jenisEndemis) {
        this.idEndemis = idEndemis;
        this.jenisEndemis = jenisEndemis;
    }


    public int getIdEndemis() {
        return idEndemis;
    }

    public void setIdEndemis(int idEndemis) {
        this.idEndemis = idEndemis;
    }

    public String getJenisEndemis() {
        return jenisEndemis;
    }

    public void setJenisEndemis(String jenisEndemis) {
        this.jenisEndemis = jenisEndemis;
    }
}
