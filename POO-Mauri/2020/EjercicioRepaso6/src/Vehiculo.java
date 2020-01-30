public class Vehiculo {
    String Modelo,Marca,Color,AñoFab,combustion,estado;
    double Precio;

    public Vehiculo(String modelo, String marca, String color, String añoFab, String combustion, String estado, double precio) {
        Modelo = modelo;
        Marca = marca;
        Color = color;
        AñoFab = añoFab;
        this.combustion = combustion;
        this.estado = estado;
        Precio = precio;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getAñoFab() {
        return AñoFab;
    }

    public void setAñoFab(String añoFab) {
        AñoFab = añoFab;
    }

    public String getCombustion() {
        return combustion;
    }

    public void setCombustion(String combustion) {
        this.combustion = combustion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "Modelo='" + Modelo + '\'' +
                ", Marca='" + Marca + '\'' +
                ", Color='" + Color + '\'' +
                ", AñoFab='" + AñoFab + '\'' +
                ", combustion='" + combustion + '\'' +
                ", estado='" + estado + '\'' +
                ", Precio=" + Precio +
                '}';
    }
}
