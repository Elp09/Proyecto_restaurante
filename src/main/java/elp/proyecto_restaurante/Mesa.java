
package elp.proyecto_restaurante;

public class Mesa {
    //Att
    int numero_mesa;
    int cantidad_sillas;
    boolean estado_uso; //un boolean que empieza en false por default, esto significa que la mesa esta desocupada
    boolean tiene_vista;
    Mesero mesero;

    public Mesa(int numero_mesa, boolean tiene_vista) {
        this.numero_mesa = numero_mesa;
        this.estado_uso = false;
        this.tiene_vista = tiene_vista;
        this.cantidad_sillas = Restaurante.randint(2, 6);
    }

    public void setNumero_mesa(int numero_mesa) {
        this.numero_mesa = numero_mesa;
    }

    public void setCantidad_sillas(int cantidad_sillas) {
        this.cantidad_sillas = cantidad_sillas;
    }

    public void setEstado_uso(boolean estado_uso) {
        this.estado_uso = estado_uso;
    }

    public void setTiene_vista(boolean tiene_vista) {
        this.tiene_vista = tiene_vista;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }
    
    
    
}
