package elp.proyecto_restaurante;

import java.util.Random;

public class Mesa {

    //Att
    int mesas;
    int numero_mesa = 0;
    int cantidad_sillas;
    boolean estado_uso;
    boolean tiene_vista;
    Mesero mesero;

    public void Iniciar_mesa() {
        numero_mesa+=1;
        mesas = getNumeroMesas(8, 12);
        cantidad_sillas = getNumeroSillas(2, 6);
        
        
        

    }


    public static int getNumeroMesas(int min, int max) {
        Random random = new Random();
        return random.nextInt(min, max + 1);
    }

    public static int getNumeroSillas(int min, int max) {
        Random random = new Random();
        return random.nextInt(min, max + 1);
    }

}

