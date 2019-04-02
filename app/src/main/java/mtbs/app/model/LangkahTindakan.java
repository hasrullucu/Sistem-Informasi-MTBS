package mtbs.app.model;

public class LangkahTindakan {
    private int idLangkahTindakan ;
    private String keterangan ;

    // fk dari tindakan
    private int idTindakan;


    public int getIdLangkahTindakan() {
        return idLangkahTindakan;
    }

    public void setIdLangkahTindakan(int idLangkahTindakan) {
        this.idLangkahTindakan = idLangkahTindakan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public int getIdTindakan() {
        return idTindakan;
    }

    public void setIdTindakan(int idTindakan) {
        this.idTindakan = idTindakan;
    }

    public LangkahTindakan(int idLangkahTindakan, String keterangan, int idTindakan) {

        this.idLangkahTindakan = idLangkahTindakan;
        this.keterangan = keterangan;
        this.idTindakan = idTindakan;
    }
}
