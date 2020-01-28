package Com.PolitecnicoMalaga.modelo;

public class Circulo extends Figura {
    private double radio;
    public Circulo(String color, String nombre) {
        super(color, nombre);
    }
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }



}
