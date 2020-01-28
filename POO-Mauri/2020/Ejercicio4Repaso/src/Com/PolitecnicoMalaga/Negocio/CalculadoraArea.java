package Com.PolitecnicoMalaga.Negocio;

import Com.PolitecnicoMalaga.modelo.Circulo;
import Com.PolitecnicoMalaga.modelo.Cuadrado;
import Com.PolitecnicoMalaga.modelo.Figura;
import Com.PolitecnicoMalaga.modelo.Triangulo;

import java.util.NoSuchElementException;

public class CalculadoraArea {
    public double Calcular(Figura figura){
        double area=0;
        if (figura instanceof Circulo){
            Circulo circulo= (Circulo) figura;
            area= Math.pow(circulo.getRadio(),2)*Math.PI;
        }else if(figura instanceof Triangulo){
            Triangulo triangulo= (Triangulo) figura;
            area= triangulo.getBase()*triangulo.getAltura();
        }else if(figura instanceof Cuadrado){
            Cuadrado cuadrado= (Cuadrado) figura;
            area= Math.pow(cuadrado.getLado(),2);
        }
        return area;
    }
}
