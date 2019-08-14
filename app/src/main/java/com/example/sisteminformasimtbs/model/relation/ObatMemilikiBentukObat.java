package com.example.sisteminformasimtbs.model.relation;

import com.example.sisteminformasimtbs.model.dataclass.BentukObat;
import com.example.sisteminformasimtbs.model.dataclass.Obat;

public class ObatMemilikiBentukObat {
    private int id; // id universal
    private int idObat ;
    private int idBentukObat;

    public static final String TABLE_OBAT_BENTUKOBAT = "ObatMemilikiBentukObat";

    private static final String COL_ID = "id";
    // fk obat
    // fk bentuk obat

    public static final String CREATE_OBAT_BENTUKOBAT = "create table "+TABLE_OBAT_BENTUKOBAT
            +" ( "
            +  COL_ID +" int primary key, "
            +  Obat.COL_IDOBAT  +" int, "
            +  BentukObat.COL_IDBENTUKOBAT +" int, "
            +   "   foreign key (idObat) references Obat (idObat), "
            +   "   foreign key (idBentukObat) references BentukObat (idBentukObat)"
            + ");";

    public ObatMemilikiBentukObat(int id, int idObat, int idBentukObat) {
        this.id = id;
        this.idObat = idObat;
        this.idBentukObat = idBentukObat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdObat() {
        return idObat;
    }

    public void setIdObat(int idObat) {
        this.idObat = idObat;
    }

    public int getIdBentukObat() {
        return idBentukObat;
    }

    public void setIdBentukObat(int idBentukObat) {
        this.idBentukObat = idBentukObat;
    }
}
