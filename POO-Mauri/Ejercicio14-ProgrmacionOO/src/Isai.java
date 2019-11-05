public class Isai {
    String Pelo;
    int cantPestañas;
    int MaxIsAI=3,NumIsaActual=1;
    Isai [] ArrayIsai=new Isai[MaxIsAI];

    public Isai(String pelo, int CantPestañas) {
        Pelo = pelo;
        cantPestañas=cantPestañas;
    }
    public void MeterIsai(Isai Genes){
        if (Genes == null) {
            throw new ExcepcionNull("Intento ilegal de crear un producto nulo"); // para este tipo de null en concreto podemos lanzarlo desde el mismo error
        } else {
            if (MaxIsAI < NumIsaActual){
                ArrayIsai[NumIsaActual] = Genes;
                NumIsaActual++;
            }
        }
    }
    public Isai getIsaiEnPosicion(int i) {
        if ((i >= 0) && (i < NumIsaActual))
            return ArrayIsai[i];
        else
            throw new ExcepcionNoValidPosition(i,MaxIsAI);
    }
}
