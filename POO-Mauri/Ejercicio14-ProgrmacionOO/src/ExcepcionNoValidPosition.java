public class ExcepcionNoValidPosition extends IndexOutOfBoundsException{
    public ExcepcionNoValidPosition(int i, int límiteMáximo){
        super("Si creamos demasiados Isai, nos comeran, mira ese te esta mirando,Asi que controlate porque la posicion : " + i + " supera al máximo permitido: " + límiteMáximo);
    }

    @Override
    public String toString() {
        return this.getMessage();//"El índice " + i + " supera al máximo permitido: " + límiteMáximo;
    }
}
