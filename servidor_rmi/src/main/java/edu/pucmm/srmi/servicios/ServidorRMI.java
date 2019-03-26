package edu.pucmm.srmi.servicios;

import edu.pucmm.irmi.interfaces.servicios.EstudianteServicioInterfaz;
import edu.pucmm.irmi.objetos.Estudiante;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRMI  {

    private static final long serialVersionUID = 1L;
    private  final int PUERTO = 3232;

    public ServidorRMI(){
        try {
            new EstudianteServices().crearEstudiante(new Estudiante(20011136, "Carlos Camacho", "ITT"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 
     */
    public void iniciarServidor(){
        try {
            System.out.println("Inicializando el servidor RMI puerto: "+PUERTO);
            Registry registry = LocateRegistry.createRegistry(PUERTO);
            registry.bind(EstudianteServicioInterfaz.NOMBRE_OPERACION, (EstudianteServicioInterfaz) (new EstudianteServices()));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
