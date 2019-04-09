package mtbs.app.model;

public class Kunjungan {
    private int idKunjungan;
    private int tipeKunjungan ;
    private double suhu ;
    private double panjangBadan ;
    private double beratBadan ;
    private String tanggalKunjungan ;
    private int kunjunganKe ;
    private String keluhan ;

    // fk dari id balita
    private int idBalita;

    public int getIdBalita() {
        return idBalita;
    }

    public void setIdBalita(int idBalita) {
        this.idBalita = idBalita;
    }

    public Kunjungan(int idKunjungan, int tipeKunjungan, double suhu, double panjangBadan, double beratBadan, String tanggalKunjungan, int kunjunganKe, String keluhan, int idBalita) {
        this.idKunjungan = idKunjungan;
        this.tipeKunjungan = tipeKunjungan;
        this.suhu = suhu;
        this.panjangBadan = panjangBadan;
        this.beratBadan = beratBadan;
        this.tanggalKunjungan = tanggalKunjungan;
        this.kunjunganKe = kunjunganKe;
        this.keluhan = keluhan;
        this.idBalita = idBalita;
    }

    public int getIdKunjungan() {
        return idKunjungan;
    }

    public void setIdKunjungan(int idKunjungan) {
        this.idKunjungan = idKunjungan;
    }

    public int getTipeKunjungan() {
        return tipeKunjungan;
    }

    public void setTipeKunjungan(int tipeKunjungan) {
        this.tipeKunjungan = tipeKunjungan;
    }

    public double getSuhu() {
        return suhu;
    }

    public void setSuhu(double suhu) {
        this.suhu = suhu;
    }

    public double getPanjangBadan() {
        return panjangBadan;
    }

    public void setPanjangBadan(double panjangBadan) {
        this.panjangBadan = panjangBadan;
    }

    public double getBeratBadan() {
        return beratBadan;
    }

    public void setBeratBadan(double beratBadan) {
        this.beratBadan = beratBadan;
    }

    public String getTanggalKunjungan() {
        return tanggalKunjungan;
    }

    public void setTanggalKunjungan(String tanggalKunjungan) {
        this.tanggalKunjungan = tanggalKunjungan;
    }

    public int getKunjunganKe() {
        return kunjunganKe;
    }

    public void setKunjunganKe(int kunjunganKe) {
        this.kunjunganKe = kunjunganKe;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }
}
