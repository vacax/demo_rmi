package edu.pucmm.irmi.interfaces.servicios;

import edu.pucmm.irmi.objetos.Estudiante;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * 
 */
public interface EstudianteServicioInterfaz extends Remote {

    String NOMBRE_OPERACION = "estudianteService";

    List<Estudiante> listarEstudiantes() throws java.rmi.RemoteException;
    Estudiante crearEstudiante(Estudiante estudiante) throws java.rmi.RemoteException;
    Estudiante actualizarEstudiante(Estudiante estudiante) throws java.rmi.RemoteException;
    boolean borrarEstudiante(Estudiante estudiante) throws java.rmi.RemoteException;
    String holaMundo() throws RemoteException;
}
