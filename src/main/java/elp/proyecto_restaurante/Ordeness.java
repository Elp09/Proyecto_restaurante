package elp.proyecto_restaurante;

import java.time.LocalTime;
import javax.swing.JOptionPane;

public class Ordeness {

    private int id_orden;
    private int numero_mesa;
    private double iva;
    private LocalTime HoraActual = LocalTime.now();
    private double total;
    private String nombre;

    public static void opciones_ordenes(Restaurante restaurante) {
        Ordeness orden = new Ordeness();
        int id_orden = 200;
        int numero_mesa = 1;
        double iva;
        LocalTime HoraActual = LocalTime.now();
        Estado estado;
        double total;
        int opc;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog("""
                                                               Ordenes
                                                               1-Abrir orden
                                                               2-Agregar platillo a la orden
                                                               3-Cerrar orden
                                                               4-Salir"""));

            switch (opc) {
                case 1:
                    iva = 0;
                    orden.setNombre(JOptionPane.showInputDialog("Digite su nombre."));

                    numero_mesa = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de mesa"));

                    if (es_mesa_valida(restaurante, numero_mesa)) {
                        orden.incrementarIdOrden();
                        JOptionPane.showMessageDialog(null, "El numero de mesa " + numero_mesa + " es valido");
                        System.out.println("|Orden #" + orden.getIdOrden() + "|");
                        System.out.println("|Cliente: " + orden.nombre + "|");
                        if (mesaTieneVista(restaurante, numero_mesa)) {
                            System.out.println("|Mesa: " + numero_mesa + "- Tiene vista al mar|");
                        } else {
                            System.out.println("|Mesa: " + numero_mesa + "- No Tiene vista al mar|");
                        }
                        System.out.println("|Mesero |");
                        System.out.println("|Hora: " + orden.HoraActual + "|");
                        System.out.println("|Estado " + Estado.Abierta + "|");
                        System.out.println("-------------------");

                    } else {
                        botones(restaurante, numero_mesa);
                    }

                    break;
                case 2: //Agregar platillo 

                    break;
                case 3: //cerrar orden

                    break;
                case 4:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Digte una opcion valida por favor.");
            }

        } while (opc != 4);
    }

    public static boolean mesaTieneVista(Restaurante restaurante, int numeroMesa) {
        int[] mesasConVista = restaurante.mesa_con_vista();
        for (int i = 0; i < mesasConVista.length; i++) {
            if (mesasConVista[i] == numeroMesa) {
                return true; 
            }
        }
        return false; 
    }

    public static boolean es_mesa_valida(Restaurante restaurante, int numero_mesa) {
        for (int i = 0; i < restaurante.getMesas().length; i++) {
            if (restaurante.getMesas()[i].getNumero_mesa() == numero_mesa) {
                return true;
            }
        }
        return false;
    }

    public static void botones(Restaurante restaurante, int numero_mesa) {
        Ordeness orden01 = new Ordeness();
        boolean found = false;
        int numBoton = mostrarBotones("Que desea hacer?", "Mesa no valida", JOptionPane.QUESTION_MESSAGE,
                new String[]{"Digitar otro numero", "Cancelar orden"});
        if (numBoton == 0) {
            while (!found) {
                int numMesa = Integer.parseInt(JOptionPane.showInputDialog("Digite nuevamente el numero de mesa."));
                for (int i = 0; i < restaurante.getMesas().length; i++) {
                    if (restaurante.getMesas()[i].getNumero_mesa() == numMesa) {
                        found = true;
                        break;
                    }
                }
                if (found == true) {
                    orden01.incrementarIdOrden();
                    orden01.nombre = JOptionPane.showInputDialog("Digite de nuevo su nombre por favor");
                    JOptionPane.showMessageDialog(null, "El numero de mesa " + numMesa + " es valido");
                    System.out.println("|Orden #" + orden01.getIdOrden() + "|");
                    System.out.println("|Cliente " + orden01.getNombre() + "|");
                    if (mesaTieneVista(restaurante, numero_mesa)) {
                        System.out.println("|Mesa: " + numero_mesa + "- Tiene vista|");
                    } else {
                        System.out.println("|Mesa: " + numero_mesa + "- No Tiene vista|");
                    }
                    System.out.println("|Mesero |");
                    System.out.println("|Hora: " + orden01.HoraActual + "|");
                    System.out.println("|Estado " + Estado.Abierta + "|");
                    System.out.println("-------------------");

                } else {
                    System.out.println("Orden cancelada correctamente.");

                }
            }
        }
    }

    public static int mostrarBotones(
            String mensaje,
            String titulo,
            int img,
            String botones[]) {
        return JOptionPane.showOptionDialog(
                null,
                mensaje,
                titulo,
                JOptionPane.DEFAULT_OPTION,
                img,
                null,
                botones,
                botones[0]);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public enum Estado {
        Abierta,
        Cerrada;
    }

    public Ordeness() {
        this.id_orden = 200;
    }

    // Método para incrementar el número de orden
    public void incrementarIdOrden() {
        this.id_orden++;
    }

    // Método para obtener el número de orden actual
    public int getIdOrden() {
        return this.id_orden;
    }

    public int getNumero_mesa() {
        return numero_mesa;
    }

    public void setNumero_mesa(int numero_mesa) {
        this.numero_mesa = numero_mesa;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public LocalTime getHoraActual() {
        return LocalTime.now();
    }

    public void setHoraActual(LocalTime HoraActual) {
        this.HoraActual = HoraActual;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
