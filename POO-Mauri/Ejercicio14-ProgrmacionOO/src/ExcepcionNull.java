public class ExcepcionNull extends IllegalArgumentException{
    public ExcepcionNull(String message){
        super(message);
    }

    @Override
    public String toString() {
        return "Un producto no puede ser null";
    }//este metodo sobre escribe el throw que se crea en meterIsai y basicamentamente cualquier string que le llegue lo machaca
}
