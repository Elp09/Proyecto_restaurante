
package elp.proyecto_restaurante;

import javax.swing.JOptionPane;


public class Mesero {
    
    private int id;
    private String nombre;
    private int mesas_asignadas[];//va entre 2 y 3
    private Turno_Mesero turno;
    private double propinas;
    private double rating;
    private double total_ventas;

    public Mesero(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.rating = 5;
        this.propinas = 0;
        this.turno = generar_turno();
        //this.mesas_asignadas = new int[Restaurante.]
        this.total_ventas = 0;
        
        
    }
    
    public static Turno_Mesero generar_turno(){
        int tipo_turno = Restaurante.randint(1, 4);
        switch (tipo_turno){
            case 1:
                return Turno_Mesero.MANANA;
            case 2:
                return Turno_Mesero.TARDE;
            case 3:
                return Turno_Mesero.NOCHE;
            default:
                return null;
        }
    }
    
    
    
    

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMesas_asignadas(int[] mesas_asignadas) {
        this.mesas_asignadas = mesas_asignadas;
    }

    public void setTurno(Turno_Mesero turno) {
        this.turno = turno;
    }

    public void setPropinas(double propinas) {
        this.propinas = propinas;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    
    

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int[] getMesas_asignadas() {
        return mesas_asignadas;
    }

    public Turno_Mesero getTurno() {
        return turno;
    }

    public double getPropinas() {
        return propinas;
    }

    public double getRating() {
        return rating;
    }
    
    
    

    
    

}