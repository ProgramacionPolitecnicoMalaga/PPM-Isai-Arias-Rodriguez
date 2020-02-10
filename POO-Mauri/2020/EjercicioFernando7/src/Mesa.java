import java.util.ArrayList;

public class Mesa {
    boolean Estado;
    double Total;
    ArrayList<Producto>ListaProductosMesa;
    String ID;

    public Mesa(boolean estado, ArrayList<Producto> listaProductosMesa, String ID) {
        Estado = estado;
        ListaProductosMesa = listaProductosMesa;
        this.ID = ID;
    }
    public void AñadirProducto(Producto NuevoProducto){
        ListaProductosMesa.add(NuevoProducto);
    }

    public ArrayList<Producto> getListaProductosMesa() {
        return ListaProductosMesa;
    }

    @Override
    public String toString() {
        return "Mesa{" +
                "Estado=" + Estado +
                ", Total=" + Total +
                ", ListaProductosMesa=" + ListaProductosMesa +
                ", ID='" + ID + '\'' +
                '}';
    }
}
