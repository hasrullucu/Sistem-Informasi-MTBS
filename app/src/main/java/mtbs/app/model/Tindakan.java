package mtbs.app.model;

public class Tindakan {
    private int idTindakan ;
    private String tindakan ;
    private int tipeTindakan ;
    private String pemberian ;

    public Tindakan(int idTindakan, String tindakan, int tipeTindakan , String pemberian) {
        this.idTindakan = idTindakan;
        this.tindakan = tindakan;
        this.tipeTindakan = tipeTindakan;
        this.pemberian = pemberian;
    }

    public int getIdTindakan() {
        return idTindakan;
    }

    public void setIdTindakan(int idTindakan) {
        this.idTindakan = idTindakan;
    }

    public String getTindakan() {
        return tindakan;
    }

    public String getPemberian() {
        return pemberian;
    }

    public void setPemberian(String pemberian) {
        this.pemberian = pemberian;
    }

    public void setTindakan(String tindakan) {
        this.tindakan = tindakan;
    }

    public int getTipeTindakan() {
        return tipeTindakan;
    }

    public void setTipeTindakan(int tipeTindakan) {
        this.tipeTindakan = tipeTindakan;
    }
}
