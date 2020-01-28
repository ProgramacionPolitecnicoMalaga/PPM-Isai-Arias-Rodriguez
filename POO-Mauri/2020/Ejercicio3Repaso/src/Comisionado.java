public class Comisionado extends Trabajador {
    int ventas;
    public Comisionado(String nombre, String apellido, double sueldo,int ventas) {
        super(nombre, apellido, sueldo);
        this.ventas=ventas;
    }
}
