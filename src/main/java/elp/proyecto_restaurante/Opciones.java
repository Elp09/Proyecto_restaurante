
package elp.proyecto_restaurante;

import javax.swing.JOptionPane;


public class Opciones {
    
    public int Inicio(){
        String botones_menu_inicial[] = {"Restaurante", "Ordenes", "Menu", "Reportes", "Salir"};
        int opcion_escogida = JOptionPane.showOptionDialog(
            null,
            "Escoja la opcion deseada:", 
            "Menu de opciones", 
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.QUESTION_MESSAGE,
            null, 
            botones_menu_inicial, "Salir");
    
        switch (opcion_escogida) {
            case 0:
                //informacion_restaurante();
                break;
            case 1:
                //menu_ordenes();
                break;
            case 2:
                //menu_menu();
                break;
            case 3:
                //menu_reportes();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Gracias por usar");
                opcion_escogida = 4;
            
               
        }
        
        return opcion_escogida;
    
            
    }
    
    public void Informacion_restaurante(){
        
    }
    
}
