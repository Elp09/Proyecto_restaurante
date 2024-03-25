
package elp.proyecto_restaurante;

import java.util.Random;


public class Restaurante {
    //Att
    private Mesa mesas[];
    private int nume_mesas;

    public Restaurante(){
        nume_mesas = randint();
        mesas = new Mesa[nume_mesas];
        
    }

    public Mesa[] getMesas() {
        return mesas;
    }

    public int getNume_mesas() {
        return nume_mesas;
    }
    
    
    
    
    
    
    
    
    
    public int randint(){
        Random ran = new Random();
        return ran.nextInt(8, 13);
    }
}
