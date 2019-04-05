package mtbs.app.model;

/**
 * Kelas  Jenis Obat untuk identifikasi jenis obat seperti
 * (Kapsul , sirup)
 *
 */
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


    /**
     *
     * @return id jenis obat
     */
    public int getIdJenisObat() {
        return idJenisObat;
    }

    /**
     * Setter dari id jenis obat
     * @param idJenisObat
     */
    public void setIdJenisObat(int idJenisObat) {
        this.idJenisObat = idJenisObat;
    }

    /**
     * Getter dari nama jenis obat
     * @return
     */
    public String getNamaJenisObat() {
        return namaJenisObat;
    }

    /**
     * Setter dari nama jenis
     * @param namaJenisObat
     */
    public void setNamaJenisObat(String namaJenisObat) {
        this.namaJenisObat = namaJenisObat;
    }

    /**
     * Getter dari dosis
     * @return
     */
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
