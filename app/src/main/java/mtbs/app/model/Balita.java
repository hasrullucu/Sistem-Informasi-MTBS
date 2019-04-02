package mtbs.app.model;


public class Balita {
    private String nama ;
    private int idBalita ;
    private String namaIbu ;
    private int nomorPasien ;
    private String alamat ;
    private char jenisKelamin ;
    private String tanggalLahir ;
    private int umur ;

    public Balita(String nama, int idBalita, String namaIbu, int nomorPasien, String alamat, char jenisKelamin, String tanggalLahir, int umur) {
        this.nama = nama;
        this.idBalita = idBalita;
        this.namaIbu = namaIbu;
        this.nomorPasien = nomorPasien;
        this.alamat = alamat;
        this.jenisKelamin = jenisKelamin;
        this.tanggalLahir = tanggalLahir;
        this.umur = umur;
    }

    public int getIdBalita() {
        return idBalita;
    }

    public void setIdBalita(int idBalita) {
        this.idBalita = idBalita;
    }

    public int getNomorPasien() {
        return nomorPasien;
    }

    public void setNomorPasien(int nomorPasien) {
        this.nomorPasien = nomorPasien;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNamaIbu() {
        return namaIbu;
    }

    public void setNamaIbu(String namaIbu) {
        this.namaIbu = namaIbu;
    }

    public char getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(char jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }
}
