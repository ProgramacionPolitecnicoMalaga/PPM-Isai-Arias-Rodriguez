package Vista;

import DAO.PersonaDAO;
import Modelo.Persona;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class BBDApp {
    private JPanel PanelMain;
    private JTextField TxtBuscar;
    private JButton BttBuscar;
    private JTable JTResultados;
    private JButton BttBorrar;
    private JButton BttAñadir;
    public JLabel lblPrueba;
    private BBDApp Estaventana;
    ArrayList<Persona> ListaEmpleados;
    PersonaDAO Empleados = new PersonaDAO();
    Persona PersonaFormulario;

    public BBDApp() throws SQLException {
        Estaventana=this;

        ListaEmpleados=Empleados.CargarArray();
        ActualizarTablaEmple(ListaEmpleados);
        BttAñadir.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Formulario FormularioAñadir=new Formulario(Estaventana);
                    FormularioAñadir.setLocationRelativeTo(SwingUtilities.getRoot((Component)e.getSource())); //crea una ventana nueva
                    FormularioAñadir.pack();
                    FormularioAñadir.setVisible(true);
                    CargarDatosFormulario(PersonaFormulario.getNombre(),PersonaFormulario.getEdad());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }


            }
        });

        BttBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Persona personaBorrar=new Persona(SeleccionarEmpleado(),0,"");
                try {
                    Empleados.BorrarPersona(personaBorrar);
                    ListaEmpleados=Empleados.CargarArray();
                    ActualizarTablaEmple(ListaEmpleados);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                BttBorrar.setEnabled(false);
                try {
                    Empleados.CargarArray();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                ActualizarTablaEmple(ListaEmpleados);

            }
        });
        JTResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SeleccionarEmpleado();
            }
        });
        BttBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Id=TxtBuscar.getText();
                if(Id!=null){
                    try {
                        Persona PersonaEncontrada=Empleados.ConsultarPersona(Integer.parseInt(Id));
                        lblPrueba.setText(PersonaEncontrada.getNombre());
                        System.out.println(PersonaEncontrada.getNombre());

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }else {
                    System.out.println("Nope");
                }

            }
        });
    }

    private int  SeleccionarEmpleado(){
        int filaseleccionada;
        filaseleccionada = JTResultados.getSelectedRow();
        int res =0;
        if (filaseleccionada != -1){
             res= (int) JTResultados.getValueAt(filaseleccionada,0);
            System.out.println(res);
            BttBorrar.setEnabled(true);

        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila.");
        }
        return res;
    }

    private void createUIComponents() {
        JTResultados=new JTable();
        Object[] colunmas={"id","nombre","edad"};
        DefaultTableModel tableModel= new DefaultTableModel();
        tableModel.setColumnIdentifiers(colunmas);
        JTResultados.setModel(tableModel);
    }
    private void ActualizarTablaEmple(ArrayList<Persona> listaemple){
        DefaultTableModel model=(DefaultTableModel) JTResultados.getModel();
        model.setRowCount(0);
        for (Persona empleActual: listaemple){
            Object [] row={empleActual.getId(),empleActual.getNombre(),empleActual.getEdad()};
            model.addRow(row);
        }
    }
    public void CargarDatosFormulario(String nombre, int edad) throws SQLException {
        System.out.println(nombre+" "+edad);
        lblPrueba.setText(nombre+" "+edad);
        Empleados.añadirPersona(new Persona (1,edad,nombre));
        ListaEmpleados=Empleados.CargarArray();
        ActualizarTablaEmple(ListaEmpleados);
    }
    public void DevolverDatos(String text, int edad) {
        PersonaFormulario=new Persona(0,edad,text);
    }
    public static void main(String[]args) throws SQLException {
        JFrame frame= new JFrame("El Mejor CRUD Existente");
        frame.setContentPane(new BBDApp().PanelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }



}
