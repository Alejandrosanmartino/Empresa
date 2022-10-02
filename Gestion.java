package empresa;
import java.util.*;
import leer.*;
public class Gestion {

    public void mostrarMenu(){
        System.out.println("Elija la opción que desea: \n"
                + "1.- Añadir Empleado \n"
                + "2.- Mostrar todos los empleados de la empresa \n"
                + "3.- Mostrar un empleado \n"
                + "4.- Modificar un empleado \n"
                + "5.- Borrar un empleado \n"
                + "Otro número --> Salir");
    }

 
    public int menuEditar(){
        int eleccion = 0;
        do {
            System.out.println("Elija que desea editar: "
                    + "- Nombre "
                    + "- Apellidos "
                    + "- Edad ");

            eleccion = Leer.datoInt();

        } while (eleccion < 0 || eleccion > 3);
        return eleccion;
    }

 
    public Empleado anadirEmpleado(){
        System.out.println("Introduzca nombre");    String nom  =   Leer.dato();
        System.out.println("Introduzca apellidos"); String ape  =   Leer.dato();
        System.out.println("Introduzca edad");      int edad    =   Leer.datoInt();

        Empleado emp = new Empleado(nom, ape, edad);

        return emp;
    }

   
    public boolean noVacio(List<Empleado> listaEmpleados, int posicionEmpleado){
        boolean existeElemento = false;
        if (listaEmpleados.size() < posicionEmpleado)   existeElemento = true;

        return existeElemento;
    }


    public Empleado obtenerEmpleado(List<Empleado> listaEmpleados, int posicionEmpleado){
        //Llamada al método booleano "noVacio". Si no es válida la posición, no se continua
        while (this.noVacio(listaEmpleados, posicionEmpleado)) {
            System.out.println("La posición elegida no existe. Por favor, introduzca otra");
            //Se solicita nueva posición
            posicionEmpleado = Leer.datoInt();
        }
        //Devuelve el objeto Empleado
        return listaEmpleados.get(posicionEmpleado-1);
    }

    public void eliminarEmpleado(List<Empleado> listaEmpleados, int posicionEmpleado){
        //Llamada al método "obtenerEmpleado" (recuerdo, este método ya se encarga de obtener una posición válida)
        //Se elimina el Empleado con el método "remove" de ArrayList
        listaEmpleados.remove(this.obtenerEmpleado(listaEmpleados, posicionEmpleado));

        System.out.println("Registro eliminado correctamente");
    }


    public void modificarEmpleado(List<Empleado> listaEmpleados, int posicionEmpleado){
        //Llamada al método "obtenerAlumno" (recuerdo, este método ya se encarga de obtener una posición válida)
        this.obtenerEmpleado(listaEmpleados, posicionEmpleado);

        //Se presenta el menú de edición. Posibilita: Editar nombre, apellidos y edad.
        //Se modifica con los "set" creados en la clase "Empleado"
        switch (this.menuEditar()) {
            case 1://Se modifica el nombre
                System.out.println("Introduzca el nuevo nombre");
                this.obtenerEmpleado(listaEmpleados, posicionEmpleado).setNombre(Leer.dato());
                break;
            case 2://Se modifican los apellidos
                System.out.println("Introduzca los nuevos apellidos");
                this.obtenerEmpleado(listaEmpleados, posicionEmpleado).setApellidos(Leer.dato());
                break;
            case 3://Se modifica la edad
                System.out.println("Introduzca la nueva edad");
                this.obtenerEmpleado(listaEmpleados, posicionEmpleado).setEdad(Leer.datoInt());
                break;
            default:
                break;
        } System.out.println("Modificación realizada correctamente");
    }
}