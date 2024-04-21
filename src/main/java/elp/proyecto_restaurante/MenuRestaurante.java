
package elp.proyecto_restaurante;

import javax.swing.JOptionPane;


public class MenuRestaurante {
 
    static int numeroPlatillo = 299;
    static Platillo[] platillos = new Platillo[1000];
    static int cantidadPlatillos = 0;

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "[Menú]\n"
                    + "1- Mostrar menú.\n"
                    + "2- Agregar platillo.\n"
                    + "3- Editar platillo.\n"
                    + "4- Eliminar platillo.\n"
                    + "5- Salir.\n"
                    + "Selecciona una opción:"));

            switch (opcion) {
                case 1:
                    mostrarMenu();
                    break;
                case 2:
                    agregarPlatillo();
                    break;
                case 3:
                    editarPlatillo();
                    break;
                case 4:
                    eliminarPlatillo();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida, por favor selecciona una opción del 1 al 5.");
                    break;
            }
        }
    }

    public static void mostrarMenu() {
        String menu = "-------- MENÚ --------\n";

        for (int i = 0; i < cantidadPlatillos; i++) {
            Platillo platillo = platillos[i];
            menu += "Número del platillo #" + (numeroPlatillo + i) + "\n";
            menu += "Nombre: " + platillo.getNombre() + "\n";
            menu += "Descripción: " + platillo.getDescripcion() + "\n";
            menu += "Precio: $" + platillo.getPrecio() + "\n";
            menu += "Tipo: " + platillo.getTipo() + "\n\n";
        }

        JOptionPane.showMessageDialog(null, menu, "Menú del Restaurante", JOptionPane.PLAIN_MESSAGE);
    }

    public static void agregarPlatillo() {
        String nombre = JOptionPane.showInputDialog("Nombre del platillo:");
        String descripcion = JOptionPane.showInputDialog("Descripción del platillo:");
        double precio = obtenerPrecio();
        TipoPlatillo tipo = obtenerTipoPlatillo();

        Platillo platillo = new Platillo(nombre, descripcion, precio, tipo);
        platillos[cantidadPlatillos] = platillo;
        cantidadPlatillos++;
        numeroPlatillo++;

        double precioConIVA = precio + (precio * 0.13);
        String precioConIVA001 = String.format("%.2f", precioConIVA);

        JOptionPane.showMessageDialog(null,
                "Platillo agregado correctamente:\n"
                + "Número del platillo #" + (numeroPlatillo) + "\n"
                + "Nombre: " + nombre + "\n"
                + "Descripción: " + descripcion + "\n"
                + "Precio: $" + precio + "\n"
                + "Precio (con IVA 13%): $" + precioConIVA001 + "\n"
                + "Tipo: " + tipo + "\n",
                "Platillo Agregado", JOptionPane.PLAIN_MESSAGE);
    }

    public static void editarPlatillo() {
        int numeroPlatilloEditar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número del platillo que desea editar:"));

        boolean platilloEncontrado = false;
        int indicePlatillo = -1;
        for (int i = 0; i < cantidadPlatillos; i++) {
            if (numeroPlatilloEditar == (numeroPlatillo + i)) {
                platilloEncontrado = true;
                indicePlatillo = i;
                break;
            }
        }

        if (platilloEncontrado) {
            mostrarPantallaActualizar(indicePlatillo);
        } else {
            JOptionPane.showMessageDialog(null, "El platillo con el número: " + numeroPlatilloEditar + " no se encuentra registrado en el sistema.");
        }
    }

    public static void mostrarPantallaActualizar(int indicePlatillo) {
        // Implementación de la función mostrarPantallaActualizar
    }

    public static void eliminarPlatillo() {
        int numeroPlatilloEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número del platillo que desea eliminar:"));

        boolean platilloEncontrado = false;
        int indicePlatillo = -1;
        for (int i = 0; i < cantidadPlatillos; i++) {
            if (numeroPlatilloEliminar == (numeroPlatillo + i)) {
                platilloEncontrado = true;
                indicePlatillo = i;
                break;
            }
        }

        if (platilloEncontrado) {
            int opcionEliminar = JOptionPane.showConfirmDialog(null,
                    "¿Desea eliminar el platillo?\n\n"
                    + "Número del platillo: " + (numeroPlatillo + indicePlatillo) + "\n"
                    + "Nombre: " + platillos[indicePlatillo].getNombre() + "\n"
                    + "Descripción: " + platillos[indicePlatillo].getDescripcion() + "\n"
                    + "Precio: $" + platillos[indicePlatillo].getPrecio() + "\n"
                    + "Tipo: " + platillos[indicePlatillo].getTipo() + "\n",
                    "Eliminar Platillo", JOptionPane.YES_NO_OPTION);

            if (opcionEliminar == JOptionPane.YES_OPTION) {
                eliminarPlatilloSistema(indicePlatillo);
                JOptionPane.showMessageDialog(null, "El platillo se ha eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            int opcion = JOptionPane.showConfirmDialog(null,
                    "El platillo con el número: " + numeroPlatilloEliminar + " no se encuentra registrado en el sistema.\n\n"
                    + "¿Desea ingresar otro número?",
                    "Platillo no encontrado", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                eliminarPlatillo();
            }
        }
    }

    public static void eliminarPlatilloSistema(int indicePlatillo) {
        for (int i = indicePlatillo; i < cantidadPlatillos - 1; i++) {
            platillos[i] = platillos[i + 1];
        }
        cantidadPlatillos--;
    }

    public static double obtenerPrecio() {
        double precio = -1;
        boolean precioValido = false;

        while (!precioValido) {
            String input = JOptionPane.showInputDialog("Precio del platillo:");
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Entrada cancelada. Se volverá al menú.");
                System.exit(0);
            }

            boolean esNumero = true;
            for (int i = 0; i < input.length(); i++) {
                if (!Character.isDigit(input.charAt(i)) && input.charAt(i) != '.') {
                    esNumero = false;
                    break;
                }
            }

            if (esNumero) {
                precio = Double.parseDouble(input);
                if (precio < 0) {
                    JOptionPane.showMessageDialog(null, "Precio inválido. Por favor ingresa un precio mayor o igual a 0.");
                } else {
                    precioValido = true;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor ingresa un número válido para el precio.");
            }
        }
        return precio;
    }

    public static TipoPlatillo obtenerTipoPlatillo() {
        String tipoPlatilloStr = JOptionPane.showInputDialog("Selecciona el tipo de platillo:\n"
                + "1. SOPA\n"
                + "2. POSTRE\n"
                + "3. PLATILLO PRINCIPAL\n"
                + "4. BEBIDA");
        int opcion = Integer.parseInt(tipoPlatilloStr);

        switch (opcion) {
            case 1:
                return TipoPlatillo.SOPA;
            case 2:
                return TipoPlatillo.POSTRE;
            case 3:
                return TipoPlatillo.PLATILLO_PRINCIPAL;
            case 4:
                return TipoPlatillo.BEBIDA;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida. Por favor selecciona una opción del 1 al 4.");
                return obtenerTipoPlatillo();
        }
    }
}