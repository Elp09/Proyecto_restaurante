
package elp.proyecto_restaurante;

import java.util.Random;


public class Restaurante {
    //Att
    private Mesa mesas[];
    public static int nume_mesas;

    public Restaurante(){
        nume_mesas = randint(8, 12);
        mesas = new Mesa[nume_mesas];
        
        
 
    }

    public Mesa[] getMesas() {
        return this.mesas;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    public static int randint(int min, int max){
        Random ran = new Random();
        return ran.nextInt(min, max + 1);
    }
}
