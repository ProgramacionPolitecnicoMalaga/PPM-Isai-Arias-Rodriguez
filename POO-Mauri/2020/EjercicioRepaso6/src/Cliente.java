public class Cliente {
    String Nombre,Apellido,NIF;
    double CuentaBancaria;

    public Cliente(String nombre, String apellido, String NIF, double cuentaBancaria) {
        Nombre = nombre;
        Apellido = apellido;
        this.NIF = NIF;
        CuentaBancaria = cuentaBancaria;
    }

    public Cliente() {

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public double getCuentaBancaria() {
        return CuentaBancaria;
    }

    public void setCuentaBancaria(long cuentaBancaria) {
        CuentaBancaria = cuentaBancaria;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", NIF='" + NIF + '\'' +
                ", CuentaBancaria=" + CuentaBancaria +
                '}';
    }
}
