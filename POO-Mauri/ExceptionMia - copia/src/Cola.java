import java.util.Arrays;

public class Cola {
    int [] Cola;
    int tamañoActual;

    public Cola(int[] cola) {
        Cola = cola;

    }

    public int[] getCola() {
        return Cola;
    }

    public void setCola(int[] cola) {
        Cola = cola;
    }
    @Override
    public String toString() {
        return "Cola{" +
                "Cola=" + Arrays.toString(Cola) +
                '}';
    }
    public void Insertar(int num) throws Excepcion {
        if(tamañoActual<Cola.length){
            Cola[tamañoActual]=num;
            tamañoActual++;
        }else{
            throw new Excepcion("F no se pudo");
        }
    }
}
