package mtbs.app.model;

public class Klasifikasi_Tindakan {
    // pk relationship
    private int idKlasifikasi_Tindakan ;
    // fk dari klasifikasi
    private int idKlasifikasi ;
    // fk dari tindakan
    private int idTindakan ;

    public Klasifikasi_Tindakan(int idKlasifikasi_Tindakan, int idKlasifikasi, int idTindakan) {
        this.idKlasifikasi_Tindakan = idKlasifikasi_Tindakan;
        this.idKlasifikasi = idKlasifikasi;
        this.idTindakan = idTindakan;
    }

    public int getIdKlasifikasi_Tindakan() {
        return idKlasifikasi_Tindakan;
    }

    public void setIdKlasifikasi_Tindakan(int idKlasifikasi_Tindakan) {
        this.idKlasifikasi_Tindakan = idKlasifikasi_Tindakan;
    }

    public int getIdKlasifikasi() {
        return idKlasifikasi;
    }

    public void setIdKlasifikasi(int idKlasifikasi) {
        this.idKlasifikasi = idKlasifikasi;
    }

    public int getIdTindakan() {
        return idTindakan;
    }

    public void setIdTindakan(int idTindakan) {
        this.idTindakan = idTindakan;
    }
}
