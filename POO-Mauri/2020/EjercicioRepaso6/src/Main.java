public class Main {
    // miramos por el cliente por lo que las ventas se suman al saldo y las compras resta
    public static void main(String[] args) {
        //------------------------------------
        System.out.println("1");
        Vehiculos NuevoVehiculo=new Vehiculos();
        Vehiculo UNTRICLICO=new Vehiculo("El 3 tres ruedas","TriRovert","Inferno","1997","PiernasTOFuertes","Le falta una rueda",150);
        Vehiculo Yate=new Vehiculo("Franves","Goisses Juste Rose","Verde","1965","Aquaman","Viejo",25000);
        NuevoVehiculo.AñadirVehiculo(UNTRICLICO);
        NuevoVehiculo.AñadirVehiculo(Yate);
        NuevoVehiculo.EnseñarVehiculos();
        //-------------------------------------
        System.out.println("2");
        Clientes NuevoCliente=new Clientes();
        Cliente Yo=new Cliente("El Isas","Rodriguez Rodriguez","Ojala",150000);
        Cliente Todos=new Cliente("Comunidad","Todos Todos","Infinito",0);
        NuevoCliente.AñadirClientes(Yo);
        NuevoCliente.AñadirClientes(Todos);
        NuevoCliente.EnseñarClientes();
        //-------------------------------------
        System.out.println("3");
        Contratos NuevoContrato=new Contratos();
        Contrato EldeLaBici=new Contrato(Yo,UNTRICLICO,"Compra",50);
        NuevoContrato.AñadirContrato(EldeLaBici);
        Cliente ClienteLocalizado=NuevoCliente.LocalizarCliente(EldeLaBici.Cliente.NIF);
        System.out.println(ClienteLocalizado.toString());
        double PrecioListo=NuevoContrato.PrepararDinero(EldeLaBici);
       NuevoCliente.ModificarSaldoCliente(ClienteLocalizado,PrecioListo);
        NuevoContrato.EnseñarContratos();
        NuevoCliente.EnseñarClientes();
        //------------------------------------------
        System.out.println("4");
        Contrato ElDelYate=new Contrato(Todos,Yate,"Venta",50000);
        NuevoContrato.AñadirContrato(ElDelYate);
        ClienteLocalizado=NuevoCliente.LocalizarCliente(ElDelYate.Cliente.NIF);
        PrecioListo=NuevoContrato.PrepararDinero(ElDelYate);
        NuevoCliente.ModificarSaldoCliente(ClienteLocalizado,PrecioListo);
        NuevoContrato.EnseñarContratos();
        NuevoCliente.EnseñarClientes();
        //------------------------------------
        System.out.println("5");
        NuevoContrato.BuscarCliente(Todos.NIF);
    }
}
