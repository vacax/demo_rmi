package edu.pucmm.irmi;

import edu.pucmm.irmi.interfaces.servicios.EstudianteServicioInterfaz;
import edu.pucmm.irmi.objetos.Estudiante;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    final static String DIRECCION_SERVIDOR = "localhost";
    final static int PUERTO_SERVIDOR = 3232;

    public static void main(String[] args) throws Exception {

        //Recuperando el registro RMI
        Registry registry = LocateRegistry.getRegistry(DIRECCION_SERVIDOR, PUERTO_SERVIDOR);

        //Tomando la referencia al objeto publicado.
        EstudianteServicioInterfaz operaciones = (EstudianteServicioInterfaz) registry.lookup(EstudianteServicioInterfaz.NOMBRE_OPERACION);

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; 

        while (!salir) {

            System.out.println("Cliente RMI - Opciones de Operaciones");
            System.out.println("1. Listar Estudiantes");
            System.out.println("2. Cantidad de Estudiantes");
            System.out.println("3. Crear Estudiantes");
            System.out.println("4. Salir");

            try {

                System.out.println("Escribe una de las opciones:");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Listar Estudiantes vía RMI:");
                        List<Estudiante> estudiantes = operaciones.listarEstudiantes();
                        System.out.println("La cantidad de estudiantes: "+estudiantes.size());
                        for(Estudiante e :  estudiantes){
                            System.out.println(""+e.toString());
                        }
                        break;
                    case 2:
                        System.out.println("La Cantidad de Estudiantes: "+operaciones.listarEstudiantes().size());
                        break;
                    case 3:
                        System.out.println("Creación de Estudiante\n");
                        System.out.print("Matrícula:");
                        int matricula = sn.nextInt();
                        System.out.print("Nombre:");
                        String nombre = sn.next();
                        System.out.print("Carrera:");
                        String carrera = sn.next();
                        operaciones.crearEstudiante(new Estudiante(matricula, nombre, carrera));
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
            
            System.out.println("\n\n\n\n\n");
        }


        //System.out.println("Datos desde el servidor "+operaciones.holaMundo());
        //System.out.println("Creando un Usuario: "+operaciones.crearEstudiante(new Estudiante(20011135, "Francisco Grullon", "MED")));

    }
}
