
package elp.proyecto_restaurante;

import javax.swing.JOptionPane;


public class Mesero {
    
    //Mesero 1
        int id_Mesero001 = 10020;
        String name_Mesero001 = "Julian Coto";
        int mesas_Mesero001 = 0;
        String turno_Mesero001 = "";
        int propinas_Mesero001 = 0;
        int rating_Mesero001 = 0;

//Mesero 2
        int id_Mesero002 = 10025;
        String name_Mesero002 = "Jose Cruz";
        int mesas_Mesero002 = 0;
        String turno_Mesero002 = "";
        int propinas_Mesero002 = 0;
        int rating_Mesero002 = 0;

//Mesero 2
        int id_Mesero003 = 10030;
        String name_Mesero003 = "Rachell Vargas";
        int mesas_Mesero003 = 0;
        String turno_Mesero003 = "";
        int propinas_Mesero003 = 0;
        int rating_Mesero003 = 0;

//Mesero 2
        int id_Mesero004 = 10035;
        String name_Mesero004 = "Maria Mata";
        int mesas_Mesero004 = 0;
        String turno_Mesero004 = "";
        int propinas_Mesero004 = 0;
        int rating_Mesero004 = 0;

        String datos_Meserostxt = JOptionPane.showInputDialog("Ingrese el numero de mesero");
        int datos_Meseros = Integer.parseInt(datos_Meserostxt);

        switch (datos_Meseros) {
            case 10020:
                JOptionPane.showConfirmDialog(null,
                        "\nEl ID del mesero es " + id_Mesero001
                        + "\nEl nombre del mesero es " + name_Mesero001
                        + "\nLa mesa asignada es: " + mesas_Mesero001
                        + "\nEl mesero esta en el turno de: " + turno_Mesero001
                        + "\nLa propina del mesero es " + propinas_Mesero001
                        + "\nEl rating del mesero es de " + rating_Mesero001);
                break;
            case 10025:
                JOptionPane.showConfirmDialog(null,
                        "\nEl ID del mesero es " + id_Mesero002
                        + "\nEl nombre del mesero es " + name_Mesero002
                        + "\nLa mesa asignada es: " + mesas_Mesero002
                        + "\nEl mesero esta en el turno de: " + turno_Mesero002
                        + "\nLa propina del mesero es " + propinas_Mesero002
                        + "\nEl rating del mesero es de " + rating_Mesero002);
                break;
            case 10030:
                JOptionPane.showConfirmDialog(null,
                        "El ID del mesero es " + id_Mesero003
                        + "\nEl nombre del mesero es " + name_Mesero003
                        + "\nLa mesa asignada es: " + mesas_Mesero003
                        + "\nEl mesero esta en el turno de: " + turno_Mesero003
                        + "\nLa propina del mesero es " + propinas_Mesero003
                        + "\nEl rating del mesero es de " + rating_Mesero003);
                break;
            case 10035:
                JOptionPane.showConfirmDialog(null,
                        "El ID del mesero es " + id_Mesero004
                        + "\nEl nombre del mesero es " + name_Mesero004
                        + "\nLa mesa asignada es: " + mesas_Mesero004
                        + "\nEl mesero esta en el turno de: " + turno_Mesero004
                        + "\nLa propina del mesero es " + propinas_Mesero004
                        + "\nEl rating del mesero es de " + rating_Mesero004);
                break;
            default:
                JOptionPane.showMessageDialog(null, "El mesero no se encontro");
                break;

        }
   
              
    
            }
