package mtbs.app.model;

public class Tindakan_JenisObat {
    // pk dari relationship
    private int idTindakan_JenisObat ;
    // fk dari tindakan
    private int idTindakan ;
    // fk dari jenis Obat
    private int idJenisObat ;

    public Tindakan_JenisObat(int idTindakan_JenisObat, int idTindakan, int idJenisObat) {
        this.idTindakan_JenisObat = idTindakan_JenisObat;
        this.idTindakan = idTindakan;
        this.idJenisObat = idJenisObat;
    }

    public int getIdTindakan_JenisObat() {
        return idTindakan_JenisObat;
    }

    public void setIdTindakan_JenisObat(int idTindakan_JenisObat) {
        this.idTindakan_JenisObat = idTindakan_JenisObat;
    }

    public int getIdTindakan() {
        return idTindakan;
    }

    public void setIdTindakan(int idTindakan) {
        this.idTindakan = idTindakan;
    }

    public int getIdJenisObat() {
        return idJenisObat;
    }

    public void setIdJenisObat(int idJenisObat) {
        this.idJenisObat = idJenisObat;
    }
}
