import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner T=new Scanner(System.in);
        Empleados AccionesEmpleado=new Empleados();
        int op;
        System.out.println("1- Empleados que vendieron un número de items ");
        System.out.println("2- Obtener el promedio de ventas de cada uno");
        System.out.println("3- Averiguar quién han conseguido el mayor número de ventas en un día");
        System.out.println("4- Insertar un nuevo empleado y sus ventas");
        op=T.nextInt();
        switch (op) {
            case 1:
                System.out.println("Cantidad de items ");
                int numero=T.nextInt();
                AccionesEmpleado.ListarEmpleVentas(numero);
                break;
            case 2:
                System.out.println("La media es ");
                AccionesEmpleado.PromedioVentas();

                break;
            case 3:

                System.out.println("Averiguar quién han conseguido el mayor número de ventas en un día (0-4)");
                int dia=T.nextInt();
                AccionesEmpleado.MayorVentas(dia);
                break;
            case 4:
                System.out.println("Averiguar quién han conseguido el mayor número de ventas en un día");
                String nom=T.toString();
                AccionesEmpleado.AñadirnuevoEmpleado(nom);

                break;
            default:
                System.out.println("NO HAS ELEGIDO");
        }
    }
}
