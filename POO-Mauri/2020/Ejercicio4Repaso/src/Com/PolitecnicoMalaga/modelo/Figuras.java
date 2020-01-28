package Com.PolitecnicoMalaga.modelo;

import Com.PolitecnicoMalaga.Negocio.CalculadoraArea;

import java.util.ArrayList;

public class Figuras {
    static ArrayList<Figura>ListasFigura;

    public void AddFigura(Figura NuevaFigura){
        ListasFigura.add(NuevaFigura);
    }
    public static void main(String[] args) {
        ListasFigura=new ArrayList<>();
        ListasFigura.add(new Circulo("Verde","Circulo"));
        ListasFigura.add(new Triangulo("Rosa","Triangulo"));
        ListasFigura.add(new Cuadrado("Amarillo","Cuadrado"));
        Figura circulo= new Circulo("negro","Circulo");
        ((Circulo)circulo).setRadio(10);
        Figura Triangulo= new Triangulo("v","Triangulo");
        ((Triangulo)Triangulo).setAltura(4);
        ((Triangulo)Triangulo).setBase(3);
        Figura Cuadradi= new Cuadrado("f","Cuadrado");
        ((Cuadrado)Cuadradi).setLado(5);
        ListasFigura.add(circulo);
        ListasFigura.add(Triangulo);
        ListasFigura.add(Cuadradi);
        CalculadoraArea calculadora=new CalculadoraArea();
        for(int i=0;i<ListasFigura.size();i++){
            System.out.println(calculadora.Calcular(ListasFigura.get(i)));
        }
    }
}
