public class Contrato {
    Cliente Cliente;
    Vehiculo Vehiculo;
    String TipoOperacion;
    double PrecioAcordado;

    public Contrato(Cliente cliente, Vehiculo vehiculo, String tipoOperacion, double precioAcordado) {
        Cliente = cliente;
        Vehiculo = vehiculo;
        TipoOperacion = tipoOperacion;
        PrecioAcordado = precioAcordado;
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente cliente) {
        Cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return Vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        Vehiculo = vehiculo;
    }

    public String getTipoOperacion() {
        return TipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        TipoOperacion = tipoOperacion;
    }

    public double getPrecioAcordado() {
        return PrecioAcordado;
    }

    public void setPrecioAcordado(double precioAcordado) {
        PrecioAcordado = precioAcordado;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "Cliente=" + Cliente +
                ", Vehiculo=" + Vehiculo +
                ", TipoOperacion='" + TipoOperacion + '\'' +
                ", PrecioAcordado=" + PrecioAcordado +
                '}';
    }
}
