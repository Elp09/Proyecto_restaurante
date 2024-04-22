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

    public static void setContadorOrdenes(int contadorOrdenes) {
        Orden.contadorOrdenes = contadorOrdenes;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public void setNumero_mesa(int numero_mesa) {
        this.numero_mesa = numero_mesa;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }

    public void setHora_orden(LocalTime hora_orden) {
        this.hora_orden = hora_orden;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setPlatillos(Platillo[] platillos) {
        this.platillos = platillos;
    }

    

    public int getId_orden() {
        return id_orden;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public int getNumero_mesa() {
        return numero_mesa;
    }

    public Mesero getMesero() {
        return mesero;
    }

    public LocalTime getHora_orden() {
        return hora_orden;
    }

    public double getIVA() {
        return IVA;
    }

    public double getTotal() {
        return total;
    }

    public boolean isEstado() {
        return estado;
    }

    public Platillo[] getPlatillos() {
        return platillos;
    }
    
    
    
}
