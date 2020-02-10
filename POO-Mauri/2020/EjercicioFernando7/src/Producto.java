public class Producto {
    double precio;
    String nombre;
    int id;

    public Producto(double precio, int id, String nombre) {
        this.precio = precio;
        this.id = id;
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "precio=" + precio +
                ", id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
