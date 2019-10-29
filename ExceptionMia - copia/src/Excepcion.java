public class Excepcion extends  Exception {
    public Excepcion(String Advertencia){
      super(Advertencia);
    }
    public String Aviso(){
        String aviso="No puedes meter más";
        return aviso;
    }

}
