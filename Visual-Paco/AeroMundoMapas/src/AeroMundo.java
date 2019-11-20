import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class AeroMundo {
    private JPanel panelMain;
    private JLabel lblPaises;
    private JComboBox CbxPaises;
    private JButton BttBuscar;
    private JLabel lblInfo;
    private JMapViewer MapViAeros;
    private static ArrayList<String> NombrePaises = new ArrayList<String>();
    private static ArrayList<Coordenada> PosicionAeros= new ArrayList<>();
    private String dir = System.getProperty("user.dir");

    public AeroMundo() {
        ProbarMapa();
        try {
            File inputFile = new File(dir + File.separator + "aeropuertos.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("aeropuerto");
            for (int n = nodeList.getLength() - 1; n >= 0; n--) {
                Node nodo = nodeList.item(n);
                short nodeType = nodo.getNodeType();
                if (nodeType == Node.ELEMENT_NODE) {
                    String pais = nodo.getAttributes().getNamedItem("pais").getNodeValue().trim();
                    NombrePaises.add(pais);
                }
            }
            EliminarRepetidos(NombrePaises);
            CargarCombobox();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        BttBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Limpiar();
                String paisSel = CbxPaises.getSelectedItem().toString();
                PrepararExpresion(paisSel);
                //System.out.println(paisSel);

            }
        });
    }

    private void ProbarMapa() {
        Coordenada punto = new Coordenada(-16.2901535,-63.5886536);
       MapViAeros.setDisplayPosition(punto,3);
        MapViAeros.addMapMarker(new MapMarkerDot(punto));


    }


    private void PrepararExpresion(String paisSel) {
        XPath xPathObjecto = XPathFactory.newInstance().newXPath();
        try {
            File inputFile = new File(dir + File.separator + "aeropuertos.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            XPathExpression expressionXPath = xPathObjecto.compile("//aeropuerto[@pais='" + paisSel + "']");
            NodeList NodosAerosSelec = (NodeList) expressionXPath.evaluate(doc, XPathConstants.NODESET);
            //System.out.println("nodos " + NodosAerosSelec.getLength());
            SacarDatos(NodosAerosSelec);

        } catch (XPathExpressionException f) {
            f.printStackTrace();
        } catch (SAXException f) {
            f.printStackTrace();
        } catch (IOException f) {
            f.printStackTrace();
        } catch (ParserConfigurationException f) {
            f.printStackTrace();
        }
    }

    private void SacarDatos(NodeList nodosAerosSelec) {
        for (int n = nodosAerosSelec.getLength() - 1; n >= 0; n--) {
            Node nodo = nodosAerosSelec.item(n);
            short nodeType = nodo.getNodeType();
            if (nodeType == Node.ELEMENT_NODE) {
                NombrePaises.add(nodo.getAttributes().getNamedItem("nombreCorto").getNodeValue());
                double latitud= Double.parseDouble(nodo.getAttributes().getNamedItem("lat").getNodeValue());
                double longitud= Double.parseDouble(nodo.getAttributes().getNamedItem("lon").getNodeValue());
                PosicionAeros.add(new Coordenada(latitud,longitud));
            }
        }
        Collections.sort(NombrePaises);
        CargarMapa(PosicionAeros);

        lblInfo.setText("Aeropuertos (" + NombrePaises.size() + ")");
    }

    private void Limpiar() {
        NombrePaises.clear();
        MapViAeros.removeAllMapMarkers();
        PosicionAeros.clear();

    }

    private void CargarCombobox() {
        NombrePaises.forEach((pais) -> CbxPaises.addItem(pais));
        lblPaises.setText("Elija país (" + NombrePaises.size() + ") :");
    }

    private ArrayList<String> EliminarRepetidos(ArrayList<String> paises) {
        Set<String> hs = new HashSet<>();
        hs.addAll(paises);
        paises.clear();
        paises.addAll(hs);
        Collections.sort(paises);
        return paises;
    }
    private void CargarMapa(ArrayList<Coordenada> posicionAeros) {
        posicionAeros.forEach((Coordenada) -> MapViAeros.addMapMarker(new MapMarkerDot(Coordenada)));
        Coordenada Zoom=posicionAeros.get(0);
        MapViAeros.setDisplayPosition(Zoom,2);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aeropuertos por país");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new AeroMundo().panelMain);
        frame.setSize(550, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
