package Com.PolitecnicoMalaga.modelo;

public class Cuadrado extends Figura {
    double lado;
    public Cuadrado(String color, String nombre) {
        super(color, nombre);
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

}
