import java.util.ArrayList;

public class Carta {
    Carta(){
            ListaProductos.add(new Producto(12,0,"Crepe"));
            ListaProductos.add(new Producto(2,1,"Bocata de chorizo"));
            ListaProductos.add(new Producto(21,2,"Salchipapa"));
            ListaProductos.add(new Producto(1,3,"Cafelito"));
        }
    public ArrayList AbrirMenu() {
        return PrepararMenu();
    }

    public Producto ElegirProduto(int opcion){
       Producto ProdcutoElegido=null;
        for (Producto ProductoActual: ListaProductos) {
            if(ProductoActual.getId()==opcion){
                ProdcutoElegido=ProductoActual;
            }
        }return ProdcutoElegido;
    }
    private ArrayList PrepararMenu() {
        ArrayList<String> Menu=new ArrayList<>();
        int c=0;
        for (Producto ProductoActual:ListaProductos) {
            String Opcion=c+"-"+ProductoActual.nombre;
            c++;
            Menu.add(Opcion);
        }
        return Menu;
    }

    ArrayList<Producto> ListaProductos=new ArrayList<>();
    public void AñadirProducto(Producto NuevoProducto){
        ListaProductos.add(NuevoProducto);
        recorrerListaProductos();
    }
    public void recorrerListaProductos(){
        for (Producto ProductoActual: ListaProductos) {
            System.out.println(ProductoActual.toString());

        }
    }

    public int ComprobarIdProducto(int id) {
        return id=ListaProductos.size();
    }
}
