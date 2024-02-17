// Autores: Elias Leblicq
//          xx
//          xx

package elp.proyecto_restaurante;


public class Proyecto_restaurante {

    public static void main(String[] args) {
        
        //Se crea e inicializa el restaurante con su informacion generada
        //aleatoriamente
        Restaurante restaurante_Mil_Sabores = new Restaurante();
        restaurante_Mil_Sabores.Inicializar();
        
        Opciones catalogo_opciones = new Opciones();
        catalogo_opciones.Inicio();

        
    }
}
