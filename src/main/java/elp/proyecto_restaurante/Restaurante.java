package elp.proyecto_restaurante;

import java.time.LocalTime;
import java.util.Random;
import javax.swing.JOptionPane;

public class Restaurante {

    //Att
    private Mesa mesas[];
    public static int nume_mesas;
    private Mesero meseros[];
    private Orden ordenes[];
    public static int ultima_orden = 0;

    public Restaurante() {
        nume_mesas = randint(8, 12);
        mesas = new Mesa[nume_mesas];
        llenar_mesas(nume_mesas, mesas);
        meseros = new Mesero[4];
        llenar_meseros(meseros);
        asignar_meseros_amesas(meseros, mesas);
        asignar_mesas_aMeseros(meseros, mesas);

        ordenes = new Orden[25];

    }

    //Parte de mesas y meseros >>>>>>>>>>>>>>>>>>
    public Mesa[] getMesas() {
        return this.mesas;
    }

    public static int getUltima_orden() {
        return ultima_orden;
    }
    
    
    public static int getNume_mesas() {
        return nume_mesas;
    }

    public Mesero[] getMeseros() {
        return meseros;
    }

    public Orden[] getOrdenes() {
        return this.ordenes;
    }

    public void setMesas(Mesa[] mesas) {
        this.mesas = mesas;
    }

    public static void setNume_mesas(int nume_mesas) {
        Restaurante.nume_mesas = nume_mesas;
    }

    public void setMeseros(Mesero[] meseros) {
        this.meseros = meseros;
    }

    public void setOrdenes(Orden[] ordenes) {
        this.ordenes = ordenes;
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
        int cantidad_con_vista = redondear((float) (nume_mesas / 4));
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
        return mesas_con_vista;
    }

    public void llenar_meseros(Mesero meseros[]) {
        int id;
        Mesero mesero;
        for (int i = 0; i < meseros.length; i++) {
            id = Restaurante.randint(100, 999);
            while (verificar_id_mesero(id)) {
                id = Restaurante.randint(100, 999);
            }
            mesero = new Mesero(id);
            meseros[i] = mesero;
        }

    }

    public boolean verificar_id_mesero(int id) {
        boolean existe = false;
        for (int i = 0; i < meseros.length; i++) {
            if (meseros[i] != null) {
                if (meseros[i].getId() == id) {
                    existe = true;
                }
            }
        }
        return existe;
    }

    public void asignar_meseros_amesas(Mesero meseros[], Mesa mesas[]) {
        Mesero meseros_disponibles[] = new Mesero[12];
        meseros_disponibles[0] = meseros[0];
        meseros_disponibles[1] = meseros[0];
        meseros_disponibles[2] = meseros[1];
        meseros_disponibles[3] = meseros[1];
        meseros_disponibles[4] = meseros[2];
        meseros_disponibles[5] = meseros[2];
        meseros_disponibles[6] = meseros[3];
        meseros_disponibles[7] = meseros[3];

        meseros_disponibles[8] = meseros[0];
        meseros_disponibles[9] = meseros[1];
        meseros_disponibles[10] = meseros[2];
        meseros_disponibles[11] = meseros[3];

        int i_mesero_escogido;
        for (int i = 0; i < mesas.length; i++) {
            i_mesero_escogido = randint(0, mesas.length - 1);
            while (meseros_disponibles[i_mesero_escogido] == null) {
                i_mesero_escogido = randint(0, mesas.length - 1);
            }
            mesas[i].setMesero(meseros_disponibles[i_mesero_escogido]);
            meseros_disponibles[i_mesero_escogido] = null;
        }
    }

    public boolean verificar_si_mesa_escogida(int mesas_escogidas[], int numero_mesa) {
        for (int i = 0; i < mesas_escogidas.length; i++) {
            if (numero_mesa == mesas_escogidas[i]) {
                return true;
            }
        }
        return false;
    }

    public void asignar_mesas_aMeseros(Mesero meseros[], Mesa mesas[]) {

        int ultima_pos_mesero[] = {0, 0, 0, 0};

        for (int i = 0; i < mesas.length; i++) {
            for (int j = 0; j < meseros.length; j++) {
                if (mesas[i].getMesero() == meseros[j]) {
                    meseros[j].mesas_asignadas[ultima_pos_mesero[j]] = i + 1;
                    ultima_pos_mesero[j] += 1;
                }
            }
        }
    }

    //FIN PARTE MESAS >>>>>>>>>>>>>>>>>>>
    public void mostrar() {
        /*for (int i = 0; i < meseros.length; i++) {
            for (int j = 0; j < 3; j++){
                System.out.print(meseros[i].getId() + " ");
                System.out.println(meseros[i].mesas_asignadas[j]);  
            }
            
        }
        
        for (int i = 0; i < mesas.length; i++) {
            System.out.println(mesas[i].numero_mesa);
            if (mesas[i].tiene_vista) {
                System.out.print("tiene vista ");
            } else {
                System.out.print("no tiene vista ");
            }
            System.out.println(mesas[i].mesero.getId());

        }*/
    }

    public static int randint(int min, int max) {
        Random ran = new Random();
        return ran.nextInt(min, max + 1);
    }

    public static int redondear(float num) {
        return Math.round(num);

    }

    public static void abrir_orden(Restaurante restaurante) {
        String nombre_cliente = JOptionPane.showInputDialog("Digite el nombre del cliente:");
        int numero_mesa = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de mesa:"));
        if (es_mesa_valida(restaurante, numero_mesa) >= 0){
            Orden orden = new Orden(nombre_cliente, restaurante.getMesas()[es_mesa_valida(restaurante, numero_mesa)]);
            restaurante.getOrdenes()[ultima_orden] = orden;
            ultima_orden ++;
        } else {
            //botones de la funcion ordenes
        }
            

    }

    public static boolean mesaTieneVista(Restaurante restaurante, int numeroMesa) {
        int[] mesasConVista = restaurante.mesa_con_vista();
        for (int i = 0; i < mesasConVista.length; i++) {
            if (mesasConVista[i] == numeroMesa) {
                return true;
            }
        }
        return false;
    }

    public static int es_mesa_valida(Restaurante restaurante, int numero_mesa) {
        for (int i = 0; i < restaurante.getMesas().length; i++) {
            if (restaurante.getMesas()[i].getNumero_mesa() == numero_mesa) {
                return i;
            }
        }
        return -1;
    }

}
