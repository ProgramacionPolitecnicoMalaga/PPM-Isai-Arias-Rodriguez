public class MiMain {
    private static Cola cola;
    private static final int TAM_COLA = 2;

    public static void main(String[] args) throws Excepcion  {
        Cola cola= new Cola(new int[TAM_COLA]);
        try {
            cola.Insertar(7);
            cola.Insertar(8);
            cola.Insertar(9);

        } catch (Excepcion excepcion) {
            excepcion.printStackTrace();
            System.out.println(" y por aqui tambien te lo digo,puedo usar ambas formas");
        }
        System.out.println(cola.toString());


    }
}
