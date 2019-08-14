package com.example.sisteminformasimtbs.model.relation;

import com.example.sisteminformasimtbs.model.dataclass.BentukObat;
import com.example.sisteminformasimtbs.model.dataclass.Tindakan;

public class TindakanMemilikiBentukObat {
   private int id; // id universal
   private int idTindakan ; // id Tindakan
     private int idBentukObat ; // id bentuk obat
    private int batasBawah ; // batas bawah dari tabel syarat umur
    private int batasAtas ; // batas atas dari tabel syarat umur




    public static final String TABLE_TIN_BENTUKOBAT = "TindakanMemilikiBentukObat";

    // COLUMN NAME TABLE - TINDAKAN_BENTUKOBAT
    private static final String COL_ID = "id"; // id universal
    private static final String COL_BATASBAWAH = "batasBawah";
    private static final String COL_BATASATAS = "batasAtas";



    public static final String CREATE_TIN_BENTUKOBAT = "create table "+ TABLE_TIN_BENTUKOBAT
            +" ("
            + COL_ID +" int primary key, "
            + Tindakan.COL_IDTINDAKAN +" int, "
            + BentukObat.COL_IDBENTUKOBAT +" int, "
            + COL_BATASBAWAH+" int, "
            + COL_BATASATAS+" int, "
            +   "      foreign key (idTindakan) references Tindakan (idTindakan), "
            +   "      foreign key (idBentukObat) references BentukObat (idBentukObat)"
            +");";

    public TindakanMemilikiBentukObat(int id, int idTindakan, int idBentukObat, int batasBawah, int batasAtas) {
        this.id = id;
        this.idTindakan = idTindakan;
        this.idBentukObat = idBentukObat;
        this.batasBawah = batasBawah;
        this.batasAtas = batasAtas;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTindakan() {
        return idTindakan;
    }

    public void setIdTindakan(int idTindakan) {
        this.idTindakan = idTindakan;
    }

    public int getIdBentukObat() {
        return idBentukObat;
    }

    public void setIdBentukObat(int idBentukObat) {
        this.idBentukObat = idBentukObat;
    }

    public int getBatasBawah() {
        return batasBawah;
    }

    public void setBatasBawah(int batasBawah) {
        this.batasBawah = batasBawah;
    }

    public int getBatasAtas() {
        return batasAtas;
    }

    public void setBatasAtas(int batasAtas) {
        this.batasAtas = batasAtas;
    }
}
