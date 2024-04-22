package elp.proyecto_restaurante;

import java.time.LocalTime;

public class Orden {

    private static int contadorOrdenes = 199;

    private int id_orden;
    private String nombre_cliente;
    private int numero_mesa;
    private Mesero mesero;
    private LocalTime hora_orden;
    private double IVA;
    private double total;
    private boolean estado;
    private Platillo[] platillos;

    public Orden(String nombre_cliente, Mesa mesa) {
        this.id_orden = contadorOrdenes++;
        this.nombre_cliente = nombre_cliente;
        this.numero_mesa = mesa.getNumero_mesa();
        this.mesero = mesa.getMesero();
        this.hora_orden = LocalTime.now(); // Se obtiene la hora actual del sistema
        this.IVA = 0;
        this.total = 0;
        this.estado = true; // La orden se inicializa como abierta
        this.platillos = new Platillo[mesa.getCantidad_sillas() * 3]; // Se inicializa el arreglo de platillos vacío
    }
}
