package elp.proyecto_restaurante;

import java.time.LocalTime;
import javax.swing.JOptionPane;

public class Ordenes {

    private int decision_orden;

    public static void main(String[] args) {
        new Ordenes().iniciarOrdenes();
    }

    public void iniciarOrdenes() {
        String nombre;
        int numero_mesa;
        int id_orden = 200;
        int decision_orden;
        boolean mesa_valida;
        boolean orden = false;
        float iva = 0;
        float total = 0;
        boolean estado = false;// determina si la cuenta esta abierta o cerrada.
        Mesa mesa;

    }

    public void opciones_ordenes() {
        do {
            iniciarOrdenes();
            int decision_orden = Integer.parseInt(
                    JOptionPane.showInputDialog("""
                    Menu de ordenes
                    1-Abrir orden
                    2-Agregar platillo a la orden
                    3-Cerrar orden
                    4-salir
                      """));

            switch (decision_orden) {
                case 1:
                    orden = true;
                    estado = true;
                    LocalTime horaActual = LocalTime.now();
                    id_orden += 1;
                    nombre = JOptionPane.showInputDialog("Digite su nombre.");
                    numero_mesa = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de mesa."));
                    // ...
                    JOptionPane.showMessageDialog(null,
                            "\n| Id Orden #|"
                            + "\n| Cliente:|"
                            + "\n| Mesa:- si tiene vistas al mar"
                            + "\n| Mesero:"
                            + "\n| Hora:" + horaActual
                            + "\n| Estado: Abierta"
                            + "\n¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯"
                    );
                    break;
                case 2:
                    if (orden) {
                        //agregar plato a la orden
                    } else {
                        JOptionPane.showMessageDialog(null, "Abra una orden por favor.");
                    }
                    break;
                //cerrar orden
                case 3:
                    break;
                default:
                    break;
            }

        } while (decision_orden != 4);

    }
}
