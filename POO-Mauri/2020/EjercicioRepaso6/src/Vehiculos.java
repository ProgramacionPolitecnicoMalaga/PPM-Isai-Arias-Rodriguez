import java.util.ArrayList;
import java.util.Arrays;

public class Vehiculos {
    ArrayList<Vehiculo>ListaVehiculos=new ArrayList<>();
    public void AñadirVehiculo(Vehiculo NuevoVehiculo){
        ListaVehiculos.add(NuevoVehiculo);
    }
    public void EnseñarVehiculos(){
        ListaVehiculos.forEach(Vehiculo -> System.out.print(Vehiculo+"\n"));
    }
}
