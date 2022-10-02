package empresa;
import java.util.*;
import leer.*;

public class Test {

    public static void main(String[] args) {

        System.out.println("Bienvenido al programa ADMINISTRADOR DE EMPLEADOS "
                + "El programa permite: \n"
                + "- Registrar los Empleados de la clase \n"
                + "- Mostrar todos los Empleados \n"
                + "- Mostrar un Empleado  \n"
                + "- Modificar un Empleado  \n"
                + "- Borrar un Empleado ");

        boolean repetir = true;
        int cantidadEmpleadosInicial=0, posicionEmpleado=0;
        int aux = 1;

        Gestion gestion = new Gestion();
        System.out.println("¿Con cuántos Empleados desea iniciar el programa?");
        cantidadEmpleadosInicial = Leer.datoInt();
        List<Empleado> listaEmpleados = new ArrayList<Empleado>(cantidadEmpleadosInicial);

        for (int i = 0; i < cantidadEmpleadosInicial; i++) {
            listaEmpleados.add(gestion.anadirEmpleado());
        }

        do {
            gestion.mostrarMenu();
            switch (Leer.datoInt()) {
                case 1: //Añadir Empleados
                    listaEmpleados.add(gestion.anadirEmpleado());
                    break;

                case 2: //Mostrar todos los  Empleados
                    for (Empleado Empleado : listaEmpleados) {
                        System.out.println(Empleado.toString());
                        System.out.println("------");
                    }
                    break;

                case 3: //Mostrar un Empleado
                    System.out.println("¿Qué Empleado desea mostrar?");
                    aux = 1;
                    for (Empleado Empleado : listaEmpleados) {
                        System.out.println(aux+ ".- " +Empleado.getNombre());
                        aux++;
                    }
                    posicionEmpleado = Leer.datoInt();
                    System.out.println(gestion.obtenerEmpleado(listaEmpleados, posicionEmpleado));
                    break;

                case 4: //Modificar Empleados
                    System.out.println("¿Qué Empleado desea modificar?");
                    aux = 1;
                    for (Empleado Empleado : listaEmpleados) {
                        System.out.println(aux+ ".- " + Empleado.getNombre());
                        aux++;
                    }
                    posicionEmpleado = Leer.datoInt();
                    gestion.modificarEmpleado(listaEmpleados, posicionEmpleado);
                    break;

                case 5: //Eliminar  Empelados
                    System.out.println("¿Qué Empleado desea eliminar?");
                    aux = 1;
                    for (Empleado Empleado : listaEmpleados) {
                        System.out.println(aux+ ".- " + Empleado.getNombre());
                        aux++;
                    }
                    posicionEmpleado = Leer.datoInt();
                    gestion.eliminarEmpleado(listaEmpleados, posicionEmpleado);
                    break;

                default: //Salir
                    repetir = false;
                    break;
            }

        } while (repetir);

        System.out.println("Muchas gracias!");
    }

}