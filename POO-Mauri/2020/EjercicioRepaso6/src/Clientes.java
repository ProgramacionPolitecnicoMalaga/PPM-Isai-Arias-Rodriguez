import java.util.ArrayList;

public class Clientes {
    ArrayList<Cliente>ListaClientes=new ArrayList<>();
    public void AñadirClientes(Cliente NuevoCliente){
        ListaClientes.add(NuevoCliente);
    }
    public void EnseñarClientes(){
        ListaClientes.forEach(Vehiculo -> System.out.print(Vehiculo+"\n"));
    }

    public Cliente LocalizarCliente(String nif) {
        Cliente ClienteLocalizado = null;
        for (Cliente ClientesL: ListaClientes) {
            if (ClientesL.NIF.equalsIgnoreCase(nif)) {
                System.out.println(nif + " +" + ClientesL.NIF);
                ClienteLocalizado=ClientesL;
            } else if(ClientesL==null) {
                System.out.println("no encontrado");
            }
        }

        return ClienteLocalizado;
    }
    public void ModificarSaldoCliente(Cliente clienteEnTransacion, double precioAcordado) {
        for (Cliente ClienteEnBusqueda:ListaClientes) {
            if(ClienteEnBusqueda.NIF.equalsIgnoreCase(clienteEnTransacion.NIF)){
               ClienteEnBusqueda.CuentaBancaria= ClienteEnBusqueda.CuentaBancaria+precioAcordado;
            }
        }
    }
}
