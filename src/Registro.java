public class Registro {
    private Integer codigoRegistro;
    private int info;

    public Registro(Integer codigoRegistro, int info) {
        this.codigoRegistro = codigoRegistro;
        this.info = info;
    }

    public Integer getCodigoRegistro() {
        return codigoRegistro;
    }

    public void setCodigoRegistro(Integer codigoRegistro) {
        this.codigoRegistro = codigoRegistro;
    }

    public int getInfo() {
        return info;
    }
}
