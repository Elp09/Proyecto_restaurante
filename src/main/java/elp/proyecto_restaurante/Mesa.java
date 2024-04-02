package elp.proyecto_restaurante;

import java.util.Random;

public class Mesa {

    //Att
    int mesa_random;
    int mesas [] = new int[mesa_random];
    int numero_mesa;
    int cantidad_sillas;
    boolean estado_uso; //un boolean que empieza en false por default, esto significa que la mesa esta desocupada
    int tiene_vista;
    double vista_procentaje = 0.25;
    Mesero mesero;

    public void Iniciar_mesa() {
        //datos de la mesa
        numero_mesa += 1;
        mesa_random = getNumeroMesas(8, 12);
        cantidad_sillas = getNumeroSillas(2, 6);
        tiene_vista=redondear(mesa_random);
        int numero_redondear = (int) (mesa_random*vista_procentaje);
        //ejemplo de "hay x mesas con vista al mar"
        //el "x" es el numero redondeado
        
        

    }

    public static int getNumeroMesas(int min, int max) {
        Random random = new Random();
        return random.nextInt(min, max + 1);
    }

    public static int getNumeroSillas(int min, int max) {
        Random random = new Random();
        return random.nextInt(min, max + 1);
    }
    public static int redondear(int mesa_random) {
        int numeroRedondeado = Math.round(mesa_random);
        return numeroRedondeado;
    }
}

