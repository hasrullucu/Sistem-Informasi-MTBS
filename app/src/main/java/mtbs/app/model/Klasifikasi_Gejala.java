package mtbs.app.model;

public class Klasifikasi_Gejala {
    // pk relationship
    private int IdKlasifikasi_gejala ;
    // fk dari klasifikasi
    private int IdKlasifikasi ;
    // fk dari gejala
    private int IdGejala ;

    public Klasifikasi_Gejala(int idKlasifikasi_gejala, int idKlasifikasi, int idGejala) {
        IdKlasifikasi_gejala = idKlasifikasi_gejala;
        IdKlasifikasi = idKlasifikasi;
        IdGejala = idGejala;
    }

    public int getIdKlasifikasi_gejala() {
        return IdKlasifikasi_gejala;
    }

    public void setIdKlasifikasi_gejala(int idKlasifikasi_gejala) {
        IdKlasifikasi_gejala = idKlasifikasi_gejala;
    }

    public int getIdKlasifikasi() {
        return IdKlasifikasi;
    }

    public void setIdKlasifikasi(int idKlasifikasi) {
        IdKlasifikasi = idKlasifikasi;
    }

    public int getIdGejala() {
        return IdGejala;
    }

    public void setIdGejala(int idGejala) {
        IdGejala = idGejala;
    }
}
