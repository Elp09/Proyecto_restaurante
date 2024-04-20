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

    public static void opciones_ordenes() {
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

                    id_orden += 1;
                    orden.setId_orden(id_orden);
                    iva = 0;
                    Estado status = Estado.Abierta;
                    String nombre = JOptionPane.showInputDialog("Digite su nombre.");
                    orden.setNombre(nombre);
                    numero_mesa = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de mesa"));
                    if (numero_mesa == 6) {
                        JOptionPane.showMessageDialog(null, "El numero de mesa " + numero_mesa + " es valido");
                        System.out.println("|Orden #" + orden.getId_orden() + "|");
                        System.out.println("|Cliente " + orden.nombre + "|");
                        System.out.println("|Mesa:" + "|");
                        System.out.println("|Mesero |");
                        System.out.println("|Hora: " + orden.HoraActual + "|");
                        System.out.println("|Estado " + Estado.Abierta + "|");
                        System.out.println("-------------------");
                    } else {
                        botones();
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

    public static void botones() {
        Ordeness orden = new Ordeness();
        boolean found = false;
        int numBoton = mostrarBotones("Que desea hacer?", "Mesa no valida", JOptionPane.QUESTION_MESSAGE,
                new String[]{"Digitar otro numero", "Cancelar orden"});
        if (numBoton == 0) {
            int numMesa = Integer.parseInt(JOptionPane.showInputDialog("Digite nuevamente el numero de mesa."));
            while (found = false) {
                System.out.println("Digite nuevamente su numero");
                if (numMesa == Restaurante.randint(1, 12)) {
                    found = true;
                }

            }
            System.out.println("|Orden #" + orden.getId_orden() + "|");
            System.out.println("|Cliente " + orden.nombre + "|");
            System.out.println("|Mesa:" + "|");
            System.out.println("|Mesero |");
            System.out.println("|Hora: " + orden.HoraActual + "|");
            System.out.println("|Estado " + Estado.Abierta + "|");
            System.out.println("-------------------");

        } else {
            JOptionPane.showMessageDialog(null, "Su orden fue cancelada correctamente.");
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

    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
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
