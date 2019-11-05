import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Tirada {

    private JPanel panelMain;
    private JPanel PanImagen;
    private JLabel LblImagen;
    private JButton tirarButton;
    private JButton BbtTirar;
    private JLabel LblTiradas;
    private JLabel LblCara;
    private JLabel LblCruz;
    private JTextField TxtNumveces;
    private JLabel LblRes;
    private JButton BttLimpiar;
    private JLabel LblPorcentajeCara;
    private JLabel LblPorcentajeCruz;
    boolean lado;
    int NumTiradas,Cara,Cruz;

    public Tirada() {
        BbtTirar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanImagen.setVisible(true);
                TirarMoneda();
                if(lado){
                    SalioCara();
                }else{
                    SalioCruz();
                }
                NumTiradas++;
                String numero= String.valueOf(NumTiradas);
                LblTiradas.setText(numero);
                int PorcentajeCRUZ=100-SacarPocentaje();
                LblPorcentajeCara.setText("Cara :"+SacarPocentaje()+"%");
                LblPorcentajeCruz.setText("Cruz :"+PorcentajeCRUZ+"%");
            }
        });
        tirarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ComroprobarLetra(TxtNumveces.getText())) {
                int numVeces= Integer.parseInt(CambiarVacioAValorMinimo(TxtNumveces.getText()));

                    int contadorVeces = 0;
                    do {
                        TirarMoneda();
                        if (lado) {
                            SalioCara();
                        } else {
                            SalioCruz();
                        }
                        NumTiradas++;
                        String numero = String.valueOf(NumTiradas);
                        LblTiradas.setText(numero);
                        int PorcentajeCRUZ=100-SacarPocentaje();
                        LblPorcentajeCara.setText("Cara :"+SacarPocentaje()+"%");
                        LblPorcentajeCruz.setText("Cruz :"+PorcentajeCRUZ+"%");
                        contadorVeces++;
                    } while (contadorVeces != numVeces);
                }
                else{
                    System.out.println("Numero no valido");
                }
            }
        });
        BttLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NumTiradas=0;
                Cara=0;
                Cruz=0;
                LblTiradas.setText("");
                LblCara.setText("");
                LblCruz.setText("");
                LblImagen.setIcon(null);
                LblRes.setText("");
                TxtNumveces.setText("");

            }
        });
    }

    private void SalioCruz() {
        String ruta="Imagenes/Cruz.JPG";
            ImageIcon icon = new ImageIcon(ruta);
        LblImagen.setIcon(icon);
        LblRes.setText("CRUZ!!!");
        Cruz++;
        String numero= String.valueOf(Cruz);
        LblCruz.setText(numero);
    }

    private void SalioCara() {
        String ruta="Imagenes/Cara.JPG";
        ImageIcon icon = new ImageIcon(ruta);
        LblImagen.setIcon(icon);
        LblRes.setText("CARA!!!");
        Cara++;
        String numero= String.valueOf(Cara);
        LblCara.setText(numero);

    }

    boolean TirarMoneda(){
            if (Math.random() < 0.5) {//heads 50% of the time
                lado = true; //heads
            } else {
                lado = false; //tails
            }
            return lado;

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
   public int SacarPocentaje(){
        int PorcentajeCara;
        PorcentajeCara=(100*Cara)/NumTiradas;
    return PorcentajeCara;
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame(" Ver Lugares");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Tirada().panelMain);
        frame.setSize(1750, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
