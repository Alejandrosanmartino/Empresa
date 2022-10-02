package empresa;

public class Empleado {
	  //Attributes
    private String nombre;
    private String apellidos;
    private int edad;

    //Constructors
    public Empleado() { }
    public Empleado(String nombre, String apellidos, int edad) {
        this.nombre     = nombre;
        this.apellidos  = apellidos;
        this.edad       = edad;
    }

    //Methods
    @Override
    public String toString() {
        return  "Nombre: " +this.nombre+       "\n"+
                "Apellidos: "  +this.apellidos+    "\n"+
                "Edad: "  +this.edad+         "\n";
    }

    //Gets and Sets
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }


}
