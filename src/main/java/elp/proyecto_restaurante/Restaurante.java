package elp.proyecto_restaurante;

import java.util.Random;

public class Restaurante {

    //Att
    private Mesa mesas[];
    public static int nume_mesas;
    private Mesero meseros[];

    public Restaurante() {
        nume_mesas = randint(8, 12);
        mesas = new Mesa[nume_mesas];
        llenar_mesas(nume_mesas, mesas);
        meseros = new Mesero[4];
        llenar_meseros(meseros);

    }

    public Mesa[] getMesas() {
        return this.mesas;
    }

    public void llenar_mesas(int nume_mesas, Mesa mesas[]) {
        int mesas_con_vista[] = mesa_con_vista();
        boolean tiene_vista;
        for (int i = 0; i < nume_mesas; i++) {
            tiene_vista = false;
            for (int j = 0; j < 3; j++) {
                if (i + 1 == mesas_con_vista[j]) {
                    tiene_vista = true;
                }
            }
            Mesa mesa = new Mesa(i + 1, tiene_vista);
            mesas[i] = mesa;
        }
    }

    public int[] mesa_con_vista() {
        int cantidad_con_vista = redondear((float) (nume_mesas/4));
        System.out.println(cantidad_con_vista);
        int mesa1 = -1;
        int mesa2 = -1;
        int mesa3 = -1;
        while ((mesa1 == mesa2) && (mesa2 == mesa3) && (mesa3 == mesa1)) {
            mesa1 = Restaurante.randint(1, nume_mesas);
            mesa2 = Restaurante.randint(1, nume_mesas);
            mesa3 = Restaurante.randint(1, nume_mesas);
        }
        
        if (cantidad_con_vista != 3) {
            mesa3 = -1;
        }
        int mesas_con_vista[] = {mesa1, mesa2, mesa3};
        for (int i = 0; i < 3; i++) {
            System.out.println(mesas_con_vista[i]);
        }
        return mesas_con_vista;
    }

    public void llenar_meseros(Mesero meseros[]) {
        int ids_meseros[] = new int[4];
        int id;
        Mesero mesero;

        for (int i = 0; i < meseros.length; i++) {
            id = Restaurante.randint(100, 999);
            mesero = new Mesero(id);
            meseros[i] = mesero;
            ids_meseros[i] = id;
        }

    }
    
    public void asignar_meseros_amesas(Mesero meseros[], Mesa mesas[]){
        int numero_mesas_asignados_Xmesero[] = {0,0,0,0};
        int numero_mesero;
        for(int i = 0; i<mesas.length; i++){
            numero_mesero = randint(0, 3);
            numero_mesas_asignados_Xmesero[numero_mesero] += 1;
            
        }
    }

    public void mostrar() {
        for (int i = 0; i < meseros.length; i++) {
            System.out.println(meseros[i].getId());
        }
        for (int i = 0; i < mesas.length; i++) {
            System.out.println(mesas[i].numero_mesa);
            if (mesas[i].tiene_vista) {
                System.out.println("tiene vista");
            } else {
                System.out.println("no tiene vista");
            }

        }
    }

    public static int randint(int min, int max) {
        Random ran = new Random();
        return ran.nextInt(min, max + 1);
    }

    public static int redondear(float num) {
        return Math.round(num);

    }

}
