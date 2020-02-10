import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.util.ArrayList;
import java.util.Scanner;

public class Cafeteria {

    private JPanel panelMain;
    private JButton BttM1;
    private JButton BttM3;
    private JButton BttM4;
    private JButton BttM2;
    private JTextArea TAMostrar;
    private JButton BttCobrar;
    private JLabel LblCuenta;
    private JTextField TxtMenuOpcion;
    private JTextArea TAMenu;
    private JLabel LblC;
    private JButton BttAñadir;
    private JButton BttAñadirProd;
    private JPanel PanNueProd;
    private JTextField TxtPrecio;
    private JTextField TxtID;
    private JTextField TxtNombre;
    private JButton BttAceptar;
    private JButton BttVerAbiertas;
    private JButton BttVerCerradas;
    private JButton BttVerCaja;


    public Cafeteria() {

        Carta Carta=new Carta();
        ArrayList<Producto> ListaMesaProducto1=new ArrayList<>();
        ArrayList<Producto> ListaMesaProducto2=new ArrayList<>();
        ArrayList<Producto> ListaMesaProducto3=new ArrayList<>();
        ArrayList<Producto> ListaMesaProducto4=new ArrayList<>();
        Mesa Mesa1=new Mesa(false,ListaMesaProducto1,"01");
        Mesa Mesa2=new Mesa(false,ListaMesaProducto2,"02");
        Mesa Mesa3=new Mesa(false,ListaMesaProducto3,"03");
        Mesa Mesa4=new Mesa(false,ListaMesaProducto4,"04");
        ArrayList<Mesa> ListaMesas=new ArrayList<>();
        ListaMesas.add(Mesa1);
        ListaMesas.add(Mesa2);
        ListaMesas.add(Mesa3);
        ListaMesas.add(Mesa4);

        //Mesa 1-----------------------------------------------------------------

        BttM1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BttCobrar.setEnabled(true);
                Mesa1.Estado=true;
                Mesa2.Estado=false;
                Mesa3.Estado=false;
                Mesa4.Estado=false;
                TAMostrar.setText("");
                TAMostrar.setText("Mesa :"+Mesa1.ID);
                TAMenu.setVisible(true);
                TxtMenuOpcion.setVisible(true);
                LblC.setVisible(true);
                BttAñadir.setVisible(true);
                LeerMenu(Carta.AbrirMenu());

            }
        });
        panelMain.addComponentListener(new ComponentAdapter() {
        });
        //Añadir------------------------------------------------------------
        BttAñadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mesa MesaActual = null;
                for(Mesa MesaACTUAL: ListaMesas){
                    if(MesaACTUAL.Estado){
                        MesaActual=MesaACTUAL;
                    }
                }
                AñadirProductoMesa(MesaActual);

                TxtMenuOpcion.setText("");
                TxtMenuOpcion.grabFocus();
            }

            private void AñadirProductoMesa(Mesa mesaActual) {
                int opcion=ElegirOpcion();
                if(!(Carta.ElegirProduto(opcion)==null)){
                    mesaActual.getListaProductosMesa().add(Carta.ElegirProduto(opcion));
                    EnseñarMesa(mesaActual);
                }else {
                    System.out.println("No se ha elegido producto");
                }

            }
        });
        BttAñadirProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanNueProd.setVisible(true);

            }
        });
        BttAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double precio= Double.parseDouble(TxtPrecio.getText());
                int id= Integer.parseInt(TxtID.getText());
                String nombre=TxtNombre.getText();
                id=Carta.ComprobarIdProducto(id);
                Producto NuevoProducto=new Producto(precio,id,nombre);
                Carta.AñadirProducto(NuevoProducto);
                PanNueProd.setVisible(false);
            }
        });
        //-------------Cobrar-------------------------------------
        BttCobrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LblCuenta.setText("");
                for(Mesa MesaACTUAL: ListaMesas){
                    if(MesaACTUAL.Estado){
                        Cobrar(MesaACTUAL);
                        EnseñarMesa(MesaACTUAL);
                    }
                }

            }
        });
        BttM2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BttCobrar.setEnabled(true);
                Mesa2.Estado=true;
                Mesa1.Estado=false;
                Mesa3.Estado=false;
                Mesa4.Estado=false;
                TAMostrar.setText("");
                TAMostrar.setText("Mesa :"+Mesa2.ID);
                TAMenu.setVisible(true);
                TxtMenuOpcion.setVisible(true);
                LblC.setVisible(true);
                BttAñadir.setVisible(true);
                LeerMenu(Carta.AbrirMenu());

            }


        });
        BttM3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BttCobrar.setEnabled(true);
                Mesa3.Estado=true;
                Mesa2.Estado=false;
                Mesa1.Estado=false;
                Mesa4.Estado=false;
                TAMostrar.setText("");
                TAMostrar.setText("Mesa :"+Mesa3.ID);
                TAMenu.setVisible(true);
                TxtMenuOpcion.setVisible(true);
                LblC.setVisible(true);
                BttAñadir.setVisible(true);
                LeerMenu(Carta.AbrirMenu());
            }
        });
        BttM4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BttCobrar.setEnabled(true);
                Mesa4.Estado=true;
                Mesa3.Estado=false;
                Mesa2.Estado=false;
                Mesa1.Estado=false;
                TAMostrar.setText("");
                TAMostrar.setText("Mesa :"+Mesa4.ID);
                TAMenu.setVisible(true);
                TxtMenuOpcion.setVisible(true);
                LblC.setVisible(true);
                BttAñadir.setVisible(true);
                LeerMenu(Carta.AbrirMenu());

            }
        });
        BttVerAbiertas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TAMostrar.setText(" ");
                ArrayList<Mesa>ListaMesasLibres=new ArrayList<>();
                for (Mesa MesaActual: ListaMesas) {
                    if(MesaActual.Estado){
                       ListaMesasLibres.add(MesaActual);
                    }
                }
                VerMesas(ListaMesasLibres);
            }
        });
        BttVerCerradas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TAMostrar.setText(" ");
                ArrayList<Mesa>ListaMesasCerradas=new ArrayList<>();
                for (Mesa MesaActual: ListaMesas) {
                    if(!MesaActual.Estado){
                        ListaMesasCerradas.add(MesaActual);
                    }
                }
                TAMostrar.setText("");
                VerMesas(ListaMesasCerradas);
            }

        });
        BttVerCaja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TAMostrar.setText(" ");
                double cajatotal=0;
                for (Mesa MesaActual:ListaMesas) {
                    cajatotal+=Cobrar(MesaActual);
                }
                LblCuenta.setText("Total ="+cajatotal+"€");
            }

        });
    }

    private void VerMesas(ArrayList<Mesa> ListaMesas) {
        for (Mesa MesaActaul: ListaMesas
        ) {
            TAMostrar.append(" Mesa(s) ="+MesaActaul.ID);

        }

    }

    private double Cobrar(Mesa mesaACTUAL) {
        double factura = 0;
        for (Producto Productoactual: mesaACTUAL.getListaProductosMesa()) {
            factura+=Productoactual.getPrecio();
        }

        LblCuenta.setText("La cuenta de la mesa "+mesaACTUAL.ID+" : " +String.valueOf(factura)+"€");
        return factura;
    }


    private void EnseñarMesa(Mesa MesaElegida) {
        TAMostrar.setText("");
        if(!MesaElegida.getListaProductosMesa().isEmpty()) {
            TAMostrar.append(MesaElegida.getListaProductosMesa().toString());
        }else TAMostrar.append("Mesa sin productos");
    }
    private int ElegirOpcion() {
        int Opcion=0;
            String CambioAInt=TxtMenuOpcion.getText();
        if(ComroprobarLetra(CambioAInt)){
            Opcion= Integer.parseInt(CambioAInt);
        }
        CorregirString(CambioAInt);
        TAMostrar.append("Introducir una letra del menu");
        return Opcion;
    }

    private int CorregirString(String cambioAInt) {
        int opcion=-1;
       if(cambioAInt.equalsIgnoreCase("")){
           cambioAInt="-1";
           opcion= Integer.parseInt(cambioAInt);
       }
        return opcion;
    }

    public static boolean ComroprobarLetra(String numero){
        boolean bandera;
        try {
            Integer.parseInt(numero);
            bandera= true;
        } catch (NumberFormatException nfe){
            //bucle por meter en string en un while
            bandera=false;
        }

        return bandera;
    }

    private void LeerMenu(ArrayList Menu) {
        TAMenu.setText("");
        for (Object opcion:Menu) {
            TAMenu.append(String.valueOf(opcion)+"\n");
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame(" Ver Lugares");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Cafeteria().panelMain);
        frame.setSize(1750, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
