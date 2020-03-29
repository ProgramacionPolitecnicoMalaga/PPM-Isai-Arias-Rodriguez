package Vista;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

public class Formulario extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField TxtNombre;
    private JTextField TxtEdad;
    private  BBDApp VentanaPadre2;
    public Formulario(BBDApp VentanaPadre) throws SQLException {
        VentanaPadre2=VentanaPadre; //faltaba conectar el panelPrincipal con la variable aqui creada
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() throws SQLException {
        int edad = Integer.parseInt(TxtEdad.getText().trim());
        VentanaPadre2.DevolverDatos(TxtNombre.getText(),edad);
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
