import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Carrito {
    private JPanel panelMain;
    private JTextField TxtCant;
    private JComboBox CbxLista;
    private JButton BttComprar;
    private JTextArea TAMostrar;
    private JLabel LblTotal;
    private JLabel LblProductoSelec;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Factura> Carrito;
    double PrecioTotal=0;

    public Carrito() {
        CbxLista.insertItemAt("",0); //ClassCastException
        CargarLista();
        Carrito=new ArrayList<>();// Si no inicias el Array u objeto algunas veces da awt nullpointer y para eveitar que se borre inicialo fuera del boton
        BttComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Cantidad= CambiarVacioAValorMinimo(TxtCant.getText());
            if(ControlarNull(CbxLista.getSelectedIndex())){
                Producto ProductoSelec = (Producto) CbxLista.getSelectedItem();
//Comparar objeto seleccionado con el arraylist para obtner los datos para el carrito
                if(ComroprobarLetra(Cantidad)) {
                    int cantidad = Integer.parseInt(CambiarVacioAValorMinimo(TxtCant.getText()));
                    ProductoSelec=BuscarProducto(ProductoSelec.getNombre());
                    System.out.println(ProductoSelec.getNombre());
                    Factura ItemYCantidad=new Factura(ProductoSelec,cantidad);
                    if(ItemRepetido(ItemYCantidad)){
                        EnseñarCarrito(Carrito);
                        EnseñarPrecioTotal(Carrito);
                    }else{
                    Carrito.add(ItemYCantidad);
                    EnseñarCarrito(Carrito);
                    EnseñarPrecioTotal(Carrito);}
                }
                //en caso de que el txtcant no tenga un string valido
            } //en caso de que al comprar no haya nada seleccionado
                TxtCant.setText("");

            }

            private void EnseñarPrecioTotal(ArrayList<Factura> carrito) {
                double cantTotal=0;
                int cantItem= Integer.parseInt(CambiarVacioAValorMinimo(TxtCant.getText()));
                for (Factura Item: carrito){
                   cantTotal =cantItem*Item.producto.getPrecio();

                }
                PrecioTotal=PrecioTotal+cantTotal;
                String factura="Total= "+PrecioTotal;
                LblTotal.setText(factura);
            }

            private boolean ItemRepetido(Factura item) {
                boolean bandera=false;
                String NombreProducto=item.producto.getNombre();
                int cantSumar=item.cantidad;
                for(int i=0;i<Carrito.size();i++){
                    if(Carrito.get(i).producto.getNombre().equalsIgnoreCase(NombreProducto)){
                        int cantidad=cantSumar+Carrito.get(i).getCantidad();
                        Carrito.get(i).setCantidad(cantidad);
                        bandera=true;
                    }
                }
                return bandera;
            }

            private void EnseñarCarrito(ArrayList<Factura> carrito) {
                String [] LineaTextArea=new String[3];
                TAMostrar.setText("");
                for(Factura Elegido : carrito){
                    TAMostrar.append(Elegido.toString()+"\n");
                }
            }

            private Producto BuscarProducto(String NombreSelec) {
                Producto ProductoElegido=null;
                for (Producto listaProducto : listaProductos) {
                    if (listaProducto.getNombre().equalsIgnoreCase(NombreSelec)) {
                        ProductoElegido = listaProducto;
                    }
                }
                return ProductoElegido;
            }
        });
        CbxLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ControlarNull(CbxLista.getSelectedIndex())) {
                    Producto ProductoSelec = (Producto) CbxLista.getSelectedItem();
                        LblProductoSelec.setText("Producto: " + ProductoSelec.getNombre());
                        BttComprar.setEnabled(true);
                    }

                }

        });
    }

    private boolean ControlarNull(int index) { //creado por el index 0 que esta vacio
        boolean bandera=true;
        if (index==0){
            LblProductoSelec.setText("Vacio");
            bandera=false;
        }

       return bandera;
    }

    private void CargarLista() {
        listaProductos=AbrirCsv();

        for (Producto producto1 : listaProductos) {
            System.out.println(producto1.toString());
            CbxLista.addItem(producto1);
        }
    }

    private ArrayList<Producto> AbrirCsv() {
        BufferedReader br;
        String linea,separador=";";
        String [] Producto;
        listaProductos=new ArrayList<>();
        try{
            br=new BufferedReader(new FileReader("productos.csv"));
            while ((linea=br.readLine()) !=null){
                String [] lineaOrdenada=linea.split(separador);
                int IDProducto= Integer.parseInt(lineaOrdenada[0]);
                double Precio= Double.valueOf((lineaOrdenada[4].replaceAll(",",".")));
                listaProductos.add(new Producto(lineaOrdenada[1],lineaOrdenada[2],lineaOrdenada[3],IDProducto, Precio));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException a) {
            a.printStackTrace();
        }
        return listaProductos;
    }
    public static String CambiarVacioAValorMinimo(String txt) {
        if(txt.isEmpty()){
            txt="1";


        }
        return txt;

    }
    public static boolean ComroprobarLetra(String numero){
        boolean bandera;
        try {
            Integer.parseInt(numero);
            bandera= true;
        } catch (NumberFormatException nfe){
            bandera=false;
        }

        return bandera;
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame(" Ver Lugares");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Carrito().panelMain);
        frame.setSize(1750, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
