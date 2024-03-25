// Autores: Elias Leblicq
//          xx
//          xx
// prueba

package elp.proyecto_restaurante;


public class Proyecto_restaurante {

    public static void main(String[] args) {
        
        //Se crea e inicializa el restaurante con su informacion generada
        //aleatoriamente
        Restaurante restaurante_Mil_Sabores = new Restaurante();
        Mesero pablo = new Mesero(1234, "pablo");
        
        Opciones catalogo_opciones = new Opciones();
        catalogo_opciones.Inicio();
        System.out.println(pablo.getTurno());
        
    }
}
