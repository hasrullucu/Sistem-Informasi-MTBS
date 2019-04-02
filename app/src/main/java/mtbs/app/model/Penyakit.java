package mtbs.app.model;

public class Penyakit {
    private int idPenyakit ;
    private String namaPenyakit ;

    public Penyakit(int idPenyakit, String namaPenyakit) {
        this.idPenyakit = idPenyakit;
        this.namaPenyakit = namaPenyakit;
    }



    public int getIdPenyakit() {
        return idPenyakit;
    }

    public void setIdPenyakit(int idPenyakit) {
        this.idPenyakit = idPenyakit;
    }

    public String getNamaPenyakit() {
        return namaPenyakit;
    }

    public void setNamaPenyakit(String namaPenyakit) {
        this.namaPenyakit = namaPenyakit;
    }


}
