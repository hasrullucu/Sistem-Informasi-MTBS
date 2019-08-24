package com.example.sisteminformasimtbs.testing;

public class TindakanResult {

    private int idTindakan ;
    private String namaTindakan ;

    public int getIdTindakan() {
        return idTindakan;
    }

    public String getNamaTindakan() {
        return namaTindakan;
    }

    public TindakanResult(int idTindakan, String namaTindakan) {
        this.idTindakan = idTindakan;
        this.namaTindakan = namaTindakan;
    }

}
