<<<<<<< HEAD
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
                    Ordeness.opciones_ordenes(restaurante);
                    break;
                case 2:
                    MenuRestaurante.Iniciar_menu_restaurante();
                    break;
                case 3:
                    //menu_reportes();
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

}
=======
package elp.proyecto_restaurante;

import javax.swing.JOptionPane;
import elp.proyecto_restaurante.MenuRestaurante;


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
                    Ordeness.opciones_ordenes(restaurante);
                    break;
                case 2:
                    MenuRestaurante.main(null);
                    break;
                case 3:
                    //menu_reportes();
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

}
>>>>>>> 1ec619019b3e334bbc0f3fcdfaaecd9234505749
