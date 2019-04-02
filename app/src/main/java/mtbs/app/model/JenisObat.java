package mtbs.app.model;

public class JenisObat {
    private int idJenisObat;
    private String namaJenisObat ;
    private int dosis ;
    private String jenisObat ;

    public JenisObat(int idJenisObat, String namaJenisObat, int dosis, String jenisObat) {
        this.idJenisObat = idJenisObat;
        this.namaJenisObat = namaJenisObat;
        this.dosis = dosis;
        this.jenisObat = jenisObat;
    }


    public int getIdJenisObat() {
        return idJenisObat;
    }

    public void setIdJenisObat(int idJenisObat) {
        this.idJenisObat = idJenisObat;
    }

    public String getNamaJenisObat() {
        return namaJenisObat;
    }

    public void setNamaJenisObat(String namaJenisObat) {
        this.namaJenisObat = namaJenisObat;
    }

    public int getDosis() {
        return dosis;
    }

    public void setDosis(int dosis) {
        this.dosis = dosis;
    }

    public String getJenisObat() {
        return jenisObat;
    }

    public void setJenisObat(String jenisObat) {
        this.jenisObat = jenisObat;
    }
}
