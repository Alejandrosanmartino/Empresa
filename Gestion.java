package empresa;
import java.util.*;
import leer.*;
public class Gestion {

    public void mostrarMenu(){
        System.out.println("Elija la opci�n que desea: \n"
                + "1.- A�adir Empleado \n"
                + "2.- Mostrar todos los empleados de la empresa \n"
                + "3.- Mostrar un empleado \n"
                + "4.- Modificar un empleado \n"
                + "5.- Borrar un empleado \n"
                + "Otro n�mero --> Salir");
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
        //Llamada al m�todo booleano "noVacio". Si no es v�lida la posici�n, no se continua
        while (this.noVacio(listaEmpleados, posicionEmpleado)) {
            System.out.println("La posici�n elegida no existe. Por favor, introduzca otra");
            //Se solicita nueva posici�n
            posicionEmpleado = Leer.datoInt();
        }
        //Devuelve el objeto Empleado
        return listaEmpleados.get(posicionEmpleado-1);
    }

    public void eliminarEmpleado(List<Empleado> listaEmpleados, int posicionEmpleado){
        //Llamada al m�todo "obtenerEmpleado" (recuerdo, este m�todo ya se encarga de obtener una posici�n v�lida)
        //Se elimina el Empleado con el m�todo "remove" de ArrayList
        listaEmpleados.remove(this.obtenerEmpleado(listaEmpleados, posicionEmpleado));

        System.out.println("Registro eliminado correctamente");
    }


    public void modificarEmpleado(List<Empleado> listaEmpleados, int posicionEmpleado){
        //Llamada al m�todo "obtenerAlumno" (recuerdo, este m�todo ya se encarga de obtener una posici�n v�lida)
        this.obtenerEmpleado(listaEmpleados, posicionEmpleado);

        //Se presenta el men� de edici�n. Posibilita: Editar nombre, apellidos y edad.
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
        } System.out.println("Modificaci�n realizada correctamente");
    }
}