package mtbs.app.model;

public class Kunjungan_Penyakit {
    // pk dari relationship
    private int IdKunjungan_penyakit ;
    // fk dari kunjugan
    private int idKunjungan ;
    // fk dari penyakit
    private int idPenyakit ;

    public Kunjungan_Penyakit(int idKunjungan_penyakit, int idKunjungan, int idPenyakit) {
        IdKunjungan_penyakit = idKunjungan_penyakit;
        this.idKunjungan = idKunjungan;
        this.idPenyakit = idPenyakit;
    }

    public int getIdKunjungan_penyakit() {
        return IdKunjungan_penyakit;
    }

    public void setIdKunjungan_penyakit(int idKunjungan_penyakit) {
        IdKunjungan_penyakit = idKunjungan_penyakit;
    }

    public int getIdKunjungan() {
        return idKunjungan;
    }

    public void setIdKunjungan(int idKunjungan) {
        this.idKunjungan = idKunjungan;
    }

    public int getIdPenyakit() {
        return idPenyakit;
    }

    public void setIdPenyakit(int idPenyakit) {
        this.idPenyakit = idPenyakit;
    }
}
