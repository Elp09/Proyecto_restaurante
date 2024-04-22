package elp.proyecto_restaurante;

import javax.swing.JOptionPane;

public class Opciones {

    public static void Inicio(Restaurante restaurante) {
        String botones_menu_inicial[] = {"Restaurante", "Ordenes", "Menu", "Reportes", "Salir"};
        int opcion_escogida = -1;
        while (opcion_escogida != 4) {
            opcion_escogida = JOptionPane.showOptionDialog(
                    null,
                    "Escoja la opcion deseada:",
                    "Menu de opciones",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    botones_menu_inicial, "Salir");

            switch (opcion_escogida) {
                case 0:
                    informacion_restaurante(restaurante);
                    break;
                case 1:
                    opciones_ordenes(restaurante);
                    break;
                case 2:
                    MenuRestaurante.incio();
                    break;
                case 3:
                    Reportes.mostrarMenu();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Gracias por usar");
                    opcion_escogida = 4;
            }
        }

    }

    public static void informacion_restaurante(Restaurante restaurante) {
        String numero_mesas = "";
        String cantidad_sillas = "";
        String estado_mesas = "";
        String meseros_mesas = "";
        String tipo_mesas = "";
        int tamano_strings = 25;
        for (int mesa = 0; mesa < restaurante.getMesas().length; mesa++) {

            numero_mesas += (("Mesa #" + restaurante.getMesas()[mesa].getNumero_mesa()
                    + "                       ").substring(0, tamano_strings) + "|");

            cantidad_sillas += (("Cantidad de sillas:" + restaurante.getMesas()[mesa].getCantidad_sillas()
                    + "                       ").substring(0, tamano_strings) + "|");
            String estado = "";
            if (restaurante.getMesas()[mesa].isEstado_uso()) {
                estado = "Ocupado";

            } else {
                estado = "Disponible";
            }
            estado_mesas += ((estado
                    + "                       ").substring(0, tamano_strings) + "|");
            meseros_mesas += (("Mesero: " + restaurante.getMesas()[mesa].getMesero().getNombre()
                    + "                         ").substring(0, tamano_strings) + "|");

            String tipo;
            if (restaurante.getMesas()[mesa].isTiene_vista()) {
                tipo = "Tiene vista al mar";
            } else {
                tipo = "No tiene vista al mar";
            }
            tipo_mesas += ((tipo
                    + "                       ").substring(0, tamano_strings) + "|");

        }
        System.out.println(numero_mesas);
        System.out.println(cantidad_sillas);
        System.out.println(estado_mesas);
        System.out.println(meseros_mesas);
        System.out.println(tipo_mesas);
    }

    public static void opciones_ordenes(Restaurante restaurante) {
        String nombre_cliente;
        int numero_mesa;
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
                    Restaurante.abrir_orden(restaurante);
                    break;
                case 2: //Agregar platillo 
                    Restaurante.agregar_platillo_orden(restaurante);
                    break;
                case 3: //cerrar orden
                    Restaurante.cerrar_ordenes(restaurante);
                    break;
                case 4:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Digte una opcion valida por favor.");
            }

        } while (opc != 4);
    }

}
