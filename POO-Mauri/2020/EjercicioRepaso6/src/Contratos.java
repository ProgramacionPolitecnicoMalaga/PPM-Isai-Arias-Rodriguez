import java.util.ArrayList;

public class Contratos {
    ArrayList<Contrato> ListaContratos=new ArrayList<>();
    public void AñadirContrato(Contrato NuevoContrato){
        ListaContratos.add(NuevoContrato);
       // System.out.println(ClienteLocalizado.NIF); no he podido crear un objeto clientes aqui ya que no usa el mismo objeto que en el main
        //y con este nuevo objeto tenemos el array
    }

    public double PrepararDinero(Contrato ContratoDinero) {
        double PrecioFinal = 0;
        if (ContratoDinero.TipoOperacion.equalsIgnoreCase("Venta")) {
            PrecioFinal=Math.abs(ContratoDinero.PrecioAcordado);
        }else if(ContratoDinero.TipoOperacion.equalsIgnoreCase("Compra")) {
            PrecioFinal=(-Math.abs(ContratoDinero.PrecioAcordado));
        }
        return PrecioFinal;
    }

    public void EnseñarContratos() {
        ListaContratos.forEach(Contrato -> System.out.print(Contrato+"\n"));
    }

    public void BuscarCliente(String NIF) {
        ArrayList<Contrato> ContratosCliente=new ArrayList<>();
        for (Contrato ContratoActual:ListaContratos) {
            if(ContratoActual.Cliente.NIF.equalsIgnoreCase(NIF)){
                ContratosCliente.add(ContratoActual);
            }
        }
        System.out.println("El cliente con el NIF: "+NIF);
        SacarSaldo(ContratosCliente);
    }

    private void SacarSaldo(ArrayList<Contrato> contratosCliente) {
        double num = 0;
        for (Contrato cliente:contratosCliente) {
            num+=PrepararDinero(cliente);
        }
        if(num<0){
            System.out.println("El cliente ha gastado "+Math.abs(num));
        }else {
            System.out.println("Hemos gastado "+Math.abs(num)+" en el cliente");
        }
    }
}
