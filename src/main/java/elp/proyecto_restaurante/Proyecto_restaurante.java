// Autores: Elias Leblicq
//          Santiago vindas
//          xx
// prueba

package elp.proyecto_restaurante;


public class Proyecto_restaurante {

    public static void main(String[] args) {
        
        //Se crea e inicializa el restaurante con su informacion generada
        //aleatoriamente
        
        Restaurante restaurante_Mil_Sabores = new Restaurante();
        
        Opciones catalogo_opciones = new Opciones();
        catalogo_opciones.Inicio(restaurante_Mil_Sabores);
        
    }
}
