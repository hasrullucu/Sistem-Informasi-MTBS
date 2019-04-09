package mtbs.app.model;

public class Klasifikasi {

    private int idKlasifikasi;
    private String namaKlasifikasi;
    private int jumlahGejala ;

     // fk dari Penyakit
    private  int idPenyakit ;

    public Klasifikasi(int idKlasifikasi, String namaKlasifikasi, int jumlahGejala, int idPenyakit) {
        this.idKlasifikasi = idKlasifikasi;
        this.namaKlasifikasi = namaKlasifikasi;
        this.jumlahGejala = jumlahGejala;
        this.idPenyakit = idPenyakit;
    }

    public int getIdKlasifikasi() {
        return idKlasifikasi;
    }

    public void setIdKlasifikasi(int idKlasifikasi) {
        this.idKlasifikasi = idKlasifikasi;
    }

    public String getNamaKlasifikasi() {
        return namaKlasifikasi;
    }

    public void setNamaKlasifikasi(String namaKlasifikasi) {
        this.namaKlasifikasi = namaKlasifikasi;
    }

    public int getJumlahGejala() {
        return jumlahGejala;
    }

    public void setJumlahGejala(int jumlahGejala) {
        this.jumlahGejala = jumlahGejala;
    }

    public int getIdPenyakit() {
        return idPenyakit;
    }

    public void setIdPenyakit(int idPenyakit) {
        this.idPenyakit = idPenyakit;
    }
}
