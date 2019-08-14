package com.example.sisteminformasimtbs.model.dataclass;

/**
 * Kelas  Jenis Obat untuk identifikasi jenis obat seperti
 * (Kapsul , sirup)
 *
 */
public class BentukObat {
    private int idBentukObat;
    private String namaBentukObat ;
    private String satuan ;

    // table name
    public static final String TABLE_BENTUKOBAT = "BentukObat";

    // column name
    // COLUMN NAME TABLE - JENISOBAT
    public static final String COL_IDBENTUKOBAT  = "idBentukObat";
    private static final String COL_NAMABENTUKOBAT = "namaBentukObat";
    private static final String COL_SATUAN = "satuan";

    public static final String CREATE_BENTUKOBAT  = "create table "+TABLE_BENTUKOBAT
            + "("
            + COL_IDBENTUKOBAT +" int primary key, "
            + COL_NAMABENTUKOBAT+ " varchar(255), "
            + COL_SATUAN + " satuan varchar"
            +" );";

    public BentukObat(int idBentukObat, String namaBentukObat, String satuan) {
        this.idBentukObat = idBentukObat;
        this.namaBentukObat = namaBentukObat;
        this.satuan = satuan;
    }

    public int getIdBentukObat() {
        return idBentukObat;
    }

    public void setIdBentukObat(int idBentukObat) {
        this.idBentukObat = idBentukObat;
    }

    public String getNamaBentukObat() {
        return namaBentukObat;
    }

    public void setNamaBentukObat(String namaBentukObat) {
        this.namaBentukObat = namaBentukObat;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }
}
