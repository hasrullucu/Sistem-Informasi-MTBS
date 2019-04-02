package mtbs.app.model;

public class Obat {
    private int idObat ;
    private String namaObat ;
    private int syarat ;
    private String pemberian ;

    public int getIdObat() {
        return idObat;
    }

    public void setIdObat(int idObat) {
        this.idObat = idObat;
    }

    public String getNamaObat() {
        return namaObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public int getSyarat() {
        return syarat;
    }

    public void setSyarat(int syarat) {
        this.syarat = syarat;
    }

    public String getPemberian() {
        return pemberian;
    }

    public void setPemberian(String pemberian) {
        this.pemberian = pemberian;
    }

    public Obat(int idObat, String namaObat, int syarat, String pemberian) {
        this.idObat = idObat;
        this.namaObat = namaObat;
        this.syarat = syarat;
        this.pemberian = pemberian;

    }
}
