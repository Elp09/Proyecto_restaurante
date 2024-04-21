
package elp.proyecto_restaurante;

import javax.swing.JOptionPane;


public class MenuRestaurante {
    
    static int numeroPlatillo = 299; 
    static String[] platillos = new String[1000];
    static String[] descripciones = new String[1000];
    static double[] precios = new double[1000];
    static String[] tipos = new String[1000];
    static int cantidadPlatillos = 0;

    public static void Iniciar_menu_restaurante() {
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
        String menu
                = "-------- MENÚ --------\n"
                + "\nPescado al ajillo con papas"
                + "\nBurger de pescado empanizado con aros de cebolla"
                + "\nArroz con mariscos";
        for (int i = 0; i < cantidadPlatillos; i++) {
            menu += "Número del platillo #" + (numeroPlatillo + i) + "\n";
            menu += "Nombre: " + platillos[i] + "\n";
            menu += "Descripción: " + descripciones[i] + "\n";
            menu += "Precio: $" + precios[i] + "\n";
            menu += "Tipo: " + tipos[i] + "\n\n";
        }
        JOptionPane.showMessageDialog(null, menu, "Menú del Restaurante", JOptionPane.PLAIN_MESSAGE);
    }

    public static void agregarPlatillo() {
        String nombre = JOptionPane.showInputDialog("Nombre del platillo:");
        String descripcion = JOptionPane.showInputDialog("Descripción del platillo:");
        double precio = obtenerPrecio();
        String tipo = obtenerTipoPlatillo();

        platillos[cantidadPlatillos] = nombre;
        descripciones[cantidadPlatillos] = descripcion;
        precios[cantidadPlatillos] = precio;
        tipos[cantidadPlatillos] = tipo;
        cantidadPlatillos++;
        numeroPlatillo++;

        double precioConIVA = precio + (precio * 0.13);
        String precioConIVA001 = String.format("%.2f", precioConIVA);

        JOptionPane.showMessageDialog(null,
                "Platillo agregado correctamente:\n"
                + "Número del platillo #" + (numeroPlatillo) + "\n" // Se corrigió la muestra del número de platillo
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
        // Obtener los datos del platillo
        String nombrePlatillo = platillos[indicePlatillo];
        String descripcionPlatillo = descripciones[indicePlatillo];
        double precioPlatillo = precios[indicePlatillo];
        String tipoPlatillo = tipos[indicePlatillo];

        int opcion = -1;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "-------- Actualizar Platillo --------\n\n"
                    + "Número del platillo: " + (numeroPlatillo + indicePlatillo) + "\n"
                    + "1. Nombre: " + nombrePlatillo + "\n"
                    + "2. Descripción: " + descripcionPlatillo + "\n"
                    + "3. Precio: $" + precioPlatillo + "\n"
                    + "4. Tipo: " + tipoPlatillo + "\n"
                    + "5. Atrás\n"
                    + "Seleccione el dato que desea actualizar (1-5):"));

            switch (opcion) {
                case 1:

                    String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del platillo:");
                    platillos[indicePlatillo] = nuevoNombre;
                    JOptionPane.showMessageDialog(null, "Nombre actualizado correctamente.");
                    break;
                case 2:

                    String nuevaDescripcion = JOptionPane.showInputDialog("Ingrese la nueva descripción del platillo:");
                    descripciones[indicePlatillo] = nuevaDescripcion;
                    JOptionPane.showMessageDialog(null, "Descripción actualizada correctamente.");
                    break;
                case 3:

                    double nuevoPrecio = obtenerPrecio();
                    precios[indicePlatillo] = nuevoPrecio;
                    JOptionPane.showMessageDialog(null, "Precio actualizado correctamente.");
                    break;
                case 4:

                    String nuevoTipo = obtenerTipoPlatillo();
                    tipos[indicePlatillo] = nuevoTipo;
                    JOptionPane.showMessageDialog(null, "Tipo actualizado correctamente.");
                    break;
                case 5:

                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor seleccione una opción del 1 al 5.");
                    break;
            }
        } while (opcion != 5);
    }

    public static void mostrarDetallesPlatillo(int indicePlatillo) {
        String nombrePlatillo = platillos[indicePlatillo];
        String descripcionPlatillo = descripciones[indicePlatillo];
        double precioPlatillo = precios[indicePlatillo];
        String tipoPlatillo = tipos[indicePlatillo];

        JOptionPane.showMessageDialog(null, "Detalles del platillo:\n"
                + "Número: " + (numeroPlatillo + indicePlatillo) + "\n"
                + "Nombre: " + nombrePlatillo + "\n"
                + "Descripción: " + descripcionPlatillo + "\n"
                + "Precio: $" + precioPlatillo + "\n"
                + "Tipo: " + tipoPlatillo);
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
                    + "Nombre: " + platillos[indicePlatillo] + "\n"
                    + "Descripción: " + descripciones[indicePlatillo] + "\n"
                    + "Precio: $" + precios[indicePlatillo] + "\n"
                    + "Tipo: " + tipos[indicePlatillo] + "\n",
                    "Eliminar Platillo", JOptionPane.YES_NO_OPTION);

            if (opcionEliminar == JOptionPane.YES_OPTION) {

                boolean platilloUtilizado = false;

                if (platilloUtilizado) {

                    JOptionPane.showMessageDialog(null, "El platillo no se puede eliminar porque ha sido utilizado en una orden.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                    eliminarPlatilloSistema(indicePlatillo);

                    JOptionPane.showMessageDialog(null, "El platillo se ha eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }
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
            descripciones[i] = descripciones[i + 1];
            precios[i] = precios[i + 1];
            tipos[i] = tipos[i + 1];
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

    public static String obtenerTipoPlatillo() {
        String tipoPlatillo = JOptionPane.showInputDialog("Selecciona el tipo de platillo:\n"
                + "1. SOPA\n"
                + "2. POSTRE\n"
                + "3. PLATILLO PRINCIPAL\n"
                + "4. BEBIDA");
        switch (tipoPlatillo) {
            case "1":
                return "SOPA";
            case "2":
                return "POSTRE";
            case "3":
                return "PLATILLO PRINCIPAL";
            case "4":
                return "BEBIDA";
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida. Por favor selecciona una opción del 1 al 4.");
                return obtenerTipoPlatillo();
        }
    }
}