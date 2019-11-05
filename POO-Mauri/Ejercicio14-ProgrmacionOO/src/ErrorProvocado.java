import java.util.ArrayList;

public class ErrorProvocado {
    public static void main(String[] args) throws ExcepcionNull , ExcepcionNoValidPosition{
       Isai Isai1=new Isai("verde",5);

            /*try {
                Isai1.MeterIsai(null);

            }catch (ExcepcionNull ex) {
                ex.printStackTrace();
                ex.getMessage(); // esto coge el message del constructor de Isai
                System.out.println(ex);
            }*/
            try {
                Isai1.getIsaiEnPosicion(3); //no hace falta try catch pero asi se controla mejor
            }catch (ExcepcionNoValidPosition ix){
                ix.printStackTrace(); // con esto quitamos lo del main no se que y queda mejor a la vista
            }


    }
}
