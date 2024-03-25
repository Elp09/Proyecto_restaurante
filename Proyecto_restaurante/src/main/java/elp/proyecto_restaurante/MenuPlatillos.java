
package elp.proyecto_restaurante;

import javax.swing.JOptionPane;


public class MenuPlatillos {
    
//Botones
    
        String botones_MenuPlatillos[] = {"Mostrar Menu", "Agregar platillo", "Editar platillo", "Eliminar platillo", "Salir"};
        int botones = JOptionPane.showOptionDialog(
                null,
                "Seleccione una option",
                "",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                botones_MenuPlatillos,
                "Mostrar Menu");

        switch (botones) {
            case 0:
                JOptionPane.showMessageDialog(null,
                        "\nEl menu es: "
                        + "\nPescado al ajillo con papas"
                        + "\nBurger de pescado empanizado con aros de cebolla"
                        + "\nArroz con mariscos");
                break;
            case 1:
                JOptionPane.showInputDialog("Que platillo desea agregar ?");
                break;

            case 2:
                JOptionPane.showInputDialog("Cual platillo desea cambiar ?");

            case 3:
                JOptionPane.showInputDialog("Cual Platillo desea eliminar");
            case 4:
                JOptionPane.showMessageDialog(null, "Saliendo...");

        }
            
}
