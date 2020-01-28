public class PorHoras extends Trabajador {
    int HorasTrabajadas;
    public PorHoras(String nombre, String apellido, double sueldo,int HorasTrabajadas) {
        super(nombre, apellido, sueldo);
        this.HorasTrabajadas=HorasTrabajadas;
    }
}
