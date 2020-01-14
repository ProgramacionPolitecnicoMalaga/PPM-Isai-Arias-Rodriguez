import java.util.ArrayList;
import java.util.TreeMap;

public class Empleados {
    ArrayList<Empleado> ListaEmpleados = new ArrayList<>();
    Empleados() {
        ListaEmpleados.add(new Empleado(new int[]{7, 7, 10, 6, 4},"Isabel"));
        ListaEmpleados.add(new Empleado(new int[]{4, 7, 5, 4, 5},"Vicente"));

    }
    public void MayorVentas(int dia){
        ArrayList<String> EmpleadoDelDia = new ArrayList<>();
       int Inicial=-1;
       String nombre,empleado="nada";
        for (Empleado listaEmpleado : ListaEmpleados) {
            int h=listaEmpleado.Ventas[dia];
            if(h>Inicial){
                Inicial = h;
                nombre=listaEmpleado.getNombre();
                empleado="Es "+nombre+" con "+Inicial;
            }

        }
        EmpleadoDelDia.add(empleado);
        LeerArray(EmpleadoDelDia);
    }
    public void PromedioVentas() {
        String nombre;
        double media;
        ArrayList<String> ListaMedia = new ArrayList<>();
        for (Empleado listaEmpleado : ListaEmpleados) {
            media=listaEmpleado.HallarMedia(listaEmpleado);
            nombre=listaEmpleado.getNombre();
            ListaMedia.add(nombre+" = "+media);
        }
        LeerArray(ListaMedia);
    }
    public void ListarEmpleVentas(int numero) {
        ArrayList<String> ListaEmpleVentas = new ArrayList<>();
        boolean flag;
        for (Empleado listaEmpleado : ListaEmpleados) {
            flag=listaEmpleado.BuscarVentas(numero);
            if(flag){
                ListaEmpleVentas.add(listaEmpleado.getNombre());
            }
        }
        LeerArray(ListaEmpleVentas);
    }

    private void LeerArray(ArrayList<String> Lista) {
        for (String palabra:Lista
        ) {
           System.out.println(palabra);
        }
    }


    public void AñadirnuevoEmpleado(String nombre) {
        Empleado NuevoEmpleado=new Empleado(new int[]{},nombre);
        ListaEmpleados.add(NuevoEmpleado);
    }
}
