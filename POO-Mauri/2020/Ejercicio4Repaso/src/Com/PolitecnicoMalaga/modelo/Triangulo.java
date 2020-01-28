package Com.PolitecnicoMalaga.modelo;

public class Triangulo extends Figura{
    private double base,altura;
    public Triangulo(String color, String nombre) {
        super(color, nombre);
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
