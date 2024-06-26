
package elp.proyecto_restaurante;


public class Mesero {
    public String nombres[] = {"Pedro", "Juan", "Marcos", "David", "Alejandro",
    "Martino", "Pablo", "Luis", "Ana", "Sofía", "María", "Carlos", "José", "Laura", 
    "Manuel", "Elena", "Andrés", "Lucía", "Gabriel", "Isabel", "Diego", "Valentina", 
    "Javier", "Camila", "Francisco", "Paula", "Miguel", "Daniela", "Antonio"};
    
    public String apellidos[] = {"Ramirez", "Fallas", "Zeledon", "Carano", "Teco", 
    "Mora", "Rodriguez", "Hernandez", "Gomez", "Lopez", "Soto", "Chaves", "Garcia", 
    "Diaz", "Castro", "Fernandez", "Vargas", "Cruz", "Mendez", "Sanchez", "Morales"};
  
    
    private int id;
    private String nombre;
    public int mesas_asignadas[] = {-1, -1, -1}; //va entre 2 y 3
    private Turno_Mesero turno;
    private double propinas;
    private double rating;
    

    public Mesero(int id) {
        this.id = id;
        setNombre();
        this.rating = 5;
        this.propinas = 0;
        this.turno = generar_turno();
        //this.mesas_asignadas = new int[Restaurante.]
        
        
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
    
    public void setNombre(){
        String nombre = "";
        int cod_nombre = Restaurante.randint(0, nombres.length);
        nombre += nombres[cod_nombre];
        int cod_apellido = Restaurante.randint(0, apellidos.length);
        nombre += " " + apellidos[cod_apellido];
        this.nombre = nombre;
        
    }
    
    
    
    

    public void setId(int id) {
        this.id = id;
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