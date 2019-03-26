package edu.pucmm.srmi.servicios;

import edu.pucmm.irmi.interfaces.servicios.EstudianteServicioInterfaz;
import edu.pucmm.irmi.objetos.Estudiante;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

/**
 * 
 */
public class EstudianteServices extends UnicastRemoteObject implements Serializable, EstudianteServicioInterfaz {

    private static EntityManagerFactory emf;

    protected EstudianteServices() throws RemoteException {
        super();
        if(emf == null) {
            emf = Persistence.createEntityManagerFactory("MiUnidadPersistencia");
        }
    }

    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    @Override
    public List<Estudiante> listarEstudiantes() throws RemoteException {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("from Estudiante ");
        List<Estudiante> lista = query.getResultList();
        return lista;
    }

    @Override
    public Estudiante crearEstudiante(Estudiante estudiante) throws RemoteException {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(estudiante);
        em.getTransaction().commit();
        return estudiante;
    }

    @Override
    public Estudiante actualizarEstudiante(Estudiante estudiante) throws RemoteException {
        return null;
    }

    @Override
    public boolean borrarEstudiante(Estudiante estudiante) throws RemoteException {
        return false;
    }

    @Override
    public String holaMundo() throws RemoteException {
        return "Desde el servidor: "+new Date();
    }
}
