
package elp.proyecto_restaurante;

import javax.swing.JOptionPane;


public class MenuRestaurante {
    
    static int numeroPlatillo = 300;
    static String[] platillos = new String[1000];
    static String[] descripciones = new String[1000];
    static double[] precios = new double[1000];
    static String[] tipos = new String[1000];
    static int cantidadPlatillos = 0;

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "[Menú]\n" +
                            "1- Mostrar menú.\n" +
                            "2- Agregar platillo.\n" +
                            "3- Editar platillo.\n" +
                            "4- Eliminar platillo.\n" +
                            "5- Salir.\n" +
                            "Selecciona una opción:"));

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
        String menu = 
                "-------- MENÚ --------\n" +
               "\nPescado al ajillo con papas"
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

        JOptionPane.showMessageDialog(null,
                "Platillo agregado correctamente:\n" +
                        "Nombre: " + nombre + "\n" +
                        "Descripción: " + descripcion + "\n" +
                        "Precio: $" + precio + "\n" +
                        "Tipo: " + tipo + "\n",
                "Platillo Agregado", JOptionPane.PLAIN_MESSAGE);
    }

    public static void editarPlatillo() {
       
    }

    public static void eliminarPlatillo() {
        
    }

    public static double obtenerPrecio() {
    
    double precio = -1;
    boolean precioValido = false;

    while (!precioValido) {
        String input = JOptionPane.showInputDialog("Precio del platillo:");
        if (input == null) { // Si el usuario cancela la entrada
            JOptionPane.showMessageDialog(null, "Entrada cancelada. Se volverá al menú.");
            System.exit(0); // Salir del programa
        }

        // Validar si la entrada es un número válido
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
        String tipoPlatillo = JOptionPane.showInputDialog("Selecciona el tipo de platillo:\n" +
                "1. SOPA\n" +
                "2. POSTRE\n" +
                "3. PLATILLO PRINCIPAL\n" +
                "4. BEBIDA");
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
    
    

