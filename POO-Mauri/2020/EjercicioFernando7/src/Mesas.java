import java.util.ArrayList;

public class Mesas {
    Mesas(){

    }
    ArrayList<Mesa>ListaMesas=new ArrayList<>();
    public void MirarMesasLibres(){
        ArrayList<Mesa> ListasMesasLibres=new ArrayList<>();
        for(Mesa MesaActual: ListaMesas){
            if(MesaActual.Estado){
                System.out.println(MesaActual);
            }

        }
    }
    public void MirarMesasOcupadas(){
        ArrayList<Mesa> ListasMesasLibres=new ArrayList<>();
        for(Mesa MesaActual: ListaMesas){
            if(!MesaActual.Estado){
                System.out.println(MesaActual);
            }

        }
    }

}
