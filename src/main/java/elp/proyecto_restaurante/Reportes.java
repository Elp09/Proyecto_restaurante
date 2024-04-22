package elp.proyecto_restaurante;

import javax.swing.JOptionPane;

public class Reportes {
    
    static int numeroPlatillo = 299;
    static Platillo[] platillos = new Platillo[1000];
    static int[] ventasPlatillos = new int[1000]; // Arreglo para contar las ventas de cada platillo
    static int cantidadPlatillos = 0;

    // Método para mostrar el menú de reportes
    public static void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "[Reportes]\n"
                    + "1- Platillos más vendidos.\n"
                    + "2- Mejor mesero en ventas.\n"
                    + "3- Mejor mesero en rating.\n"
                    + "4- Datos de los meseros.\n"
                    + "5- Datos de las órdenes.\n"
                    + "6- Ventas totales.\n"
                    + "7- Ventas por tipo de platillo.\n"
                    + "8- Ventas por tipo de mesa.\n"
                    + "9- Salir.\n"
                    + "Selecciona una opción:"));

            switch (opcion) {
                case 1:
                    mostrarPlatilloMasVendido();
                    break;
                case 2:
                    mejor_mesero_rating(restaurante);
                    break;
                case 3:
                    mostrarMejorMeseroEnRating();
                    break;
                case 4:
                    mostrarDatosMeseros();
                    break;
                case 5:
                    mostrarDatosOrdenes();
                    break;
                case 6:
                    mostrarVentasTotales();
                    break;
                case 7:
                    mostrarVentasPorTipoPlatillo();
                    break;
                case 8:
                    mostrarVentasPorTipoMesa();
                    break;
                case 9:
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida, por favor selecciona una opción del 1 al 9.");
                    break;
            }
        }
    }

    public static void mostrarPlatilloMasVendido() {
        int maxVentas = 0;
        int indiceMaxVentas = -1;

        for (int i = 0; i < cantidadPlatillos; i++) {
            if (ventasPlatillos[i] > maxVentas) {
                maxVentas = ventasPlatillos[i];
                indiceMaxVentas = i;
            }
        }

        if (indiceMaxVentas != -1) {
            Platillo platilloMasVendido = platillos[indiceMaxVentas];
            String mensaje = "Platillo más vendido:\n\n";
            mensaje += "Nombre: " + platilloMasVendido.getNombre() + "\n";
            mensaje += "Descripción: " + platilloMasVendido.getDescripcion() + "\n";
            mensaje += "Precio: $" + platilloMasVendido.getPrecio() + "\n";
            mensaje += "Ventas: " + maxVentas + "\n";

            JOptionPane.showMessageDialog(null, mensaje, "Platillo Más Vendido", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay platillos registrados.", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void mostrarMejorMeseroEnVentas() {

    }

    public static void mostrarMejorMeseroEnRating() {
        // Implementación del reporte
    }

    public static void mostrarDatosMeseros() {
        Mesero[] meseros = new Mesero[10]; // Por ejemplo, aquí se crea un arreglo de 10 meseros

        // Llenar el arreglo con meseros
        for (int i = 0; i < meseros.length; i++) {
            meseros[i] = new Mesero(i + 1); // Se crea un mesero con ID único
        }

        // Mostrar los datos de los meseros en la consola
        System.out.println("Datos de los meseros:");
        for (Mesero mesero : meseros) {
            System.out.println("ID: " + mesero.getId());
            System.out.println("Nombre: " + mesero.getNombre());
            System.out.println("Turno: " + mesero.getTurno());
            System.out.println("Propinas: $" + mesero.getPropinas());
            System.out.println("Rating: " + mesero.getRating());
            System.out.println();
        }
    }

    public static void mostrarDatosOrdenes() {

        Restaurante restaurante = new Restaurante();

        Orden[] ordenes = restaurante.getOrdenes();

        System.out.println("Datos de las órdenes:");
        for (Orden orden : ordenes) {
            System.out.println("ID de orden: " + orden.getId_orden());
            System.out.println("Nombre del cliente: " + orden.getNombre_cliente());
            System.out.println("Número de mesa: " + orden.getNumero_mesa());
            System.out.println("Mesero asignado: " + orden.getMesero().getNombre());
            System.out.println("Hora de la orden: " + orden.getHora_orden());
            System.out.println("IVA aplicado: " + orden.getIVA());
            System.out.println("Total de la orden: " + orden.getTotal());
            System.out.println("Estado de la orden: " + (orden.isEstado() ? "Abierta" : "Cerrada"));
            System.out.println("Platillos:");
            for (Platillo platillo : orden.getPlatillos()) {
                if (platillo != null) {
                    System.out.println("- Nombre: " + platillo.getNombre());
                    System.out.println("  Precio: " + platillo.getPrecio());

                }
            }
        }
    }

    public static void mostrarVentasTotales() {
        // Implementación del reporte
    }

    public static void mostrarVentasPorTipoPlatillo() {
        // Implementación del reporte
    }

    public static void mostrarVentasPorTipoMesa() {
        // Implementación del reporte
    }
    public static void mejor_mesero_rating(Restaurante restaurante){
        double mejor_rating = 0;
        Mesero best_mes;
        for(int i = 0; i < restaurante.getMeseros().length; i++){
            if (restaurante.getMeseros()[i].getRating() > mejor_rating){
                mejor_rating = restaurante.getMeseros()[i].getRating();
                best_mes = restaurante.getMeseros()[i];
            }
        }
        String textomejor = "";
        textomejor += "Nombre: " + best_mes.getNombre() + "\n";
        textomejor += "Rating: " + best_mes.getRating() + "\n";
        textomejor += "Id: " + best_mes.getId()+ "\n";
        textomejor += "propinas: " + best_mes.getPropinas()+ "\n";
        JOptionPane.showMessageDialog(null, textomejor);
    }
    
    
    String reportes_Platillo = "";
    String reportes_Mesero = "";
    String reportes_DatosMesero = "";
    String reportes_DatosOrdenes = "";
    int reportes_VentasTotales = 0;
    int reporte_VentasPlatillo = 0;
    int reportes_VentasMesa = 0;
    
    

}
