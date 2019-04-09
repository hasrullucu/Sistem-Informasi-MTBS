package mtbs.app.model;

/**
 *  Kelas endemis
 */
public class Endemis {
    private int idEndemis ;
    private String jenisEndemis ;

    /**
     * Constructor dari tabel endemis
     * @param idEndemis
     * @param jenisEndemis
     */
    public Endemis(int idEndemis, String jenisEndemis) {
        this.idEndemis = idEndemis;
        this.jenisEndemis = jenisEndemis;
    }

    /**
     * Mendapatkan id endemis dari tabel endemis sekarang
     * @return
     */
    public int getIdEndemis() {
        return idEndemis;
    }

    /**
     * Setter dari endemis
     * @param idEndemis
     */
    public void setIdEndemis(int idEndemis) {
        this.idEndemis = idEndemis;
    }

    /**
     * Getter dari jenis endemis
     * 2 jawaban (Endemis / Non Edemis)
     * @return
     */
    public String getJenisEndemis() {
        return jenisEndemis;
    }

    /**
     * Setter  jenis Endemis
     * @param jenisEndemis
     */
    public void setJenisEndemis(String jenisEndemis) {
        this.jenisEndemis = jenisEndemis;
    }
}
