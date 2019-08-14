package com.example.sisteminformasimtbs.model.dataclass;

public class Obat{
    private int idObat ;
    private String namaObat ;
    private int syarat ;
    private String pemberian ;

    // TABLE NAME OBAT
    public static final String TABLE_OBAT = "Obat";

    // COLUMN NAME TABLE - OBAT
    public static final String COL_IDOBAT =  "idObat";
    public static final String COL_NAMAOBAT =  "namaObat";
    public static final String COL_SYARAT = "syarat";
    public static final String COL_PEMBERIAN = "pemberian";

    public static final String CREATE_OBAT = "create table Obat "
            +"("
            + COL_IDOBAT+" int primary key , "
            + COL_NAMAOBAT+" varchar(255) , "
            + COL_SYARAT+" varchar(255), "
            + COL_PEMBERIAN+" varchar(255) "
            +");" ;

    public Obat(int idObat, String namaObat, int syarat, String pemberian) {

        this.idObat = idObat;
        this.namaObat = namaObat;
        this.syarat = syarat;
        this.pemberian = pemberian;
    }

    public int getIdObat() {
        return idObat;
    }

    public void setIdObat(int idObat) {
        this.idObat = idObat;
    }

    public String getNamaObat() {
        return namaObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public int getSyarat() {
        return syarat;
    }

    public void setSyarat(int syarat) {
        this.syarat = syarat;
    }

    public String getPemberian() {
        return pemberian;
    }

    public void setPemberian(String pemberian) {
        this.pemberian = pemberian;
    }

}
