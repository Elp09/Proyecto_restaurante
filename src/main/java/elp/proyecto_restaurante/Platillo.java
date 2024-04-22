
package elp.proyecto_restaurante;


public class Platillo {
    
    private String nombre;
    private String descripcion;
    private double precio;
    private TipoPlatillo tipo;
    private int numero_platillo;
    

    

    public Platillo(String nombre, String descripcion, double precio, TipoPlatillo tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
    }
    public int getNumero_platillo() {
        return numero_platillo;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public TipoPlatillo getTipo() {
        return tipo;
    }

    public void setTipo(TipoPlatillo tipo) {
        this.tipo = tipo;
    }
}
 
