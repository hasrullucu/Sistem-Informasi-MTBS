package com.example.sisteminformasimtbs.testing;

public class LangkahTindakanResult {
    private int idLangkahTindakan ;
    private String namaLangkahTindakan ;

    public int getIdLangkahTindakan() {
        return idLangkahTindakan;
    }

    public String getNamaLangkahTindakan() {
        return namaLangkahTindakan;
    }

    public LangkahTindakanResult(int idLangkahTindakan, String namaLangkahTindakan) {
        this.idLangkahTindakan = idLangkahTindakan;
        this.namaLangkahTindakan = namaLangkahTindakan;
    }
}
