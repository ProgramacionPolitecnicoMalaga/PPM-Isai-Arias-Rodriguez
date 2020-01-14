import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class Empleado {
    int[]Ventas;
    String Nombre;
    double media;

    public Empleado(int[] ventas, String nombre) {
        Ventas = ventas;
        Nombre = nombre;
    }

    public int[] getVentas() {
        return Ventas;
    }

    public void setVentas(int[] ventas) {
        Ventas = ventas;
    }

    public String getNombre() {
        return Nombre;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "Ventas=" + Arrays.toString(Ventas) +
                ", Nombre='" + Nombre + '\'' +
                ", media=" + media +
                '}';
    }

    public boolean BuscarVentas(int numero){
        boolean flag=false;
        for (int venta : this.Ventas) {
            if (venta == numero) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public double HallarMedia(Empleado Emple) {
        for (int i=0; i < Emple.Ventas.length; i++) {
            media = media + Emple.Ventas[i];
        }
    return media;
    }



}